package org.cyy.demo.other;

import org.cyy.demo.R;
import org.cyy.util.Logger;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
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
//		SpotsDialog dialog = new SpotsDialog(this);
//		dialog.setMessage("cyy");
//		dialog.show();
		tv = (TextView)this.findViewById(R.id.textView1);
		registerForContextMenu(tv);
//		tv.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
////				setResult(Activity.RESULT_OK);
////				finish();
//				
//			}
//		});
		/*new Thread(new Runnable() {
			
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
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
					}
				});
			}
		}).start();;*/
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		 menu.setHeaderTitle("选择自己喜欢的！");
	        menu.add(0, 3, 0, "修改");
	        menu.add(0, 4, 1, "删除");
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return super.onContextItemSelected(item);
	}
	@Override
	public boolean handleMessage(Message msg) {
		Logger.i("cyy-cyy", msg.what+"---主线程Callback");
		return false;
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
	}
	@Override
	protected void onPause() {
		super.onPause();
	}
}
