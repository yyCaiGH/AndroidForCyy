package com.geihoo.utils;

import java.io.InputStream;

import com.geihoo.groups.R;

import android.R.integer;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

public class ImageUtil {

	/*
	 * 以最省内存的方式读取本地资源的图片
	 * 
	 * @param context
	 * 
	 * @param resId
	 * 
	 * @return
	 */
	public static Bitmap readBitMap(Context context, int resId) {
		BitmapFactory.Options opt = new BitmapFactory.Options();
		opt.inPreferredConfig = Bitmap.Config.RGB_565;
		opt.inPurgeable = true;
		opt.inInputShareable = true;
		// 获取资源图片
		InputStream is = context.getResources().openRawResource(resId);
		return BitmapFactory.decodeStream(is, null, opt);
	}

	/**
	 * 缩放图片
	 * 
	 * @param context
	 * @param bitmap
	 * @param size
	 * @return
	 */
	public static Bitmap postScale(Context context, Bitmap bitmap, int size) {
		int bitmapWidth = bitmap.getWidth();
		int bitmapHeight = bitmap.getHeight();
		int dimen = (int) context.getResources().getDimension(size);// 缩放图片
		float scaleWidth = ((float) dimen) / bitmapWidth;
		float scaleHeight = ((float) dimen) / bitmapHeight;
		Matrix matrix = new Matrix();
		matrix.postScale(scaleWidth, scaleHeight);
		Bitmap newbm = Bitmap.createBitmap(bitmap, 0, 0, bitmapWidth,
				bitmapHeight, matrix, true);

		return newbm;
	}

	/**
	 * 通过id获取图片并缩放
	 * 
	 * @param context
	 *            所在的activity
	 * @param resId
	 *            图片id
	 * @param size
	 *            缩放尺寸
	 * @return
	 */
	public static Bitmap getImageById(Context context, int resId, int size) {
		return postScale(context, readBitMap(context, resId), size);
	}
}
