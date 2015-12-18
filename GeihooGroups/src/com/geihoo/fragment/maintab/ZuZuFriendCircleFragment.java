package com.geihoo.fragment.maintab;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.geihoo.activity.AddFriendsActivity;
import com.geihoo.activity.CreateFriendCircleActivity;
import com.geihoo.activity.CreateSocietyActivity;
import com.geihoo.activity.MainTabActivity;
import com.geihoo.adapter.FragmentAdapter;
import com.geihoo.base.BaseFragment;
import com.geihoo.fragment.contacts.ConnectionFragment;
import com.geihoo.fragment.contacts.RecentlyFragment;
import com.geihoo.fragment.zzfc.FriendCircleFragment;
import com.geihoo.fragment.zzfc.ZuZuFragment;
import com.geihoo.groups.R;
import com.geihoo.listener.MyOnPageChangeListener;
import com.geihoo.utils.Constant;
import com.geihoo.utils.ToastUtil;

/**
 * 
 * 族族和朋友圈tab
 *
 * @author yy_cai
 *
 * 2015年12月10日
 */
public class ZuZuFriendCircleFragment extends BaseFragment{

	static String tag="ZuZuFriendCircleFragment";
	private ViewPager viewPager;
	private MainTabActivity mActivity;
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.mActivity=(MainTabActivity)activity;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_tow_viewpager,container,false);
		
		initTopBar(view, "族族");
		
		RadioGroup rgTab =(RadioGroup)view.findViewById(R.id.rg);
		final RadioButton rbZuZu=(RadioButton) rgTab.findViewById(R.id.rb_left);
		rbZuZu.setText("圈子");
		final RadioButton rbFriendCircle=(RadioButton) rgTab.findViewById(R.id.rb_right);
		rbFriendCircle.setText("朋友圈");
		List<Fragment> fragments = new ArrayList<Fragment>();
		fragments.add(new ZuZuFragment());
		fragments.add(new FriendCircleFragment());	
		viewPager = (ViewPager) view.findViewById(R.id.vp_contacts);  
		viewPager.setAdapter(new FragmentAdapter(getChildFragmentManager(),fragments));  
		viewPager.setOnPageChangeListener(new MyOnPageChangeListener(mActivity,viewPager,rgTab,null,null));
		viewPager.setCurrentItem(0);
		
		rgTab.setOnCheckedChangeListener(new OnCheckedChangeListener() {//多设置了一遍监听，只监听第二次的
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				RadioButton rb = (RadioButton)group.findViewById(checkedId);
				if(rb==rbZuZu){
					viewPager.setCurrentItem(0);
					mActivity.setZzfcTabIndex(Constant.ZZFC_ZZ);
				}
				else if(rb==rbFriendCircle){
					viewPager.setCurrentItem(1);
					mActivity.setZzfcTabIndex(Constant.ZZFC_FC);
				}
			}
		});
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
			mActivity.dealSlidingMenu();
		}
		if(v.getId()==R.id.iv_top_right){
			if(mActivity.getZzfcTabIndex() == Constant.ZZFC_ZZ){
				Intent i = new Intent(getActivity(), CreateSocietyActivity.class);
				startActivity(i);
				getActivity().overridePendingTransition(R.anim.anim_go_up,R.anim.anim_activity_out);
			}
			else if(mActivity.getZzfcTabIndex() == Constant.ZZFC_FC){
				Intent i = new Intent(getActivity(), CreateFriendCircleActivity.class);
				startActivity(i);
				getActivity().overridePendingTransition(R.anim.anim_go_up,R.anim.anim_activity_out);
			}
		}
	}
}
