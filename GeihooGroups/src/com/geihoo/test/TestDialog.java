package com.geihoo.test;

import android.content.Context;

import com.geihoo.base.BaseDialog;
import com.geihoo.groups.R;

/**
 * @author yy_cai
 *
 * 2015年7月24日
 */
public class TestDialog extends BaseDialog{

	public TestDialog(Context context) {
        super(context, R.style.Dialog);
        setContentView(R.layout.view_test);
	}


}
