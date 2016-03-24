package org.cyy.demo.ontouchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;

public class MyLinearLayout extends LinearLayout implements OnScrollListener{

	static String tag = "MyLinearLayout";
	public MyLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		// 得到Header的高度，这个高度需要用这种方式得到，在onLayout方法里面得到的高度始终是0
        getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
            	setPadding(-40, -30, -50, -80);
                getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
	}

    
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.i(tag, tag+"-->onTouchEvent--"+event.getAction());
		return super.onTouchEvent(event);
	}
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		Log.i(tag, tag+"-->onInterceptTouchEvent--"+ev.getAction());
		return super.onInterceptTouchEvent(ev);
	}
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		Log.i(tag, tag+"-->dispatchTouchEvent--"+ev.getAction());
		return super.dispatchTouchEvent(ev);
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
