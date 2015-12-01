package com.geihoo.utils;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.geihoo.groups.R;
import com.geihoo.test.ArrayAdapter;

public class DialogUtil {

	/**
     * 创建普通对话框
     * 
     * @param ctx 上下文 必填
     * @param title 标题 必填
     * @param message 显示内容 必填
     * @param btnName 按钮名称 必填
     * @param listener 监听器，需实现android.content.DialogInterface.OnClickListener接口 必填
     * @return
     */

	public static AlertDialog createDialog(Context ctx,
			String title, 
			String message, 
			String RightName,
			String LeftName,
			View.OnClickListener rightListener){
		final AlertDialog dialog = new AlertDialog.Builder(ctx).create();
		dialog.show();
		Window window = dialog.getWindow();
		window.setContentView(R.layout.dialog_prompt);

		TextView tvTitle = (TextView)window.findViewById(R.id.tv_title);
		tvTitle.setText(title);
		
		TextView tvPrompt = (TextView)window.findViewById(R.id.tv_prompt);
		tvPrompt.setText(message);
		
		Button btnLeft=(Button)window.findViewById(R.id.btn_left);
		btnLeft.setText(LeftName);
		btnLeft.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.cancel();
			}
		});
		
		Button btnRight=(Button)window.findViewById(R.id.btn_right);
		btnRight.setText(RightName);
		btnRight.setOnClickListener(rightListener);
		return dialog;            
	}
	public static void createPromptDialog(Context ctx, 
			String title, 
			String message
			) {
		final AlertDialog dialog = new AlertDialog.Builder(ctx).create();
		dialog.show();
		Window window = dialog.getWindow();
		window.setContentView(R.layout.dialog_prompt);
		
		TextView tvTitle = (TextView)window.findViewById(R.id.tv_title);
		tvTitle.setText(title);
		
		TextView tvPrompt = (TextView)window.findViewById(R.id.tv_prompt);
		tvPrompt.setText(message);
		
		Button btnLeft=(Button)window.findViewById(R.id.btn_left);
		btnLeft.setText("确   认");
		btnLeft.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.cancel();
			}
		});
		Button btnRight=(Button)window.findViewById(R.id.btn_right);
		btnRight.setVisibility(View.GONE);
	 }
	
	public static void createSelectDialog(Context ctx,String[] items){
		final AlertDialog dialog = new AlertDialog.Builder(ctx).create();
		dialog.show();
		Window window = dialog.getWindow();
		window.setContentView(R.layout.dialog_select);
		ListView lv = (ListView)window.findViewById(R.id.lv_select_item);
		ArrayAdapter<String>  adapter = new ArrayAdapter<String>(ctx, R.layout.item_dialog_select, items);
		lv.setAdapter(adapter);
        lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				dialog.cancel();
			}
		});
    }
	public static void createSelectDescribeDialog(Context ctx,final TextView tv,String[] items){
		final AlertDialog dialog = new AlertDialog.Builder(ctx).create();
		dialog.show();
		Window window = dialog.getWindow();
		window.setContentView(R.layout.dialog_select);
		ListView lv = (ListView)window.findViewById(R.id.lv_select_item);
		ArrayAdapter<String>  adapter = new ArrayAdapter<String>(ctx, R.layout.item_dialog_select, items);
		lv.setAdapter(adapter);
        lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				tv.setText(((TextView)view).getText());
				dialog.cancel();
			}
		});
    }
	/**
	 * 临时补充
	 * @param ctx
	 * @param items
	 */
	public static void createSelectDialog(Context ctx,ArrayList<String> items){
		final AlertDialog dialog = new AlertDialog.Builder(ctx).create();
		dialog.show();
		Window window = dialog.getWindow();
		window.setContentView(R.layout.dialog_select);
		ListView lv = (ListView)window.findViewById(R.id.lv_select_item);
		ArrayAdapter<String>  adapter = new ArrayAdapter<String>(ctx, R.layout.item_dialog_select, items);
		lv.setAdapter(adapter);
        lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				dialog.cancel();
			}
		});
    }
}
