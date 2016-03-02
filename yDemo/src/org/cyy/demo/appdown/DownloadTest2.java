package org.cyy.demo.appdown;

import org.cyy.demo.R;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class DownloadTest2 extends Activity{

	TextView tv ;
	ReceiveProgressBroadCast broadCast;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_down_2);
		Intent intent = new Intent(this, DownloadService.class);
        startService(intent);
		tv = (TextView)this.findViewById(R.id.textView2);
		registerReceiver();
	}
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(broadCast);
	};
	private void registerReceiver() {
    	broadCast = new ReceiveProgressBroadCast();
        IntentFilter filter = new IntentFilter();
        filter.addAction(DownloadTest.PROGRESS_INFO_ACTION);
        this.registerReceiver(broadCast, filter);
	}
	/**
     * 
     * 说明：自定义监听进度广播
     *
     * @author yy_cai
     *
     * 2016年2月29日
     */
    private class ReceiveProgressBroadCast extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			int progress = intent.getIntExtra("progress",-1);
			int notificationId = intent.getIntExtra("notificationId", -1);
			if(DownloadTest.PROGRESS_INFO_ACTION.equals(action)){
//				downNewFile(url, notificationId, name);
				switch (notificationId) {
//				case DownloadTest.BAIDU_NOTICE_ID:
//					tv1.setText("百度知道："+progress+"%");
//					break;
//				case DownloadTest.SOUGOU_NOTICE_ID:
//					tv2.setText("搜狗小说："+progress+"%");
//					break;
				case DownloadTest.JUNWANG_NOTICE_ID:
					tv.setText("君王2："+progress+"%");
					break;
				default:
					break;
				}
			}
			
		}
    	
    }
}
