package com.geihoo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.geihoo.base.BaseActivity;
import com.geihoo.base.BaseFragment;
import com.geihoo.bean.ZuZuBean;
import com.geihoo.fragment.createsociety.AddMemberFragment;
import com.geihoo.fragment.createsociety.LookOverSocietyFragment;
import com.geihoo.fragment.createsociety.SelectSocietyTypeFragment;
import com.geihoo.fragment.createsociety.SetSocietyFragment;
import com.geihoo.groups.R;
import com.geihoo.utils.Constant;
import com.geihoo.utils.ImageUtil;

/**
 * 创建社团
 * 
 * @author yy_cai
 * 
 *         2015年7月22日
 */
public class CreateSocietyActivity extends BaseActivity {

	public final static int SELECT_TYPE = 100;
	public final static int SET_SOCIETY = 101;
	public final static int ADD_MEMBER = 102;
	public final static int LOOK_OVER_SOCIETY = 103;
	public final static int SET_SOCIETY_STATE = 104;

	private SelectSocietyTypeFragment selectSoietyTypeF;
	private AddMemberFragment addMemberF;
	private SetSocietyFragment setSocietyF;
	private LookOverSocietyFragment lookOverSocietyF;
	
	private ZuZuBean newZuZuBean;//创建该族族
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
		addMemberF = new AddMemberFragment();
		setSocietyF = new SetSocietyFragment();
		lookOverSocietyF = new LookOverSocietyFragment();
		selectSoietyTypeF = new SelectSocietyTypeFragment();
		initTopBar();
		setRightButtonVisibility(View.GONE);
		initFragment(selectSoietyTypeF, null,R.id.fl_create_society);
	}
	@Override
	protected void initData() {
		if(newZuZuBean==null){
			newZuZuBean=new ZuZuBean();//创建该族族
			newZuZuBean.setBgIcon(ImageUtil.readBitMap(this, R.drawable.zz_def_bg));//设置默认值，没值不能序列化
			newZuZuBean.setHeadIcon(ImageUtil.readBitMap(this, R.drawable.zz_def_head));
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

	
	public ZuZuBean getNewZuZuBean() {
		return newZuZuBean;
	}

	public BaseFragment getSetSocietyFragment(){
		return setSocietyF;
	}
	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.tv_top_left) {
			onBackPressed();
		} else if (v.getId() == R.id.tv_top_right) {
			switch (tag) {
			case SET_SOCIETY:
				if(setSocietyF.saveZuZuInfo()){
					replaceFragmentAndAddToBackStack(addMemberF, null,R.id.fl_create_society);
				}
				break;
			case ADD_MEMBER:
				addMemberF.saveContactsToZuZu();
				replaceFragmentAndAddToBackStack(lookOverSocietyF, null,R.id.fl_create_society);
				break;
			default:
				break;
			}
		}
	}

	@Override
	public void onBackPressed() {
		switch (tag) {
		case SET_SOCIETY:
			setRightButtonVisibility(View.GONE);
		case SELECT_TYPE:
		case ADD_MEMBER:
			break;
		case LOOK_OVER_SOCIETY:
		case SET_SOCIETY_STATE:
			setRightButtonVisibility(View.VISIBLE);
			break;
		default:
			break;
		}
		super.onBackPressed();
	}
}
