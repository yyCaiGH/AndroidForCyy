package com.geihoo.fragment.me;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.geihoo.activity.MeActivity;
import com.geihoo.activity.SocietyMainActivity;
import com.geihoo.adapter.FragmentAdapter;
import com.geihoo.base.BaseFragment;
import com.geihoo.dialog.CreateActivityDialog;
import com.geihoo.fragment.zuzu.activity.SocietyActivityAdvanceFragment;
import com.geihoo.fragment.zuzu.activity.SocietyActivityForeshowFragment;
import com.geihoo.groups.R;
import com.geihoo.listener.MyOnPageChangeListener;
/**
 * 
 * 我的活动(活动预告，往期活动)
 * 
 * @author yy_cai
 *
 * 2015年7月23日
 */
public class MyActivityFragment extends BaseFragment{
	static String tag="SocietyActivityFragment";
	private ViewPager viewPager;
	
	private MeActivity activity;
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.activity=(MeActivity)activity;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_my_activity, container,false);
		
		activity.setTitle("我的活动");
		
		RadioGroup rg=(RadioGroup) view.findViewById(R.id.rg_activity);
		
		List<Fragment> fragments = new ArrayList<Fragment>();
		fragments.add(new MyActivityForeshowFragment());
		fragments.add(new MyActivityAdvanceFragment());
		viewPager = (ViewPager) view.findViewById(R.id.vp_activity); 
		viewPager.setAdapter(new FragmentAdapter(getChildFragmentManager(),fragments));  
		viewPager.setCurrentItem(0);
		viewPager.setOnPageChangeListener(new MyOnPageChangeListener(activity, viewPager, rg, null, null));
		
		return view;
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		if(v.getId()==R.id.tv_top_right){
			new CreateActivityDialog(activity).show();
		}
	}
}
