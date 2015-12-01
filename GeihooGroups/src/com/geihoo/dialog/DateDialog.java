package com.geihoo.dialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.geihoo.groups.R;

public class DateDialog {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static AlertDialog.Builder builder;
	public static void showTimeSelector(Context context, LayoutInflater inflater,final TextView showDate) {
		
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		View v = inflater.inflate(R.layout.datetimedialog, null);
		final DatePicker date = (DatePicker) v.findViewById(R.id.date);
		final TimePicker time = (TimePicker) v.findViewById(R.id.time);
		// 24进制
		time.setIs24HourView(true);

		builder.setView(v)
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						// 时间格式化
						int year = date.getYear();
						int month = date.getMonth();
						int day = date.getDayOfMonth();
						int hour = time.getCurrentHour();
						int minute = time.getCurrentMinute();

						Calendar c = Calendar.getInstance();
						c.set(Calendar.YEAR, year);
						c.set(Calendar.MONTH, month);
						c.set(Calendar.DAY_OF_MONTH, day);
						c.set(Calendar.HOUR_OF_DAY, hour);
						c.set(Calendar.MINUTE, minute);
						c.set(Calendar.SECOND, 0);
						Date date = new Date(c.getTimeInMillis());

						String dateStr = sdf.format(date);
						// 获取时间
						showDate.setText(dateStr);
					}
				}).setNegativeButton("取消", null).create().show();
	}
}
