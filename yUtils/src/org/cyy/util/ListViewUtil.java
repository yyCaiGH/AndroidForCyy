package org.cyy.util;

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
	
    /**
     * 根据位置获取可视范围的view。达到更新item控件的目的
     * @param pos
     * @param listView
     * @return
     */
	public static View getViewByPosition(int pos, ListView listView) {
		int firstListItemPosition = listView.getFirstVisiblePosition();//listview可见视图下的第一item的位置
		int lastListItemPosition = firstListItemPosition + listView.getChildCount() - 1;//listview可见视图下的最后一个item的位置
		if (pos >= firstListItemPosition && pos <= lastListItemPosition ) { //只有在可见视图范围才获取该view进行更新
//			return listView.getAdapter().getView(pos, null, listView); //只是获取一个全新的view，并不是获取item里的控件
			//getChildAt是获取可见视图的view，可见视图从0开始计算位置，pos的位置减去firstListItemPosition才是需要的view的位置
			return listView.getChildAt(pos-firstListItemPosition);
		}
		return null;
	}
}
