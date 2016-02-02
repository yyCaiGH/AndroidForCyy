package org.cyy.base;

import java.io.File;

import org.cyy.app.AppConfig;
import org.cyy.util.Logger;

import android.app.Application;
import android.os.Build;
import android.os.StrictMode;

public class BaseApplication extends Application{

	@SuppressWarnings("unused")
	@Override
	public void onCreate() {
		super.onCreate();
		Logger.i("App", "-------------应用程序启动-----------");
		//通过StrictMode可以检查程序的性能和存在的问题，是否有内存泄露等问题
		if (AppConfig.DEVELOPER_MODE && Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
			StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyDialog().build());
			StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyDeath().build());
		}
		init();
	}
	
	private void init() {
		createFolds();
	}

	/**
	 * 创建存放文件的文件夹
	 */
	public void createFolds(){
		
		File fold = new File(AppConfig.IMAGES_SAVEPATH);
		if(!fold.exists()){
			fold.mkdirs();
		}
//		fold = new File(AppConfig.CACHE_SAVEPATH);
//		if(!fold.exists()){
//			fold.mkdirs();
//		}
	}
	
}
