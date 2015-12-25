package com.geihoo.fragment.maintab;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.geihoo.activity.FunMarketActivity;
import com.geihoo.activity.MainTabActivity;
import com.geihoo.adapter.MyFunsAdapter;
import com.geihoo.base.BaseFragment;
import com.geihoo.bean.FunBean;
import com.geihoo.groups.R;
import com.geihoo.test.Datas;
import com.geihoo.utils.ImageUtil;

/**
 * 
 * 我的功能模块
 * 
 * @author yy_cai
 * 
 *         2015年12月12日
 */
public class MyFunctionFragment extends BaseFragment {

	private String tag = "MyFunctionFragment";
	private MainTabActivity mActivity;
	private GridView gvFuns;
	private List<FunBean> addedFun;
	// 获取系统apk变量
	private PackageManager manager;
	private List<ResolveInfo> myApps;
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mActivity = (MainTabActivity) activity;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addedFun = new ArrayList<FunBean>();// 已添加的功能初始化
		//添加本地apk
		manager = mActivity.getPackageManager();
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_LAUNCHER);
		myApps = manager.queryIntentActivities(intent, 0);
		selectApps();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i(tag, "onCreateView");
		View view = inflater.inflate(R.layout.fragment_main_tab_fun, container,
				false);
		initView(view);
		initData();
		return view;
	}

	private void selectApps() {
		/**
		 * jp.scn.android,scene 
		 * com.wytn.wowplus,哇加 
		 * com.miui.notes,便签
		 * com.tencent.mm,微信
		 * com.tencent.mobileqq,QQ
		 * com.ss.android.article.news,今日头条
		 * com.hipu.yidian,一点资讯
		 * com.sohu.newsclient,搜狐新闻
		 * com.tencent.qqmusic,QQ音乐
		 * com.immomo.momo,陌陌
		 * com.baidu.BaiduMap,百度地图
		 * com.taobao.taobao,手机淘宝
		 * com.moji.mjweather,墨迹天气
		 */
		List<String> localApks = new ArrayList<String>();
		localApks.add("jp.scn.android");
//		localApks.add("com.wytn.wowplus");
		localApks.add("com.miui.notes");
//		localApks.add("com.tencent.mm");
//		localApks.add("com.tencent.mobileqq");
		localApks.add("com.ss.android.article.news");
		localApks.add("com.hipu.yidian");
		localApks.add("com.sohu.newsclient");
//		localApks.add("com.tencent.qqmusic");
//		localApks.add("com.immomo.momo");
//		localApks.add("com.baidu.BaiduMap");
//		localApks.add("com.taobao.taobao");
		localApks.add("com.moji.mjweather");
		List<FunBean> list = Datas.getAllFuns(mActivity);
		if(list.size()>16){
			Log.i("cyy-cyy", "大于16个app，已经加载过了...");
			return;
		}
		for (int i = myApps.size() - 1; i >= 0; i--) {
			ResolveInfo res = myApps.get(i);
			String pkg = res.activityInfo.packageName; // 包名
//			Log.i("cyy-apk-cyy", pkg + "," + appName);
			if (localApks.contains(pkg)) {
				String appName = res.loadLabel(manager).toString();//APK名称
				Bitmap bitmap = ((BitmapDrawable) res.loadIcon(manager)).getBitmap();//APK图标
				String activityName = res.activityInfo.name; // 包括包名和activity名
				FunBean fun = new FunBean();
				fun.setImage(bitmap);
				fun.setName(appName);
				fun.setActivityName(activityName);
				fun.setPackageName(pkg);
				fun.setAdd(true);
				list.add(fun);
			}
		}
	}

	@Override
	protected void initView(View view) {
		initTopView(view);
		gvFuns = (GridView) view.findViewById(R.id.gv_all_fun);
		gvFuns.setOnItemClickListener(this);
	}

	private void initTopView(View view) {
		ImageView topHome = (ImageView) view.findViewById(R.id.iv_top_left);
		topHome.setOnClickListener(this);
		TextView title = (TextView) view.findViewById(R.id.tv_top_title);
		title.setText("生活");
		ImageView create = (ImageView) view.findViewById(R.id.iv_top_right);
		create.setVisibility(View.GONE);

	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.iv_top_left) {
			mActivity.dealSlidingMenu();
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		super.onItemClick(parent, view, position, id);
		FunBean fun = addedFun.get(position);
		if(!TextUtils.isEmpty(fun.getActivityName())){
			// 该应用的包名和主Activity
			String pkg = fun.getPackageName(); // 包名
			String cls = fun.getActivityName(); // 包括包名和activity名
			System.out.println(pkg + "," + cls);
			ComponentName componet = new ComponentName(pkg, cls);
			Intent i = new Intent();
			i.setComponent(componet);
			mActivity.startActivity(i);
			mActivity.overridePendingTransition(R.anim.anim_welcome_entry, R.anim.anim_welcome_out);
		}
		else if(fun.getName()==null){
			Intent i = new Intent(mActivity, FunMarketActivity.class);
			mActivity.startActivity(i);
		}
		else{
			Toast.makeText(mActivity, "功能开发中", 0).show();
		}
		
	}

	@Override
	public void onStart() {
		Log.i(tag, "onStart");
		super.onStart();
	}

	@Override
	public void onResume() {
		Log.i(tag, "onResume");
		super.onResume();
		List<FunBean> list = Datas.getAllFuns(mActivity);
		addedFun.clear();
		for (FunBean fun : list) {
			if (fun.isAdd()) {
				addedFun.add(fun);
			}
		}
		// 添加按钮
		FunBean fun = new FunBean();
		fun.setName(null);
		fun.setImage(ImageUtil.readBitMap(mActivity, R.drawable.my_tianjia));
		fun.setAdd(true);
		addedFun.add(fun);

		gvFuns.setAdapter(new MyFunsAdapter(addedFun, mActivity));
	}

	@Override
	public void onPause() {
		Log.i(tag, "onPause");
		super.onPause();
	}

	@Override
	public void onStop() {
		Log.i(tag, "onStop");
		super.onStop();
	}

	@Override
	public void onDestroyView() {
		Log.i(tag, "onDestroyView");
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		Log.i(tag, "onDestroy");
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		Log.i(tag, "onDetach");
		super.onDetach();
	}
}
