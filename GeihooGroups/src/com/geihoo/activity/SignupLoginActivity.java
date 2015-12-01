package com.geihoo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.geihoo.base.BaseActivity;
import com.geihoo.base.BaseFragment;
import com.geihoo.fragment.signuplogin.SignupLoginFragment;
import com.geihoo.groups.R;

/**
 * 登录注册页面
 * 
 * @author hjs 2015.7.28
 */
public class SignupLoginActivity extends BaseActivity {

	public final static int SELECT_TYPE = 100;

	private SignupLoginFragment signupLoginFragment;
	/**
	 * Fragment事务
	 */
	private FragmentTransaction ft;

	/**
	 * 标志目前处于哪个Fragment
	 */
	private int tag;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_signup_login);
		init();
	}

	private void init() {
		signupLoginFragment = new SignupLoginFragment();
		initFragment(signupLoginFragment, null);
	}

	/**
	 * 第一次加载Fragment不要将事务加进后台栈,防止后退出现空白的现象
	 */
	private void initFragment(BaseFragment f, Bundle bundle) {
		ft = getSupportFragmentManager().beginTransaction();
		ft.add(R.id.fl_Signup_login, f);
		f.setArguments(bundle);
		ft.commit();
	}

	/**
	 * Fragment的替换(整个中心部分的替换（实质是覆盖）)
	 * 
	 * @param f
	 *            传递的参数
	 */
	public void replaceFragment(BaseFragment f, Bundle bundle) {
		ft = getSupportFragmentManager().beginTransaction();
		ft.replace(R.id.fl_Signup_login, f);
		f.setArguments(bundle);
		ft.addToBackStack(null);
		ft.commit();
	}

	@Override
	public void onClick(View v) {

	}

}
