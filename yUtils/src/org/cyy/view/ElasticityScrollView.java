package org.cyy.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
/**
 * 
 * 说明：有弹性的ScrollView
 * 在布局文件中设置该属性：android:overScrollMode="always"
 * @author yy_cai
 *
 * 2016年2月3日
 */
public class ElasticityScrollView extends ScrollView {

	// private static final int MAX_Y_OVERSCROLL_DISTANCE = 100;
	//
	// private int mMaxYOverscrollDistance;
//	private GestureDetector mGestureDetector;
//	View.OnTouchListener mGestureListener;

	public ElasticityScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
//		mGestureDetector = new GestureDetector(new YScrollDetector());
	}

//	@Override
//	public boolean onInterceptTouchEvent(MotionEvent ev) {
//		return super.onInterceptTouchEvent(ev);
////				&& mGestureDetector.onTouchEvent(ev);
//	}

	// Return false if we're scrolling in the x direction
//	class YScrollDetector extends SimpleOnGestureListener {
//		@Override
//		public boolean onScroll(MotionEvent e1, MotionEvent e2,
//				float distanceX, float distanceY) {
//			if (Math.abs(distanceY) > Math.abs(distanceX)) {
//				return true;
//			}
//			return false;
//		}
//	}


	 @Override
	 protected boolean overScrollBy(int deltaX, int deltaY, int scrollX,
	 int scrollY, int scrollRangeX, int scrollRangeY,
	 int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
	 // This is where the magic happens, we have replaced the incoming
	 // maxOverScrollY with our own custom variable mMaxYOverscrollDistance;
	 return super.overScrollBy(deltaX, deltaY, scrollX, scrollY,
	 scrollRangeX, scrollRangeY, maxOverScrollX,
	 300, isTouchEvent);
	 }
}
