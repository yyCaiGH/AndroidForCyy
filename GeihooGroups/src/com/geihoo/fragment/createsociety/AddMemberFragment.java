package com.geihoo.fragment.createsociety;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.geihoo.activity.CreateSocietyActivity;
import com.geihoo.adapter.SelectContactAdapter;
import com.geihoo.base.BaseFragment;
import com.geihoo.bean.ContactsBean;
import com.geihoo.groups.R;
import com.geihoo.test.Datas;
/**
 * 添加成员
 * @author yy_cai
 *
 * 2015年7月22日
 */
public class AddMemberFragment extends BaseFragment{
	String tag = "AddMemberFragment";
	private CreateSocietyActivity mActivity;
	private ListView lvMembers;
	private List<ContactsBean> members;
	private SelectContactAdapter selectContactAdapter;
	@Override
	public void onAttach(Activity activity) {
		Log.i(tag, "onAttach");
		super.onAttach(activity);
		this.mActivity=(CreateSocietyActivity)activity;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i(tag, "onCreate");
		super.onCreate(savedInstanceState);
		members = Datas.getContacts(mActivity);//获取所有联系人
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i(tag, "onCreateView");
		View view = inflater.inflate(R.layout.fragment_createsociety_add_member, container,false);
		initView(view);
		return view;
	}
	protected void initView(View view){
		mActivity.setTopBar("添加成员",mActivity.ADD_MEMBER);
		EditText etSearch = (EditText)view.findViewById(R.id.et_search);
		etSearch.setHint("搜索好友");
		initListView(view);
	}
	private void initListView(View view) {
		lvMembers = (ListView)view.findViewById(R.id.lv_members);
		selectContactAdapter = new SelectContactAdapter(members, mActivity);
		lvMembers.setAdapter(selectContactAdapter);
	}
	public void saveContactsToZuZu(){
		//由于每个Contact都有一个bitmap，导致intent的参数值过大。
		mActivity.getNewZuZuBean().setContacts(selectContactAdapter.getSelectContacts());
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
		//应该在这里设置被选中的联系人的checkbox为勾选状态，
		//但不知道为什么现在的checkbox能一直记住你选中的状态，所以暂时不设置
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
