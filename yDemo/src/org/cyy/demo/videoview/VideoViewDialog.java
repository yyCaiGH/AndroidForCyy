package org.cyy.demo.videoview;

import org.cyy.demo.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * 通知
 * 
 * @author yy_cai
 * 
 *         2015年7月24日
 */
public class VideoViewDialog extends Activity {
	private VideoView video1;
	MediaController mediaco;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.dialog_video_view);
		initView();
		initData();
		String videoFile = this.getIntent().getStringExtra("videoFile");
		videPlay(videoFile);
	}

	private void initView() {
		video1 = (VideoView) findViewById(R.id.video1);
	}

	private void initData() {
		// VideoView与MediaController进行关联
		mediaco = new MediaController(this);
		video1.setMediaController(mediaco);
	}
	private void videPlay(String videofile) {
//		Uri uri = null;
//		uri = Uri.parse("http://192.168.1.111:8080/image_upload/video.mp4");
//		video1.setVideoURI(uri);
		video1.setVideoPath(videofile);
		mediaco.setMediaPlayer(video1);
		// 让VideiView获取焦点
		video1.requestFocus();
		video1.start();
		
	}
	

}
