package org.cyy.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.widget.Toast;

public class NoticeUtils {
	private static ProgressDialog pd;
	private static Toast toast;

	/**
	 * 显示ProgressDialog.
	 * 
	 * @param context
	 * @param title
	 * @param message
	 */
	public static void showDialog(Context context, String title, String message) {
		showDialog(context, title, message, false, null);
	}
	
	/**
	 * 
	 * @param context
	 * @param title
	 * @param messageId
	 */
	public static void showDialog(Context context, String title, int messageId) {
		showDialog(context, title, context.getString(messageId), false, null);
	}

	/**
	 * 显示ProgressDialog.
	 * 
	 * @param context
	 * @param title
	 * @param message
	 * @param canceledOnTouchOutside
	 * @param onDismissListener
	 */
	public static void showDialog(Context context, String title, String message, boolean canceledOnTouchOutside, OnDismissListener onDismissListener) {
		hideDialog();
		pd = new ProgressDialog(context);
		if(title != null) {
			pd.setTitle(title);
		}
		pd.setMessage(message);
		pd.setCanceledOnTouchOutside(canceledOnTouchOutside);
		pd.setOnDismissListener(onDismissListener);
		pd.show();
	}

	/**
	 * 隐藏ProgressDialog.
	 */
	public static void hideDialog() {
		if (pd != null && pd.isShowing()) {
			pd.dismiss();
		}
		pd = null;
	}

	/**
	 * 显示Toast.
	 * 
	 * @param context
	 * @param text
	 */
	public static void showToast(Context context, String text) {
		showToast(context, text, Toast.LENGTH_SHORT);
	}

	/**
	 * 显示Toast.
	 * 
	 * @param context
	 * @param text
	 * @param duration
	 */
	public static void showToast(Context context, String text, int duration) {
		if (toast != null) {
			toast.cancel();
		}
		toast = Toast.makeText(context, text, duration);
		toast.show();
	}
	
	/**
	 * 显示Toast.
	 * @param context
	 * @param resId
	 * @param duration
	 */
	public static void showToast(Context context, int resId, int duration) {
		if (toast != null) {
			toast.cancel();
		}
		toast = Toast.makeText(context, context.getString(resId), duration);
		toast.show();
	}
	
}
