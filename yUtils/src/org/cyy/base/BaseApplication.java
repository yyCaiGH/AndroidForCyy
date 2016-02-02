package org.cyy.base;

import org.cyy.util.Logger;

import android.app.Application;

public class BaseApplication extends Application{

//	private UserBean user;
	@Override
	public void onCreate() {
		super.onCreate();
		Logger.i("yUtils", "-------------应用程序启动-----------");
//		user = new UserBean();
//		user.setNickName("Flying Girl");
	}
}
