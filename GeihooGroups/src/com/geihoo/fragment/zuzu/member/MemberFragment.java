package com.geihoo.fragment.zuzu.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.geihoo.adapter.CommonAdapter;
import com.geihoo.adapter.ViewHolder;
import com.geihoo.adapter.ZuZuMemberAdapter;
import com.geihoo.base.BaseFragment;
import com.geihoo.bean.ContactsBean;
import com.geihoo.groups.R;
import com.geihoo.test.DataDemo;
import com.geihoo.test.Datas;
import com.geihoo.utils.DialogUtil;
import com.geihoo.utils.ImageUtil;
/**
 * 成员
 * @author czz
 *
 */
public class MemberFragment extends BaseFragment{
	public static String tag="MemberFragment";
	private ListView friendList,otherList; 
	Activity activity;
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.activity=activity;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_member, container,false);
		friendList=(ListView) view.findViewById(R.id.lv_friend);
		otherList=(ListView) view.findViewById(R.id.lv_other);
		//添加item中数据
		List<HashMap<String, Object>> members = Datas.getZuZuMembers(activity);
		otherList.setAdapter(new ZuZuMemberAdapter(members, activity));
		
		List<HashMap<String, Object>> memberFriends = Datas.getZuZuMemberFriends(activity);
		friendList.setAdapter(new ZuZuMemberAdapter(memberFriends, activity));
//		List<ContactsBean> list = Datas.getContacts();
//	    friendList.setAdapter(new CommonAdapter<ContactsBean>(getActivity(),list,R.layout.member_listitem) {
//
//			@Override
//			public void convert(ViewHolder helper, ContactsBean item) {
//				// TODO Auto-generated method stub
//				helper.setMyImageResource(R.id.img, item.getImage());
//				helper.setText(R.id.tv_member, item.getName());
//			}
//		});

		   
	    
		return view;
	}
	
}
