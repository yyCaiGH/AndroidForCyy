package com.geihoo.activity;

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
import com.geihoo.base.BaseActivity;
import com.geihoo.base.BaseFragment;
import com.geihoo.dialog.CreateActivityDialog;
import com.geihoo.fragment.zuzu.activity.SocietyActivityAdvanceFragment;
import com.geihoo.fragment.zuzu.activity.SocietyActivityForeshowFragment;
import com.geihoo.groups.R;
import com.geihoo.listener.MyOnPageChangeListener;

/**
 * 
 * 族族活动Activity
 * 
 * @author yy_cai
 * 
 *         2015年12月29日
 */
public class ZuZuActivityActivity extends BaseActivity {
	static String tag = "ZuZuActivityActivity";
	private ViewPager viewPager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.fragment_society_activity);
		initTopBar();
		
		RadioGroup rg = (RadioGroup) this.findViewById(R.id.rg_activity);

		List<Fragment> fragments = new ArrayList<Fragment>();
		fragments.add(new SocietyActivityForeshowFragment());
		fragments.add(new SocietyActivityAdvanceFragment());
		viewPager = (ViewPager) this.findViewById(R.id.vp_activity);
		viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),
				fragments));
		viewPager.setCurrentItem(0);
		viewPager.setOnPageChangeListener(new MyOnPageChangeListener(this,
				viewPager, rg, null, null));
	}

	@Override
	protected void initTopBar() {
		TextView tvTitle = (TextView) this.findViewById(R.id.tv_top_title);
		TextView tvLeft = (TextView) this.findViewById(R.id.tv_top_left);
		// 创建活动
		TextView createActivity = (TextView) this
				.findViewById(R.id.tv_top_right);
		Drawable drawable = getResources()
				.getDrawable(R.drawable.top_add_image);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(),
				drawable.getMinimumHeight());
		createActivity.setCompoundDrawables(drawable, null, null, null);
		createActivity.setOnClickListener(this);
		tvTitle.setText("活动");
		tvLeft.setOnClickListener(this);
		createActivity.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		if (v.getId() == R.id.tv_top_right) {
			new CreateActivityDialog(this).show();
		}
		else if(v.getId() == R.id.tv_top_left){
			this.finish();
		}
	}
}
