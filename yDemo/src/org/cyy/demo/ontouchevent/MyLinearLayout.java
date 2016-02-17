package org.cyy.demo.ontouchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class MyLinearLayout extends LinearLayout{

	static String tag = "MyLinearLayout";
	public MyLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.i(tag, tag+"-->onTouchEvent--"+event.getAction());
		return super.onTouchEvent(event);
	}
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		Log.i(tag, tag+"-->onInterceptTouchEvent--"+ev.getAction());
		return super.onInterceptTouchEvent(ev);
	}
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		Log.i(tag, tag+"-->dispatchTouchEvent--"+ev.getAction());
		return super.dispatchTouchEvent(ev);
	}
}
