package com.geihoo.fragment.zuzu.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.geihoo.activity.SocietyMainActivity;
import com.geihoo.adapter.ActivityAdapter;
import com.geihoo.adapter.CommonAdapter;
import com.geihoo.adapter.ViewHolder;
import com.geihoo.base.BaseActivity;
import com.geihoo.base.BaseFragment;
import com.geihoo.bean.ActivityBean;
import com.geihoo.dialog.ActivityDetailsDialog;
import com.geihoo.groups.R;
import com.geihoo.test.Datas;
import com.geihoo.utils.ImageUtil;
/**
 * 活动之往期回顾
 * @author czz
 *
 */
public class SocietyActivityAdvanceFragment extends BaseFragment{
	static String tag="SocietyPhotoFragment_album";
	private ListView advanceList;

	private BaseActivity mActivity;
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mActivity=(BaseActivity)activity;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_society_activity_advance, container,false);
		advanceList=(ListView) view.findViewById(R.id.lv_advance);
		
		List<ActivityBean> list=Datas.getOldActivitys(mActivity);
		
		advanceList.setAdapter(new ActivityAdapter(list, mActivity));
		
		advanceList.setOnItemClickListener(this);
		return view;
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		super.onItemClick(parent, view, position, id);
		new ActivityDetailsDialog(getActivity(),ActivityDetailsDialog.GUO_QI).show();
	}

}
