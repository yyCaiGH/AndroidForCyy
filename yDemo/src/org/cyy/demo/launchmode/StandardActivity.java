package org.cyy.demo.launchmode;

import org.cyy.demo.R;
import org.cyy.util.Logger;

import android.app.Activity;
import android.content.Intent;
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
		tv.setText("StandardActivity");
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
		Logger.i(TAG, "onResume");
	}

	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		super.onNewIntent(intent);
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
	public void onClick(View v) {
		if(v.getId()==R.id.btn_other){
			Intent i = new Intent(this,SingleTopActivity.class);
			startActivity(i);
		}
		
	}
	
	
}
