package com.geihoo.test;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.geihoo.base.BaseDialog;
import com.geihoo.groups.R;

/**
 * @author yy_cai
 *
 * 2015年7月24日
 */
public class OneImageDialog extends BaseDialog{

	public OneImageDialog(Context context,int resId,String title) {
        super(context, R.style.Dialog);
        setContentView(R.layout.view_test);
        ImageView image = (ImageView)this.findViewById(R.id.image);
        image.setBackgroundResource(resId);
        this.findViewById(R.id.tv_top_left).setOnClickListener(this);
        TextView tvTitle = (TextView)this.findViewById(R.id.tv_top_title);
        tvTitle.setText(title);
	}
	@Override
	public void onClick(View v) {
		super.onClick(v);
	}


}
