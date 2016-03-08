package org.cyy.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/**
 * 
 * 说明：获取系统硬件参数
 *
 * @author yy_cai
 *
 * 2016年2月2日
 */
public class SysUtils {

	public static final int NETTYPE_NULL = 0x00;
	public static final int NETTYPE_WIFI = 0x01;
	public static final int NETTYPE_CMWAP = 0x02;
	public static final int NETTYPE_CMNET = 0x03;
	/**
	 * 检测当前系统声音是否为正常模式
	 * @return
	 */
	public static boolean isAudioNormal(Context ctx) {
		AudioManager mAudioManager = (AudioManager)ctx.getSystemService(Context.AUDIO_SERVICE); 
		return mAudioManager.getRingerMode() == AudioManager.RINGER_MODE_NORMAL;
	}
	
	/**
	 * 获取手机设备号
	 */
	public static String getMobileIMEI(Context ctx){
		 TelephonyManager tm = (TelephonyManager)ctx.getSystemService(Context.TELEPHONY_SERVICE);  
		 return tm.getDeviceId();
	}
	
	/**
	 * 检测网络是否可用
	 * @return
	 */
	public static boolean isNetworkConnected(Context ctx) {
		ConnectivityManager cm = (ConnectivityManager)ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getActiveNetworkInfo();
		return ni != null && ni.isConnectedOrConnecting();
	}

	/**

     * 判断是否是wifi连接

     */

    public static boolean isWifiConn(Context ctx){
        ConnectivityManager connectivity = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) return false;
        return connectivity.getActiveNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI;
    }
    
    /**
	 * Gps是否打开
	 * 需要<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />权限
	 *
	 * @param context the context
	 * @return true, if is gps enabled
	 */
	public static boolean isGpsEnabled(Context context) {
		LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);  
	    return lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
	}
	
	/**
	 * 判断当前网络是否是移动数据网络.
	 *
	 * @param context the context
	 * @return boolean
	 */
	public static boolean isMobile(Context context) {
		ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
		if (activeNetInfo != null
				&& activeNetInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
			return true;
		}
		return false;
	}
	
	/**
	 * 获取当前网络类型
	 * @return 0：没有网络   1：WIFI网络   2：WAP网络    3：NET网络
	 */
	@SuppressLint("DefaultLocale")
	public static int getNetworkType(Context ctx) {
		int netType = 0;
		ConnectivityManager connectivityManager = (ConnectivityManager)ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
		if (networkInfo == null) {
			return netType;
		}		
		int nType = networkInfo.getType();
		if (nType == ConnectivityManager.TYPE_MOBILE) {
			String extraInfo = networkInfo.getExtraInfo();
			if(!StringUtils.isEmpty(extraInfo)){
				if (extraInfo.toLowerCase().equals("cmnet")) {
					netType = NETTYPE_CMNET;
				} else {
					netType = NETTYPE_CMWAP;
				}
			}
		} else if (nType == ConnectivityManager.TYPE_WIFI) {
			netType = NETTYPE_WIFI;
		}
		return netType;
	}
	
}
