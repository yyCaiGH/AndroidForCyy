package org.cyy.demo.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.cyy.demo.R;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MusicListActivity extends Activity {

	private EditText fileName;
	private String path;
//	private MediaPlayer mediaPlayer;
//	private boolean pause;
//	private int position;
	private IMusic iMusic;
	private ListView musics;
	private List<HashMap<String,String>> data; 
	private ServiceConnection conn=new MusicServiceConnection();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_music_list);
//		mediaPlayer=new MediaPlayer();
		fileName = (EditText)this.findViewById(R.id.filename);
		TelephonyManager telephonyManager=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
		telephonyManager.listen(new MyPhoneListener(), PhoneStateListener.LISTEN_CALL_STATE);
		Intent service =new Intent(this,MusicService.class);
		this.startService(service);//这样Activity退出的时候就不会关闭Service
		this.bindService(service, conn, BIND_AUTO_CREATE);
		
		musics=(ListView)this.findViewById(R.id.listView1);
		
		
	}
	private class MusicServiceConnection implements ServiceConnection{

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.d("cyyc", "onserviceconnected");
			iMusic =(IMusic)service;
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			iMusic=null;
		}
		
	}
	private final class MyPhoneListener extends PhoneStateListener{

		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			switch (state) {
			case TelephonyManager.CALL_STATE_RINGING:
//				if(mediaPlayer.isPlaying()){
////					mediaPlayer.pause();
//					position=mediaPlayer.getCurrentPosition();
//					mediaPlayer.stop();
//				}
				iMusic.callStateRinging();
				break;
			case TelephonyManager.CALL_STATE_IDLE:
////				mediaPlayer.start();
//				if(position>0&&path!=null){
//					play(position);
//					position=0;
//				}
				Log.d("cyyc", "CALL_STATE_IDLE");
				if(path!=null)
				iMusic.callStateIdle(path);
				break;
			default:
				break;
			}
		}
		
	}
	@Override
	protected void onDestroy() {
//		mediaPlayer.release();
//		mediaPlayer=null;
		this.unbindService(conn);
//		this.stopService(new Intent(this,MusicService.class));//stop之后服务就会关闭
		super.onDestroy();
	}
	public void media(View v){
		switch (v.getId()) {
		case R.id.playmedia://播放音乐
			String name=fileName.getText().toString()+".mp3";
			File audio=new File(Environment.getExternalStorageDirectory()+"/Music",name);
			if(audio.exists()){
				path=audio.getAbsolutePath();
//				play(0);
				iMusic.playMusic(path);
			}else{
				path=null;
				Toast.makeText(this, "文件找不到", Toast.LENGTH_LONG).show();
			}
			break;
		case R.id.pausemedia://暂停音乐
//			if(mediaPlayer.isPlaying()){
//				mediaPlayer.pause();
//				pause=true;
//				((Button)v).setText("继续");
//			}else{
//				mediaPlayer.start();
//				pause=false;
//				((Button)v).setText("暂停");
//			}
			iMusic.pauseMusic();
			break;
		case R.id.resetmedia://重播音乐
//			if(mediaPlayer.isPlaying()){
//				mediaPlayer.seekTo(0);//从头播放音乐
//			}else{
//				if(path!=null)
//					play(0);
//			}
			iMusic.resetMusic(path);
			break;
		case R.id.stopmedia://停止音乐
//			if(mediaPlayer.isPlaying()){
//				mediaPlayer.stop();
//			}
			iMusic.stopMusic();
			break;
		case R.id.quit://退出音乐播放器
			
			break;
		case R.id.button1:
			File path=new File(Environment.getExternalStorageDirectory()+"/Music");
			Log.d("cyy-cyy-path", path.getAbsolutePath());
			data=new SearchFileFromSDcard().searchFile(this,path);
			SimpleAdapter adapter=new SimpleAdapter(this, data, android.R.layout.simple_list_item_1, new String[]{"music"}, new int[]{android.R.id.text1});
			musics.setAdapter(adapter);
			musics.setOnItemClickListener(new musicItemListener());
			break;
		default:
			break;
		}
	}
	private class musicItemListener implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			String fileName=data.get(position).get("music");
			File audio=new File(Environment.getExternalStorageDirectory()+"/music",fileName);
			if(audio.exists()){
				path=audio.getAbsolutePath();
//				play(0);
				iMusic.playMusic(path);
			}else{
				path=null;
				Toast.makeText(MusicListActivity.this, "文件找不到", Toast.LENGTH_LONG).show();
			}
			
		}
		
	}
//	private void play(int position) {
//		try {
//			mediaPlayer.reset();//初始化各项参数
//			mediaPlayer.setDataSource(path);
//			mediaPlayer.prepare();
//			mediaPlayer.setOnPreparedListener(new prepareListener(position));
//		}  catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//	private class prepareListener implements OnPreparedListener{
//		private int position;
//		public prepareListener(int position){
//			this.position=position;
//		}
//		@Override
//		public void onPrepared(MediaPlayer mp) {
//			mediaPlayer.start();//开始播放
//			if(position>0){
//				mediaPlayer.seekTo(position);
//			}
//		}
//		
//	}

}