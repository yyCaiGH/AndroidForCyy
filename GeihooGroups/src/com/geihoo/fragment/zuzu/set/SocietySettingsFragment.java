package com.geihoo.fragment.zuzu.set;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geihoo.activity.SocietySettingsActivity;
import com.geihoo.base.BaseFragment;
import com.geihoo.groups.R;
import com.geihoo.utils.DialogUtil;
/**
 * 
 * 族族设置
 *
 * @author yy_cai
 *
 * 2015年11月25日
 */
public class SocietySettingsFragment extends BaseFragment {
	private SocietySettingsActivity activity;
	private TextView editName,editBackGroundPhoto,editPhoto,describe;
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		this.activity=(SocietySettingsActivity)activity;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_society_settings, container,false);
		initTvBackTopBar(view, "族族设置");
		initView(view);
		return view;
	}
	protected void initView(View view) {
		editBackGroundPhoto = (TextView) view.findViewById(R.id.tv_settings_background_photo);
		editBackGroundPhoto.setOnClickListener(this);
		editPhoto = (TextView) view.findViewById(R.id.tv_settings_photo);
		editPhoto.setOnClickListener(this);
		editName = (TextView) view.findViewById(R.id.tv_settings_name);
		editName.setOnClickListener(this);
		describe = (TextView) view.findViewById(R.id.tv_more_society_describe);
		describe.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		super.onClick(v);
		if(v==editPhoto){
			//设置族族头像
			Bundle bundle = new Bundle();
			bundle.putInt("type", 1);
			activity.replaceFragmentAndAddToBackStack(new SocietySetPhotoFragment(), bundle, R.id.fragment_society_settings_id);
		}else if(v==editName){
			//设置族族名称和简介
			activity.replaceFragmentAndAddToBackStack( new SocietySetNameFragment(), null,R.id.fragment_society_settings_id);
		}else if(v==editBackGroundPhoto){
			//设置族族背景
			Bundle bundle = new Bundle();
			bundle.putInt("type", 2);
			activity.replaceFragmentAndAddToBackStack(new SocietySetPhotoFragment(), bundle, R.id.fragment_society_settings_id);
		}else if(v==describe){
			String[] items =new String[]{"公开","封闭","私密"};
			DialogUtil.createSelectDescribeDialog(getActivity(),describe,items);
		}
	}

}
