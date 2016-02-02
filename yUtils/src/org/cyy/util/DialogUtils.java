package org.cyy.util;

import org.cyy.R;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class DialogUtils {

	/**
	 * 自定义view的AlertDialog
	 * @param ctx
	 */
	public static void createMyAlertDialog(Context ctx) {
		final AlertDialog dialog = new AlertDialog.Builder(ctx).create();
		dialog.show();
		Window window = dialog.getWindow();
		window.setContentView(R.layout.dialog_demo);
		initView(window);
	}

	private static void initView(Window window) {
		TextView tvSmallTitle = (TextView)window.findViewById(R.id.tv_dialog_demo_small_title);
		tvSmallTitle.setText("小标题");
	}

}
