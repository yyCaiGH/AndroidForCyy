package org.cyy.demo.service;


import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MusicService extends Service {

	private IBinder binder =new MusicBinder();
	private MediaPlayer mediaPlayer;
	private boolean pause;
	private int position;
	@Override
	public void onCreate() {
		super.onCreate();
		mediaPlayer=new MediaPlayer();
	}
	@Override
	public IBinder onBind(Intent intent) {
		return binder;
	}
	private class MusicBinder extends Binder implements IMusic {

		@Override
		public void playMusic(String path) {
			Log.d("cyyc", "service-playMusic");
			play(0,path);
		}

		@Override
		public void pauseMusic() {
			Log.d("cyyc", "service-pauseMusic");
			if(mediaPlayer.isPlaying()){
				mediaPlayer.pause();
				pause=true;
//				((Button)v).setText("继续");
			}else{
				mediaPlayer.start();
				pause=false;
//				((Button)v).setText("暂停");
			}
			
		}

		@Override
		public void resetMusic(String path) {
			Log.d("cyyc", "service-resetMusic");
			if(mediaPlayer.isPlaying()){
				mediaPlayer.seekTo(0);//从头播放音乐
			}else{
				if(path!=null)
					play(0,path);
			}
			
		}

		@Override
		public void stopMusic() {
			Log.d("cyyc", "service-stopMusic");
			if(mediaPlayer.isPlaying()){
				mediaPlayer.stop();
			}
			
		}

		@Override
		public void callStateRinging() {
			Log.d("cyyc", "service-callStateRinging");
			if(mediaPlayer.isPlaying()){
//				mediaPlayer.pause();
				position=mediaPlayer.getCurrentPosition();
				mediaPlayer.stop();
			}
			
		}

		@Override
		public void callStateIdle(String path) {
			Log.d("cyyc", "service-callStateIdle");
//			mediaPlayer.start();
			if(position>0&&path!=null){
				play(position,path);
				position=0;
			}
			
		}
		private void play(int position,String path) {
			try {
				mediaPlayer.reset();//初始化各项参数
				mediaPlayer.setDataSource(path);
				mediaPlayer.prepare();
				mediaPlayer.setOnPreparedListener(new prepareListener(position));
			}  catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		private class prepareListener implements OnPreparedListener{
			private int position;
			public prepareListener(int position){
				this.position=position;
			}
			@Override
			public void onPrepared(MediaPlayer mp) {
				mediaPlayer.start();//开始播放
				if(position>0){
					mediaPlayer.seekTo(position);
				}
			}
			
		}

		
	}
	@Override
	public void onDestroy() {
		Log.d("cyyc", "service-onDestroy");
		mediaPlayer.release();
		mediaPlayer=null;
		Toast.makeText(this, "音乐服务结束", Toast.LENGTH_LONG).show();
		super.onDestroy();
	}

}
