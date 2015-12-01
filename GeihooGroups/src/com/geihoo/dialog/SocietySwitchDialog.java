package com.geihoo.dialog;

import com.geihoo.groups.R;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class SocietySwitchDialog extends Dialog implements
		android.view.View.OnClickListener {

	public SocietySwitchDialog(Context context) {
		super(context, R.style.Dialog);
		setContentView(R.layout.activity_switch_society);
		initView();
	}

	private void initView() {
		// 顶部设置
		TextView title = (TextView) this.findViewById(R.id.tv_top_title);
		title.setText(R.string.switch_society);
		TextView backTextView = (TextView) this.findViewById(R.id.tv_top_left);
		backTextView.setText(R.string.back);
		this.findViewById(R.id.tv_top_right).setVisibility(View.GONE);
		backTextView.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		this.cancel();
	}
}
