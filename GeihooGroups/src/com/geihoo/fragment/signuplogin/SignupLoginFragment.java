package com.geihoo.fragment.signuplogin;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.geihoo.activity.SignupLoginActivity;
import com.geihoo.base.BaseFragment;
import com.geihoo.groups.R;

/**
 * 登录注册主页
 * 
 * @author hjs 2015.7.28
 */
public class SignupLoginFragment extends BaseFragment {

	private final static int SIGNBTN = 1;
	private final static int LOGINBTN = 2;

	Activity activity;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_signup_login, container,
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
		Button signButton = (Button) view.findViewById(R.id.signup_btn);
		Button loginButton = (Button) view.findViewById(R.id.login_btn);
		signButton.setTag(SIGNBTN);
		loginButton.setTag(LOGINBTN);
		signButton.setOnClickListener(this);
		loginButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		int tag = Integer.parseInt(v.getTag().toString());
		switch (tag) {
		case SIGNBTN:
			signup();
			break;
		case LOGINBTN:
			login();
			break;
		default:
			break;
		}
	}
	
	private void login() {
		LoginFragment loginFragment = new LoginFragment();
		((SignupLoginActivity)activity).replaceFragment(loginFragment, null);
	}
	private void signup(){
		((SignupLoginActivity)activity).replaceFragment(new EducationInfoFragment(), null);
	}
}
