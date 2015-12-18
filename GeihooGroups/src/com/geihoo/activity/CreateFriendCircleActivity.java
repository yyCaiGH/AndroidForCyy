package com.geihoo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.geihoo.base.BaseActivity;
import com.geihoo.base.BaseFragment;
import com.geihoo.bean.FriendCircleBean;
import com.geihoo.bean.ZuZuBean;
import com.geihoo.fragment.createfc.AddFriendsFragment;
import com.geihoo.fragment.createfc.LookOverFriendCircleFragment;
import com.geihoo.fragment.createfc.SetFriendCircleFragment;
import com.geihoo.fragment.createsociety.AddMemberFragment;
import com.geihoo.fragment.createsociety.LookOverSocietyFragment;
import com.geihoo.fragment.createsociety.SelectSocietyTypeFragment;
import com.geihoo.fragment.createsociety.SetSocietyFragment;
import com.geihoo.groups.R;
import com.geihoo.utils.Constant;
import com.geihoo.utils.ImageUtil;

/**
 * 创建朋友圈
 * 
 * @author yy_cai
 * 
 *         2015年7月22日
 */
public class CreateFriendCircleActivity extends BaseActivity {

	public final static int SET_FC = 101;
	public final static int ADD_FRIEND = 102;
	public final static int LOOK_OVER_FC = 103;

	private AddFriendsFragment addFriendF;
	private SetFriendCircleFragment setFriendCircleF;
	private LookOverFriendCircleFragment lookOverFriendCircleF;
	
	private FriendCircleBean newFcBean;//创建该朋友圈
	/**
	 * Fragment事务
	 */
	private FragmentTransaction ft;

	private TextView tvTitle;

	/**
	 * 标志目前处于哪个Fragment
	 */
	private int tag;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_create_society);
		initData();
		initView();
		
	}

	@Override
	protected void initView() {
		addFriendF = new AddFriendsFragment();
		setFriendCircleF = new SetFriendCircleFragment();
		lookOverFriendCircleF = new LookOverFriendCircleFragment();
		initTopBar();
		initFragment(setFriendCircleF, null,R.id.fl_create_society);
	}
	@Override
	protected void initData() {
		if(newFcBean==null){
			newFcBean=new FriendCircleBean();//创建该族族
			newFcBean.setBgIcon(ImageUtil.readBitMap(this, R.drawable.zz_def_bg));//设置默认值，没值不能序列化
			newFcBean.setHeadIcon(ImageUtil.readBitMap(this, R.drawable.zz_def_head));
		}
	}
	protected void initTopBar() {
		tvTitle = (TextView) this.findViewById(R.id.tv_top_title);
		TextView tvBack = (TextView) this.findViewById(R.id.tv_top_left);
		tvBack.setText("返回");
		tvBack.setOnClickListener(this);
		TextView tvNext = (TextView) this.findViewById(R.id.tv_top_right);
		tvNext.setText("继续");
		tvNext.setOnClickListener(this);

	}

	public void setTopBar(String title, int tag) {
		tvTitle.setText(title);
		this.tag = tag;
	}

	public void setRightButtonVisibility(int visibility) {
		this.findViewById(R.id.tv_top_right).setVisibility(visibility);
	}

	
	public FriendCircleBean getNewFcBean() {
		return newFcBean;
	}

	public BaseFragment getSetFriendCircleFragment(){
		return setFriendCircleF;
	}
	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.tv_top_left) {
			onBackPressed();
		} else if (v.getId() == R.id.tv_top_right) {
			switch (tag) {
			case SET_FC:
				if(setFriendCircleF.saveZuZuInfo()){
					replaceFragmentAndAddToBackStack(addFriendF, null,R.id.fl_create_society);
				}
				break;
			case ADD_FRIEND:
				addFriendF.saveContactsToZuZu();
				replaceFragmentAndAddToBackStack(lookOverFriendCircleF, null,R.id.fl_create_society);
				break;
			default:
				break;
			}
		}
	}

	@Override
	public void onBackPressed() {
		switch (tag) {
		case SET_FC:
			setRightButtonVisibility(View.GONE);
		case ADD_FRIEND:
			break;
		case LOOK_OVER_FC:
			setRightButtonVisibility(View.VISIBLE);
			break;
		default:
			break;
		}
		super.onBackPressed();
	}
}
