package com.geihoo.fragment.zzfc;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.geihoo.activity.FriendCircleActivity;
import com.geihoo.activity.MainTabActivity;
import com.geihoo.adapter.FriendCircleAdapter;
import com.geihoo.adapter.SocietyPostAdapter;
import com.geihoo.base.BaseFragment;
import com.geihoo.bean.FriendCircleBean;
import com.geihoo.bean.PostContentBean;
import com.geihoo.groups.R;
import com.geihoo.test.DataDemo;
import com.geihoo.utils.Constants;
import com.geihoo.utils.ListViewUtil;
import com.geihoo.view.MyGridView;

/**
 * 
 * 朋友圈
 *
 * @author yy_cai
 *
 * 2015年12月10日
 */
public class FriendCircleFragment extends BaseFragment {

	static String tag = "FriendCircleFragment";
	private MainTabActivity mActivity;
	private View view;
	private MyGridView FriendCircle;
	private FriendCircleAdapter fcAdapter;
	private List<FriendCircleBean> friendCircleDatas;
	ArrayList<PostContentBean> postList;
	ListView postListView;
	SocietyPostAdapter societyPostAdapter;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mActivity = (MainTabActivity) activity;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i(tag, "onCreate");
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i(tag, "onCreateView");
		view = inflater.inflate(R.layout.fragment_friend_circle, container, false);
		initData();
		initView();
		initFriendCircle();//朋友圈
		return view;
	}
	
	protected void initData() {
		postList = Constants.getPostList();//全部朋友圈动态数据
	}

	private void initView() {
		//初始化全部动态
		postListView = (ListView) view.findViewById(R.id.postListView);
		societyPostAdapter = new SocietyPostAdapter(mActivity, postList,SocietyPostAdapter.MY_DYNAMIC);
		postListView.setAdapter(societyPostAdapter);
		ListViewUtil.setListViewHeightBasedOnChildren(postListView,societyPostAdapter);
		
	}
	/**
	 * 朋友圈
	 */
	private void initFriendCircle() {
		friendCircleDatas = DataDemo.getFriendsCircle(mActivity);
		fcAdapter = new FriendCircleAdapter(friendCircleDatas, getActivity());
		FriendCircle = (MyGridView) view.findViewById(R.id.mgv_friend_circle);
		FriendCircle.setAdapter(fcAdapter);
		FriendCircle.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		if(parent == FriendCircle){
			Intent i = new Intent(getActivity(), FriendCircleActivity.class);
			FriendCircleBean fc = friendCircleDatas.get(position);
			i.putExtra("friendCircle", fc);
			startActivity(i);
			getActivity().overridePendingTransition(R.anim.anim_go_up,R.anim.anim_activity_out);
			
		}
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
		fcAdapter.notifyDataSetChanged();
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
