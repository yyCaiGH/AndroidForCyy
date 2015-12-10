package com.geihoo.listener;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.geihoo.groups.R;
/**
 * 
 * ViewPager+RadioGroup双页卡切换监听
 *
 * @author yy_cai
 *
 * 2015年11月24日
 */
public class MyOnPageChangeListener implements OnPageChangeListener{

	private RadioButton radioButtonLeft,radioButtonRight;
	/**
	 * 角标图片
	 */
	private static Drawable drawable;
	public MyOnPageChangeListener(Context ctx,final ViewPager pager,RadioGroup rg,RadioButton rbL,RadioButton rbR){
		if(drawable == null){
			drawable=ctx.getResources().getDrawable(R.drawable.line_blue_img);
			drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
		}
//		radioButtonLeft = rbL;
//		radioButtonRight = rbR;
		radioButtonLeft=(RadioButton)rg.getChildAt(0);
		radioButtonRight=(RadioButton)rg.getChildAt(2);
		rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				RadioButton rb = (RadioButton)group.findViewById(checkedId);
				if(rb==radioButtonLeft){
					pager.setCurrentItem(0);
				}
				else if(rb==radioButtonRight){
					pager.setCurrentItem(1);
				}
			}
		});
	}
	@Override
	public void onPageScrollStateChanged(int arg0) {
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}

	@Override
	public void onPageSelected(int position) {
		if(position==0){
			radioButtonLeft.setChecked(true);
			radioButtonLeft.setCompoundDrawables(null, null, null, drawable);
			radioButtonRight.setCompoundDrawables(null, null, null, null);
		}
		else if(position==1){
			radioButtonRight.setChecked(true);
			radioButtonLeft.setCompoundDrawables(null, null, null, null);
			radioButtonRight.setCompoundDrawables(null, null, null, drawable);
		}
		
	}

}
