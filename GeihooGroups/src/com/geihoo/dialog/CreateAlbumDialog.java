package com.geihoo.dialog;

import com.geihoo.base.BaseDialog;
import com.geihoo.groups.R;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class CreateAlbumDialog extends BaseDialog{

	public CreateAlbumDialog(Context context) {
        super(context, R.style.Dialog);
        setContentView(R.layout.activity_create_album);
        initTopBarAndBack("创建相册");
        initView();
	}

	protected void initView() {
		TextView headRight=(TextView)findViewById(R.id.tv_top_right);
		headRight.setText("创建");
		headRight.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		if(v.getId()==R.id.tv_top_right){
			this.cancel();
		}
	}
	

}
