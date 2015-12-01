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
/**
 * 
 * 族族名称和简介
 *
 * @author yy_cai
 *
 * 2015年11月25日
 */
public class SocietySetNameFragment extends BaseFragment {
	private SocietySettingsActivity mActivity;
	private View view;
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mActivity=(SocietySettingsActivity)activity;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_society_set_name, container,false);
		initTvBackTopBar(view, "编辑名称和说明");
		return view;
	}
		

}
