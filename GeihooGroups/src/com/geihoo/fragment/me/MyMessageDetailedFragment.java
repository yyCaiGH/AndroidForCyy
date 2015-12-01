package com.geihoo.fragment.me;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.geihoo.activity.MeActivity;
import com.geihoo.adapter.MessageDetailedAdapter;
import com.geihoo.adapter.NoticesAdapter;
import com.geihoo.base.BaseFragment;
import com.geihoo.groups.R;
import com.geihoo.utils.ImageUtil;
/**
 * 艾特我，添加我，赞我的，评论我的
 * @author yy_cai
 *
 * 2015年9月1日
 */
public class MyMessageDetailedFragment extends BaseFragment{

	public static final int MES_ADD=0x200;
	public static final int MES_AITE=0x201;
	public static final int MES_COMMON=0x202;
	public static final int MES_ZAN=0x203;
	private MeActivity activity;
	private ListView lvMessage;

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		this.activity = (MeActivity)activity;
		super.onAttach(activity);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_my_message_detailed, container,false);
		initView(view);
		initData();
		return view;
	}


	protected void initView(View view) {
		activity.setRightStyle(null, 0);
		lvMessage = (ListView)view.findViewById(R.id.lv_message_detailed);
	}

	protected void initData() {
		int type = this.getArguments().getInt("type");
		switch (type) {
		case MES_ADD:
			activity.setTitle("加我的");
			initAddMeListView();
			break;
		case MES_AITE:
			activity.setTitle("@我的");
			initAiteMeListView();
			break;	
		case MES_COMMON:
			activity.setTitle("评论我的");
			initCommonMeListView();
			break;
		case MES_ZAN:
			activity.setTitle("赞我的");
			initZanMeListView();
			break;
		default:
			break;
		}
		
	}
	
	private void initAddMeListView() {
		List<HashMap<String, Object>> notices = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(activity, R.drawable.touxiang));
		map.put("name", "林丽子");
		map.put("type", "加了我");
		notices.add(map);
		map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(activity, R.drawable.ahpicture));
		map.put("name", "蔡呵呵");
		map.put("type", "加了我");
		notices.add(map);
		lvMessage.setAdapter(new MessageDetailedAdapter(notices, activity));
	}
	
	private void initAiteMeListView() {
		List<HashMap<String, Object>> notices = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(activity, R.drawable.touxiang));
		map.put("name", "林丽子");
		map.put("type", "@了我");
		notices.add(map);
		map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(activity, R.drawable.ahpicture));
		map.put("name", "蔡呵呵");
		map.put("type", "@了我");
		notices.add(map);
		lvMessage.setAdapter(new MessageDetailedAdapter(notices, activity));
	}
	private void initCommonMeListView() {
		List<HashMap<String, Object>> notices = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(activity, R.drawable.touxiang));
		map.put("name", "林丽子");
		map.put("type", "评论了我");
		notices.add(map);
		map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(activity, R.drawable.ahpicture));
		map.put("name", "蔡呵呵");
		map.put("type", "评论了我");
		notices.add(map);
		lvMessage.setAdapter(new MessageDetailedAdapter(notices, activity));
	}
	
	private void initZanMeListView() {
		List<HashMap<String, Object>> notices = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(activity, R.drawable.touxiang));
		map.put("name", "林丽子");
		map.put("type", "赞了我");
		notices.add(map);
		map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(activity, R.drawable.ahpicture));
		map.put("name", "蔡呵呵");
		map.put("type", "赞了我");
		map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(activity, R.drawable.tx10));
		map.put("name", "小女子");
		map.put("type", "赞了我");
		notices.add(map);
		lvMessage.setAdapter(new MessageDetailedAdapter(notices, activity));
	}
}
