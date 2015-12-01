package com.geihoo.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;

import com.geihoo.adapter.FragmentAdapter;
import com.geihoo.base.BaseActivity;
import com.geihoo.fragment.maintab.ContactsFragment;
import com.geihoo.fragment.maintab.DynamicFragment;
import com.geihoo.fragment.maintab.GroupFragment;
import com.geihoo.fragment.maintab.MeFragment;
import com.geihoo.groups.R;
import com.geihoo.listener.MyDrawerListener;
import com.geihoo.view.MyTabView;
import com.geihoo.view.MyViewPager;

public class MainTabActivity extends BaseActivity {

	private final static String tag = "MainTabActivity";
	// private GroupFragment groupF=new GroupFragment();
	// private ContactsFragment contactF=new ContactsFragment();
	// private DynamicFragment dynamicF=new DynamicFragment();
	// private NearbyFragment nearbyF=new NearbyFragment();
	private DrawerLayout mDrawerLayout;// 侧拉菜单
	private MyViewPager pager;
	private MyTabView tabView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_groups_main);
		init();
	}

	private void init() {
		mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawerLayout);

		mDrawerLayout.setDrawerListener(new MyDrawerListener(this));
		
		List<Fragment> fragments = new ArrayList<Fragment>();
		fragments.add(new GroupFragment());
		fragments.add(new ContactsFragment());
		fragments.add(new DynamicFragment());
		fragments.add(new MeFragment());
		
		pager = (MyViewPager) findViewById(R.id.cyy_view_pager);

		pager.setNoScroll(true);// 设置viewPager不滚动
		
		pager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),
				fragments));

		pager.setOffscreenPageLimit(3);// 预加载3个pager，后期真正有数据的时候，应该设置个判断值，如果已经加载过，就不再加载。除非下拉手动加载

		tabView = (MyTabView) findViewById(R.id.cyy_my_tab_view);

		int[] imageIds = { R.drawable.main_tab_st, R.drawable.main_tab_st_1,
				R.drawable.main_tab_tx, R.drawable.main_tab_tx_1,
				R.drawable.main_tab_dt, R.drawable.main_tab_dt_1,
				R.drawable.main_tab_me, R.drawable.main_tab_me_1, };

		String[] titles = { getResources().getString(R.string.tab_st),
				getResources().getString(R.string.tab_tx),
				getResources().getString(R.string.tab_dt),
				getResources().getString(R.string.tab_wo), };

		tabView.SetTabImages(imageIds);

		tabView.SetTabTitles(titles);

		tabView.SetViewPager(pager);

	}

	public void setPagerCurrentItem(int item){
		pager.setCurrentItem(item);
	}
	
	public void dealSlidingMenu() {
		mDrawerLayout.openDrawer(Gravity.LEFT);// 展开侧边的菜单
	}

}
