package com.geihoo.fragment.zuzu.set;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.geihoo.activity.SocietySettingsActivity;
import com.geihoo.base.BaseFragment;
import com.geihoo.groups.R;
import com.geihoo.view.CustomImageView;
/**
 * 
 * 更改族族封面或头像
 *
 * @author yy_cai
 *
 * 2015年11月25日
 */
public class SocietySetPhotoFragment extends BaseFragment {
	private SocietySettingsActivity activity;
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.activity=(SocietySettingsActivity)activity;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_society_set_photo, container,false);
		initView(view);
		return view;
	}

	@Override
	protected void initView(View view) {
		TextView tv = (TextView)view.findViewById(R.id.tv_edit_img);
		ImageView ivBgImg = (ImageView)view.findViewById(R.id.iv_zz_tx);
		CustomImageView civHeadImg = (CustomImageView)view.findViewById(R.id.civ_image);
		int type = this.getArguments().getInt("type");
		
		if(type==2){
			initTvBackTopBar(view, "选择封面照片");
			tv.setText("更改封面照片");
		}
		else if(type==1){
			initTvBackTopBar(view, "选择族族头像");
			tv.setText("更改族族头像");
			civHeadImg.setVisibility(View.VISIBLE);
			ivBgImg.setVisibility(View.GONE);
		}
	}
}
