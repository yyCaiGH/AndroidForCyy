package com.geihoo.activity;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.geihoo.adapter.FragmentAdapter;
import com.geihoo.base.BaseActivity;
import com.geihoo.bean.ZuZuBean;
import com.geihoo.fragment.zuzu.maintab.SocietyActivityFragment;
import com.geihoo.fragment.zuzu.maintab.SocietyMainFragment;
import com.geihoo.fragment.zuzu.maintab.SocietyMoreFragment;
import com.geihoo.fragment.zuzu.maintab.SocietyPhotoFragment;
import com.geihoo.fragment.zuzu.maintab.SocietyWeFragment;
import com.geihoo.groups.R;
import com.geihoo.listener.MyDrawerListener;
import com.geihoo.view.MyTabView;

public class SocietyMainActivity extends BaseActivity{

	private final static String tag = "SocietyMainActivity";
	private ViewPager pager;
	private MyTabView tabView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_society_main);
		init();
		
	}


	private void init() {
		Bundle bundle = new Bundle();
		bundle.putParcelable("zuzu", this.getIntent().getParcelableExtra("zuzu"));
		//侧拉菜单
		DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawerLayout);
		mDrawerLayout.setDrawerListener(new MyDrawerListener(this));
		
		SocietyMainFragment societyMainFragment = new SocietyMainFragment();
		societyMainFragment.setArguments(bundle);
		List<Fragment> fragments = new ArrayList<Fragment>();
		fragments.add(societyMainFragment);
		fragments.add(new SocietyPhotoFragment());
//		fragments.add(new SocietyChatFragment());
		fragments.add(new SocietyWeFragment());
		fragments.add(new SocietyMoreFragment());
		
		pager = (ViewPager) findViewById(R.id.society_pager);

		pager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),fragments));
		
//		pager.setOffscreenPageLimit(1);//限制保存在内存的pager数量吗？
		
		tabView = (MyTabView) findViewById(R.id.society_tab_view);
		
		int[] imageIds = {
				R.drawable.mainpage_icon_2,R.drawable.mainpage_icon_1,
				R.drawable.pic_icon_2,R.drawable.pic_icon_1,
				//R.drawable.group_chat_icon_2,R.drawable.group_chat_icon_1,
				R.drawable.activity_icon_2,R.drawable.activity_icon_1,
				R.drawable.more_icon_2,R.drawable.more_icon_1
		};
		
		String[] titles ={
				getResources().getString(R.string.society_tab1),
				getResources().getString(R.string.society_tab2),
//				"发现",
				//getResources().getString(R.string.society_tab3),
				getResources().getString(R.string.society_tab4),
				getResources().getString(R.string.society_tab5)
		};
		
		tabView.SetTabImages(imageIds);
		
		tabView.SetTabTitles(titles);
		
		tabView.SetViewPager(pager);

	}


}
