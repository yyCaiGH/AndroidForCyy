package org.cyy.yutils.sysfunction;

import android.app.Activity;
import android.content.Intent;
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
	public static void fromAlbumAndCrop(Activity act,int requestCode){
		Intent intent = new Intent(Intent.ACTION_PICK, null);
		intent.setType("image/*");
		intent.putExtra("crop", "true");
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		intent.putExtra("outputX", 200);
		intent.putExtra("outputY", 200);
		intent.putExtra("scale", true);
		intent.putExtra("return-data", true);
		// intent.putExtra("outputFormat",
		// Bitmap.CompressFormat.JPEG.toString());
		//intent.putExtra("noFaceDetection", false); // no face detection
		act.startActivityForResult(intent, requestCode);
	}
}
