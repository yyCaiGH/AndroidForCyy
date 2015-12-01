package com.geihoo.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

public class TextViewUtils {

	/**
	 * 设置TextView的左边图像
	 * @param context
	 * @param view 
	 * @param imgId 图像id
	 * @param size 图像大小
	 */
	public static void setDrawableLeftImg(Context context,TextView view, int imgId, int size){
		Drawable drawable= context.getResources().getDrawable(imgId);
		drawable.setBounds(0, 0, size, size);
		view.setCompoundDrawables(drawable, null, null, null);
	}
}
