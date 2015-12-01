package com.geihoo.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;

public class ViewUtils {

	private static int status_bar_height=0;//状态栏高度
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
	
	public static int getLocationY(View v){
		int[] location = new int[2];
		v.getLocationOnScreen(location);
		return location[1];
	}
	
	public static void addStatusBar(Activity activity) {
        ViewGroup group = (ViewGroup) activity.findViewById(android.R.id.content);
        View view = new View(activity);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                getStatusBarHeight(activity));
        view.setBackgroundColor(Color.parseColor("#2EA1CE"));//设置颜色
        group.addView(view, lp);
    }


    private static int getStatusBarHeight(Context context)
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
}
