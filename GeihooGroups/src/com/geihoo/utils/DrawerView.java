package com.geihoo.utils;

import android.view.View;
import android.view.View.OnClickListener;

/**
 * 自定义SlidingMenu 测拉菜单类（已被DrawerLayout取代）
 * */
public class DrawerView implements OnClickListener {

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	/*private final Activity activity;
	SlidingMenu localSlidingMenu;

	public DrawerView(Activity activity) {
		this.activity = activity;
	}

	public SlidingMenu initSlidingMenu() {
		localSlidingMenu = new SlidingMenu(activity);
		localSlidingMenu.setMode(SlidingMenu.LEFT);// 设置左右滑菜单
		localSlidingMenu.setTouchModeAbove(SlidingMenu.SLIDING_WINDOW);// 设置要使菜单滑动，触碰屏幕的范围
		// localSlidingMenu.setTouchModeBehind(SlidingMenu.SLIDING_CONTENT);//设置了这个会获取不到菜单里面的焦点，所以先注释掉
		localSlidingMenu.setShadowWidthRes(R.dimen.shadow_width);// 设置阴影图片的宽度
		localSlidingMenu.setShadowDrawable(R.drawable.shadow);// 设置阴影图片
		localSlidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);// SlidingMenu划出时主页面显示的剩余宽度
		localSlidingMenu.setFadeDegree(0.35F);// SlidingMenu滑动时的渐变程度
		localSlidingMenu.attachToActivity(activity, SlidingMenu.RIGHT);// 使SlidingMenu附加在Activity右边
		// localSlidingMenu.setBehindWidthRes(R.dimen.left_drawer_avatar_size);//设置SlidingMenu菜单的宽度
		localSlidingMenu.setMenu(R.layout.view_slidingmenu);// 设置menu的布局文件
		// localSlidingMenu.toggle();//动态判断自动关闭或开启SlidingMenu
		localSlidingMenu
				.setOnOpenedListener(new SlidingMenu.OnOpenedListener() {
					public void onOpened() {

					}
				});
		localSlidingMenu.setOnClosedListener(new OnClosedListener() {

			@Override
			public void onClosed() {
				// TODO Auto-generated method stub

			}
		});
		initView();
		return localSlidingMenu;
	}

	private void initView() {
		TextView tvMes = (TextView) localSlidingMenu
				.findViewById(R.id.tv_sm_mes);
		tvMes.setOnClickListener(this);
		TextView tvSet = (TextView) localSlidingMenu
				.findViewById(R.id.tv_sm_set);
		tvSet.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent i = new Intent(activity, SlidingMenuActivity.class);
		String tagName = SlidingMenuActivity.FRAGMENT_TAG;
		if (v.getId() == R.id.tv_sm_mes) {
			i.putExtra(tagName, SlidingMenuActivity.NOTICE_FRAGMENT);
		} else if (v.getId() == R.id.tv_sm_set) {
			i.putExtra(tagName, SlidingMenuActivity.SET_FRAGMENT);
		}
		activity.startActivity(i);
		activity.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
	}
*/
}
