package com.geihoo.fragment.me;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.geihoo.activity.MeActivity;
import com.geihoo.adapter.SocietyPostAdapter;
import com.geihoo.base.BaseFragment;
import com.geihoo.bean.PostContentBean;
import com.geihoo.groups.R;
import com.geihoo.utils.Constants;
/**
 * 我的收藏
 * @author yy_cai
 *
 * 2015年8月31日
 */
public class MyCollectFragment extends BaseFragment{

	private MeActivity activity;
	ListView postListView;
	ArrayList<PostContentBean> postList = new ArrayList<PostContentBean>();
	SocietyPostAdapter societyPostAdapter;
	public final static int SET_POSTLIST = 0;
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		this.activity = (MeActivity)activity;
		super.onAttach(activity);
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		initData();
		handler.obtainMessage(SET_POSTLIST).sendToTarget();//先放着，不卡
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_my_collect, container,
				false);
		initView(view);
		return view;
	}


	private void initTopView(View view) {
		activity.setTitle(activity.getResources().getString(R.string.top_title_wdsc));
		activity.setRightStyle(null, 0);
		
	}
	protected void initView(View view) {
		initTopView(view);
		postListView = (ListView) view.findViewById(R.id.postListView);
	}

	protected void initData() {
		postList = Constants.getPostList();
	}

	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			switch (msg.what) {
			case SET_POSTLIST:
				// detail_loading.setVisibility(View.GONE);
//				homeDynamicAdapter = new HomeDynamicAdapter(activity, postList);
//				postListView.setAdapter(homeDynamicAdapter);
				societyPostAdapter = new SocietyPostAdapter(activity, postList,SocietyPostAdapter.MY_COLLECT);
				postListView.setAdapter(societyPostAdapter);
				break;
			default:
				break;
			}
			super.handleMessage(msg);
		}
	};

	/** 此方法意思为fragment是否可见 ,可见时候加载数据 */
	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		if (isVisibleToUser) {
			// fragment可见时加载数据
			if (postList != null && postList.size() != 0) {
				handler.obtainMessage(SET_POSTLIST).sendToTarget();
			} else {
				new Thread(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						try {
							Thread.sleep(2);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						handler.obtainMessage(SET_POSTLIST).sendToTarget();
					}
				}).start();
			}
		} else {
			// fragment不可见时不执行操作
		}
		super.setUserVisibleHint(isVisibleToUser);
	}
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.iv_top_left){
			activity.finish();
		}
	}
}
