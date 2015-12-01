package com.geihoo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.geihoo.base.BaseActivity;
import com.geihoo.groups.R;
/**
 * 
 * 添加好友（从通讯录添加好友）
 *
 * @author yy_cai
 *
 * 2015年11月29日
 */
public class AddFriendsActivity extends BaseActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_add_friends);
		initView();
	}
	@Override
	protected void initView() {
		EditText etSearch = (EditText)this.findViewById(R.id.et_search);
		etSearch.setHint("搜索昵称/账号");
	}

	@Override
	protected void initTopBar() {
		TextView tvTitle = (TextView)this.findViewById(R.id.tv_top_title);
		tvTitle.setText("添加好友");
		TextView tvBack = (TextView)this.findViewById(R.id.tv_top_left);
		tvBack.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.tv_top_left){
			this.finish();
		}
	}


}
