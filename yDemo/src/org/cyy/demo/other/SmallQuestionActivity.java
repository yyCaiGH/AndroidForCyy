package org.cyy.demo.other;

import org.cyy.demo.R;
import org.cyy.util.Logger;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;

public class SmallQuestionActivity extends Activity implements Handler.Callback{

	TextView tv;
	//可以添加参数this是因为该Activity继承了Handler.Callback，该handler发送的消息会回调boolean handleMessage(Message msg)
	Handler handler = new Handler(this){

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			Logger.i("cyy-cyy", msg.what+"---主线程");
		}
		
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_other);
		tv = (TextView)this.findViewById(R.id.textView1);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Handler handler1 = new Handler(Looper.getMainLooper()){

					@Override
					public void handleMessage(Message msg) {
						Logger.i("cyy-cyy", msg.what+"---其他线程");
						super.handleMessage(msg);
						tv.setText("cyy");
					}
					
				};
				handler1.sendEmptyMessage(3);
			}
		}).start();
		handler.sendEmptyMessage(2);
	}
	@Override
	public boolean handleMessage(Message msg) {
		Logger.i("cyy-cyy", msg.what+"---主线程Callback");
		return false;
	}
	
}
