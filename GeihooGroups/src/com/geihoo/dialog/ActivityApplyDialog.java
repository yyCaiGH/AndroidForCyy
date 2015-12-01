package com.geihoo.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.geihoo.base.BaseDialog;
import com.geihoo.groups.R;
import com.geihoo.utils.ToastUtil;

/**
 * 活动报名
 * @author yy_cai
 *
 * 2015年9月6日
 */
public class ActivityApplyDialog extends BaseDialog{

	private Context context;
	public ActivityApplyDialog(Context context) {
        super(context);
        setContentView(R.layout.dialog_activity_apply);
        this.context=context;
        initView();
	}
	
	protected void initView() {
		TextView tvTitle = (TextView)this.findViewById(R.id.tv_top_title);
		tvTitle.setText("报名");
		TextView tvBack = (TextView)this.findViewById(R.id.tv_top_left);
		tvBack.setOnClickListener(this);
		TextView tvNext = (TextView)this.findViewById(R.id.tv_top_right);
		tvNext.setVisibility(View.GONE);
		
		TextView sure = (TextView)this.findViewById(R.id.tv_act_sure);
		sure.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.tv_top_left){
			this.cancel();
		}
		else if(v.getId()==R.id.tv_act_sure){
			ToastUtil.showTextLong(context, "报名成功");
			this.cancel();
		}
	}
}
