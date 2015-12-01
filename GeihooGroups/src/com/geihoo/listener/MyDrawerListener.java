package com.geihoo.listener;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.util.Log;
import android.view.View;
import android.view.animation.ScaleAnimation;

import com.geihoo.groups.R;
import com.geihoo.utils.Logger;
import com.nineoldandroids.view.ViewHelper;

public class MyDrawerListener implements DrawerListener{

	private Activity activity;
	public MyDrawerListener(Activity activity) {
		this.activity = activity;
	}
	@Override
	public void onDrawerSlide(View drawerView, float slideOffset) {
//		View mContent = mDrawerLayout.getChildAt(0);
		View mContent = activity.findViewById(R.id.ll_main_content);
		View mMenu = drawerView;
		float scale = 1 - slideOffset;
//		float rightScale = 0.8f + scale * 0.2f;//缩放

		if (drawerView.getId()==R.id.fragment_left_menu) {// 展开左侧菜单
//			float leftScale = 1 - 0.3f * scale;
			// 设置左侧菜单缩放效果
//			ViewHelper.setScaleX(mMenu, leftScale);
//			ViewHelper.setScaleY(mMenu, leftScale);
//			ViewHelper.setAlpha(mMenu, 0.6f + 0.4f * (1 - scale));
			// 设置中间View缩放效果
			ViewHelper.setTranslationX(mContent,
					mMenu.getMeasuredWidth() * (1 - scale));
			ViewHelper.setPivotX(mContent, 0);
			ViewHelper.setPivotY(mContent,
					mContent.getMeasuredHeight() / 2);
			mContent.invalidate();
//			ViewHelper.setScaleX(mContent, rightScale);
//			ViewHelper.setScaleY(mContent, rightScale);
		}
		
	}

	@Override
	public void onDrawerOpened(View drawerView) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDrawerClosed(View drawerView) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDrawerStateChanged(int newState) {
		// TODO Auto-generated method stub
		
	}



}
