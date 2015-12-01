package com.geihoo.fragment.zuzu.activity;

import java.util.Calendar;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.TimePicker;

public class TimePickerFragment extends DialogFragment implements
		OnTimeSetListener {

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);

		return new TimePickerDialog(getActivity(), this, hour, minute,
				DateFormat.is24HourFormat(getActivity()));
	}

	public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
		// 处理设置的时间，这里我们作为示例，在日志中输出我们选择的时间
		Log.d("onTimeSet", "hourOfDay: " + hourOfDay + "Minute: " + minute);
	}
}