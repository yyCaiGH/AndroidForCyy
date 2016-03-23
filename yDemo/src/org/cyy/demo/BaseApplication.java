package org.cyy.demo;

import java.io.File;

import org.cyy.util.Logger;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import android.app.Application;
import android.content.Context;
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
		//初始化图片加载第三方包
		initImageLoader(getApplicationContext());
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
	
	/**
	 * 初始化图片加载第三方包
	 * @param context
	 */
	public static void initImageLoader(Context context) {
		// This configuration tuning is custom. You can tune every option, you may tune some of them,
		// or you can create default configuration by
		//  ImageLoaderConfiguration.createDefault(this);
		// method.
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
				.threadPriority(Thread.NORM_PRIORITY - 2)
				.denyCacheImageMultipleSizesInMemory()
				.diskCacheFileNameGenerator(new Md5FileNameGenerator())
				.diskCacheSize(50 * 1024 * 1024) // 50 Mb
//				.discCache(new UnlimitedDiscCache(cacheDir))//自定义缓存路径 -- 废弃
				.diskCache(new UnlimitedDiscCache(new File(AppConfig.CACHE_SAVEPATH)))//自定义缓存路径 
//				.diskCache(new UnlimitedDiscCache(new File("")))//设置缓存保存路径
				.tasksProcessingOrder(QueueProcessingType.LIFO)
				.writeDebugLogs() // Remove for release app
				.build();
		// Initialize ImageLoader with configuration.
		ImageLoader.getInstance().init(config);
	}

}
