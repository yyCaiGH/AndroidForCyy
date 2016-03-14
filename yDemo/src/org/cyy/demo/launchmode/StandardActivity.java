package org.cyy.demo.launchmode;

import org.cyy.demo.R;
import org.cyy.util.Logger;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class StandardActivity extends Activity implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_other);
		TextView tv = (TextView)this.findViewById(R.id.textView1);
		
		tv.setText("StandardActivity,任务栈id="+this.getTaskId());
		Logger.i(TAG, "onCreate");
		this.findViewById(R.id.btn_other).setOnClickListener(this);
	}

	private final static String TAG = StandardActivity.class.getSimpleName();
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Logger.i(TAG, "onStart");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Logger.i(TAG, "onResume，任务栈id="+this.getTaskId());
	}

	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		super.onNewIntent(intent);
		setIntent(intent);//后续getIntent才是传过来得intent
		Logger.i(TAG, "onNewIntent");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Logger.i(TAG, "onPause");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Logger.i(TAG, "onStop");
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Logger.i(TAG, "onDestroy");
	}

	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		Logger.i(TAG, "onRestoreInstanceState");
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
		Logger.i(TAG, "onPostCreate");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Logger.i(TAG, "onRestart");
	}

	@Override
	protected void onPostResume() {
		// TODO Auto-generated method stub
		super.onPostResume();
		Logger.i(TAG, "onPostResume");
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		Logger.i(TAG, "onSaveInstanceState");
	}

	@Override
	protected void onUserLeaveHint() {
		// TODO Auto-generated method stub
		super.onUserLeaveHint();
		Logger.i(TAG, "onUserLeaveHint");
	}

	@Override
	protected void onApplyThemeResource(Theme theme, int resid, boolean first) {
		// TODO Auto-generated method stub
		super.onApplyThemeResource(theme, resid, first);
		Logger.i(TAG, "onApplyThemeResource");
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Logger.i(TAG, "onActivityResult");
	}

	@Override
	protected void onChildTitleChanged(Activity childActivity,
			CharSequence title) {
		// TODO Auto-generated method stub
		super.onChildTitleChanged(childActivity, title);
		Logger.i(TAG, "onChildTitleChanged");
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		Logger.i(TAG, "onWindowFocusChanged");
	}
	@Override
	public void onAttachedToWindow() {
		// TODO Auto-generated method stub
		super.onAttachedToWindow();
		Logger.i(TAG, "onAttachedToWindow");
	}
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.btn_other){
			Intent i = new Intent(this,SingleTopActivity.class);
//			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(i);
		}
		
	}
	
	
}
