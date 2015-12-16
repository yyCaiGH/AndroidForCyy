package com.geihoo.base;

import com.geihoo.bean.UserBean;
import com.geihoo.utils.Logger;

import android.app.Application;

public class BaseApplication extends Application{

	private UserBean user;
	@Override
	public void onCreate() {
		super.onCreate();
		Logger.i("GeiHoo", "-------------族族程序启动-----------");
		user = new UserBean();
		user.setNickName("Flying Girl");
	}
}
