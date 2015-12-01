package com.geihoo.utils;

import android.content.Context;
import android.widget.Toast;
/**
 * Toast封装
 * @author yy_cai
 */
public class ToastUtil {
	/**
	 * duration is short
	 */
	public static void showTextShort(Context context, String content) {

		Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
	}
	
	/**
	 * duration is long
	 */
	public static void showTextLong(Context context, String content){
		
		Toast.makeText(context, content, Toast.LENGTH_LONG).show();
	}
}
