package org.cyy.demo.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter{

	OneFragment oneF = new OneFragment();
	TowFragment towF = new TowFragment();
	ThreeFragment threeF = new ThreeFragment();
	public FragmentAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case MainTab.TAB_ONE:
			return oneF;
		case MainTab.TAB_TOW:
			return towF;
		case MainTab.TAB_THREE:
			return threeF;
		default:
			break;
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}
	
}
