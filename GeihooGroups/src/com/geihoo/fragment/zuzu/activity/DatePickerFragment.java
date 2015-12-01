package com.geihoo.fragment.zuzu.activity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.geihoo.groups.R;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.widget.DatePicker;


public class DatePickerFragment extends DialogFragment implements OnDateSetListener {
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		
		return new DatePickerDialog(getActivity(), R.style.AppTheme_Dialog,null, year, month, day);
	}

	@Override
	public void onDateSet(DatePicker view, int year, int month, int day) {
		Log.d("OnDateSet", "select year:" + year + ";month:" + month + ";day:"
				+ day);
	}
	
}