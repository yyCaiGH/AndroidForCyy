package org.cyy.demo.customview;

import org.cyy.demo.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

public class MyView extends View{

	/** 
     * 文本 
     */  
    private String mTitleText;  
    /** 
     * 文本的颜色 
     */  
    private int mTitleTextColor;  
    /** 
     * 文本的大小 
     */  
    private float mTitleTextSize;  
  
    /** 
     * 绘制时控制文本绘制的范围 
     */  
    private Rect mBound;  
    private Paint mPaint; 
    
	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyView);
		for (int i = 0; i < ta.getIndexCount(); i++) {
			int attr = ta.getIndex(i);
			switch (attr) {
			case R.styleable.MyView_viewText:
				mTitleText = ta.getString(attr);
				break;
			case R.styleable.MyView_viewColor:
				mTitleTextColor = ta.getColor(attr, Color.BLACK);
				break;
			case R.styleable.MyView_viewTextSize:
				mTitleTextSize = ta.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(  
                        TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics())); 
				break;
			default:
				break;
			}
		}
		ta.recycle();
		mPaint = new Paint();
		mPaint.setTextSize(mTitleTextSize);
		
		mBound = new Rect();
		mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		
		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		int widthSize = MeasureSpec.getSize(widthMeasureSpec);
		int heightMode = MeasureSpec.getMode(heightMeasureSpec);
		int heightSize = MeasureSpec.getSize(heightMeasureSpec);
		int width;
		int height;
		if(widthMode == MeasureSpec.EXACTLY){//march_parent
			width = widthSize;
		}
		else{//wrap_content
			width = getPaddingLeft()+mBound.width()+getPaddingRight();
		}
		
		if(heightMode == MeasureSpec.EXACTLY){
			height = heightSize;
		}
		else{
			height = getPaddingBottom()+mBound.height()+getPaddingTop();
		}
		setMeasuredDimension(width, height);
	}
	@Override
	protected void onDraw(Canvas canvas) {
		mPaint.setColor(mTitleTextColor);
		canvas.drawText(mTitleText, getWidth()/2-mBound.width()/2, getHeight()/2+mBound.height()/4, mPaint);//+mBound.height()/4，由于Android屏幕原点在左上角。所以这里要+，为什么/4,经试验，/2不在中间
		Log.i("cyy-cyy", "getWidth="+getWidth()+",getHeight="+getHeight()+"，getMeasuredWidth="+getMeasuredWidth()+"，getMeasuredHeight="+getMeasuredHeight());
	}
	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		// TODO Auto-generated method stub
		super.onLayout(changed, left, top, right, bottom);
	}
}
