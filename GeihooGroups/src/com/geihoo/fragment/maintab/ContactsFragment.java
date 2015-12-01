package com.geihoo.fragment.maintab;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.geihoo.activity.AddFriendsActivity;
import com.geihoo.activity.MainTabActivity;
import com.geihoo.adapter.FragmentAdapter;
import com.geihoo.base.BaseFragment;
import com.geihoo.fragment.contacts.ConnectionFragment;
import com.geihoo.fragment.contacts.RecentlyFragment;
import com.geihoo.groups.R;
import com.geihoo.listener.MyOnPageChangeListener;
/**
 * 
 * 通讯模块（信息，联系人）
 *
 * @author yy_cai
 *
 * 2015年11月24日
 */
public class ContactsFragment extends BaseFragment{
	static String tag="ContactsFragment";
	private ViewPager viewPager;
	private MainTabActivity activity;
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.activity=(MainTabActivity)activity;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_main_tab_contacts,container,false);
		
		initTopBar(view, activity.getResources().getString(R.string.top_title_tx));
		
		RadioGroup rgContacts =(RadioGroup)view.findViewById(R.id.rg_contacts);
		RadioButton recently=(RadioButton) rgContacts.findViewById(R.id.rb_contacts_recently);
		RadioButton tell=(RadioButton) rgContacts.findViewById(R.id.rb_contacts_tell);
		
		List<Fragment> fragments = new ArrayList<Fragment>();
		fragments.add(new RecentlyFragment());
		fragments.add(new ConnectionFragment());	
		viewPager = (ViewPager) view.findViewById(R.id.vp_contacts);  
		viewPager.setAdapter(new FragmentAdapter(getChildFragmentManager(),fragments));  
		viewPager.setOnPageChangeListener(new MyOnPageChangeListener(activity,viewPager,rgContacts,recently,tell));
		viewPager.setCurrentItem(0);
		
		return view;
	}
	@Override
	protected void initTopBar(View view,String title) {
		super.initTopBar(view,title);
		ImageView topHome = (ImageView)view.findViewById(R.id.iv_top_left);
		topHome.setOnClickListener(this);
		ImageView create = (ImageView)view.findViewById(R.id.iv_top_right);
		create.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.iv_top_left){
			activity.dealSlidingMenu();
		}
		if(v.getId()==R.id.iv_top_right){
			Intent i = new Intent(activity,AddFriendsActivity.class);
			startActivity(i);
		}
	}
	
}
