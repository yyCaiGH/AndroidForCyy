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
import com.geihoo.base.BaseFragment;
import com.geihoo.groups.R;

/**
 * 登录页面主页
 * 
 * @author hjs 2015.7.28
 */
public class LoginFragment extends BaseFragment {

	private final static int BACKTEXTVIEW = 1;
	private final static int LOGINBTN = 2;

	Activity activity;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_login, container,
				false);
		initData(view);
		return view;
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		this.activity = activity;
		super.onAttach(activity);
	}

	private void initData(View view) {
		TextView backTextView = (TextView) view.findViewById(R.id.tv_top_left);
		Button loginButton = (Button) view.findViewById(R.id.login_btn);
		backTextView.setTag(BACKTEXTVIEW);
		backTextView.setText(R.string.back);
		loginButton.setTag(LOGINBTN);
		view.findViewById(R.id.tv_top_title).setVisibility(View.GONE);
		view.findViewById(R.id.tv_top_right).setVisibility(View.GONE);
		backTextView.setOnClickListener(this);
		loginButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		int tag = Integer.parseInt(v.getTag().toString());
		switch (tag) {
		case BACKTEXTVIEW:
			back();
			break;
		case LOGINBTN:
			login();
			break;
		default:
			break;
		}
	}
	
	private void back(){
		activity.onBackPressed();
	}
	
	private void login() {
		Intent i = new Intent(getActivity(), MainTabActivity.class);
		startActivity(i);
		getActivity().overridePendingTransition(R.anim.anim_go_up,R.anim.anim_activity_out);
	}
}
