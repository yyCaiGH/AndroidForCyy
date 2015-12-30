package com.geihoo.fragment.zuzu.maintab;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.geihoo.activity.MemberActivity;
import com.geihoo.activity.SocietyDocumentActivity;
import com.geihoo.activity.SocietySettingsActivity;
import com.geihoo.activity.ZuZuActivityActivity;
import com.geihoo.base.BaseFragment;
import com.geihoo.dialog.SocietyPostedSetDialog;
import com.geihoo.groups.R;
import com.geihoo.test.WeDialog;

/**
 * 我们模块
 * 
 * @author yy_cai
 * 
 * 2015年12月29日
 */
public class SocietyWeFragment extends BaseFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_we_sociaty, container,false);
		// 初始化界面
		initView(view);
		return view;
	}

	protected void initView(View view) {
		// TODO Auto-generated method stub
		TextView headLeft = (TextView) view.findViewById(R.id.tv_top_left);
		headLeft.setOnClickListener(this);
		TextView title = (TextView) view.findViewById(R.id.tv_top_title);
		title.setText("我们");
		TextView zzActivity = (TextView) view.findViewById(R.id.tv_we_activity);
		zzActivity.setOnClickListener(this);
		TextView zzFile = (TextView) view.findViewById(R.id.tv_we_file);
		zzFile.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.tv_top_left) {
			getActivity().finish();
		} 
		else if(v.getId() == R.id.tv_we_activity){
			Intent i = new Intent(this.getActivity(),ZuZuActivityActivity.class);
			startActivity(i);
		}
		else if(v.getId()==R.id.tv_we_file){
			Intent intent = new Intent();
			intent.setClass(getActivity(), SocietyDocumentActivity.class);
			startActivity(intent);
		}
	}

}
