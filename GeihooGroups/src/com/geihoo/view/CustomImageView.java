package com.geihoo.view;

import java.io.InputStream;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.geihoo.groups.R;
import com.geihoo.utils.ImageUtil;

/**
 * 自定义View，实现圆角，圆形等效果
 * 
 * @author zhy
 * 
 */
public class CustomImageView extends View {

	/**
	 * TYPE_CIRCLE / TYPE_ROUND
	 */
	private int type;
	private static final int TYPE_CIRCLE = 0;
	private static final int TYPE_ROUND = 1;
	private static final int TYPE_RING = 2;

	/**
	 * 图片
	 */
	private Bitmap mSrc;

	/**
	 * 圆角的大小
	 */
	private int mRadius;

	/**
	 * 控件的宽度
	 */
	private int mWidth;
	/**
	 * 控件的高度
	 */
	private int mHeight;
	/**
	 * 截取的正方形的宽度
	 */
	private int realWidth;

	public CustomImageView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public CustomImageView(Context context) {
		this(context, null);
	}
	/**
	 * 初始化一些自定义的参数
	 * 
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public CustomImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
				R.styleable.CustomImageView, defStyle, 0);

		int n = a.getIndexCount();
		for (int i = 0; i < n; i++) {
			int attr = a.getIndex(i);
			switch (attr) {
			case R.styleable.CustomImageView_src:
//				mSrc = BitmapFactory.decodeResource(getResources(),a.getResourceId(attr, 0));
				mSrc = readBitMap(a.getResourceId(attr, 0));
				break;
			case R.styleable.CustomImageView_type:
				type = a.getInt(attr, 0);// 默认为Circle
				break;
			case R.styleable.CustomImageView_borderRadius:
				mRadius = a.getDimensionPixelSize(attr, (int) TypedValue
						.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10f,
								getResources().getDisplayMetrics()));// 默认为10DP
				break;
			}
		}
		a.recycle();
	}

	public void setPic(Bitmap pic) {
		this.mSrc = pic;
	}

	/**
	 * 计算控件的高度和宽度
	 */
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		/**
		 * 设置宽度
		 */
		int specMode = MeasureSpec.getMode(widthMeasureSpec);
		int specSize = MeasureSpec.getSize(widthMeasureSpec);

		if (specMode == MeasureSpec.EXACTLY)// match_parent , accurate
		{
			mWidth = specSize;
		} else {
			// 由图片决定的宽
			int desireByImg = getPaddingLeft() + getPaddingRight()
					+ mSrc.getWidth();
			if (specMode == MeasureSpec.AT_MOST)// wrap_content
			{
				mWidth = Math.min(desireByImg, specSize);
			} else

				mWidth = desireByImg;
		}

		/***
		 * 设置高度
		 */

		specMode = MeasureSpec.getMode(heightMeasureSpec);
		specSize = MeasureSpec.getSize(heightMeasureSpec);
		if (specMode == MeasureSpec.EXACTLY)// match_parent , accurate
		{
			mHeight = specSize;
		} else {
			int desire = getPaddingTop() + getPaddingBottom()
					+ mSrc.getHeight();

			if (specMode == MeasureSpec.AT_MOST)// wrap_content
			{
				mHeight = Math.min(desire, specSize);
			} else
				mHeight = desire;
		}

		setMeasuredDimension(mWidth, mHeight);
		realWidth = Math.min(mWidth, mHeight);
	}

	/**
	 * 绘制
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		mSrc = Bitmap.createScaledBitmap(mSrc, realWidth, realWidth, false);
		switch (type) {
		// 如果是TYPE_CIRCLE绘制圆形
		case TYPE_CIRCLE:
			canvas.drawBitmap(createCircleImage(mSrc, realWidth, realWidth/2), 0, 0, null);
			break;
		case TYPE_ROUND:
			canvas.drawBitmap(createRoundConerImage(mSrc), 0, 0, null);
			break;
		case TYPE_RING:
			createRingImage(canvas);
			break;
		}

	}

	/**
	 * 根据原图和变长绘制圆形图片
	 * 
	 * @param source
	 * @param min
	 * @return
	 */
	private Bitmap createCircleImage(Bitmap source, int min, int radius) {
		final Paint paint = new Paint();
		paint.setAntiAlias(true);
		Bitmap target = Bitmap.createBitmap(min, min, Config.ARGB_8888);
		/**
		 * 产生一个同样大小的画布
		 */
		Canvas canvas = new Canvas(target);
		/**
		 * 首先绘制圆形
		 */
		canvas.drawCircle(min / 2, min / 2, radius, paint);
		/**
		 * 使用SRC_IN，参考上面的说明
		 */
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
		/**
		 * 绘制图片
		 */
		canvas.drawBitmap(source, 0, 0, paint);
		return target;
	}

	/**
	 * 根据原图添加圆角
	 * 
	 * @param source
	 * @return
	 */
	private Bitmap createRoundConerImage(Bitmap source) {
		final Paint paint = new Paint();
		paint.setAntiAlias(true);
		Bitmap target = Bitmap.createBitmap(mWidth, mHeight, Config.ARGB_8888);
		Canvas canvas = new Canvas(target);
		RectF rect = new RectF(0, 0, source.getWidth(), source.getHeight());
		canvas.drawRoundRect(rect, mRadius, mRadius, paint);
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
		canvas.drawBitmap(source, 0, 0, paint);
		return target;
	}
	
	public void createRingImage(Canvas canvas){
		canvas.drawBitmap(createCircleImage(mSrc, realWidth, realWidth/2-realWidth/18), 0, 0, null);
		drawCircleBorder(canvas, Color.GRAY, 2);
	}
	
    /** 
     * 边缘画圆 
     */ 
    private void drawCircleBorder(Canvas canvas, int color, int mBorderThickness) {
        Paint paint = new Paint(); 
        /* 去锯齿 */ 
        paint.setAntiAlias(true); 
        paint.setFilterBitmap(true); 
        paint.setDither(true); 
        paint.setColor(color); 
        /* 设置paint的　style　为STROKE：空心 */ 
        paint.setStyle(Paint.Style.STROKE); 
        /* 设置paint的外框宽度 */ 
        paint.setStrokeWidth(mBorderThickness); 
        canvas.drawCircle(realWidth / 2, realWidth / 2, realWidth / 2-mBorderThickness, paint); 
    }
    
    /*
	 * 以最省内存的方式读取本地资源的图片
	 * 
	 * @param context
	 * 
	 * @param resId
	 * 
	 * @return
	 */
	private Bitmap readBitMap(int resId) {
		BitmapFactory.Options opt = new BitmapFactory.Options();
		opt.inPreferredConfig = Bitmap.Config.RGB_565;
		opt.inPurgeable = true;
		opt.inInputShareable = true;
		// 获取资源图片
		InputStream is = getResources().openRawResource(resId);
		return BitmapFactory.decodeStream(is, null, opt);
	}
}
