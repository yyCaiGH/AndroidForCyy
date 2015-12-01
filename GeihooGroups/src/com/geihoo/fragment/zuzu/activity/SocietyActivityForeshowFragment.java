package com.geihoo.fragment.zuzu.activity;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.geihoo.activity.SocietyMainActivity;
import com.geihoo.adapter.ActivityAdapter;
import com.geihoo.adapter.CommonAdapter;
import com.geihoo.adapter.ViewHolder;
import com.geihoo.base.BaseFragment;
import com.geihoo.bean.ActivityBean;
import com.geihoo.dialog.ActivityDetailsDialog;
import com.geihoo.groups.R;
import com.geihoo.test.Datas;

/**
 * 活动之活动预告
 * 
 * @author czz
 * 
 */

public class SocietyActivityForeshowFragment extends BaseFragment implements
		OnClickListener {
	static String tag = "SocietyActivityForeshowFragment";
	private ListView foreshowList;
	private SocietyMainActivity mActivity;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mActivity = (SocietyMainActivity) activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(
				R.layout.fragment_society_activity_foreshow, container, false);
		foreshowList = (ListView) view.findViewById(R.id.lv_foreshow);

		List<ActivityBean> list = Datas.getActivitys(mActivity);

		foreshowList.setAdapter(new ActivityAdapter(list, mActivity));

		foreshowList.setOnItemClickListener(this);
		return view;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		new ActivityDetailsDialog(getActivity(),ActivityDetailsDialog.KE_BAOMING).show();
	}

}
