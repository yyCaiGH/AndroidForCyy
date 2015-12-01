package com.geihoo.fragment.maintab;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.zip.DataFormatException;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.geihoo.activity.MainTabActivity;
import com.geihoo.adapter.SocietyPostAdapter;
import com.geihoo.base.BaseFragment;
import com.geihoo.bean.PostContentBean;
import com.geihoo.dialog.StickPostsDialog;
import com.geihoo.groups.R;
import com.geihoo.utils.Constants;
import com.geihoo.view.flv.DynamicListView;
import com.geihoo.view.flv.DynamicListView.OnStartListener;
import com.geihoo.view.flv.SimpleFooter;
import com.geihoo.view.flv.SimpleHeader;

/**
 * 动态
 * 
 * @author yy_cai
 * 
 *         2015年7月16日
 */
public class DynamicFragment extends BaseFragment {

	MainTabActivity activity;
	ArrayList<PostContentBean> postList = new ArrayList<PostContentBean>();
	// ListView postListView;
	private DynamicListView dlv;
	// HomeDynamicAdapter homeDynamicAdapter;
	SocietyPostAdapter societyPostAdapter;
	PopupWindow popupWindow;
	TextView title;
	public final static int SET_POSTLIST = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		initData();
		handler.obtainMessage(SET_POSTLIST).sendToTarget();// 先放着，不卡
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		this.activity = (MainTabActivity) activity;
		super.onAttach(activity);
	}

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
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = LayoutInflater.from(getActivity()).inflate(
				R.layout.fragment_home_dynamic, null);
		initView(view);
		initListView(view);
		return view;
	}

	private void initListView(View view) {
		dlv = (DynamicListView) view.findViewById(R.id.task_lv_dynamic);
		// 设置下拉刷新的样式（可选，但如果没有Header则无法下拉刷新）
		SimpleHeader header = new SimpleHeader(activity);
		header.setTextColor(0xff1da664);
		header.setCircleColor(0xff1da664);
		dlv.setHeadable(header);

		// 设置加载更多的样式（可选）
		SimpleFooter footer = new SimpleFooter(activity);
		footer.setCircleColor(0xff1da664);
		dlv.setFootable(footer);

		// 设置列表项出现动画（可选）
//		dlv.setItemAnimForTopIn(R.anim.top_item_in);
//		dlv.setItemAnimForBottomIn(R.anim.bottom_item_in);

		// 下拉刷新事件回调（可选）
		dlv.setOnRefreshStartListener(new OnStartListener() {
			@Override
			public void onStart() {
				refresh();
			}
		});

		// 加载更多事件回调（可选）
		dlv.setOnLoadMoreStartListener(new OnStartListener() {
			@Override
			public void onStart() {
				loadMore();
			}
		});
	}

	private void refresh() {
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				PostContentBean bean = new PostContentBean();
				bean.setName("叶良辰");
				SimpleDateFormat date = new SimpleDateFormat("MM月dd日");
				bean.setTime(date.format(new Date()));
				bean.setContent("世界这么大，我想去看看");
				bean.setHeadImgId(R.drawable.test_head_img_9);
				bean.setImageId1(R.drawable.test_content_img_8);
				postList.add(0, bean);
				societyPostAdapter.notifyDataSetChanged();
				dlv.setRefreshSuccess("刷新成功"); // 通知加载成功
				dlv.startLoadMore(); // 开启LoadingMore功能
			}
		}, 2 * 1000);
	}

	private void loadMore() {
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
//				datas.add("加载一条数据");
//				adapter.notifyDataSetChanged();
				dlv.setLoadMoreSuccess(); // 通知加载成功
			}
		}, 2 * 1000);
	}
	
	protected void initView(View view) {
		// postListView = (ListView) view.findViewById(R.id.postListView);

		ImageView topHome = (ImageView) view.findViewById(R.id.iv_top_left);
		topHome.setOnClickListener(this);
		title = (TextView) view.findViewById(R.id.tv_top_title);
		title.setText(getActivity().getResources().getString(
				R.string.top_title_sydt));
		title.setOnClickListener(this);
		ImageView create = (ImageView) view.findViewById(R.id.iv_top_right);
		create.setVisibility(View.GONE);

		Drawable drawable = getResources().getDrawable(
				R.drawable.top_drawdown_image);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(),
				drawable.getMinimumHeight());
		title.setCompoundDrawables(null, null, drawable, null);// 只放右边
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
				// homeDynamicAdapter = new HomeDynamicAdapter(activity,
				// postList);
				// postListView.setAdapter(homeDynamicAdapter);
				societyPostAdapter = new SocietyPostAdapter(activity, postList,
						SocietyPostAdapter.MY_DYNAMIC);
				dlv.setAdapter(societyPostAdapter);
				break;
			default:
				break;
			}
			super.handleMessage(msg);
		}
	};

	public void onClick(View v) {
		if (v.getId() == R.id.iv_top_left) {
			activity.dealSlidingMenu();
		}else if (v.getId() == R.id.tv_top_title) {
			showPopupWindow(v);
		} else if (v.getId() == R.id.tv_all_dynam) {
			title.setText("所有动态");
			popupWindow.dismiss();
		} else if (v.getId() == R.id.tv_my_dynam) {
			title.setText("私密动态");
			popupWindow.dismiss();
		} else if (v.getId() == R.id.tv_scholl_dynam) {
			title.setText("公开动态");
			popupWindow.dismiss();
		}

	};

	private void showPopupWindow(View view) {

		// TODO Auto-generated method stub
		// 一个自定义的布局，作为显示的内容
		View contentView = LayoutInflater.from(getActivity()).inflate(
				R.layout.view_pop_dynamic_type, null);
		// 设置按钮的点击事件
		TextView allDynam = (TextView) contentView
				.findViewById(R.id.tv_all_dynam);
		TextView myDynam = (TextView) contentView
				.findViewById(R.id.tv_my_dynam);
		TextView schollDynam = (TextView) contentView
				.findViewById(R.id.tv_scholl_dynam);
		allDynam.setOnClickListener(this);
		myDynam.setOnClickListener(this);
		schollDynam.setOnClickListener(this);

		popupWindow = new PopupWindow(contentView, LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT, true);

		popupWindow.setTouchable(true);
		popupWindow.setOutsideTouchable(true);

		// 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
		// 我觉得这里是API的一个bug
		popupWindow.setBackgroundDrawable(new ColorDrawable(0));
		// 设置好参数之后再show
		popupWindow.showAsDropDown(view, -115, -38);
		// popupWindow.showAtLocation(view, Gravity.CENTER_HORIZONTAL, 0, 0);
	}
}
