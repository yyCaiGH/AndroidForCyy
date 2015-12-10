package com.geihoo.fragment.zzfc;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;

import com.geihoo.activity.MainTabActivity;
import com.geihoo.activity.SocietyMainActivity;
import com.geihoo.adapter.GroupsAdapter;
import com.geihoo.base.BaseFragment;
import com.geihoo.bean.ZuZuBean;
import com.geihoo.dialog.CommonZuZuDialog;
import com.geihoo.dialog.SearchSocietyDialog;
import com.geihoo.groups.R;
import com.geihoo.test.DataDemo;
import com.geihoo.utils.Constant;
import com.geihoo.utils.DialogUtil;
import com.geihoo.view.MyGridView;

/**
 * 
 * 族族
 *
 * @author yy_cai
 *
 * 2015年12月10日
 */
public class ZuZuFragment extends BaseFragment {

	static String tag = "ZuZuFragment";
	private MainTabActivity mActivity;
	private View view;
	private MyGridView commonZuzuGv,privateZuzuGv,publicZuzuGv;
	List<ZuZuBean> commonZuzuDatas,privateZuzuDatas,publicZuzuDatas;
	GroupsAdapter commonGA;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mActivity = (MainTabActivity) activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i(tag, "onCreateView");
		view = inflater.inflate(R.layout.fragment_zuzu, container, false);
		initView();
		initData();
		initPrivateZuzu();// 私密族族
		initPublicZuzu();// 公开族族
		initCommonZuzu();// 常用族族
		return view;
	}

	private void initView() {

		EditText search = (EditText) view.findViewById(R.id.et_search);
		search.setOnClickListener(this);
		search.setFocusable(false);

		TextView tvEdit = (TextView) view.findViewById(R.id.tv_edit);
		tvEdit.setOnClickListener(this);
	}
	
	protected void initData() {
		commonZuzuDatas = DataDemo.getCommonZuzu(mActivity);
		privateZuzuDatas = DataDemo.getPrivateZuzu(mActivity);
		publicZuzuDatas = DataDemo.getPublicZuzus(mActivity);
	}

	/**
	 * 常用族族
	 */
	private void initCommonZuzu() {
		commonZuzuGv = (MyGridView) view.findViewById(R.id.mgv_common_zz_type);
		commonGA = new GroupsAdapter(commonZuzuDatas, mActivity);
		commonZuzuGv.setAdapter(commonGA);
		commonZuzuGv.setOnItemClickListener(this);
		commonZuzuGv.setOnItemLongClickListener(this);
	}
	/**
	 * 私密族族
	 */
	private void initPrivateZuzu() {
		privateZuzuGv = (MyGridView) view.findViewById(R.id.mgv_private_zz_type);
		privateZuzuGv.setAdapter(new GroupsAdapter(privateZuzuDatas, mActivity));
		privateZuzuGv.setOnItemClickListener(this);
		privateZuzuGv.setOnItemLongClickListener(this);
		
	}
	/**
	 * 公开族族
	 */
	private void initPublicZuzu() {
		publicZuzuGv = (MyGridView) view.findViewById(R.id.mgv_public_zz_type);
		publicZuzuGv.setAdapter(new GroupsAdapter(publicZuzuDatas, mActivity));
		publicZuzuGv.setOnItemClickListener(this);
		publicZuzuGv.setOnItemLongClickListener(this);
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		ZuZuBean zuzu = null;
		if (parent == commonZuzuGv) {
			zuzu = commonZuzuDatas.get(position);
		}
		else if (parent == privateZuzuGv) {
			zuzu = privateZuzuDatas.get(position);
		}
		else if (parent == publicZuzuGv) {
			zuzu = publicZuzuDatas.get(position);
		}
		Intent i = new Intent(getActivity(), SocietyMainActivity.class);
		i.putExtra("zuzu", zuzu);
		startActivity(i);
		getActivity().overridePendingTransition(R.anim.anim_go_up,R.anim.anim_activity_out);
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view,
			int position, long id) {
		if(parent==commonZuzuGv){
			String[] items ={"移除常用族族","重排族族","添加至主屏幕","关闭通知"};
			DialogUtil.createSelectDialog(getActivity(),items);
		}
		else{
			String[] items ={"移至常用族族","重排族族","添加至主屏幕","关闭通知"};
			DialogUtil.createSelectDialog(getActivity(),items);
		}
		return true;
	}
	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.et_search) {
			new SearchSocietyDialog(getActivity()).show();
		}else if(v.getId()==R.id.tv_edit){
			new CommonZuZuDialog(mActivity,commonGA).show();
		}
		
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i(tag, "onCreate");
		super.onCreate(savedInstanceState);
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
