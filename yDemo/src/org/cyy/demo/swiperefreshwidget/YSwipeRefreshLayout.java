package org.cyy.demo.swiperefreshwidget;

import org.cyy.demo.R;
import org.cyy.view.RotateImageView;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 继承自SwipeRefreshLayout,从而实现滑动到底部时上拉加载更多的功能. 
 * 注意 :
 * 在下拉刷新完成时需要调用RefreshLayout的setRefreshing(false)方法来停止刷新过程；
 * 在上拉加载更多完成时需要调用setLoading(false,flase)来标识加载完成，但数据未全部加载完毕。
 * setLoading(false,true)来标识数据已全部加载完毕
 * @author yy_cai
 */
public class YSwipeRefreshLayout extends SwipeRefreshLayout implements
		OnScrollListener {
	/**
	 * 滑动到最下面时的上拉操作
	 */
	private int mTouchSlop;
	/**
	 * listview实例
	 */
	private ListView mListView;

	/**
	 * 上拉监听器, 到了最底部的上拉加载操作
	 */
	private OnRefreshAndLoadListener mOnLoadListener;
	
	/**
	 * ListView的加载中footer
	 */
	private View mListViewFooter;
	
	private RotateImageView mFooterRIV;
	
//	private TextView mFooterTv;
	/**
	 * 按下时的y坐标
	 */
	private int mYDown;
	/**
	 * 抬起时的y坐标, 与mYDown一起用于滑动到底部时判断是上拉还是下拉
	 */
	private int mLastY;
	/**
	 * 是否在加载中 ( 上拉加载更多 )
	 */
	private boolean isLoading = false;

	private boolean isLoadComplete=false;
	/**
	 * @param context
	 */
	public YSwipeRefreshLayout(Context context) {
		this(context, null);
	}

	public YSwipeRefreshLayout(Context context, AttributeSet attrs) {
		super(context, attrs);

		mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();

		mListViewFooter = LayoutInflater.from(context).inflate(
				R.layout.listview_footer, null, false);
		mListViewFooter.setVisibility(View.GONE);//默认FooterView是看不到的
		mFooterRIV = ((RotateImageView)mListViewFooter.findViewById(R.id.pull_to_refresh_load_progress));
		mFooterRIV.startRotate();
//		mFooterTv = (TextView)mListViewFooter.findViewById(R.id.pull_to_refresh_finsha_text);
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		super.onLayout(changed, left, top, right, bottom);

		// 初始化ListView对象
		if (mListView == null) {
			getListView();
			this.setOnRefreshListener(new OnRefreshListener() {
				
				@Override
				public void onRefresh() {
					isLoadComplete=false;//重新加载
					mFooterRIV.startRotate();
					mOnLoadListener.onRefresh();//整合SwipeRefreshLayout的刷新功能到本view中
				}
			});
		}
	}

	/**
	 * 获取ListView对象
	 */
	private void getListView() {
		int childs = getChildCount();
		if (childs > 0) {
			View childView = getChildAt(0);
			if (childView instanceof ListView) {
				mListView = (ListView) childView;
				// 设置滚动监听器给ListView, 使得滚动的情况下也可以自动加载
				mListView.setOnScrollListener(this);
				Log.d(VIEW_LOG_TAG, "### 找到listview");
				mListView.addFooterView(mListViewFooter);
			}
		}
		else{
			Toast.makeText(getContext(), "请在SwipeRefreshLayout中放置一个ListView", Toast.LENGTH_LONG).show();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.ViewGroup#dispatchTouchEvent(android.view.MotionEvent)
	 */
	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		final int action = event.getAction();

		switch (action) {
		case MotionEvent.ACTION_DOWN:
			// 按下
			mYDown = (int) event.getRawY();
			break;

		case MotionEvent.ACTION_MOVE:
			// 移动
			mLastY = (int) event.getRawY();
			break;

		case MotionEvent.ACTION_UP:
			// 抬起
			if (canLoad()) {
				loadData();
			}
			break;
		default:
			break;
		}

		return super.dispatchTouchEvent(event);
	}

	/**
	 * 是否可以加载更多, 条件是未全部加载完成, listview不在加载中, 且为上拉操作,到了最底部.
	 * 
	 * @return
	 */
	private boolean canLoad() {
		return !isLoadComplete&&!isLoading && isPullUp()&&isBottom();
	}

	/**
	 * 判断是否到了最底部
	 */
	private boolean isBottom() {

		if (mListView != null && mListView.getAdapter() != null) {
			return mListView.getLastVisiblePosition() == (mListView
					.getAdapter().getCount() - 1);
		}
		return false;
	}

	/**
	 * 是否是上拉操作
	 * 
	 * @return
	 */
	private boolean isPullUp() {
		return (mYDown - mLastY) >= mTouchSlop;
	}

	/**
	 * 如果到了最底部,而且是上拉操作.那么执行onLoad方法
	 */
	private void loadData() {
		if (mOnLoadListener != null) {
			// 设置状态
			setLoading(true,false);
			//
			mOnLoadListener.onLoad();
		}
	}

	/**
	 * 
	 * @param loading 是否正在加载
	 * @param LoadComplete 是否加载完成
	 */
	public void setLoading(boolean loading,boolean LoadComplete) {
		isLoading = loading;
		isLoadComplete = LoadComplete;
		if(isLoadComplete){
			mListViewFooter.setVisibility(View.GONE);
			mFooterRIV.stopRotate();
			Toast.makeText(getContext(), "数据已全部加载", Toast.LENGTH_LONG).show();
//			mFooterRIV.setVisibility(View.INVISIBLE);
//			mFooterTv.setVisibility(View.VISIBLE);
			mYDown = 0;
			mLastY = 0;
		}
		else if (isLoading&&!isLoadComplete) {
//			mListView.addFooterView(mListViewFooter);
			mListViewFooter.setVisibility(View.VISIBLE);
//			mFooterRIV.setVisibility(View.VISIBLE);
//			mFooterTv.setVisibility(View.GONE);
		}
		else {
//			mListView.removeFooterView(mListViewFooter);
			mListViewFooter.setVisibility(View.GONE);
			mYDown = 0;
			mLastY = 0;
		}
	}

	/**
	 * @param loadListener
	 */
	public void setOnRefreshAndLoadListener(OnRefreshAndLoadListener loadListener) {
		mOnLoadListener = loadListener;
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {

	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		// 滚动时到了最底部也可以加载更多
		if (canLoad()) {
			loadData();
		}
	}

	/**
	 * 下拉刷新，上拉加载监听
	 */
	public static interface OnRefreshAndLoadListener {
		public void onLoad();
		public void onRefresh();
	}
}
