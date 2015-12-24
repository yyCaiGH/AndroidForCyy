package com.geihoo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.geihoo.base.BaseActivity;
import com.geihoo.groups.R;
import com.geihoo.test.OneImageDialog;
import com.geihoo.test.WeDialog;
import com.geihoo.utils.DialogUtil;

/**
 * 
 * 添加好友（从通讯录添加好友）
 * 
 * @author yy_cai
 * 
 *         2015年11月29日
 */
public class AddFriendsActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_add_friends);
		initView();
	}

	@Override
	protected void initView() {
		initTopBar();
		EditText etSearch = (EditText) this.findViewById(R.id.et_search);
		etSearch.setHint("搜索昵称/账号");

		this.findViewById(R.id.tv_add_friend_from_wx).setOnClickListener(this);
		this.findViewById(R.id.tv_add_friend_from_fj).setOnClickListener(this);
		this.findViewById(R.id.tv_add_friend_from_ld).setOnClickListener(this);
		this.findViewById(R.id.tv_add_friend_from_sys).setOnClickListener(this);
		this.findViewById(R.id.tv_add_friend_from_txl).setOnClickListener(this);
	}

	@Override
	protected void initTopBar() {
		TextView tvTitle = (TextView) this.findViewById(R.id.tv_top_title);
		tvTitle.setText("添加好友");
		TextView tvBack = (TextView) this.findViewById(R.id.tv_top_left);
		tvBack.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.tv_top_left) {
			this.finish();
		} else if (v.getId() == R.id.tv_add_friend_from_wx) {
			String[]  items= {"通过微信好友邀请","通过微信朋友圈邀请"};
			DialogUtil.createSelectDialog(this, items);
		} else if (v.getId() == R.id.tv_add_friend_from_fj) {
			new OneImageDialog(this, R.drawable.add_friend_from_fj,"附近的人").show();
		} else if (v.getId() == R.id.tv_add_friend_from_ld) {
			new OneImageDialog(this,R.drawable.add_friend_from_ld,"雷达搜索").show();
		} else if (v.getId() == R.id.tv_add_friend_from_sys) {
			new OneImageDialog(this,R.drawable.add_friend_from_sys,"扫一扫").show();
		} else if (v.getId() == R.id.tv_add_friend_from_txl) {
			new OneImageDialog(this,R.drawable.add_friend_from_txl,"查看手机通讯录").show();
		}
	}

}
