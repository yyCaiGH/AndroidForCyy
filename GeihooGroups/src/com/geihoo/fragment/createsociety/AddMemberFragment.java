package com.geihoo.fragment.createsociety;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.geihoo.activity.CreateSocietyActivity;
import com.geihoo.adapter.CommonAdapter;
import com.geihoo.adapter.ViewHolder;
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

	private CreateSocietyActivity activity;
	private ListView lvMembers;
	private View view;
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.activity=(CreateSocietyActivity)activity;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_createsociety_add_member, container,false);
		init();
		initListView();
		return view;
	}
	private void init(){
		activity.setTopBar("添加成员",activity.ADD_MEMBER);
		EditText etSearch = (EditText)view.findViewById(R.id.et_search);
		etSearch.setHint("搜索好友");
	}
	private void initListView() {
		lvMembers = (ListView)view.findViewById(R.id.lv_members);
		List<ContactsBean> members = Datas.getContacts(activity);
		lvMembers.setAdapter(new CommonAdapter<ContactsBean>(getActivity(),members,R.layout.item_add_member) {
			@Override
			public void convert(ViewHolder helper, ContactsBean contact) {
				helper.setMyImageBitmap(R.id.civ_image, contact.getImage());
				helper.setText(R.id.tv_member_name, contact.getName());
			}
		});
	}
}
