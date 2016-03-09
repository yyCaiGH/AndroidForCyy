package org.cyy.base;


import org.cyy.ybase.R;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public abstract class BaseDialog extends Dialog implements android.view.View.OnClickListener,OnItemClickListener{

	public BaseDialog(Context context, int theme) {
		super(context, theme);
		initView();
		initData();
	}

	/**
	 * 默认进行全屏设置
	 * @param context
	 */
	public BaseDialog(Context context){
		super(context,R.style.Dialog);
	}
	/**
	 * 初始化标题栏
	 * @param view
	 * @param title
	 */
	protected  void initTopBar(String title){
		TextView tvTitle = (TextView)this.findViewById(R.id.tv_topbar_title);
		tvTitle.setText(title);
	}
	/**
	 * 在setContentView后调用
	 * 功能：
	 * 1、设置标题title
	 * 2、设置左边返回监听
	 */
	protected void initTopBarAndBack(String title){
		TextView back = (TextView)this.findViewById(R.id.tv_topbar_left);
		back.setOnClickListener(this);
		initTopBar(title);
	}
	/**
	 * 初始化界面
	 * @param view
	 */
	abstract void initView();
	/**
	 * 初始化数据
	 */
	abstract void initData();
	
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.tv_topbar_left){
			this.cancel();
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		
	}


}
