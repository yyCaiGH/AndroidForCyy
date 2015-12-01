package com.geihoo.fragment.zuzu.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.geihoo.adapter.ZuZuMemberAdapter;
import com.geihoo.base.BaseFragment;
import com.geihoo.groups.R;
import com.geihoo.test.Datas;
import com.geihoo.utils.ImageUtil;
/**
 * 管理员
 * @author czz
 *
 */
public class ManagerFragment extends BaseFragment{

	private ListView managerList;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_manager, container,false);
		managerList=(ListView) view.findViewById(R.id.lv_zuzu_manager);
		List<HashMap<String, Object>> members = new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object> member = new HashMap<String, Object>();
		member.put("member_name", "陈子正");
		member.put("image", ImageUtil.readBitMap(getActivity(), R.drawable.tx1));
		member.put("menmber_tab", 1);
		members.add(member);
		member = new HashMap<String, Object>();
		member.put("member_name", "陈琼霞");
		member.put("image", ImageUtil.readBitMap(getActivity(), R.drawable.tx2));
		member.put("menmber_tab", 2);
		members.add(member);
		member = new HashMap<String, Object>();
		member.put("member_name", "蔡跃勇");
		member.put("image", ImageUtil.readBitMap(getActivity(), R.drawable.tx3));
		member.put("menmber_tab", 2);
		members.add(member);
		managerList.setAdapter(new ZuZuMemberAdapter(members, getActivity()));
		return view;
	}

}
