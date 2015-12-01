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
import com.geihoo.adapter.NoticesAdapter;
import com.geihoo.base.BaseFragment;
import com.geihoo.groups.R;
import com.geihoo.utils.ImageUtil;
/**
 * 我的消息
 * @author yy_cai
 *
 * 2015年8月31日
 */
public class MyMessageFragment extends BaseFragment{

	private MeActivity activity;
	private ListView lvNotices;

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		this.activity = (MeActivity)activity;
		super.onAttach(activity);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_my_message, container,false);
		initView(view);
		initData(view);
		initNoticeListView();
		return view;
	}


	protected void initView(View view) {
		initTopView(view);
		lvNotices = (ListView)view.findViewById(R.id.lv_sys_notice);
		view.findViewById(R.id.rl_me_mes_zan).setOnClickListener(this);
		view.findViewById(R.id.rl_me_mes_common).setOnClickListener(this);
		view.findViewById(R.id.rl_me_mes_aite).setOnClickListener(this);
		view.findViewById(R.id.rl_me_mes_add).setOnClickListener(this);
	}

	private void initTopView(View view) {
		activity.setTitle(activity.getResources().getString(R.string.top_title_wdxx));
		activity.setRightStyle(null, 0);
	}
	private void initData(View view) {
		
	}
	
	private void initNoticeListView() {
		List<HashMap<String, Object>> notices = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(activity, R.drawable.touxiang));
		map.put("notice_desc", "瓜瓜将你添加到私密社团瓜瓜也");
		map.put("notice_time", "昨天下午2:45");
		notices.add(map);
		map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(activity, R.drawable.ahpicture));
		map.put("notice_desc", "TT将你添加到私密社团瓜瓜也");
		map.put("notice_time", "周三下午3:22");
		notices.add(map);
		lvNotices.setAdapter(new NoticesAdapter(notices, activity));
	}
	
	@Override
	public void onClick(View v) {
		Bundle bundle = new Bundle();
		if(v.getId()==R.id.rl_me_mes_zan){
			bundle.putInt("type", MyMessageDetailedFragment.MES_ZAN);
		}else if(v.getId()==R.id.rl_me_mes_common){
			bundle.putInt("type", MyMessageDetailedFragment.MES_COMMON);
		}else if(v.getId()==R.id.rl_me_mes_aite){
			bundle.putInt("type", MyMessageDetailedFragment.MES_AITE);
		}else if(v.getId()==R.id.rl_me_mes_add){
			bundle.putInt("type", MyMessageDetailedFragment.MES_ADD);
		}
		activity.replaceFragmentAndAddToBackStack(new MyMessageDetailedFragment(),bundle,R.id.fl_me);
	}
}
