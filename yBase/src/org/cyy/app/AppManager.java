package org.cyy.app;

import java.io.File;
import java.math.BigDecimal;
import java.util.Stack;

//import com.nostra13.universalimageloader.cache.disc.DiskCache;
//import com.nostra13.universalimageloader.core.ImageLoader;
//import com.tencent.weibo.sdk.android.api.util.SharePersistent;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * 应用程序Activity管理类：用于Activity管理和应用程序退出
 * @author liux (http://my.oschina.net/liux)
 * @version 1.0
 * @created 2012-3-21
 */
public class AppManager {
	
	private static Stack<Activity> activityStack;
	private static AppManager instance;
	
	private AppManager(){}
	/**
	 * 单一实例
	 */
	public static AppManager getAppManager(){
		if(instance==null){
			instance=new AppManager();
		}
		return instance;
	}
	/**
	 * 添加Activity到堆栈
	 */
	public void addActivity(Activity activity){
		if(activityStack==null){
			activityStack=new Stack<Activity>();
		}
		activityStack.add(activity);
	}
	/**
	 * 获取当前Activity（堆栈中最后一个压入的）
	 */
	public Activity currentActivity(){
		Activity activity=activityStack.lastElement();
		return activity;
	}
	/**
	 * 结束当前Activity（堆栈中最后一个压入的）
	 */
	public void finishActivity(){
		Activity activity=activityStack.lastElement();
		finishActivity(activity);
	}
	/**
	 * 结束指定的Activity
	 */
	public void finishActivity(Activity activity){
		if(activity!=null){
			activityStack.remove(activity);
			activity.finish();
			activity=null;
		}
	}
	/**
	 * 结束指定类名的Activity
	 */
	public void finishActivity(Class<?> cls){
		for (Activity activity : activityStack) {
			if(activity.getClass().equals(cls) ){
				finishActivity(activity);
			}
		}
	}
	/**
	 * 结束所有Activity
	 */
	public void finishAllActivity(){
		for (int i = 0, size = activityStack.size(); i < size; i++){
            if (null != activityStack.get(i)){
            	activityStack.get(i).finish();
            }
	    }
		activityStack.clear();
	}
	/**
	 * 结束除首页MainActivity之外的所有Activity
	 */
	public void finishAllActivityRemainMainActivity(){
		for (int i = 1, size = activityStack.size(); i < size; i++){
			if (null != activityStack.get(i)){
				activityStack.get(i).finish();
			}
		}
	}
	/**
	 * 判断当前堆栈中是否就一个Activity
	 */
	public boolean onlyActivity(){
		
		if(activityStack.size() > 1){
			return false;
		}
		return true;
	}
	/**
	 * 退出应用程序
	 */
	public void AppExit(Context context) {
		try {
//			ApiClient.setInstance(null);
			finishAllActivity();
			ActivityManager activityMgr= (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
			activityMgr.restartPackage(context.getPackageName()); //关闭所有与这个进程有关的线程
			System.exit(0);
		} catch (Exception e) {	}
	}
	
	/**
	 * 清除内存缓存
	 * @param view
	 */
//	public void clearMemoryClick() {
//	    ImageLoader.getInstance().clearMemoryCache();  // 清除内存缓存
//	}
	/**
	 * 清除本地缓存
	 * @param view
	 */
//	public void clearDiskClick() {
//	    ImageLoader.getInstance().clearDiskCache();  // 清除本地缓存
//	}
	/**
	 * 缓存文件大小 
	 */
//	public float getCacheFileSize(){
//		DiskCache diskCache = ImageLoader.getInstance().getDiskCache();//获取缓存对象
//		float size = 0;
//		if(diskCache.getDirectory().listFiles() != null){
//			for(File file : diskCache.getDirectory().listFiles()) {//遍历缓存文件
//				size += file.length();
//			}
//			float cacheSize = size / (1024 * 1024);				//缓存文件大小
//			BigDecimal bgDown = new BigDecimal(cacheSize);		//BigDecimal类则是针对大小数的处理类
//			cacheSize = bgDown.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
//			return cacheSize;
//		}else{
//			return (float) 0.00;
//		}
//	}
	
	/**
	 * 清除token
	 * @param context
	 */
	public void clearToken(Context context) {
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		Editor edt = sp.edit();
		edt.putBoolean("isLogin", false);// 将已成功登陆标记改成未登陆
		edt.putBoolean("haspermission", false);// 拥有扫描二维码权限置false
		edt.remove("token");
		edt.commit();
		
		//结束除了MainActivity之外的所有Activity
//		finishAllActivityRemainMainActivity();
		AppExit(context);
		//判断是否已登录过 登入过则显示会员界面,没登入过则显示登录界面
//		((MainActivity) activityStack.get(0)).isAlreadyLogin();
//		//跳转到会员标签
//		((MainActivity) activityStack.get(0)).getmScrollLayout().snapToScreen(2);
	}
}