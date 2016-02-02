package org.cyy.util;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
/**
 * 
 * 说明：安装、卸载apk，判断、停止服务
 *
 * @author yy_cai
 *
 * 2016年2月3日
 */
public class AppUtil {

	/**
	 * 获取App安装包信息
	 * @return
	 */
	public static PackageInfo getPackageInfo(Context ctx) {
		PackageInfo info = null;
		try { 
			info = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 0);
		} catch (NameNotFoundException e) {    
			e.printStackTrace(System.err);
		} 
		if(info == null) info = new PackageInfo();
		return info;
//		info.versionName //版本名称
//		info.versionCode //版本号
	}
	
	/**
	 * 描述：打开并安装文件.
	 *
	 * @param context the context
	 * @param file apk文件路径
	 */
	public static void installApk(Context context, File file) {
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setAction(android.content.Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.fromFile(file),
				"application/vnd.android.package-archive");
		context.startActivity(intent);
	}
	
	/**
	 * 描述：卸载程序.
	 *
	 * @param context the context
	 * @param packageName 包名
	 */
	public static void uninstallApk(Context context,String packageName) {
		Intent intent = new Intent(Intent.ACTION_DELETE);
		Uri packageURI = Uri.parse("package:" + packageName);
		intent.setData(packageURI);
		context.startActivity(intent);
	}


	/**
	 * 用来判断服务是否运行.
	 *
	 * @param ctx the ctx
	 * @param className 判断的服务名字 "com.xxx.xx..XXXService"
	 * @return true 在运行 false 不在运行
	 */
	public static boolean isServiceRunning(Context ctx, String className) {
		boolean isRunning = false;
		ActivityManager activityManager = (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningServiceInfo> servicesList = activityManager.getRunningServices(Integer.MAX_VALUE);
		Iterator<RunningServiceInfo> l = servicesList.iterator();
		while (l.hasNext()) {
			RunningServiceInfo si = (RunningServiceInfo) l.next();
			if (className.equals(si.service.getClassName())) {
				isRunning = true;
			}
		}
		return isRunning;
	}

	/**
	 * 停止服务.
	 *
	 * @param ctx the ctx
	 * @param className the class name
	 * @return true, if successful
	 */
	public static boolean stopRunningService(Context ctx, String className) {
		Intent intent_service = null;
		boolean ret = false;
		try {
			intent_service = new Intent(ctx, Class.forName(className));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (intent_service != null) {
			ret = ctx.stopService(intent_service);
		}
		return ret;
	}
}
