package com.geihoo.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.geihoo.base.BaseDialog;
import com.geihoo.groups.R;

/**
 * 族族发帖通知
 * @author yy_cai
 *
 * 2015年7月24日
 */
public class SocietyPostedSetDialog extends BaseDialog{

	private Context context;
	private RelativeLayout inappRl1,inappRl2,inappRl3,pushRl1,pushRl2,pushRl3;
	private ImageView inappIv1,inappIv2,inappIv3,pushIv1,pushIv2,pushIv3;
	public SocietyPostedSetDialog(Context context,String title) {
        super(context, R.style.Dialog);
        setContentView(R.layout.dialog_society_posted_set);
        this.context=context;
        initTopBarAndBack(title);
        initView();
	}
	
	protected void initView() {
		inappRl1 = (RelativeLayout)this.findViewById(R.id.rl_inapp_1);
		inappRl1.setOnClickListener(this);
		inappRl2 = (RelativeLayout)this.findViewById(R.id.rl_inapp_2);
		inappRl2.setOnClickListener(this);
		inappRl3 = (RelativeLayout)this.findViewById(R.id.rl_inapp_3);
		inappRl3.setOnClickListener(this);
		
		pushRl1 = (RelativeLayout)this.findViewById(R.id.rl_push_1);
		pushRl1.setOnClickListener(this);
		pushRl2 = (RelativeLayout)this.findViewById(R.id.rl_push_2);
		pushRl2.setOnClickListener(this);
		pushRl3 = (RelativeLayout)this.findViewById(R.id.rl_push_3);
		pushRl3.setOnClickListener(this);
		
		inappIv1 = (ImageView)this.findViewById(R.id.iv_inapp_1);
		inappIv2 = (ImageView)this.findViewById(R.id.iv_inapp_2);
		inappIv3 = (ImageView)this.findViewById(R.id.iv_inapp_3);
		pushIv1 = (ImageView)this.findViewById(R.id.iv_push_1);
		pushIv2 = (ImageView)this.findViewById(R.id.iv_push_2);
		pushIv3 = (ImageView)this.findViewById(R.id.iv_push_3);
	}
	

	
	@Override
	public void onClick(View v) {
		super.onClick(v);
		if(v==inappRl1){
			inappIv1.setVisibility(View.VISIBLE);
			inappIv2.setVisibility(View.GONE);
			inappIv3.setVisibility(View.GONE);
		}
		else if(v==inappRl2){
			inappIv2.setVisibility(View.VISIBLE);
			inappIv1.setVisibility(View.GONE);
			inappIv3.setVisibility(View.GONE);
		}
		else if(v==inappRl3){
			inappIv3.setVisibility(View.VISIBLE);
			inappIv1.setVisibility(View.GONE);
			inappIv2.setVisibility(View.GONE);
		}
		else if(v==pushRl1){
			pushIv1.setVisibility(View.VISIBLE);
			pushIv2.setVisibility(View.GONE);
			pushIv3.setVisibility(View.GONE);
		}
		else if(v==pushRl2){
			pushIv2.setVisibility(View.VISIBLE);
			pushIv1.setVisibility(View.GONE);
			pushIv3.setVisibility(View.GONE);
		}
		else if(v==pushRl3){
			pushIv3.setVisibility(View.VISIBLE);
			pushIv2.setVisibility(View.GONE);
			pushIv1.setVisibility(View.GONE);
		}
	}

}
