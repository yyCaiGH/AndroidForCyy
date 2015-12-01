package com.geihoo.fragment.zuzu.maintab;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.geihoo.activity.MemberActivity;
import com.geihoo.activity.SocietyDocumentActivity;
import com.geihoo.activity.SocietySettingsActivity;
import com.geihoo.base.BaseFragment;
import com.geihoo.dialog.SocietyPostedSetDialog;
import com.geihoo.groups.R;
import com.geihoo.test.WeDialog;

/**
 * 更多模块
 * 
 * @author czz
 * 
 *         2015年7月23日
 */
public class SocietyMoreFragment extends BaseFragment {
	private TextView member, headLeft, headRight, title;
	private TextView settings, describe, toDestTop, document;
	private LinearLayout noticeSet;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_society_more, container,false);
		// 获取控件
		findWidget(view);
		// 初始化界面
		initView();
		// 监听事件
		initListener();

		return view;
	}

	private void initListener() {
		// TODO Auto-generated method stub
		headLeft.setOnClickListener(this);
		member.setOnClickListener(this);
		settings.setOnClickListener(this);
		noticeSet.setOnClickListener(this);
		toDestTop.setOnClickListener(this);
		document.setOnClickListener(this);

	}

	@SuppressLint("NewApi")
	private void initView() {
		// TODO Auto-generated method stub
		title.setText(R.string.more_title);
	}

	// 获取控件
	private void findWidget(View view) {
		// TODO Auto-generated method stub
		headLeft = (TextView) view.findViewById(R.id.tv_top_left);
		member = (TextView) view.findViewById(R.id.tv_member);
		headRight = (TextView) view.findViewById(R.id.tv_top_right);
		title = (TextView) view.findViewById(R.id.tv_top_title);

		settings = (TextView) view.findViewById(R.id.tv_more_settings);
		describe = (TextView) view.findViewById(R.id.tv_more_society_describe);
		noticeSet = (LinearLayout) view.findViewById(R.id.tv_more_notice_set);
		toDestTop = (TextView) view.findViewById(R.id.tv_more_add_to_desktop);
		document = (TextView) view.findViewById(R.id.tv_more_document);

		view.findViewById(R.id.tv_more_we).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.tv_top_left) {
			getActivity().finish();
		} else if (v.getId() == R.id.tv_member) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), MemberActivity.class);
			startActivity(intent);
		} else if (v.getId() == R.id.tv_more_settings) {
			// 跳转到page27
			Intent intent = new Intent();
			intent.setClass(getActivity(), SocietySettingsActivity.class);
			startActivity(intent);
		} else if (v.getId() == R.id.tv_more_notice_set) {
			// 族族通知设置
			new SocietyPostedSetDialog(getActivity(), "旅游").show();
		} else if (v.getId() == R.id.tv_more_document) {
			// 跳转到page34文件
			Intent intent = new Intent();
			intent.setClass(getActivity(), SocietyDocumentActivity.class);
			startActivity(intent);
		} else if (v.getId() == R.id.tv_more_add_to_desktop) {
			// 将社团添加都手机桌面

		} else if (v.getId() == R.id.tv_more_we) {
			new WeDialog(getActivity()).show();
		}
	}

}
