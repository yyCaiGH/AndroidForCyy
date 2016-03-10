package org.cyy.base;

import org.cyy.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

import com.readystatesoftware.systembartint.SystemBarTintManager;

public  class BaseActivity extends FragmentActivity implements View.OnClickListener, OnItemClickListener, OnItemLongClickListener {

	private FragmentTransaction ft;
	private SystemBarTintManager tintManager;//设置状态栏颜色
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
//		initTintManager();//遇到太多问题	1、侧滑菜单奇丑，不能像qq那样。2、族族首页与系统主题不合，要多次设回来，设回去
		initTopBar();
		initView();
		initData();
	}
	/**
	 * 初始化标题栏
	 */
	protected void initTopBar(){
		
	}
	/**
	 * 初始化界面
	 */
	protected  void initView(){
		
	}
	/**
	 * 初始化数据
	 */
	protected  void initData(){
		
	}
	
	/**
	 * 初始化状态栏管理器
	 */
	private void initTintManager(){
		tintManager = new SystemBarTintManager(this);
		tintManager.setStatusBarTintEnabled(true);
		tintManager.setStatusBarTintResource(R.color.sys_main_color);//默认为系统主色调
	}
	/**
	 * 设置状态栏颜色
	 * @param res
	 */
	protected void setStatusBarTintResource(int res){
		tintManager.setStatusBarTintResource(res);
	}
	/**
	 * 初始化Fragment
	 * @param f Fragment对象
	 * @param bundle 传递给该Fragment的参数
	 * @param containerViewId Fragment的位置
	 */
	public void initFragment(BaseFragment f, Bundle bundle,int containerViewId) {
		ft = getSupportFragmentManager().beginTransaction();
		ft.add(containerViewId, f);
		f.setArguments(bundle);
		ft.commit();
	}

	/**
	 * 替换Fragment，并将Fragment置于后台栈中
	 * @param f Fragment对象
	 * @param bundle 传递给该Fragment的参数
	 * @param containerViewId Fragment的位置
	 */
	public void replaceFragmentAndAddToBackStack(BaseFragment f, Bundle bundle,int containerViewId) {
		ft = getSupportFragmentManager().beginTransaction();
		ft.replace(containerViewId, f);
		f.setArguments(bundle);
		ft.addToBackStack(null);
		ft.commit();
	}
	/**
	 * 替换Fragment 不将Fragment置于后台栈中
	 * @param f Fragment对象
	 * @param bundle 传递给该Fragment的参数
	 * @param containerViewId Fragment的位置
	 */
	public void replaceFragment(BaseFragment f, Bundle bundle,int containerViewId) {
		ft = getSupportFragmentManager().beginTransaction();
		ft.replace(containerViewId, f);
		f.setArguments(bundle);
		ft.commit();
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return super.onTouchEvent(event);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onClick(View v) {
	}

	@Override
	public void startActivity(Intent intent) {
		super.startActivity(intent);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

	@Override
	public void finish() {
		super.finish();
		super.overridePendingTransition(R.anim.anim_activity_entry,R.anim.anim_go_down);
	}

	@Override
	public void startActivityForResult(Intent intent, int requestCode) {
		// TODO Auto-generated method stub
		super.startActivityForResult(intent, requestCode);
		overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
	}
}