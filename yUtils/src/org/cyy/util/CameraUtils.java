package org.cyy.util;

import java.io.ByteArrayOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
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
	 * 从相册选择图片，与getImageUrlFromAlbum和getStreamByImageUrl配套使用
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
	 * 通过拍照获取图片，与getStreamByImageUrl配套使用
	 */
	public static void getImageByCamera(Activity act, int requestCode,Uri uri){
		Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//action is capture
		cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
		act.startActivityForResult(cameraIntent, requestCode);
	}
	
	/**
	 * 从相册选择图片后，将url图片转换为Stream，与getImageFromAlbum配套使用
	 * 该方法通过减小采样值（减小bitmap的内存）结合图片压缩技术，让图片能够最小化还挺清晰。完美结合。
	 * @param act
	 * @param data
	 */
	public static ByteArrayOutputStream getStreamByImageUrl(String url) {
		Bitmap photo = getSmallBitmap(url);//缩放图片大小，避免图片过大，经过不断压缩，会导致图片失真
//		Bitmap photo = BitmapFactory.decodeFile(url);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		photo.compress(Bitmap.CompressFormat.JPEG, 100, baos);
		int options = 100;  
		//压缩图片不大于100kb,但是如果图片本身就很大，会造成过度失真
        while ( baos.toByteArray().length / 1024>100) {  //循环判断压缩后图片是否大于100kb,大于继续压缩     
            baos.reset();//重置baos即清空baos  
            photo.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
            Logger.i("CameraUtils", "已将图片压缩至大小："+baos.toByteArray().length / 1024+"KB");
            options -= 10;//每次都减少10  
            if(options==20){//不让过分压缩
            	break;
            }
        }  
        photo.recycle();//清理Bitmap
        photo=null;
		return baos;
	}

	/**
	 * 图片从相册返回时获取图片的地址
	 * @param act
	 * @param data
	 * @return
	 */
	public static String  getImageUrlFromAlbum(Activity act, Intent data){
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
		return url;
	}
	
	/**
	 * 根据图片路径获得图片并对图片进行缩放
	 * 
	 * @param filePath
	 * @return
	 */
	public static Bitmap getSmallBitmap(String filePath) {
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;//仅获取图片的宽高
		BitmapFactory.decodeFile(filePath, options);
//		 Calculate inSampleSize
		options.inSampleSize = calculateInSampleSize(options, 480, 800);//缩小到480*800,足够看的清了
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
