package org.cyy.demo.customdialog;

import org.cyy.demo.R;


import org.cyy.view.dialog.SpotsDialog;

import android.app.Activity;
import android.os.Bundle;

public class CustomDialogActivity extends Activity{

	protected SpotsDialog spotsDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_test);
		showLoading("cyy");
	}
	
	/**
	 * 加载框
	 * 
	 * @param str
	 */
	public void showLoading(String str) {
		spotsDialog = new SpotsDialog(this);
		spotsDialog.setMessage(str);
		spotsDialog.show();
	}

	/**
	 * 销毁加载框
	 */
	public void hideLoading() {
		if (spotsDialog != null && spotsDialog.isShowing()) {
			spotsDialog.dismiss();
		}
		spotsDialog = null;
	}
}
