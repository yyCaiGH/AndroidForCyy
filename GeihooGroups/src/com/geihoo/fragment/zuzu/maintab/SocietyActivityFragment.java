package com.geihoo.fragment.zuzu.maintab;

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
 * 活动(活动预告，往期活动)
 * 
 * @author czz
 *
 * 2015年7月23日
 */
public class SocietyActivityFragment extends BaseFragment{
	static String tag="SocietyActivityFragment";
	private ViewPager viewPager;
	
	private SocietyMainActivity activity;
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.activity=(SocietyMainActivity)activity;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_society_activity, container,false);
		
		initTvBackTopBar(view, "活动");
		
		RadioGroup rg=(RadioGroup) view.findViewById(R.id.rg_activity);
		
		List<Fragment> fragments = new ArrayList<Fragment>();
		fragments.add(new SocietyActivityForeshowFragment());
		fragments.add(new SocietyActivityAdvanceFragment());
		viewPager = (ViewPager) view.findViewById(R.id.vp_activity); 
		viewPager.setAdapter(new FragmentAdapter(getChildFragmentManager(),fragments));  
		viewPager.setCurrentItem(0);
		viewPager.setOnPageChangeListener(new MyOnPageChangeListener(activity, viewPager, rg, null, null));
		
		return view;
	}

	@Override
	protected void initTvBackTopBar(View view, String title) {
		super.initTvBackTopBar(view, title);
		//创建活动
		TextView createActivity=(TextView) view.findViewById(R.id.tv_top_right);
		Drawable drawable=getResources().getDrawable(R.drawable.top_add_image);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
		createActivity.setCompoundDrawables(drawable, null,null,null);
		createActivity.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		super.onClick(v);
		if(v.getId()==R.id.tv_top_right){
			new CreateActivityDialog(activity).show();
		}
	}
}
