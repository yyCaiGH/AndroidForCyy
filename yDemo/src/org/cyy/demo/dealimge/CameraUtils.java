package org.cyy.demo.dealimge;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

/**
 * 
 * 获取系统图片
 * 
 * @author yy_cai
 * 
 *         2015年12月1日
 */
public class CameraUtils {

	/**
	 * return-data = true 从相册中获取照片，并直接裁剪
	 */
	public static void fromAlbumAndCrop(Activity act, int requestCode) {
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
		// intent.putExtra("noFaceDetection", false); // no face detection
		act.startActivityForResult(intent, requestCode);
	}

	/**
	 * 从相册选择图片，与getBitmapOnActivityResult配套使用
	 * 
	 * @param act
	 */
	public static void getImageFromAlbum(Activity act, int requestCode) {
		Intent intent = new Intent(Intent.ACTION_PICK, null);
		intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
				"image/*");
		act.startActivityForResult(intent, requestCode);
	}

	/**
	 * 从相册选择图片后，对Data处理获得图片，与getImageFromAlbum配套使用
	 * 
	 * @param act
	 * @param data
	 */
	public static Bitmap getBitmapOnActivityResult(Activity act, Intent data) {
		Uri uri = data.getData();
		String url = null;
		Cursor cur = act.getContentResolver()
				.query(uri, new String[] { MediaStore.Images.Media.DATA },
						null, null, null);
		if (cur != null && cur.moveToFirst()) {
			url = cur.getString(0);
		} else {
			Toast.makeText(act, "未获得图片", Toast.LENGTH_SHORT).show();
			return null;
		}
		Bitmap photo = getSmallBitmap(url);
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		photo.compress(Bitmap.CompressFormat.JPEG, 100, stream);// (0-100)压缩文件
		saveByteToSD(stream,"test100.jpg");
		
		stream.reset();
		photo.compress(Bitmap.CompressFormat.JPEG, 20, stream);// (0-100)压缩文件
		saveByteToSD(stream,"test50.jpg");
		Log.i("cyy-cyy", "压缩前的stream："+stream.toByteArray().length/1024+"kb");
		return photo;
	}

	
	public static String saveByteToSD(ByteArrayOutputStream baos,String fileName){
		File file = new File(DealImageActivity.IMAGE_DIR,fileName);
		try {
			FileOutputStream fos = new FileOutputStream(file);  
			fos.write(baos.toByteArray());  
			fos.flush();  
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file.getAbsolutePath();
	}
	
	/**
	 * 根据图片路径获得图片并对图片进行缩放，返回bitmap用于显示
	 * 
	 * @param filePath
	 * @return
	 */
	public static Bitmap getSmallBitmap(String filePath) {
		final BitmapFactory.Options options = new BitmapFactory.Options();
//		options.inJustDecodeBounds = true;//仅获取图片的宽高
//		BitmapFactory.decodeFile(filePath, options);
		// Calculate inSampleSize
//		options.inSampleSize = calculateInSampleSize(options, 240, 320);
		// Decode bitmap with inSampleSize set
		options.inJustDecodeBounds = false;
		return BitmapFactory.decodeFile(filePath, options);
	}

	/**
	 * 计算图片的缩放值
	 * @param options
	 * @param reqWidth
	 * @param reqHeight
	 * @return
	 */
	private static int calculateInSampleSize(BitmapFactory.Options options,int reqWidth, int reqHeight) {
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;
		if (height > reqHeight || width > reqWidth) {
			final int heightRatio = Math.round((float) height
					/ (float) reqHeight);
			final int widthRatio = Math.round((float) width / (float) reqWidth);
			inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
		}
		return inSampleSize;
	}
}
