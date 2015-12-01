package com.geihoo.fragment.me;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.geihoo.activity.MeActivity;
import com.geihoo.base.BaseFragment;
import com.geihoo.groups.R;
import com.geihoo.view.CustomImageView;

/**
 * 
 * 更改族族封面或头像
 * 
 * @author yy_cai
 * 
 *         2015年11月25日
 */
public class UpdateMyInfoFragment extends BaseFragment {
	private MeActivity activity;
	public final static int UPDATE_HEAD = 0x100;
	public final static int UPDATE_NIKENAME = 0x101;
	public final static int UPDATE_SEX = 0x102;
	public final static int UPDATE_AREA = 0x103;
	public final static int UPDATE_ABOUT = 0x104;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.activity = (MeActivity) activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_my_info_photo,
				container, false);
		initView(view);
		return view;
	}

	@Override
	protected void initView(View view) {
		int type = this.getArguments().getInt("type");
		LinearLayout updateImg = (LinearLayout)view.findViewById(R.id.ll_update_img);
		LinearLayout updateText = (LinearLayout)view.findViewById(R.id.ll_update_text);
		TextView key = (TextView) view.findViewById(R.id.tv_key);
		EditText value = (EditText) view.findViewById(R.id.et_value);
		switch (type) {
		case UPDATE_HEAD:
			updateImg.setVisibility(View.VISIBLE);
			updateText.setVisibility(View.GONE);
			activity.setTitle("更换头像");
			TextView tv = (TextView) view.findViewById(R.id.tv_edit_img);
			CustomImageView civHeadImg = (CustomImageView) view
					.findViewById(R.id.civ_image);
			tv.setText("更换头像");
			break;
		case UPDATE_NIKENAME:
			activity.setTitle("更改昵称");
			key.setText("昵称");
			value.setHint("请输入你的昵称");
			break;
		case UPDATE_SEX:
			activity.setTitle("更改性别");
			key.setText("性别");
			value.setHint("请选择你的性别");
			break;
		case UPDATE_AREA:
			activity.setTitle("更改地区");
			key.setText("地区");
			value.setHint("请输入你的地区");
			break;
		case UPDATE_ABOUT:
			activity.setTitle("更改简介");
			key.setText("简介");
			value.setHint("请输入你的简介");
			break;
		default:
			break;
		}
	}
}
