package org.cyy.demo.welcome;

import java.util.ArrayList;
import java.util.List;

import org.cyy.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

public class WelcomePageActivity extends Activity {
	private ViewPager awesomePager;
	private AwesomePagerAdapter awesomeAdapter;
	private LayoutInflater mInflater;
	private List<View> mListViews;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome_page);
		awesomeAdapter = new AwesomePagerAdapter();
		awesomePager = (ViewPager) findViewById(R.id.awesomepager);
		mListViews = new ArrayList<View>();
		mInflater = getLayoutInflater();
		View endView=mInflater.inflate(R.layout.welcome_layout3, null);
		mListViews.add(mInflater.inflate(R.layout.welcome_layout1, null));
		mListViews.add(mInflater.inflate(R.layout.welcome_layout2, null));
		mListViews.add(endView);
		awesomePager.setAdapter(awesomeAdapter);
	}

	private class AwesomePagerAdapter extends PagerAdapter{


		@Override
		public int getCount() {
			return mListViews.size();
		}
		@Override
		public Object instantiateItem(View collection, int position) {


			((ViewPager) collection).addView(mListViews.get(position),0);

			return mListViews.get(position);
		}

		@Override
		public void destroyItem(View collection, int position, Object view) {
			((ViewPager) collection).removeView(mListViews.get(position));
		}



		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view==(object);
		}

		@Override
		public void finishUpdate(View arg0) {}


		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {}

		@Override
		public Parcelable saveState() {
			return null;
		}

		@Override
		public void startUpdate(View arg0) {}

	}


}
