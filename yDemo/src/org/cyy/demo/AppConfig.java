package org.cyy.demo;

import android.content.Context;
import android.os.Environment;

/**
 * 应用程序配置类：用于保存用户相关信息及设置
 * 
 * @version 1.0
 * @created 2016-2-2
 */
public class AppConfig {

	public final static String DEFAULT_SAVE_PATH = Environment.getExternalStorageDirectory() + "/yDemo/";
	public final static String AVATAR_SAVEPATH = DEFAULT_SAVE_PATH + "avatar/";
	public final static String IMAGES_SAVEPATH = DEFAULT_SAVE_PATH+"images/";
	public final static String AUDIO_SAVEPATH = DEFAULT_SAVE_PATH + "audio/";
	public final static String FILES_SAVEPATH = DEFAULT_SAVE_PATH + "files/";
	public final static String CRASHS_SAVEPATH = DEFAULT_SAVE_PATH + "crashs/";
	public final static String CACHE_SAVEPATH = DEFAULT_SAVE_PATH + "cache/";
	public final static String APK_SAVEPATH = DEFAULT_SAVE_PATH + "apk/";
	public final static String AVATAR_NAME = "head.jpg";
	
	public final static boolean DEVELOPER_MODE = false;//是否开发模式
	
	public final static int NOTIFICATION_UPDATE_APP = 0;
	public final static int NOTIFICATION_MEMBER_COMPAIGN = 1;
			
	private static AppConfig appConfig;

	public static AppConfig getAppConfig(Context context) {
		if (appConfig == null) {
			appConfig = new AppConfig();
		}
		return appConfig;
	}
}
