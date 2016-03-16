package org.cyy.view;

import org.cyy.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 
 * 说明：标题栏
 * 
 * @author yy_cai
 * 
 *         2016年3月18日
 */
public class TitleBar extends FrameLayout {

	// 控件
	private RelativeLayout tb;
	private LinearLayout llLeft, llRight;
	private TextView tvLetf, tvRight, tvTitle;
	private ImageView ivLeft, ivRight;
	// 属性
	private int style = 0;// 标题栏风格
	private int tbBackground;
	private String leftStr;
	private String rightStr;
	private String titleStr;
	private Drawable leftImg;
	private Drawable rightImg;
	private float besideSize;
	private float titleSize;
	private int besideColor;
	private int titleColor;

	private TopBarClickListener listener;

	// 点击事件监听器接口

	public interface TopBarClickListener {
		void leftClick();

		void rightClick();
	}

	// 设置监听器

	public void setOnTopBarClickListener(TopBarClickListener listener) {
		this.listener = listener;
	}

	public TitleBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray ta = context.obtainStyledAttributes(attrs,
				R.styleable.TitleBar);
		style = ta.getInt(R.styleable.TitleBar_style, 0);
		tbBackground = ta.getColor(R.styleable.TitleBar_background,
				getResources().getColor(R.color.sys_main_color));
		leftStr = ta.getString(R.styleable.TitleBar_leftStr);
		rightStr = ta.getString(R.styleable.TitleBar_rightStr);
		titleStr = ta.getString(R.styleable.TitleBar_titleStr);
		leftImg = ta.getDrawable(R.styleable.TitleBar_leftImg);
		rightImg = ta.getDrawable(R.styleable.TitleBar_rightImg);
		besideSize = ta.getDimension(R.styleable.TitleBar_besideSize, 14f);
		titleSize = ta.getDimension(R.styleable.TitleBar_titleSize, 16f);
		besideColor = ta.getColor(R.styleable.TitleBar_besideColor,
				getResources().getColor(R.color.sys_big_title_text_color));
		titleColor = ta.getColor(R.styleable.TitleBar_titleColor,
				getResources().getColor(R.color.sys_big_title_text_color));
		// 回收TypedArray（避免浪费资源，避免因为缓存导致的错误）

		ta.recycle();

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.view_title_bar, this);

		tb = (RelativeLayout) findViewById(R.id.title_bar);
		llLeft = (LinearLayout) findViewById(R.id.tb_left);
		llRight = (LinearLayout) findViewById(R.id.tb_right);

		tvLetf = (TextView) findViewById(R.id.tb_left_tv);
		tvTitle = (TextView) findViewById(R.id.tb_title_tv);
		tvRight = (TextView) findViewById(R.id.tb_right_tv);

		ivLeft = (ImageView) findViewById(R.id.tb_left_iv);
		ivRight = (ImageView) findViewById(R.id.tb_right_iv);

		initAttr();

		setTitleBarStyle(style);

		llLeft.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(listener!=null){
					listener.leftClick();
				}
			}
		});
		llRight.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(listener!=null){
					listener.rightClick();
				}
			}
		});

	}

	/**
	 * 设置标题栏风格
	 * 
	 * @param t
	 */
	private void setTitleBarStyle(int t) {
		switch (t) {
		case 0:// 默认只有标题
			llRight.setVisibility(View.GONE);
			llLeft.setVisibility(View.GONE);
			break;
		case 1:// 只显示标题和两边文字
			ivRight.setVisibility(View.GONE);
			ivLeft.setVisibility(View.GONE);
			break;
		case 2:// 只显示标题和两边图片
			tvLetf.setVisibility(View.GONE);
			tvRight.setVisibility(View.GONE);
			break;
		case 3:// 只显示标题和左边文字
			llRight.setVisibility(View.GONE);
			ivLeft.setVisibility(View.GONE);
			break;
		case 4:// 只显示标题和左边图片
			llRight.setVisibility(View.GONE);
			tvLetf.setVisibility(View.GONE);
			break;
		case 5:// 只显示标题和左边图片与文字
			llRight.setVisibility(View.GONE);
			break;
		default:
			break;
		}
	}

	/**
	 * 初始化属性
	 */
	private void initAttr() {
		tb.setBackgroundColor(tbBackground);

		tvLetf.setText("" + leftStr);
		tvTitle.setText("" + titleStr);
		tvRight.setText("" + rightStr);
		tvLetf.setTextSize(besideSize);
		tvRight.setTextSize(besideSize);
		tvTitle.setTextSize(titleSize);
		tvLetf.setTextColor(besideColor);
		tvRight.setTextColor(besideColor);
		tvTitle.setTextColor(titleColor);

		if (leftImg != null) {
			ivLeft.setImageDrawable(leftImg);
		}
		if (rightImg != null) {
			ivRight.setImageDrawable(rightImg);
		}

	}

	/**
	 * 设置左边文字
	 * @param str
	 */
	public void setLeftStr(String str) {
		tvLetf.setText(str);
	}
	/**
	 * 设置标题文字
	 * @param str
	 */
	public void setTitleStr(String str) {
		tvTitle.setText(str);
	}

}
