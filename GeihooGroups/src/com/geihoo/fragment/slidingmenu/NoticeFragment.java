package com.geihoo.fragment.slidingmenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.geihoo.activity.SlidingMenuActivity;
import com.geihoo.adapter.NoticesAdapter;
import com.geihoo.base.BaseFragment;
import com.geihoo.groups.R;
import com.geihoo.utils.ImageUtil;

/**
 * 通知
 * 
 * @author yy_cai
 * 
 *         2015年7月16日
 */
public class NoticeFragment extends BaseFragment {

	private ListView lvNotices;
	private View view;
	private SlidingMenuActivity parent;
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		parent=(SlidingMenuActivity)activity;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_sm_notice, container, false);
		initView();
        initNoticeListView();
		return view;
	}
	
	private void initView() {
		TextView tvTitle = (TextView)view.findViewById(R.id.tv_top_title);
		tvTitle.setText(parent.getResources().getString(R.string.top_title_tz));
		TextView tvBack = (TextView)view.findViewById(R.id.tv_top_left);
		tvBack.setText("返回");
		tvBack.setOnClickListener(this);
		TextView tvNext = (TextView)view.findViewById(R.id.tv_top_right);
		tvNext.setVisibility(View.GONE);
		lvNotices = (ListView)view.findViewById(R.id.lv_notice);
	}
	
	private void initNoticeListView() {
		List<HashMap<String, Object>> notices = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(parent, R.drawable.touxiang));
		map.put("notice_desc", "瓜瓜将你添加到私密社团瓜瓜也");
		map.put("notice_time", "昨天下午2:45");
		notices.add(map);
		map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(parent, R.drawable.ahpicture));
		map.put("notice_desc", "TT将你添加到私密社团瓜瓜也");
		map.put("notice_time", "周三下午3:22");
		notices.add(map);
		lvNotices.setAdapter(new NoticesAdapter(notices, parent));
	}

	
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.tv_top_left){
			parent.onBackPressed();
		}
	}







}
