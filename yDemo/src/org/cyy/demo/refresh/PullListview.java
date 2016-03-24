package org.cyy.demo.refresh;

import org.cyy.view.refresh.PullToRefreshBase;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

public class PullListview extends PullToRefreshBase<ListView> implements OnScrollListener{

	private ListView mListView;
	public PullListview(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ListView createRefreshableView(Context context, AttributeSet attrs) {
		ListView listView = new ListView(context);
		mListView = listView;
		listView.setOnScrollListener(this);
		return listView;
	}

	@Override
	protected boolean isReadyForPullDown() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean isReadyForPullUp() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		// TODO Auto-generated method stub
		
	}

}
