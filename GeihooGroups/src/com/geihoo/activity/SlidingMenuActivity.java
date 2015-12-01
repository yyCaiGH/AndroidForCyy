package com.geihoo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import com.geihoo.base.BaseActivity;
import com.geihoo.base.BaseFragment;
import com.geihoo.fragment.createsociety.AddMemberFragment;
import com.geihoo.fragment.createsociety.LookOverSocietyFragment;
import com.geihoo.fragment.createsociety.SelectSocietyTypeFragment;
import com.geihoo.fragment.createsociety.SetSocietyFragment;
import com.geihoo.fragment.me.SetFragment;
import com.geihoo.fragment.slidingmenu.NoticeFragment;
import com.geihoo.groups.R;
/**
 * 侧拉菜单功能集合
 * @author yy_cai
 *
 * 2015年8月1日
 */
public class SlidingMenuActivity extends BaseActivity{
	
	public final static String FRAGMENT_TAG = "FragmentTag";
	public final static int NOTICE_FRAGMENT = 0x100;
	public final static int SET_FRAGMENT = 0x101;
	private SetFragment setF;
	private NoticeFragment noticeF;
	/**
	 * Fragment事务
	 */
	private FragmentTransaction ft;
	
	
	/**
	 * 标志目前处于哪个Fragment
	 */
	private int tag;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_sliding_menu);
		init();
	}
	
	private void init() {
		setF = new SetFragment();
		noticeF = new NoticeFragment();
		
		int tag=this.getIntent().getIntExtra(FRAGMENT_TAG, SET_FRAGMENT);
		switch (tag) {
		case SET_FRAGMENT:
			initFragment(setF,null);
			break;
		case NOTICE_FRAGMENT:
			initFragment(noticeF, null);
		default:
			break;
		}
		
	}


	
	/**
	 * 第一次加载Fragment不要将事务加进后台栈,防止后退出现空白的现象
	 */
	private void initFragment(BaseFragment f,Bundle bundle) {
		ft=getSupportFragmentManager().beginTransaction();
		ft.add(R.id.fl_slidingmenu, f);
        f.setArguments(bundle);  
		ft.commit();
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
	}
}
