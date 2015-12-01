package com.geihoo.utils;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListViewUtil {
	/**
	 * 列出ListView的所有项
	 * @param listView
	 * @param baseAdapter
	 */
	public static void setListViewHeightBasedOnChildren(ListView listView, BaseAdapter baseAdapter) {

		if (baseAdapter == null) {
			return;
		}

		int totalHeight = 0;
		for (int i = 0; i < baseAdapter.getCount(); i++) {
			View listItem = baseAdapter.getView(i, null, listView);
			listItem.measure(0, 0);
			totalHeight += listItem.getMeasuredHeight();
		}

		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight
				+ (listView.getDividerHeight() * (baseAdapter.getCount() - 1));
		listView.setLayoutParams(params);
	}
	
	public static void setListViewHeightBasedOnChildren2(ListView listView) {
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) {
			return;
		}
		int totalHeight = 0;
		for (int i = 0; i < listAdapter.getCount(); i++) {
			View listItem = listAdapter.getView(i, null, listView);
			listItem.measure(0, 0);
			totalHeight += listItem.getMeasuredHeight();
		}

		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight
				+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		listView.setLayoutParams(params);
	}
}
