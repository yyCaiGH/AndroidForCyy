package com.geihoo.fragment.me;

import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.geihoo.activity.MeActivity;
import com.geihoo.adapter.CommonAdapter;
import com.geihoo.adapter.ViewHolder;
import com.geihoo.base.BaseFragment;
import com.geihoo.bean.ZuZuBean;
import com.geihoo.dialog.AddZuZuSetDialog;
import com.geihoo.dialog.PushSetDialog;
import com.geihoo.dialog.SocietyPostedSetDialog;
import com.geihoo.groups.R;
import com.geihoo.test.Datas;
import com.geihoo.utils.ListViewUtil;

/**
 * 设置
 * 
 * @author yy_cai
 * 
 * 2015年7月16日
 */
public class SetFragment extends BaseFragment {

	private ListView groupNoticeSet;
	private ListView addZuZuSet;
	private View view;
	private MeActivity activity;
	private LayoutInflater inflater;
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		this.activity=(MeActivity)activity;
		inflater=LayoutInflater.from(activity);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_sm_set, container, false);
		initView();
		initNoticeSetListView();
		initSetListView();
		return view;
	}

	
	private void initView() {
		activity.setTitle(activity.getResources().getString(R.string.top_title_sz));
		activity.setRightStyle(null, 0);
		
		LinearLayout pushNoticeSet = (LinearLayout) view
				.findViewById(R.id.ll_push_tz);
		pushNoticeSet.setOnClickListener(this);
	}


	/**
	 * 族族设置
	 */
	private void initSetListView() {
		addZuZuSet = (ListView) view.findViewById(R.id.lv_groups_set);
		List<ZuZuBean> allzuzu = Datas.getsomeZuzubyCount(activity, 3);
		addZuZuSet.setAdapter(new CommonAdapter<ZuZuBean>(activity,allzuzu,R.layout.item_clan_set) {
			@Override
			public void convert(ViewHolder helper, ZuZuBean zz) {
				helper.setMyImageBitmap(R.id.civ_image, zz.getHeadIcon());
				helper.setText(R.id.tv_zz_name, zz.getName());
			}
		});
		View v = inflater.inflate(R.layout.item_simple_test, null);
		TextView context = (TextView)v.findViewById(android.R.id.text1);
		context.setText("查看所有族族");
		addZuZuSet.addFooterView(v,null,false);
		ListViewUtil.setListViewHeightBasedOnChildren2(addZuZuSet);
		addZuZuSet.setOnItemClickListener(this);
		
	}
	
	/**
	 * 发帖通知设置
	 */
	private void initNoticeSetListView() {
		groupNoticeSet = (ListView) view.findViewById(R.id.lv_groups_notice_set);
		List<ZuZuBean> allzuzu = Datas.getsomeZuzubyCount(activity, 3);
		groupNoticeSet.setAdapter(new CommonAdapter<ZuZuBean>(activity,allzuzu,R.layout.item_groups_notice_set) {
			@Override
			public void convert(ViewHolder helper, ZuZuBean zz) {
				// TODO Auto-generated method stub
				helper.setMyImageBitmap(R.id.civ_image, zz.getHeadIcon());
				helper.setText(R.id.tv_group_name, zz.getName());
				helper.setText(R.id.tv_notice_set, "推送通知");
			}
		});
		View v = inflater.inflate(R.layout.item_simple_test, null);
		TextView context = (TextView)v.findViewById(android.R.id.text1);
		context.setText("查看所有族族");
		groupNoticeSet.addFooterView(v,null,false);
		ListViewUtil.setListViewHeightBasedOnChildren2(groupNoticeSet);
		groupNoticeSet.setOnItemClickListener(this);
	}
	
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		ZuZuBean zz = (ZuZuBean) parent.getAdapter().getItem(position);
		if(addZuZuSet == parent){
			new AddZuZuSetDialog(getActivity(), zz.getName()).show();
		}
		else if(groupNoticeSet == parent){
			new SocietyPostedSetDialog(getActivity(), zz.getName()).show();
		}
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.ll_push_tz) {
			new PushSetDialog(getActivity()).show();
		}
		else if(v.getId() == R.id.tv_top_left){
			activity.onBackPressed();
		}
	}

}
