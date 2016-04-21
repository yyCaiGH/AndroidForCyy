package org.cyy.demo.dealimge;

import org.cyy.demo.R;


import org.cyy.util.FileUtils;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class DealImageActivity extends Activity implements OnClickListener{
	public static final String BASE_DIR = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Airefly";
//	public static final String BASE_DIR = Environment.getExternalStorageDirectory()+ "/Firefly";
	public static final String IMAGE_DIR = BASE_DIR + "/image/";//本地图片名存储位置
	ImageView iv1,iv2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_deal_image);
		iv1 = (ImageView)this.findViewById(R.id.imageView1);
		iv1.setOnClickListener(this);
		iv2 = (ImageView)this.findViewById(R.id.imageView2);
		iv2.setOnClickListener(this);
		FileUtils.createDirectory(BASE_DIR);
		FileUtils.createDirectory(IMAGE_DIR);
	}
	@Override
	public void onClick(View v) {
		if(v==iv1){
			CameraUtils.getImageFromAlbum(this, 1);
		}
		if(v==iv2){
			CameraUtils.getImageFromAlbum(this, 2);
		}
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==1){
			Bitmap photo = CameraUtils.getBitmapOnActivityResult(this, data);
			
			iv1.setImageBitmap(BitmapFactory.decodeFile(IMAGE_DIR+"test100.jpg"));
			iv2.setImageBitmap(BitmapFactory.decodeFile(IMAGE_DIR+"test50.jpg"));
			
		}
		else if(requestCode==2){
			
		}
	}
}
