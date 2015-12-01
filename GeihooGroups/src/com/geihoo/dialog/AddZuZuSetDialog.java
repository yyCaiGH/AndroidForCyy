package com.geihoo.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.geihoo.base.BaseDialog;
import com.geihoo.groups.R;

/**
 * 加族族设置
 * @author yy_cai
 *
 * 2015年7月24日
 */
public class AddZuZuSetDialog extends BaseDialog{

	private Context context;
	private RelativeLayout rl1,rl2;
	private ImageView iv1,iv2;
	public AddZuZuSetDialog(Context context,String title) {
        super(context, R.style.Dialog);
        setContentView(R.layout.dialog_add_zuzu);
        this.context=context;
        initTopBarAndBack(title);
        initView();
	}
	
	protected void initView() {
		rl1 = (RelativeLayout)this.findViewById(R.id.rl_1);
		rl1.setOnClickListener(this);
		rl2 = (RelativeLayout)this.findViewById(R.id.rl_2);
		rl2.setOnClickListener(this);
		iv1 = (ImageView)this.findViewById(R.id.iv_1);
		iv2 = (ImageView)this.findViewById(R.id.iv_2);
	}
	

	
	@Override
	public void onClick(View v) {
		super.onClick(v);
		if(v==rl1){
			iv1.setVisibility(View.VISIBLE);
			iv2.setVisibility(View.GONE);
		}
		else if(v==rl2){
			iv1.setVisibility(View.GONE);
			iv2.setVisibility(View.VISIBLE);
		}
	}

}
