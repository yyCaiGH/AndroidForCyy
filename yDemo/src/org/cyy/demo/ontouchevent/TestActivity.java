package org.cyy.demo.ontouchevent;

import org.cyy.demo.R;
import org.cyy.demo.R.id;
import org.cyy.demo.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;


public class TestActivity extends Activity implements OnTouchListener,OnClickListener,OnLongClickListener,OnGestureListener{
	GestureDetector gd;
	static String tag = "TestActivity";
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		MyImageView iv = (MyImageView)this.findViewById(R.id.iv_test);
		iv.setOnTouchListener(this);
		iv.setOnClickListener(this);
		iv.setOnLongClickListener(this);
		MyLinearLayout ll = (MyLinearLayout)this.findViewById(R.id.ll_test);
		ll.setOnTouchListener(this);
		ll.setOnClickListener(this);
		ll.setOnLongClickListener(this);
		MyFrameLayout fl = (MyFrameLayout)this.findViewById(R.id.fl_test);
		fl.setOnTouchListener(this);
		fl.setOnClickListener(this);
		fl.setOnLongClickListener(this);
		gd = new GestureDetector(this, this);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.i(tag, tag+"-->onTouchEvent--"+event.getAction());
		return super.onTouchEvent(event);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if(v.getId()==R.id.iv_test){
			Log.i(tag, "MyImageView"+"-->onTouch--"+event.getAction());
			return gd.onTouchEvent(event);
		}
		else if(v.getId()==R.id.ll_test){
			Log.i(tag, "MyLinearLayout"+"-->onTouch--"+event.getAction());
		}
		else if(v.getId()==R.id.fl_test){
			Log.i(tag, "MyFrameLayout"+"-->onTouch--"+event.getAction());
		}
		return false;
	}
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		Log.i(tag, tag+"-->dispatchTouchEvent--"+ev.getAction());
		return super.dispatchTouchEvent(ev);
	}

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.iv_test){
			Log.i(tag, "MyImageView"+"-->onClick--");
		}
		else if(v.getId()==R.id.ll_test){
			Log.i(tag, "MyLinearLayout"+"-->onClick--");
		}
		else if(v.getId()==R.id.fl_test){
			Log.i(tag, "MyFrameLayout"+"-->onClick--");
		}
	}

	@Override
	public boolean onLongClick(View v) {
		if(v.getId()==R.id.iv_test){
			Log.i(tag, "MyImageView"+"-->onLongClick--");
		}
		else if(v.getId()==R.id.ll_test){
			Log.i(tag, "MyLinearLayout"+"-->onLongClick--");
		}
		else if(v.getId()==R.id.fl_test){
			Log.i(tag, "MyFrameLayout"+"-->onLongClick--");
		}
		return false;
	}

	@Override
	public boolean onDown(MotionEvent e) {
		Log.i(tag, tag+"-->onDown--手势");
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		Log.i(tag, tag+"-->onShowPress--手势");
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		Log.i(tag, tag+"-->onSingleTapUp--手势");
		return false;
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		Log.i(tag, tag+"-->onScroll--手势");
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		Log.i(tag, tag+"-->onLongPress--手势");
		
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		Log.i(tag, tag+"-->onFling--手势");
		return false;
	}
}
