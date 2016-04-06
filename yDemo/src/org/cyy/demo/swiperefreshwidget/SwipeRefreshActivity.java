package org.cyy.demo.swiperefreshwidget;

import java.util.ArrayList;
import java.util.List;

import org.cyy.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.widget.Toast;

public class SwipeRefreshActivity extends Activity implements OnRefreshListener {
	private SwipeRefreshLayout mSwipeRefreshWidget;
	private LinearLayoutManager mLayoutManager;
	private RecyclerView mRecyclerView;
	private SampleAdapter adapter;
	private int lastVisibleItem;

	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 0:
				Toast.makeText(SwipeRefreshActivity.this, "DOWN", 0).show();
				mSwipeRefreshWidget.setRefreshing(false);
				adapter.getList().add(0,666);
				adapter.notifyDataSetChanged();
				break;
			case 1:
				Toast.makeText(SwipeRefreshActivity.this, "UP", 0).show();
				adapter.getList().add(888);
				adapter.notifyDataSetChanged();
				break;
			case 2:
				Toast.makeText(SwipeRefreshActivity.this, "first", 0).show();
				mSwipeRefreshWidget.setRefreshing(false);
				addList();
			default:
				break;
			}

		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_swipe_refresh);

		mSwipeRefreshWidget = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_widget);
		mRecyclerView = (RecyclerView) findViewById(android.R.id.list);

		mSwipeRefreshWidget.setColorSchemeResources(R.color.black, android.R.color.holo_blue_light,
				R.color.sys_main_color, android.R.color.holo_red_light);
		mSwipeRefreshWidget.setOnRefreshListener(this);

		mSwipeRefreshWidget.setProgressViewOffset(true, -50, (int) TypedValue
				.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources()
						.getDisplayMetrics()));

		mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {

			@Override
			public void onScrollStateChanged(RecyclerView recyclerView,
					int newState) {
				super.onScrollStateChanged(recyclerView, newState);
				if (newState == RecyclerView.SCROLL_STATE_IDLE&& lastVisibleItem + 1 == adapter.getItemCount()) {
					handler.sendEmptyMessageDelayed(1, 3000);
				}
			}

			@Override
			public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
				super.onScrolled(recyclerView, dx, dy);
				lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
			}

		});

		mRecyclerView.setHasFixedSize(true);
		mLayoutManager = new LinearLayoutManager(this);
		mRecyclerView.setLayoutManager(mLayoutManager);
		mRecyclerView.setItemAnimator(new DefaultItemAnimator());

		adapter = new SampleAdapter(this);
		mRecyclerView.setAdapter(adapter);

		mSwipeRefreshWidget.setRefreshing(true);
		handler.sendEmptyMessageDelayed(2, 3000);
	}


	private void addList() {
		List<Integer> list = getList();
		adapter.getList().addAll(list);
		adapter.notifyDataSetChanged();
	}

	private List<Integer> getList() {
		List<Integer> list = new ArrayList<Integer>();
		int size = adapter.getList().size();
		int lastPosition = size > 0 ? adapter.getList().get(size - 1) : 0;
		for (int i = 1; i < 15; i++) {
			list.add(lastPosition + i);
		}
		return list;
	}

	@Override
	public void onRefresh() {
		handler.sendEmptyMessageDelayed(0, 3000);
	}

}
