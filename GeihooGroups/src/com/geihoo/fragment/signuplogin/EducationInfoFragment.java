package com.geihoo.fragment.signuplogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.geihoo.activity.MainTabActivity;
import com.geihoo.activity.SignupLoginActivity;
import com.geihoo.base.BaseFragment;
import com.geihoo.fragment.zuzu.activity.DatePickerFragment;
import com.geihoo.groups.R;
/**
 * 教育信息
 * @author yy_cai
 *
 * 2015年7月28日
 */
public class EducationInfoFragment extends BaseFragment{

	private SignupLoginActivity parent;
	private View view;
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		parent=(SignupLoginActivity)activity;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_signup_education_info, container,false);
		init();
		initView();
		return view;
	}
	
	private void init() {
		
	}
	
	private void initView() {
		TextView back = (TextView)view.findViewById(R.id.tv_top_left);
		back.setText(parent.getResources().getString(R.string.top_left_back));
		TextView title = (TextView)view.findViewById(R.id.tv_top_title);
		title.setText(parent.getResources().getString(R.string.top_title_jyxx));
		TextView next = (TextView)view.findViewById(R.id.tv_top_right);
		next.setVisibility(View.GONE);
		Button sign=(Button) view.findViewById(R.id.sign);
		TextView birthday=(TextView) view.findViewById(R.id.birthday);
		
		back.setOnClickListener(this);
		sign.setOnClickListener(this);
		birthday.setOnClickListener(this);
//		next.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.tv_top_left){
			parent.onBackPressed();
		}
		else if(v.getId()==R.id.sign){
			Intent i = new Intent(getActivity(), MainTabActivity.class);
			startActivity(i);
			getActivity().overridePendingTransition(R.anim.anim_go_up,R.anim.anim_activity_out);
		}else if(v.getId()==R.id.birthday){
			DatePickerFragment datePicker = new DatePickerFragment();
			datePicker.show(getFragmentManager(), "datePicker");
		}
	}
}
