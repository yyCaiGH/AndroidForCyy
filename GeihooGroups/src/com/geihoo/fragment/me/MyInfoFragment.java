package com.geihoo.fragment.me;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.geihoo.activity.MeActivity;
import com.geihoo.base.BaseDialog;
import com.geihoo.base.BaseFragment;
import com.geihoo.bean.ContactsBean;
import com.geihoo.groups.R;
import com.geihoo.view.CustomImageView;

/**
 * 我的资料
 * @author yy_cai
 *
 * 2015年9月1日
 */
public class MyInfoFragment extends BaseFragment{

	private final static String tag="MyInfoFragment";
	private MeActivity activity;
	private Bundle contactBundle;
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		this.activity = (MeActivity)activity;
		super.onAttach(activity);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_my_info, container,
				false);
		contactBundle = this.getArguments();
		initView(view);
		return view;
	}


	@Override
	public void onResume() {
		super.onResume();
		activity.setRightStyle("完成", 0);//有可能在另外的Fragment里重新对右边状态进行了设置
	}
	
	protected void initView(View view) {
		initTopView(view);
		RelativeLayout rl_me_home = (RelativeLayout)view.findViewById(R.id.rl_me_home);
		rl_me_home.setOnClickListener(this);
		RelativeLayout rl_me_head = (RelativeLayout)view.findViewById(R.id.rl_me_head);
		rl_me_head.setOnClickListener(this);
		RelativeLayout rl_me_nickname = (RelativeLayout)view.findViewById(R.id.rl_me_nickname);
		rl_me_nickname.setOnClickListener(this);
		RelativeLayout rl_me_sex = (RelativeLayout)view.findViewById(R.id.rl_me_sex);
		rl_me_sex.setOnClickListener(this);
		RelativeLayout rl_me_area = (RelativeLayout)view.findViewById(R.id.rl_me_area);
		rl_me_area.setOnClickListener(this);
		RelativeLayout rl_me_introduction = (RelativeLayout)view.findViewById(R.id.rl_me_introduction);
		rl_me_introduction.setOnClickListener(this);
		if(contactBundle!=null){
			ContactsBean contact = contactBundle.getParcelable("contact");
			if(contact!=null){
				CustomImageView headImg = (CustomImageView)view.findViewById(R.id.civ_contact_head);
				headImg.setPic(contact.getImage());
				TextView name = (TextView)view.findViewById(R.id.tv_nickname_value);
				name.setText(contact.getName());
			}
		}
	}

	private void initTopView(View view) {
		activity.setTitle(activity.getResources().getString(R.string.top_title_wdzl));
		activity.setRightStyle("完成", 0);
	}
	@Override
	public void onClick(View v) {
		Bundle bundle = new Bundle();
		if(v.getId()==R.id.rl_me_home){
			activity.replaceFragmentAndAddToBackStack(new MyHomeFragment(), contactBundle, R.id.fl_me);
		}
		else if(v.getId()==R.id.rl_me_head){
			bundle.putInt("type", UpdateMyInfoFragment.UPDATE_HEAD);
			activity.replaceFragmentAndAddToBackStack(new UpdateMyInfoFragment(), bundle, R.id.fl_me);
		}
		else if(v.getId()==R.id.rl_me_nickname){
			bundle.putInt("type", UpdateMyInfoFragment.UPDATE_NIKENAME);
			activity.replaceFragmentAndAddToBackStack(new UpdateMyInfoFragment(), bundle, R.id.fl_me);
		}
		else if(v.getId()==R.id.rl_me_sex){
			bundle.putInt("type", UpdateMyInfoFragment.UPDATE_SEX);
			activity.replaceFragmentAndAddToBackStack(new UpdateMyInfoFragment(), bundle, R.id.fl_me);
		}
		else if(v.getId()==R.id.rl_me_area){
			bundle.putInt("type", UpdateMyInfoFragment.UPDATE_AREA);
			activity.replaceFragmentAndAddToBackStack(new UpdateMyInfoFragment(), bundle, R.id.fl_me);
		}
		else if(v.getId()==R.id.rl_me_introduction){
			bundle.putInt("type", UpdateMyInfoFragment.UPDATE_ABOUT);
			activity.replaceFragmentAndAddToBackStack(new UpdateMyInfoFragment(), bundle, R.id.fl_me);
		}
	}

}
