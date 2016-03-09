package org.cyy.test;

import org.cyy.base.BaseFragment;
import org.cyy.ybase.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

public class TestFragment2 extends BaseFragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_test, container,false);
		TextView tv = (TextView)view.findViewById(R.id.textView1);
		tv.setText("Fragment2");
		RatingBar rb = (RatingBar)view.findViewById(R.id.ratingBar1);
		rb.setRating(4);
		return view;
	}

}
