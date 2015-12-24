package com.geihoo.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.geihoo.base.BaseActivity;
import com.geihoo.fragment.me.MyActivityFragment;
import com.geihoo.fragment.me.MyCollectFragment;
import com.geihoo.fragment.me.MyHomeFragment;
import com.geihoo.fragment.me.MyInfoFragment;
import com.geihoo.fragment.me.MyMessageFragment;
import com.geihoo.fragment.me.SetFragment;
import com.geihoo.fragment.zuzu.maintab.SocietyActivityFragment;
import com.geihoo.groups.R;
/**
 * 
 * “我”模块的Activity控制器
 *
 * @author yy_cai
 *
 * 2015年11月29日
 */
public class MeActivity extends BaseActivity {

	public static final int ME_MESSAGE = 0x100;
	public static final int ME_COLLECT = 0x101;
	public static final int ME_SET = 0x102;
	public static final int ME_INFO = 0x103;
	public static final int ME_HOME = 0x104;
	public static final int ME_ACTIVITY = 0x105;
	private TextView tvTitle,tvRight,tvLeft;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_me);
		initView();
	}
	@Override
	protected void initView() {
		initTopBar();
		
		int type = this.getIntent().getIntExtra("type", 0x100);
		if (type == ME_COLLECT) {
			initFragment(new MyCollectFragment(), null,R.id.fl_me);
		} else if (type == ME_MESSAGE) {
			initFragment(new MyMessageFragment(), null,R.id.fl_me);
		} else if (type == ME_SET) {
			initFragment(new SetFragment(), null,R.id.fl_me);
		}else if (type == ME_INFO) {
//			Bundle bundle = new Bundle();
//			bundle.putParcelable("contact", this.getIntent().getParcelableExtra("contact"));
			initFragment(new MyInfoFragment(), null,R.id.fl_me);
		}else if (type == ME_HOME) {
			Bundle bundle = new Bundle();
			bundle.putParcelable("contact", this.getIntent().getParcelableExtra("contact"));
			bundle.putBoolean("friendly", this.getIntent().getBooleanExtra("friendly", true));
			initFragment(new MyHomeFragment(), bundle,R.id.fl_me);
		}
		else if(type == ME_ACTIVITY){
			initFragment(new MyActivityFragment(), null, R.id.fl_me);
		}
	}

	@Override
	protected void initTopBar() {
		tvTitle = (TextView) this.findViewById(R.id.tv_top_title);
		tvRight = (TextView) this.findViewById(R.id.tv_top_right);
		tvLeft = (TextView) this.findViewById(R.id.tv_top_left);
		tvLeft.setOnClickListener(this);
		tvRight.setOnClickListener(this);
	}

	/**
	 * 设置顶部左边图标风格
	 * @param left 文字   null表示没有文字
	 * @param resId 图像id 0表示没有图片
	 */
	public void setLeftStyle(String left,int resId) {
		tvLeft.setText(left);
		if(resId!=0){
			tvLeft.setBackgroundResource(resId);
		}
		
	}

	/**
	 * 设置顶部右边图标风格(有文字没图片，2选1)
	 * @param right 文字   null表示没有文字
	 * @param resId 图像id 0表示没有图片
	 */
	public void setRightStyle(String right,int resId) {
		tvRight.setText(right);
		if(resId!=0){
			Drawable drawable=getResources().getDrawable(resId);
			drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
			tvRight.setCompoundDrawables(drawable, null,null,null);
		}
		else{
			tvRight.setCompoundDrawables(null, null,null,null);
		}
	}

	public void setTitle(String title) {
		tvTitle.setText(title);
	}
	
	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.tv_top_left) {
			this.onBackPressed();
		}
	}

}
