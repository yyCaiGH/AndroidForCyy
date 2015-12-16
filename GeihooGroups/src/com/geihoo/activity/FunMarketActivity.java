package com.geihoo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.geihoo.adapter.FunMarketAdapter;
import com.geihoo.base.BaseActivity;
import com.geihoo.groups.R;
import com.geihoo.test.Datas;

/**
 * 功能市场
 * @author yy_cai
 *
 * 2015年7月24日
 */
public class FunMarketActivity extends BaseActivity{

	private ListView marketFuns;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_fun_market);
        initView();
        initFunistView();
	}
	protected void initView() {
		TextView tvTitle = (TextView)this.findViewById(R.id.tv_top_title);
		tvTitle.setText("族族市场");
		TextView tvBack = (TextView)this.findViewById(R.id.tv_top_left);
		tvBack.setText("返回");
		tvBack.setOnClickListener(this);
		TextView tvNext = (TextView)this.findViewById(R.id.tv_top_right);
		tvNext.setVisibility(View.GONE);
	}
	
	private void initFunistView() {
		marketFuns = (ListView)this.findViewById(R.id.lv_fun_market);
		marketFuns.setAdapter(new FunMarketAdapter(Datas.getAllFuns(this), this));
	}

	
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.tv_top_left){
			this.finish();
		}
	}

}
