package com.geihoo.fragment.maintab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.geihoo.activity.MainTabActivity;
import com.geihoo.activity.MeActivity;
import com.geihoo.base.BaseFragment;
import com.geihoo.fragment.me.MyHomeFragment;
import com.geihoo.fragment.me.MyInfoFragment;
import com.geihoo.groups.R;
import com.geihoo.utils.DialogUtil;
import com.geihoo.utils.ImageUtil;

public class MeFragment extends BaseFragment{

	private View view ;
	private MainTabActivity activity;
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.activity=(MainTabActivity)activity;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_main_tab_me, container,false);
		initView();
		initData();
		return view;
	}
	private void initView() {
		initTopView();
		initClick();
	}
	private void initTopView() {
		ImageView topHome = (ImageView)view.findViewById(R.id.iv_top_left);
		topHome.setOnClickListener(this);
		TextView title = (TextView)view.findViewById(R.id.tv_top_title);
		title.setText(getActivity().getResources().getString(R.string.top_title_wo));
		ImageView create = (ImageView)view.findViewById(R.id.iv_top_right);
		create.setVisibility(View.GONE);
		
	}
	private void initClick() {
		view.findViewById(R.id.rl_me_collect).setOnClickListener(this);
		view.findViewById(R.id.rl_me_home).setOnClickListener(this);
		view.findViewById(R.id.rl_me_info).setOnClickListener(this);
		view.findViewById(R.id.rl_me_message).setOnClickListener(this);
		view.findViewById(R.id.rl_me_set).setOnClickListener(this);
		view.findViewById(R.id.rl_me_activity).setOnClickListener(this);
		view.findViewById(R.id.iv_me_erweima).setOnClickListener(this);
	}
	protected void initData() {
		
	}
	
	
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.iv_top_left){
			activity.dealSlidingMenu();
		}
		else if(v.getId()==R.id.rl_me_info){
			Intent i = new Intent(activity,MeActivity.class);
			i.putExtra("type", MeActivity.ME_INFO);
			startActivity(i);
		}
		else if(v.getId()==R.id.rl_me_home){
			Intent i = new Intent(activity,MeActivity.class);
			i.putExtra("type", MeActivity.ME_HOME);
			startActivity(i);
		}
		else if(v.getId()==R.id.rl_me_message){
			Intent i = new Intent(activity,MeActivity.class);
			i.putExtra("type", MeActivity.ME_MESSAGE);
			startActivity(i);
		}
		else if(v.getId()==R.id.rl_me_collect){
			Intent i = new Intent(activity,MeActivity.class);
			i.putExtra("type", MeActivity.ME_COLLECT);
			startActivity(i);
		}
		else if(v.getId()==R.id.rl_me_set){
			Intent i = new Intent(activity,MeActivity.class);
			i.putExtra("type", MeActivity.ME_SET);
			startActivity(i);
		}
		else if(v.getId()==R.id.rl_me_activity){
			Intent i = new Intent(activity,MeActivity.class);
			i.putExtra("type", MeActivity.ME_ACTIVITY);
			startActivity(i);
		}
		else if(v.getId()==R.id.iv_me_erweima){
			DialogUtil.showOneImageDialog(activity, ImageUtil.readBitMap(activity, R.drawable.weixindemo));
		}
	}
}
