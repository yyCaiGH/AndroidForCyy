package com.geihoo.fragment.maintab;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.geihoo.activity.MainTabActivity;
import com.geihoo.adapter.MyFunsAdapter;
import com.geihoo.base.BaseFragment;
import com.geihoo.bean.FunBean;
import com.geihoo.groups.R;
import com.geihoo.test.Datas;
import com.geihoo.utils.ImageUtil;

/**
 * 
 * 我的功能模块
 *
 * @author yy_cai
 *
 * 2015年12月12日
 */
public class MyFunctionFragment extends BaseFragment{

	private String tag ="MyFunctionFragment";
	private MainTabActivity mActivity;
	private GridView gvFuns;
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mActivity=(MainTabActivity)activity;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i(tag, "onCreateView");
		View view = inflater.inflate(R.layout.fragment_main_tab_fun, container,false);
		initView(view);
		initData();
		return view;
	}
	@Override
	protected void initView(View view) {
		initTopView(view);
		gvFuns = (GridView)view.findViewById(R.id.gv_all_fun);
		gvFuns.setOnItemClickListener(this);
	}
	private void initTopView(View view) {
		ImageView topHome = (ImageView)view.findViewById(R.id.iv_top_left);
		topHome.setOnClickListener(this);
		TextView title = (TextView)view.findViewById(R.id.tv_top_title);
		title.setText("生活");
		ImageView create = (ImageView)view.findViewById(R.id.iv_top_right);
		create.setVisibility(View.GONE);
		
	}
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.iv_top_left){
			mActivity.dealSlidingMenu();
		}
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		super.onItemClick(parent, view, position, id);
		Toast.makeText(mActivity, "功能开发中", 0).show();
	}


	@Override
	public void onStart() {
		Log.i(tag, "onStart");
		super.onStart();
	}

	@Override
	public void onResume() {
		Log.i(tag, "onResume");
		super.onResume();
		List<FunBean> list = Datas.getAllFuns(mActivity);
		List<FunBean> addedFun = new ArrayList<FunBean>();//已添加的功能
		for(FunBean fun : list){
			if(fun.isAdd()){
				addedFun.add(fun);
			}
		}
		//添加按钮
		FunBean fun = new FunBean();
		fun.setName(null);
		fun.setImage(ImageUtil.readBitMap(mActivity, R.drawable.my_tianjia));
		fun.setAdd(true);
		addedFun.add(fun);
		
		gvFuns.setAdapter(new MyFunsAdapter(addedFun, mActivity));
	}

	@Override
	public void onPause() {
		Log.i(tag, "onPause");
		super.onPause();
	}

	@Override
	public void onStop() {
		Log.i(tag, "onStop");
		super.onStop();
	}

	@Override
	public void onDestroyView() {
		Log.i(tag, "onDestroyView");
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		Log.i(tag, "onDestroy");
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		Log.i(tag, "onDetach");
		super.onDetach();
	}
}
