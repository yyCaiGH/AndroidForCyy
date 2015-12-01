package com.geihoo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.geihoo.base.BaseActivity;
import com.geihoo.base.BaseFragment;
import com.geihoo.fragment.createsociety.AddMemberFragment;
import com.geihoo.fragment.createsociety.LookOverSocietyFragment;
import com.geihoo.fragment.createsociety.SelectSocietyTypeFragment;
import com.geihoo.fragment.createsociety.SetSocietyFragment;
import com.geihoo.groups.R;

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

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.tv_top_left) {
			onBackPressed();
		} else if (v.getId() == R.id.tv_top_right) {
			switch (tag) {
			case SET_SOCIETY:
				replaceFragmentAndAddToBackStack(addMemberF, null,R.id.fl_create_society);
				break;
			case ADD_MEMBER:
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
