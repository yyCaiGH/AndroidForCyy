package org.cyy.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * 
 * 说明：SharedPreferences，偏好设置工具
 *
 * @author yy_cai
 *
 * 2016年2月16日
 */
public class spUtils {

	/**
	 * 第一次启动存储一个偏好，每次都判断是否第一次启动
	 * 对第一次启动做针对性的处理
	 * @param ctx
	 * @return
	 */
	public static boolean isFirstStart(Context ctx){
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
		boolean first = prefs.getBoolean("first", true);
		if (first) {
			prefs.edit().putBoolean("first", false).commit();
			return true;
		}

		return false;
	}
}
