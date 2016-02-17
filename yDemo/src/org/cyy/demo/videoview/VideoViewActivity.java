package org.cyy.demo.videoview;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.cyy.demo.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class VideoViewActivity extends Activity implements OnClickListener {

	private final static SimpleDateFormat SDF = new SimpleDateFormat(
			"yyyyMMddHHmmss");

	// MediaPlayer mediaPlayer;
	// SurfaceHolder surfaceHolder;

	ImageView ivPhoto, ivVideo, imageView;

	File videofile = null;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video_view);
		initView();
		initData();
	}

	private void initView() {
		Button button = (Button) findViewById(R.id.b01);
		button.setOnClickListener(this);

		imageView = (ImageView) findViewById(R.id.iv01);
		ivPhoto = (ImageView) this.findViewById(R.id.iv_photo);
		ivVideo = (ImageView) this.findViewById(R.id.iv_video_thumbnail);

		ivVideo.setOnClickListener(this);
		this.findViewById(R.id.btn_photo).setOnClickListener(this);
		this.findViewById(R.id.btn_video).setOnClickListener(this);

		
	}

	private void initData() {
		File photoFile = new File("/sdcard/myAstImg");
		if (!photoFile.exists())
			photoFile.mkdirs();// 创建图片文件夹

		File videoFile = new File("/sdcard/aaa");
		if (!videoFile.exists())
			videoFile.mkdirs();// 创建视频文件夹

		/*
		 * MoviePlayerView movie = (MoviePlayerView) findViewById(R.id.video1);
		 * movie.play("/mnt/sdcard/video.mp4", new
		 * MoviePlayerView.OnPlayCompletionListener() {
		 * 
		 * @Override public void onPlayCompletion() {
		 * Toast.makeText(VideoViewActivity.this, "播放成功回调", 0).show();
		 * 
		 * } });
		 */

		/*
		 * SurfaceView surfaceView = (SurfaceView) findViewById(R.id.video1);
		 * surfaceHolder = surfaceView.getHolder(); mediaPlayer = new
		 * MediaPlayer(); surfaceHolder.setFixedSize(100, 100);
		 * surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		 * surfaceHolder.addCallback(new SurfaceHolder.Callback() {
		 * 
		 * @Override public void surfaceDestroyed(SurfaceHolder arg0) { // TODO
		 * Auto-generated method stub
		 * 
		 * }
		 * 
		 * @Override public void surfaceCreated(SurfaceHolder arg0) {
		 * mediaPlayer.setDisplay(surfaceHolder);
		 * 
		 * }
		 * 
		 * @Override public void surfaceChanged(SurfaceHolder arg0, int arg1,
		 * int arg2, int arg3) { // TODO Auto-generated method stub
		 * 
		 * } });
		 * 
		 * mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		 * 
		 * try { mediaPlayer.setDataSource("/mnt/sdcard/video.mp4");
		 * mediaPlayer.prepare(); mediaPlayer.start(); } catch (Exception e) { }
		 */
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.b01) {
			Intent intent = new Intent(Intent.ACTION_PICK, null);
			intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
					"image/*");
			startActivityForResult(intent, 3);
		} else if (v.getId() == R.id.btn_photo) {
			Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(intent, 1);
		} else if (v.getId() == R.id.btn_video) {
			Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
			intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
			videofile = new File("/sdcard/aaa/" + SDF.format(new Date())
					+ ".mp4");
			Uri originalUri = Uri.fromFile(videofile);// 这是个实例变量，方便下面获取视频的时候用
			Log.i("cyy-cyy", "uri=" + originalUri.getPath());
			intent.putExtra(MediaStore.EXTRA_OUTPUT, originalUri);
			startActivityForResult(intent, 2);
		} else if (v.getId() == R.id.iv_video_thumbnail) {
			if (videofile != null) {
				Intent i = new Intent(this, VideoViewDialog.class);
				i.putExtra("videoFile", videofile.getAbsolutePath());
				startActivity(i);
			}
		}
	}

	private Bitmap getVideoThumbnail(String videoPath, int width, int height,
			int kind) {
		Bitmap bitmap = null;
		// 获取视频的缩略图
		bitmap = ThumbnailUtils.createVideoThumbnail(videoPath, kind);
		System.out.println("w" + bitmap.getWidth());
		System.out.println("h" + bitmap.getHeight());
		bitmap = ThumbnailUtils.extractThumbnail(bitmap, width, height,
				ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
		return bitmap;
	}

	/**
	 * 开始裁剪
	 * 
	 * @param uri
	 */
	private void startCrop(Uri uri) {
		Intent intent = new Intent("com.android.camera.action.CROP");// 调用Android系统自带的一个图片剪裁页面,
		intent.setDataAndType(uri, "image/*");
		intent.putExtra("crop", "true");// 进行修剪
		// aspectX aspectY 是宽高的比例
		intent.putExtra("aspectX", 2);
		intent.putExtra("aspectY", 1);
		// outputX outputY 是裁剪图片宽高
		intent.putExtra("outputX", 500);
		intent.putExtra("outputY", 500);
		intent.putExtra("return-data", true);
		startActivityForResult(intent, 4);

		Log.i("cyy-cyy", "进入裁剪");
	}

	private Bitmap getBitmapFromUri(Uri uri) {
		try {
			Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
					.openInputStream(uri));
			return bitmap;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}



	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Log.i("cyy-cyy", "requestCode=" + requestCode);
		if (resultCode == Activity.RESULT_OK && requestCode == 1) {
			String sdStatus = Environment.getExternalStorageState();
			if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
				Toast.makeText(this, "您的sd卡没有加载成功", Toast.LENGTH_LONG).show();
				return;
			}
			Log.i("cyy-cyy", "sd卡路径："
					+ Environment.getExternalStorageDirectory()
							.getAbsolutePath());
			Bundle bundle = data.getExtras();
			Bitmap bitmap = (Bitmap) bundle.get("data");// 获取相机返回的数据，并转换为Bitmap图片格式
			FileOutputStream b = null;

			String img = SDF.format(new Date());
			String fileName = "/sdcard/myAstImg/" + img;
			try {
				b = new FileOutputStream(fileName + ".png");
				bitmap.compress(Bitmap.CompressFormat.PNG, 100, b);// 把数据写入文件,30是压缩率，表示压缩70%;如果不压缩是100，表示压缩率为0
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					b.flush();
					b.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			ivPhoto.setImageBitmap(bitmap);// 将图片显示在ImageView里
		} else if (resultCode == Activity.RESULT_OK && requestCode == 2) {
			Toast.makeText(this, "视频录制完成", 0).show();
			ivVideo.setImageBitmap(getVideoThumbnail(
					videofile.getAbsolutePath(), 400, 400,
					MediaStore.Images.Thumbnails.MICRO_KIND));
		} else if (resultCode == Activity.RESULT_OK && requestCode == 3) {
			// startCrop();
			Bitmap photo = getBitmapFromUri(data.getData());
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			photo.compress(Bitmap.CompressFormat.JPEG, 75, stream);// (0-100)压缩文件
			imageView.setImageBitmap(photo); // 把图片显示在ImageView控件上
		} else if (resultCode == Activity.RESULT_OK && requestCode == 4) {
			Log.i("cyy-cyy", "相册裁剪成功");
			Log.i("cyy-cyy", "裁剪以后 [ " + data + " ]");
			Bundle extras = data.getExtras();
			Bitmap photo = extras.getParcelable("data");
			// Bitmap photo = getBitmapFromUri(imageUri);
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			photo.compress(Bitmap.CompressFormat.JPEG, 75, stream);// (0-100)压缩文件
			imageView.setImageBitmap(photo); // 把图片显示在ImageView控件上
		}
	}
}
