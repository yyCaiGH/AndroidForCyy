package com.geihoo.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.geihoo.base.BaseDialog;
import com.geihoo.groups.R;
/**
 * 推送通知设置
 * @author yy_cai
 *
 * 2015年7月24日
 */
public class PushSetDialog extends BaseDialog{

	private Context context;
	public PushSetDialog(Context context) {
        super(context, R.style.Dialog);
        setContentView(R.layout.dialog_push_set);
        this.context=context;
        initView();
	}
	
	protected void initView() {
		TextView tvTitle = (TextView)this.findViewById(R.id.tv_top_title);
		tvTitle.setText(context.getResources().getString(R.string.top_title_tstz));
		TextView tvBack = (TextView)this.findViewById(R.id.tv_top_left);
		tvBack.setOnClickListener(this);
		TextView tvNext = (TextView)this.findViewById(R.id.tv_top_right);
		tvNext.setVisibility(View.GONE);
		
	}
	

	
	@Override
	public void onClick(View v) {
		super.onClick(v);
	}

}
