package com.geihoo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.geihoo.base.BaseActivity;
import com.geihoo.base.BaseFragment;
import com.geihoo.fragment.zuzu.photo.AlbumFragment;
import com.geihoo.fragment.zuzu.set.SocietySettingsFragment;
import com.geihoo.groups.R;
/**
 * 族族设置
 * @author whd
 *
 */
public class SocietySettingsActivity extends BaseActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_society_settings);
		initView();
		
	}
	public void initView() {
		initFragment(new SocietySettingsFragment(), null,R.id.fragment_society_settings_id);
	}

}
