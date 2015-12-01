package com.geihoo.fragment.me;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.geihoo.activity.MeActivity;
import com.geihoo.adapter.MyHomeAdapter;
import com.geihoo.adapter.NoticesAdapter;
import com.geihoo.base.BaseDialog;
import com.geihoo.base.BaseFragment;
import com.geihoo.bean.ContactsBean;
import com.geihoo.groups.R;
import com.geihoo.utils.ImageUtil;
import com.geihoo.view.CustomImageView;
/**
 * 我的主页
 * @author yy_cai
 *
 * 2015年9月1日
 */
public class MyHomeFragment extends BaseFragment{

	private MeActivity activity;
	private ListView dynamicList;
	private Bundle contactBundle;
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		this.activity = (MeActivity)activity;
		super.onAttach(activity);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_my_home, container,
				false);
		contactBundle = this.getArguments();
		initView(view);
		initDynamicList();
		return view;
	}


	protected void initView(View view) {
		initTopView();
		dynamicList = (ListView)view.findViewById(R.id.lv_home_dyn);
		View v = LayoutInflater.from(activity).inflate(R.layout.view_my_home_head, null);
		if(contactBundle!=null){
			ContactsBean contact = contactBundle.getParcelable("contact");
			if(contact!=null){
				CustomImageView headImg = (CustomImageView)v.findViewById(R.id.civ_contact_head);
				headImg.setPic(contact.getImage());
				TextView name = (TextView)v.findViewById(R.id.tv_contact_name);
				name.setText(contact.getName());
			}
		}
		dynamicList.addHeaderView(v,null,false);
	}

	private void initTopView() {
		activity.setTitle(activity.getResources().getString(R.string.top_title_wdzy));
		activity.setRightStyle(null, R.drawable.top_add_image);
	}
	
	private void initDynamicList() {
		List<HashMap<String, Object>> dynamic = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(activity, R.drawable.txzh01));
		map.put("content", "开心一刻，分享给你们！！");
		map.put("time", "1小时前");
		map.put("imageNum", "3张");
		dynamic.add(map);
		map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(activity, R.drawable.txzh02));
		map.put("content", "我最想去的几个地方！！");
		map.put("time", "7小时前");
		map.put("imageNum", "5张");
		dynamic.add(map);
		map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(activity, R.drawable.txzh03));
		map.put("content", "世界那么大，我想去看看");
		map.put("time", "8月30日");
		map.put("imageNum", "8张");
		dynamic.add(map);
		map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(activity, R.drawable.txzh04));
		map.put("content", "我喜欢的，你不一定喜欢");
		map.put("time", "8月28日");
		map.put("imageNum", "3张");
		dynamic.add(map);
		map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(activity, R.drawable.txzh05));
		map.put("content", "云岚又来了，好开心！！");
		map.put("time", "8月25日");
		map.put("imageNum", "2张");
		dynamic.add(map);
		map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(activity, R.drawable.txzh06));
		map.put("content", "云岚来了，好开心！！");
		map.put("time", "8月21日");
		map.put("imageNum", "2张");
		dynamic.add(map);
		dynamicList.setAdapter(new MyHomeAdapter(dynamic, activity));
	}
}
