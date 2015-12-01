package com.geihoo.dialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.geihoo.adapter.CommonZuZuAdapter;
import com.geihoo.adapter.GroupsAdapter;
import com.geihoo.base.BaseDialog;
import com.geihoo.bean.ZuZuBean;
import com.geihoo.groups.R;
import com.geihoo.test.DataDemo;
import com.geihoo.test.Datas;
import com.geihoo.test.InitText;
import com.geihoo.view.MyGridView;
import com.geihoo.view.dslv.DragSortListView;
import com.geihoo.view.dslv.DragSortListView.DragSortListener;
import com.geihoo.view.dslv.DragSortListView.DropListener;
import com.geihoo.view.dslv.DragSortListView.RemoveListener;

/**
 * 编辑常用族族
 * 
 * @author yy_cai
 * 
 *         2015年9月2日
 */
public class CommonZuZuDialog extends BaseDialog {

	public final static int COMMON_ZUZU = 0x100;
	public final static int noCommon_ZUZU = 0x101;
	private Context context;
	private DragSortListView commonZuZus, noCommonZuZus;
	private CommonZuZuAdapter CommonAdapter, noCommonAdapter;
	List<ZuZuBean> commonZuzuList, noCommonZuzuList;// listview的数据源
	GroupsAdapter commonGA;
	public CommonZuZuDialog(Context context,GroupsAdapter commonGA) {
		super(context);
		setContentView(R.layout.dialog_common_zuzu);
		this.context=context;
		this.commonGA = commonGA;
		initView();
		// 取数据设置适配器类的数据源。
		initData();
	}

	protected void initView() {
		commonZuZus = (DragSortListView) findViewById(R.id.dslvList);
		noCommonZuZus = (DragSortListView) findViewById(R.id.dslvList_all);
		TextView tvBack = (TextView) this.findViewById(R.id.tv_top_left);
		tvBack.setOnClickListener(this);
		TextView tvTitle = (TextView) this.findViewById(R.id.tv_top_title);
		tvTitle.setText("常用族族");
	}

	protected void initData() {// 初始化
//		commonZuzuList = Datas.getCommonZuzu();
		commonZuzuList = DataDemo.getCommonZuzu(context);
		// 得到滑动listview并且设置监听器。
		commonZuZus.setDropListener(new MyDropListener(COMMON_ZUZU));
		commonZuZus.setRemoveListener(new MyRemoveListener(COMMON_ZUZU));

		CommonAdapter = new CommonZuZuAdapter(context, commonZuzuList,COMMON_ZUZU);
		commonZuZus.setAdapter(CommonAdapter);
		commonZuZus.setDragEnabled(true); // 设置是否可拖动。
		
		//非常用族族
		noCommonZuzuList = DataDemo.getPrivateZuzu(context);
		noCommonZuZus.setDropListener(new MyDropListener(noCommon_ZUZU));
		noCommonZuZus.setRemoveListener(new MyRemoveListener(noCommon_ZUZU));

		noCommonAdapter = new CommonZuZuAdapter(context, noCommonZuzuList,noCommon_ZUZU);
		noCommonZuZus.setAdapter(noCommonAdapter);
		noCommonZuZus.setDragEnabled(true); // 设置是否可拖动。
	}

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.tv_top_left){
			commonGA.notifyDataSetChanged();
			this.cancel();
		}
	}

	// 监听器在手机拖动停下的时候触发
	private class MyDropListener implements DropListener {

		private int type;

		public MyDropListener(int type) {
			this.type = type;
		}

		@Override
		public void drop(int from, int to) {// from to 分别表示 被拖动控件原位置 和目标位置
			if (from != to) {
				if(type==noCommon_ZUZU){
					ZuZuBean item = (ZuZuBean) noCommonAdapter.getItem(from);
					noCommonAdapter.remove(from);
					noCommonAdapter.insert(item, to);
				}else if(type==COMMON_ZUZU){
					ZuZuBean item = (ZuZuBean) CommonAdapter.getItem(from);// 得到listview的适配器
					CommonAdapter.remove(from);// 在适配器中”原位置“的数据。
					CommonAdapter.insert(item, to);// 在目标位置中插入被拖动的控件。
				}
			}
		}

	}

	// 删除监听器，点击左边差号就触发。删除item操作。
	private class MyRemoveListener implements RemoveListener {
		private int type;

		public MyRemoveListener(int type) {
			this.type = type;
		}

		@Override
		public void remove(int which) {
			if(type==noCommon_ZUZU){
				ZuZuBean item = (ZuZuBean) noCommonAdapter.getItem(which);
				noCommonAdapter.remove(which);
				CommonAdapter.insert(item, 0);
			}else if(type==COMMON_ZUZU){
				ZuZuBean item = (ZuZuBean) CommonAdapter.getItem(which);
				CommonAdapter.remove(which);
				noCommonAdapter.insert(item, 0);
			}
		}

	}
}
