package org.cyy.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
/**
 * 屏幕工具
 * 说明：
 *
 * @author yy_cai
 *
 * 2016年2月2日
 */
public class ScreenUtil {

	private ScreenUtil(){

		throw new UnsupportedOperationException("ScreenUtil cannot be instantiated");

	}

	/**
	 * 得到view在屏幕的位置x,y,长,宽
	 * @param v
	 * @return
	 */
	public static int[] getLocation(View v) {
		int[] loc = new int[4];
		int[] location = new int[2];
		v.getLocationOnScreen(location);
		loc[0] = location[0];
		loc[1] = location[1];
		int w = View.MeasureSpec.makeMeasureSpec(0,
				View.MeasureSpec.UNSPECIFIED);
		int h = View.MeasureSpec.makeMeasureSpec(0,
				View.MeasureSpec.UNSPECIFIED);
		v.measure(w, h);

		loc[2] = v.getMeasuredWidth();
		loc[3] = v.getMeasuredHeight();

		// base = computeWH();
		return loc;
	}
	
	/**
	 * 获取屏幕宽度
	 * @param context
	 * @return
	 */
	public static int getScreenWidth(Context context){

		WindowManager wm = (WindowManager) context

		.getSystemService(Context.WINDOW_SERVICE);

		DisplayMetrics outMetrics = new DisplayMetrics();

		wm.getDefaultDisplay().getMetrics(outMetrics);

		return outMetrics.widthPixels;

	}

	/**
	 * 获取屏幕高度
	 * @param context
	 * @return
	 */
	public static int getScreenHeight(Context context) {

		WindowManager wm = (WindowManager) context

		.getSystemService(Context.WINDOW_SERVICE);

		DisplayMetrics outMetrics = new DisplayMetrics();

		wm.getDefaultDisplay().getMetrics(outMetrics);

		return outMetrics.heightPixels;

	}

	/**
	 * 获取状态栏高度
	 * @param context
	 * @return
	 */
	public static int getStatusHeight(Context context) {

		int statusHeight = -1;

		try {

			Class<?> clazz = Class.forName("com.android.internal.R$dimen");

			Object object = clazz.newInstance();

			int height = Integer.parseInt(clazz.getField("status_bar_height").get(object).toString());

			statusHeight = context.getResources().getDimensionPixelSize(height);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return statusHeight;

	}
	private static int status_bar_height=0;//状态栏高度
	/**
	 * 获取状态栏高度2
	 * @param context
	 * @return
	 */
	private static int getStatusHeight2(Context context)
    {
        if(status_bar_height != 0){
        	return status_bar_height;
        }
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0)
        {
        	status_bar_height = context.getResources().getDimensionPixelSize(resourceId);
        }
        return status_bar_height;
    }
	
	/**
	 * 添加状态栏（无状态栏的情况下可考虑添加）
	 * @param activity
	 */
	public static void addStatusBar(Activity activity) {
        ViewGroup group = (ViewGroup) activity.findViewById(android.R.id.content);
        View view = new View(activity);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
        		getStatusHeight2(activity));
        view.setBackgroundColor(Color.parseColor("#2EA1CE"));//设置颜色
        group.addView(view, lp);
    }


    
	/**
	 * 
	 * 获取当前屏幕截图，包含状态栏
	 */

	public static Bitmap snapShotWithStatusBar(Activity activity) {

		View view = activity.getWindow().getDecorView();

		view.setDrawingCacheEnabled(true);

		view.buildDrawingCache();

		Bitmap bmp = view.getDrawingCache();

		int width = getScreenWidth(activity);

		int height = getScreenHeight(activity);

		Bitmap bp = null;

		bp = Bitmap.createBitmap(bmp, 0, 0, width, height);

		view.destroyDrawingCache();

		return bp;

	}

	/**
	 * 
	 * 获取当前屏幕截图，不包含状态栏
	 * 
	 * 
	 */

	public static Bitmap snapShotWithoutStatusBar(Activity activity) {

		View view = activity.getWindow().getDecorView();

		view.setDrawingCacheEnabled(true);

		view.buildDrawingCache();

		Bitmap bmp = view.getDrawingCache();

		Rect frame = new Rect();

		activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);

		int statusBarHeight = frame.top;

		int width = getScreenWidth(activity);

		int height = getScreenHeight(activity);

		Bitmap bp = null;

		bp = Bitmap.createBitmap(bmp, 0, statusBarHeight, width, height

		- statusBarHeight);

		view.destroyDrawingCache();

		return bp;

	}
}
