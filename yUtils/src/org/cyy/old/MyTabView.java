package org.cyy.old;

import org.cyy.R;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/**
 * 使用方法：
1、view_mytab.xml配套到资源文件下
2、tabView = (MyTabView) findViewById(R.id.my_tab_view);
3、int[] imageIds = {R.drawable.img1...8或10张图};
4、String[] titles ={4或5个标题};
5、tabView.SetTabImages(imageIds);
6、tabView.SetTabTitles(titles);
7、tabView.SetViewPager(pager);
 * @author yy_cai
 *
 * 2015年7月16日
 */
public class MyTabView extends LinearLayout implements OnClickListener{
	private ViewPager pager;
	private LinearLayout ll_bottom_0, ll_bottom_1, ll_bottom_2, ll_bottom_3 ,ll_bottom_4;
	private ImageView iv_0_0, iv_0_1, iv_1_0, iv_1_1, iv_2_0, iv_2_1, iv_3_0, iv_3_1,iv_4_0, iv_4_1;
	private TextView  tv_0_0, tv_0_1, tv_1_0, tv_1_1, tv_2_0, tv_2_1, tv_3_0, tv_3_1,tv_4_0, tv_4_1;
	
	public MyTabView(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.view_mytab,this);
		init();
	}
	
	private void init(){
		initView();
		setListener();
		initAlpha();
		changeSelectAlpha(0);
	}
	
	public void SetViewPager(ViewPager viewPager){
		
		this.pager = viewPager;
		
		pager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				initAlpha();
				changeSelectAlpha(position);
			}

			@Override
			public void onPageScrolled(int curPosition, float progress, int deltaPx) {
				/**
				 * 这个API的参数莫名其妙，一点都不规律
				 * curPosition的值当向左滑（即翻到右边的那一页）的时候为当前页的值，当向右滑的时候，为当前页的值-1
				 * progress的值当向左滑的时候，从0-1逐渐递增，当向右滑的时候，从1-0逐渐递减
				 * deltaPX的值当向左滑的时候，大概从0-1078逐渐递增，当向右滑的时候，从1078-0逐渐递减
				 */
				//Log.e(tag, "--------------------curPosition="+curPosition+",progress="+progress+",deltaPx="+deltaPx);
				//这里的思路忽略了不同滑动方向的不同递增规律，以及deltaPX的值不小于0的问题，但误打误撞刚好可以满足条件，暂时用这个方法吧
				changeAlpha(curPosition, deltaPx, progress);
			}

			@Override
			public void onPageScrollStateChanged(int position) {
				
			}
		});
	}
	/**
	 * 第一个tab位置的暗色图标、明色图标
	 * 第二个tab位置的暗色图标、明色图标
	 * 如此顺序排列8个或10个
	 * @param imageIds
	 */
	public void SetTabImages(int imageIds[]){
		iv_0_0.setImageResource(imageIds[0]);
		iv_0_1.setImageResource(imageIds[1]);
		iv_1_0.setImageResource(imageIds[2]);
		iv_1_1.setImageResource(imageIds[3]);
		iv_2_0.setImageResource(imageIds[4]);
		iv_2_1.setImageResource(imageIds[5]);
		iv_3_0.setImageResource(imageIds[6]);
		iv_3_1.setImageResource(imageIds[7]);
		if(imageIds.length==10){
			ll_bottom_4.setVisibility(View.VISIBLE);//开启第五个图标
			iv_4_0.setImageResource(imageIds[8]);
			iv_4_1.setImageResource(imageIds[9]);
		}
	}
	/**
	 * 4或5个tab的标题
	 * @param titles
	 */
	public void SetTabTitles(String titles[]){
		tv_0_0.setText(titles[0]);
		tv_0_1.setText(titles[0]);
		tv_1_0.setText(titles[1]);
		tv_1_1.setText(titles[1]);
		tv_2_0.setText(titles[2]);
		tv_2_1.setText(titles[2]);
		tv_3_0.setText(titles[3]);
		tv_3_1.setText(titles[3]);
		if(titles.length==5){
			tv_4_0.setText(titles[4]);
			tv_4_1.setText(titles[4]);
		}
	}
	/**
	 * 初始化控件
	 */
	private void initView() {
		
		ll_bottom_0 = (LinearLayout) findViewById(R.id.ll_bottom_0);
		ll_bottom_1 = (LinearLayout) findViewById(R.id.ll_bottom_1);
		ll_bottom_2 = (LinearLayout) findViewById(R.id.ll_bottom_2);
		ll_bottom_3 = (LinearLayout) findViewById(R.id.ll_bottom_3);
		ll_bottom_4 = (LinearLayout) findViewById(R.id.ll_bottom_4);
		
		iv_0_0 = (ImageView) findViewById(R.id.iv_0_0);
		iv_0_1 = (ImageView) findViewById(R.id.iv_0_1);
		iv_1_0 = (ImageView) findViewById(R.id.iv_1_0);
		iv_1_1 = (ImageView) findViewById(R.id.iv_1_1);
		iv_2_0 = (ImageView) findViewById(R.id.iv_2_0);
		iv_2_1 = (ImageView) findViewById(R.id.iv_2_1);
		iv_3_0 = (ImageView) findViewById(R.id.iv_3_0);
		iv_3_1= (ImageView) findViewById(R.id.iv_3_1);
		iv_4_0 = (ImageView) findViewById(R.id.iv_4_0);
		iv_4_1= (ImageView) findViewById(R.id.iv_4_1);

		tv_0_0 = (TextView) findViewById(R.id.tv_0_0);
		tv_0_1 = (TextView) findViewById(R.id.tv_0_1);
		tv_1_0 = (TextView) findViewById(R.id.tv_1_0);
		tv_1_1 = (TextView) findViewById(R.id.tv_1_1);
		tv_2_0 = (TextView) findViewById(R.id.tv_2_0);
		tv_2_1 = (TextView) findViewById(R.id.tv_2_1);
		tv_3_0 = (TextView) findViewById(R.id.tv_3_0);
		tv_3_1= (TextView) findViewById(R.id.tv_3_1);
		tv_4_0 = (TextView) findViewById(R.id.tv_4_0);
		tv_4_1= (TextView) findViewById(R.id.tv_4_1);
	}
	
	/**
	 * 设置选中的图标为亮色调
	 * @param i 被选中的页面的index
	 */
	private void changeSelectAlpha(int i) {
		if(i == 0){
			iv_0_0.setAlpha(0.0f);
			iv_0_1.setAlpha(1.0f);
			tv_0_0.setAlpha(0.0f);
			tv_0_1.setAlpha(1.0f);
		}
		else if(i == 1){
			iv_1_0.setAlpha(0.0f);
			iv_1_1.setAlpha(1.0f);
			tv_1_0.setAlpha(0.0f);
			tv_1_1.setAlpha(1.0f);
		}
		else if(i == 2){
			iv_2_0.setAlpha(0.0f);
			iv_2_1.setAlpha(1.0f);
			tv_2_0.setAlpha(0.0f);
			tv_2_1.setAlpha(1.0f);
		}
		else if(i == 3){
			iv_3_0.setAlpha(0.0f);
			iv_3_1.setAlpha(1.0f);
			tv_3_0.setAlpha(0.0f);
			tv_3_1.setAlpha(1.0f);
		}
		else if(i == 4){
			iv_4_0.setAlpha(0.0f);
			iv_4_1.setAlpha(1.0f);
			tv_4_0.setAlpha(0.0f);
			tv_4_1.setAlpha(1.0f);
		}
	}
	/**
	 * 设置监听
	 */
	private void setListener() {

		ll_bottom_0.setOnClickListener(this);
		ll_bottom_1.setOnClickListener(this);
		ll_bottom_2.setOnClickListener(this);
		ll_bottom_3.setOnClickListener(this);
		ll_bottom_4.setOnClickListener(this);
	}

	/**
	 * 初始化全部图标为暗色调
	 */
	protected void initAlpha() {
		iv_0_0.setAlpha(1.0f); 
		iv_0_1.setAlpha(0.0f); 
		iv_1_0.setAlpha(1.0f); 
		iv_1_1.setAlpha(0.0f); 
		iv_2_0.setAlpha(1.0f); 
		iv_2_1.setAlpha(0.0f); 
		iv_3_0.setAlpha(1.0f); 
		iv_3_1.setAlpha(0.0f); 
		iv_4_0.setAlpha(1.0f); 
		iv_4_1.setAlpha(0.0f); 

		tv_0_0.setAlpha(1.0f); 
		tv_0_1.setAlpha(0.0f); 
		tv_1_0.setAlpha(1.0f); 
		tv_1_1.setAlpha(0.0f); 
		tv_2_0.setAlpha(1.0f); 
		tv_2_1.setAlpha(0.0f); 
		tv_3_0.setAlpha(1.0f); 
		tv_3_1.setAlpha(0.0f); 
		tv_4_0.setAlpha(1.0f); 
		tv_4_1.setAlpha(0.0f); 
	}

	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.ll_bottom_0){
			pager.setCurrentItem(0, false);
		}
		else if(v.getId() == R.id.ll_bottom_1){
			pager.setCurrentItem(1, false);
		}
		else if(v.getId() == R.id.ll_bottom_2){
			pager.setCurrentItem(2, false);
		}
		else if(v.getId() == R.id.ll_bottom_3){
			pager.setCurrentItem(3, false);
		}
		else if(v.getId() == R.id.ll_bottom_4){
			pager.setCurrentItem(4, false);
		}
	}

	/**
	 * 渐变效果处理
	 */
	private void changeAlpha(int currPosition, int deltaPx, float progress){

		int nextPosition;
		//deltaPx一直都大于0,除了点击的时候等于0，这边思路是存在问题的，但结果是令人满意的
		if(deltaPx > 0){
			nextPosition = currPosition + 1;
		}
		else{
			nextPosition = currPosition - 1;
		}

		switch (nextPosition) {
		case 0:
			tv_0_1.setAlpha(progress);
			tv_0_0.setAlpha(1 - progress);
			iv_0_1.setAlpha(progress);
			iv_0_0.setAlpha(1 - progress);

			tv_1_1.setAlpha(1 - progress);
			tv_1_0.setAlpha(progress);
			iv_1_1.setAlpha(1 - progress);
			iv_1_0.setAlpha(progress);
			break;
		case 1:
			tv_1_0.setAlpha(1 - progress);
			tv_1_1.setAlpha(progress);
			iv_1_0.setAlpha(1 - progress);
			iv_1_1.setAlpha(progress);
			if(currPosition == 0){
				tv_0_0.setAlpha(progress);
				tv_0_1.setAlpha(1 - progress);
				iv_0_0.setAlpha(progress);
				iv_0_1.setAlpha(1 - progress);
			}else{
				tv_2_0.setAlpha(progress);
				tv_2_1.setAlpha(1 - progress);
				iv_2_0.setAlpha(progress);
				iv_2_1.setAlpha(1 - progress);
			}
			break;
		case 2:
			tv_2_1.setAlpha(progress);
			tv_2_0.setAlpha(1 - progress);
			iv_2_1.setAlpha(progress);
			iv_2_0.setAlpha(1 - progress);
			if(currPosition == 1){
				tv_1_1.setAlpha(1 - progress);
				tv_1_0.setAlpha(progress);
				iv_1_1.setAlpha(1 - progress);
				iv_1_0.setAlpha(progress);
			}else{
				tv_3_0.setAlpha(progress);
				tv_3_1.setAlpha(1 - progress);
				iv_3_0.setAlpha(progress);
				iv_3_1.setAlpha(1 - progress);
			}
			break;
		case 3:
			tv_3_1.setAlpha(progress);
			tv_3_0.setAlpha(1 - progress);
			iv_3_1.setAlpha(progress);
			iv_3_0.setAlpha(1 - progress);	
			if(currPosition == 2){
				tv_2_0.setAlpha(progress);
				tv_2_1.setAlpha(1 - progress);
				iv_2_0.setAlpha(progress);
				iv_2_1.setAlpha(1 - progress);
			}
			else{
				tv_4_0.setAlpha(progress);
				tv_4_1.setAlpha(1 - progress);
				iv_4_0.setAlpha(progress);
				iv_4_1.setAlpha(1 - progress);
			}
			break;
		case 4:
			tv_4_1.setAlpha(progress);
			tv_4_0.setAlpha(1 - progress);
			iv_4_1.setAlpha(progress);
			iv_4_0.setAlpha(1 - progress);	
			
			tv_3_0.setAlpha(progress);
			tv_3_1.setAlpha(1 - progress);
			iv_3_0.setAlpha(progress);
			iv_3_1.setAlpha(1 - progress);
			break;
		}

	}
}
