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
import com.geihoo.utils.ImageUtil;
/**
 * 禁言
 * @author czz
 *
 */
public class BlacklistFragment extends BaseFragment{
	private ListView blackList;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_blacklist, container,false);

		blackList=(ListView) view.findViewById(R.id.lv_zuzu_black);
		List<HashMap<String, Object>> members = new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object> member = new HashMap<String, Object>();
		member.put("member_name", "奥巴马");
		member.put("image", ImageUtil.readBitMap(getActivity(), R.drawable.tx1));
		member.put("menmber_tab", 3);//3是被拉入黑名单的普通成员
		members.add(member);
		member = new HashMap<String, Object>();
		member.put("member_name", "习近平");
		member.put("image", ImageUtil.readBitMap(getActivity(), R.drawable.tx2));
		member.put("menmber_tab", 4);//4是被拉入黑名单的管理员
		members.add(member);
		blackList.setAdapter(new ZuZuMemberAdapter(members, getActivity()));
		return view;
	}

}
