package com.geihoo.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.geihoo.base.BaseActivity;
import com.geihoo.base.BaseFragment;
import com.geihoo.fragment.signuplogin.SignupLoginFragment;
import com.geihoo.fragment.zuzu.photo.AlbumFragment;
import com.geihoo.groups.R;
/**
 * 
 * 查看相册Activity
 *
 * @author yy_cai
 *
 * 2015年11月29日
 */
public class AlbumActivity extends BaseActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_album);
		initView();
	}


	@Override
	protected void initView() {
		initFragment(new AlbumFragment(), null,R.id.fragment_album_activity);
	}
	
}
