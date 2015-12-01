package com.geihoo.test;

import android.content.Context;
import android.widget.ImageView;

import com.geihoo.base.BaseDialog;
import com.geihoo.groups.R;
import com.geihoo.utils.ImageUtil;

public class WeDialog extends BaseDialog{

	public WeDialog(Context context) {
		super(context);
		ImageView iv = new ImageView(context);
		iv.setImageBitmap(ImageUtil.readBitMap(context, R.drawable.page60));
		this.setContentView(iv);
	}

}
