package org.cyy.view;

import org.cyy.R;

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
import android.util.TypedValue;
import android.view.View;


/**
 * 
 * 说明：自定义View，实现圆角，圆形，圆环，抠图等效果
 *
 * @author yy_cai
 *
 * 2016年3月23日
 */
public class YImageView extends View {

	
	private static final int TYPE_CIRCLE = 0;//圆形
	private static final int TYPE_ROUND = 1;//圆角
	private static final int TYPE_RING = 2;//圆环

	/**
	 * TYPE_CIRCLE / TYPE_ROUND
	 */
	private int mType;
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

	public YImageView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public YImageView(Context context) {
		this(context, null);
	}

	/**
	 * 初始化一些自定义的参数
	 * 
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public YImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
				R.styleable.YImageView, defStyle, 0);
		
		//不用for循环，避免在for循环中会出现空指针的现象
		mSrc = BitmapFactory.decodeResource(getResources(),
				a.getResourceId(R.styleable.YImageView_src, R.drawable.ic_launcher));
		
		mType = a.getInt(R.styleable.YImageView_type, 0);// 默认为Circle
		
		mRadius = a.getDimensionPixelSize(R.styleable.YImageView_borderRadius, (int) TypedValue
				.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30f,
						getResources().getDisplayMetrics()));// 默认为30dp
		a.recycle();
	}

	/**
	 * 设置图片
	 * @param pic
	 */
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
		realWidth = Math.min(mWidth, mHeight);//获得最小值，在剪切的时候得到最佳效果
	}

	/**
	 * 绘制
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		mSrc = Bitmap.createScaledBitmap(mSrc, realWidth, realWidth, false);//图片缩放，防止只剪切图片部分的问题
		switch (mType) {
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
	 * 根据原图和变长绘制椭圆圆形图片
	 * 
	 * @param source
	 * @param min
	 * @return
	 */
	private Bitmap createOvalImage(Bitmap source, int min, int radius) {
		final Paint paint = new Paint();
		paint.setAntiAlias(true);
		Bitmap target = Bitmap.createBitmap(min, min, Config.ARGB_8888);
		/**
		 * 产生一个同样大小的画布
		 */
		Canvas canvas = new Canvas(target);
		/**
		 * 首先绘制椭圆
		 */
		RectF oval2 = new RectF(radius/12,radius/3,min-radius/12,min-radius/3);// 椭圆放置在这个长方形中
	    canvas.drawOval(oval2, paint);  
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
	 * 根据原图将图形抠出一个中心圆块
	 * 
	 * @param source
	 * @param min
	 * @return
	 */
	private Bitmap createDigCircleImage(Bitmap source, int min, int radius) {
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
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
		/**
		 * 绘制图片
		 */
		canvas.drawBitmap(source, 0, 0, paint);
		return target;
	}
	
	/**
	 * 根据原图将图形抠出一个正方形
	 * 
	 * @param source
	 * @param min
	 * @return
	 */
	private Bitmap createDigRectImage(Bitmap source, int min, int radius) {
		final Paint paint = new Paint();
		int cutLeng = radius/4;
		paint.setAntiAlias(true);
		Bitmap target = Bitmap.createBitmap(min, min, Config.ARGB_8888);
		/**
		 * 产生一个同样大小的画布
		 */
		Canvas canvas = new Canvas(target);
		/**
		 * 首先绘制方形
		 */
		canvas.drawRect(cutLeng, cutLeng, min-cutLeng, min-cutLeng, paint);
		/**
		 * 使用SRC_IN，参考上面的说明
		 */
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
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
		canvas.drawBitmap(createCircleImage(mSrc, realWidth, realWidth/2-realWidth/12), 0, 0, null);
		drawCircleBorder(canvas, Color.GRAY, realWidth/50);//设为-12可以填充整个空白的部分
	}
	
    /**
     * 边缘画圆框
     * @param canvas
     * @param color 边框的颜色
     * @param mBorderThickness 边框的宽度
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
    
}
