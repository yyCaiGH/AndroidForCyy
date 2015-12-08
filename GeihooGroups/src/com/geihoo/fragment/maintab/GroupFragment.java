package com.geihoo.fragment.maintab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.geihoo.activity.CreateSocietyActivity;
import com.geihoo.activity.FriendCircleActivity;
import com.geihoo.activity.MainTabActivity;
import com.geihoo.activity.SocietyMainActivity;
import com.geihoo.adapter.GroupsAdapter;
import com.geihoo.base.BaseFragment;
import com.geihoo.bean.ZuZuBean;
import com.geihoo.dialog.CommonZuZuDialog;
import com.geihoo.dialog.SearchSocietyDialog;
import com.geihoo.groups.R;
import com.geihoo.test.DataDemo;
import com.geihoo.test.Datas;
import com.geihoo.test.MyGroupsAdapter;
import com.geihoo.utils.DialogUtil;
import com.geihoo.view.MyGridView;

/**
 * 族族
 * 
 * @author yy_cai
 * 
 */
public class GroupFragment extends BaseFragment {

	private final static int MYZZ_CYZZ=0x100;
	private final static int MYZZ_SMZZ=0x101;
	private final static int MYZZ_GKZZ=0x102;
	static String tag = "GroupFragment";
	private MainTabActivity parent;
	private View view;
	private MyGridView MyZuzu, FriendCircle;
	List<ZuZuBean> CommonZuzus,privateZuzu,publicZuzu,myzuzu;
	List<HashMap<String, Object>> FriendCircleDatas;
	GroupsAdapter commonGA;
	
	TextView cyzz,gkzz,smzz;
	private int type=MYZZ_CYZZ;
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		parent = (MainTabActivity) activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i(tag, "onCreateView");
		view = inflater.inflate(R.layout.fragment_group2, container, false);
		initView();
		initData();
		initFriendCircle();//朋友圈
		initMyZuzu();// 我的族族
		return view;
	}


	private void initView() {
		
		ImageView topHome = (ImageView) view.findViewById(R.id.iv_top_left);
		topHome.setOnClickListener(this);
		TextView title = (TextView) view.findViewById(R.id.tv_top_title);
		title.setText(getActivity().getResources().getString(R.string.top_title_st));
		ImageView create = (ImageView) view.findViewById(R.id.iv_top_right);
		create.setOnClickListener(this);

		EditText search = (EditText) view.findViewById(R.id.et_search);
		search.setOnClickListener(this);
		search.setFocusable(false);

		TextView tvEdit = (TextView) view.findViewById(R.id.tv_edit);
		tvEdit.setOnClickListener(this);
	}
	
	protected void initData() {
		CommonZuzus = DataDemo.getCommonZuzu(parent);
		privateZuzu = DataDemo.getPrivateZuzu(parent);
		publicZuzu = DataDemo.getPublicZuzus(parent);
		FriendCircleDatas = DataDemo.getFriendsCircle(parent);
		initTab();
	}

	private void initTab() {
		myzuzu= new ArrayList<ZuZuBean>();
		myzuzu.addAll(CommonZuzus);
		
		cyzz = (TextView)view.findViewById(R.id.tv_cyzz);
		cyzz.setOnClickListener(this);
		
		smzz = (TextView)view.findViewById(R.id.tv_smzz);
		smzz.setOnClickListener(this);
		
		gkzz = (TextView)view.findViewById(R.id.tv_gkzz);
		gkzz.setOnClickListener(this);
	}

	/**
	 * 朋友圈
	 */
	private void initFriendCircle() {
		MyGroupsAdapter commonGA = new MyGroupsAdapter(FriendCircleDatas, getActivity());
		FriendCircle = (MyGridView) view.findViewById(R.id.mgv_friend_circle);
		FriendCircle.setAdapter(commonGA);
		FriendCircle.setOnItemClickListener(this);
	}



	/**
	 * 我的族族（常用，私密，公开）
	 */
	private void initMyZuzu() {
		MyZuzu = (MyGridView) view.findViewById(R.id.mgv_my_zz);
		commonGA = new GroupsAdapter(myzuzu, getActivity());
		MyZuzu.setAdapter(commonGA);
		MyZuzu.setOnItemClickListener(this);
		MyZuzu.setOnItemLongClickListener(this);
	}



	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		ZuZuBean zuzu = null;
		switch (type) {
		case MYZZ_CYZZ:
			zuzu = CommonZuzus.get(position);
			break;
		case MYZZ_SMZZ:
			zuzu = privateZuzu.get(position);
			break;
		case MYZZ_GKZZ:
			zuzu = publicZuzu.get(position);
			break;
		default:
			break;
		}
		if (parent == MyZuzu) {
			Intent i = new Intent(getActivity(), SocietyMainActivity.class);
			i.putExtra("zuzu", zuzu);
			startActivity(i);
			getActivity().overridePendingTransition(R.anim.anim_go_up,
					R.anim.anim_activity_out);
		}
		if(parent == FriendCircle){
			Intent i = new Intent(getActivity(), FriendCircleActivity.class);
			String name = FriendCircleDatas.get(position).get("title").toString();
			i.putExtra("name", name);
			startActivity(i);
			getActivity().overridePendingTransition(R.anim.anim_go_up,
					R.anim.anim_activity_out);
			
		}
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view,
			int position, long id) {
		if(parent==MyZuzu){
			String[] items ={"重排族族","添加至主屏幕","关闭通知"};
			DialogUtil.createSelectDialog(getActivity(),items);
		}
		return true;
	}
	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.et_search) {
			new SearchSocietyDialog(getActivity()).show();
		}else if(v.getId()==R.id.tv_edit){
			new CommonZuZuDialog(parent,commonGA).show();
		}else if (v.getId() == R.id.iv_top_right) {
			Intent i = new Intent(getActivity(), CreateSocietyActivity.class);
			startActivity(i);
			getActivity().overridePendingTransition(R.anim.anim_go_up,R.anim.anim_activity_out);
		}else if (v.getId() == R.id.iv_top_left) {
			parent.dealSlidingMenu();
		}else if(v==cyzz){
			type = MYZZ_CYZZ;
			myzuzu.clear();
			myzuzu.addAll(CommonZuzus);
			cyzz.setTextColor(parent.getResources().getColor(android.R.color.holo_orange_dark));
			smzz.setTextColor(parent.getResources().getColor(android.R.color.darker_gray));
			gkzz.setTextColor(parent.getResources().getColor(android.R.color.darker_gray));
			((GroupsAdapter)MyZuzu.getAdapter()).notifyDataSetChanged();
		}else if(v==smzz){
			type = MYZZ_SMZZ;
			myzuzu.clear();
			myzuzu.addAll(privateZuzu);
			smzz.setTextColor(parent.getResources().getColor(android.R.color.holo_orange_dark));
			cyzz.setTextColor(parent.getResources().getColor(android.R.color.darker_gray));
			gkzz.setTextColor(parent.getResources().getColor(android.R.color.darker_gray));
			((GroupsAdapter)MyZuzu.getAdapter()).notifyDataSetChanged();
		}else if(v==gkzz){
			type = MYZZ_GKZZ;
			myzuzu.clear();
			myzuzu.addAll(publicZuzu);
			gkzz.setTextColor(parent.getResources().getColor(android.R.color.holo_orange_dark));
			smzz.setTextColor(parent.getResources().getColor(android.R.color.darker_gray));
			cyzz.setTextColor(parent.getResources().getColor(android.R.color.darker_gray));
			((GroupsAdapter)MyZuzu.getAdapter()).notifyDataSetChanged();
		}
		
	}

	private void clearData() {
		publicZuzu.clear();
		privateZuzu.clear();
		CommonZuzus.clear();
		myzuzu.clear();
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
//		clearData();
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		Log.i(tag, "onDetach");
		super.onDetach();
	}

}
