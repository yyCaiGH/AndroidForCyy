package com.geihoo.fragment.slidingmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.geihoo.activity.SlidingMenuActivity;
import com.geihoo.activity.WelcomeActivity;
import com.geihoo.base.BaseFragment;
import com.geihoo.groups.R;
import com.geihoo.view.CustomImageView;

public class DrawerLeftMenuFragment extends BaseFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.view_slidingmenu, container,
				false);
		initView(view);
		return view;

	}

	protected void initView(View view) {
		int duration =500;
		CustomImageView civPhoto = (CustomImageView)view.findViewById(R.id.civ_photo_image);
		TextView tvName = (TextView)view.findViewById(R.id.tv_sm_user_name);
		setShowAnimation(civPhoto,1000,0);
		setShowAnimation(tvName,1000,100);
		TextView tvMes = (TextView) view.findViewById(R.id.tv_sm_mes);
		setTranslationAnimation(tvMes,duration,0);
		tvMes.setOnClickListener(this);
		TextView tvAct = (TextView) view.findViewById(R.id.tv_sm_activity);
		setTranslationAnimation(tvAct,duration,150);
		TextView tvFile = (TextView) view.findViewById(R.id.tv_sm_file);
		setTranslationAnimation(tvFile,duration,450);
		TextView tvSet = (TextView) view.findViewById(R.id.tv_sm_set);
		setTranslationAnimation(tvSet,duration,600);
		
//		View dl = view.findViewById(R.id.dividing_line);
//		Animation anim1 = AnimationUtils.loadAnimation(getActivity(), R.anim.anim_left_to_right);
//		dl.setAnimation(anim1);
		
	}
	
	@Override
	public void onClick(View v) {
		Intent i = new Intent(getActivity(), SlidingMenuActivity.class);
		String tagName = SlidingMenuActivity.FRAGMENT_TAG;
		if (v.getId() == R.id.tv_sm_mes) {
			i.putExtra(tagName, SlidingMenuActivity.NOTICE_FRAGMENT);
		} 
//		else if (v.getId() == R.id.tv_sm_set) {
//			i.putExtra(tagName, SlidingMenuActivity.SET_FRAGMENT);
//		}
		getActivity().startActivity(i);
		getActivity().overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
	}
	
	private void setShowAnimation( View view, int duration ,long startOffset){

	    AlphaAnimation showAnimation = new AlphaAnimation(0.0f, 1.0f);

	    showAnimation.setStartOffset(startOffset);
	    
	    showAnimation.setDuration( duration );

	    view.startAnimation( showAnimation );
	} 
	/**
	 * 从左向右移动
	 * @param view
	 * @param duration
	 * @param startOffset
	 */
	private void setTranslationAnimation(View view, int duration ,long startOffset){
		TranslateAnimation translationAnimation = new TranslateAnimation(-500f, 0f, 0f, 0f);
		
		translationAnimation.setStartOffset(startOffset);
	    
		translationAnimation.setDuration( duration );

	    view.startAnimation( translationAnimation );
	}
}
