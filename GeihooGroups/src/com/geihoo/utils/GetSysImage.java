package com.geihoo.utils;

import android.content.Intent;
import android.support.v4.app.Fragment;
/**
 * 
 * 获取系统图片
 *
 * @author yy_cai
 *
 * 2015年12月1日
 */
public class GetSysImage {

	/**
	 * return-data = true
	 * 从相册中获取照片，并直接裁剪
	 */
	public static void fromAlbumAndCrop(Fragment fragment,int requestCode,int aspectX,int aspectY,int outputX,int outputY){
		Intent intent = new Intent(Intent.ACTION_PICK, null);
		intent.setType("image/*");
		intent.putExtra("crop", "true");
		intent.putExtra("aspectX", aspectX);
		intent.putExtra("aspectY", aspectY);
		intent.putExtra("outputX", outputX);
		intent.putExtra("outputY", outputY);
//		intent.putExtra("scale", true);
		intent.putExtra("return-data", true);
		// intent.putExtra("outputFormat",
		// Bitmap.CompressFormat.JPEG.toString());
		//intent.putExtra("noFaceDetection", false); // no face detection
		fragment.startActivityForResult(intent, requestCode);
	}
}
