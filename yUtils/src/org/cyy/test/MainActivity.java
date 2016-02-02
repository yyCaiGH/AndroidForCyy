package org.cyy.test;

import java.util.ArrayList;
import java.util.List;

import org.cyy.R;
import org.cyy.base.BaseActivity;
import org.cyy.view.MyTabView;
import org.cyy.view.MyViewPager;
import org.cyy.view.adapter.FragmentAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class MainActivity extends BaseActivity{

	private MyViewPager pager;
	private MyTabView tabView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	private void init() {
		List<Fragment> fragments = new ArrayList<Fragment>();
		fragments.add(new TestFragment());
		fragments.add(new TestFragment2());
		fragments.add(new TestFragment());
		fragments.add(new TestFragment2());
		
		pager = (MyViewPager) findViewById(R.id.cyy_view_pager);

//		pager.setNoScroll(true);// 设置viewPager不滚动
		
		pager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),fragments));

		pager.setOffscreenPageLimit(3);// 预加载3个pager，后期真正有数据的时候，应该设置个判断值，如果已经加载过，就不再加载。除非下拉手动加载

		tabView = (MyTabView) findViewById(R.id.cyy_my_tab_view);

		int[] imageIds = { R.drawable.main_tab_st, R.drawable.main_tab_st_1,
				R.drawable.main_tab_st, R.drawable.main_tab_st_1,
				R.drawable.main_tab_st, R.drawable.main_tab_st_1,
				R.drawable.main_tab_st, R.drawable.main_tab_st_1, };

		String[] titles = { "现实","生命","生活","宇宙"};

		tabView.SetTabImages(imageIds);

		tabView.SetTabTitles(titles);

		tabView.SetViewPager(pager);
	}
}
