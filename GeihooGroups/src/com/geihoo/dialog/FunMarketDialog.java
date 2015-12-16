package com.geihoo.dialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.geihoo.adapter.FunMarketAdapter;
import com.geihoo.adapter.NoticesAdapter;
import com.geihoo.base.BaseDialog;
import com.geihoo.bean.FunBean;
import com.geihoo.groups.R;
import com.geihoo.test.Datas;
import com.geihoo.utils.ImageUtil;

/**
 * 功能市场
 * @author yy_cai
 *
 * 2015年7月24日
 */
public class FunMarketDialog extends BaseDialog{

	private ListView marketFuns;
	private Context context;
	public FunMarketDialog(Context context) {
        super(context);
        setContentView(R.layout.dialog_fun_market);
        this.context=context;
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
		marketFuns.setAdapter(new FunMarketAdapter(Datas.getAllFuns(context), context));
	}

	
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.tv_top_left){
			this.cancel();
		}
	}

}
