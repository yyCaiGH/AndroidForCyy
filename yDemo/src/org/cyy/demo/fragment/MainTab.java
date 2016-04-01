package org.cyy.demo.fragment;

import java.util.ArrayList;
import java.util.List;

import org.cyy.demo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainTab extends FragmentActivity implements OnClickListener{
	public static final String tag="MainTab";
	public static final int TAB_ONE = 0;
	public static final int TAB_TOW = 1;
	public static final int TAB_THREE = 2;
	private ViewPager viewPager;
	private RadioButton rb1, rb2, rb3;
	
//	protected SlidingMenu side_drawer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main_tab);
		initView();
		initSlidingMenu();
		Log.i(tag, "------------------onCreate over");
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i(tag, "------------------onResume over");
	}
	private void initSlidingMenu() {
		Button btn= (Button)this.findViewById(R.id.btn_cyy);
		btn.setOnClickListener(this);
//		side_drawer = new DrawerView(this).initSlidingMenu();
	}
	private void initView() {
		List<Fragment> _fragments = new ArrayList<Fragment>();
		_fragments.add(new ThreeFragment());
		_fragments.add(new TowFragment());
		_fragments.add(new OneFragment());
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		viewPager.setOffscreenPageLimit(2);
		viewPager.setOnPageChangeListener(new MyPageChangeListener());
		viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),_fragments));
		RadioGroup rg = (RadioGroup) findViewById(R.id.rg);
		rb1 = (RadioButton) rg.findViewById(R.id.rb1);
		rb2 = (RadioButton) rg.findViewById(R.id.rb2);
		rb3 = (RadioButton) rg.findViewById(R.id.rb3);
		rg.check(R.id.rb1);
//		Drawable drawable1 = getResources().getDrawable(R.drawable.home_image_bg);
//        drawable1.setBounds(0, 0, 40, 40);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
//        rb1.setCompoundDrawables(null,drawable1,null, null);//只放左边
        rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				Log.e(tag, "onCheckedChanged=");
				if(checkedId==R.id.rb1){
					viewPager.setCurrentItem(0);
				}
				else if(checkedId==R.id.rb2){
					viewPager.setCurrentItem(1);
				}
				else if(checkedId==R.id.rb3){
					viewPager.setCurrentItem(2);
				}
				
			}
		});
        
//		rb1.setOnClickListener(this);
//		rb2.setOnClickListener(this);
//		rb3.setOnClickListener(this);
		
		
	}
	private class MyPageChangeListener implements OnPageChangeListener{

		@Override
		public void onPageScrolled(int position, float positionOffset,
				int positionOffsetPixels) {
			Log.i("cyy-cyy", "当前页index ："+position);
			
		}

		@Override
		public void onPageSelected(int position) {
			Log.i(tag, "onPageSelected="+position);
			switch (position) {
			case TAB_ONE:
				rb1.setChecked(true);
				break;
			case TAB_TOW:
				rb2.setChecked(true);
				break;
			case TAB_THREE:
				rb3.setChecked(true);
				break;
			default:
				break;
			}
			
		}

		@Override
		public void onPageScrollStateChanged(int state) {
			
		}
		
	}
	@Override
	public void onClick(View v) {
		Log.i(tag, "onClick="+v.getId());
		switch (v.getId()) {
		case R.id.rb1:
			viewPager.setCurrentItem(TAB_ONE);
			break;
		case R.id.rb2:
			viewPager.setCurrentItem(TAB_TOW);
			break;
		case R.id.rb3:
			viewPager.setCurrentItem(TAB_THREE);
			break;
		case R.id.btn_cyy:
//			if(side_drawer.isMenuShowing()){
//				side_drawer.showContent();
//			}else{
//				side_drawer.showMenu();
//			}
			break;
		default:
			break;
		}
	}

	
}
