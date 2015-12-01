package com.geihoo.fragment.createsociety;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.geihoo.activity.CreateSocietyActivity;
import com.geihoo.activity.SocietyMainActivity;
import com.geihoo.base.BaseFragment;
import com.geihoo.groups.R;
import com.geihoo.utils.ToastUtil;
/**
 * 查看社团
 * @author yy_cai
 *
 * 2015年7月23日
 */
public class LookOverSocietyFragment extends BaseFragment{

	private CreateSocietyActivity parent;
//	private ListView lvMembers;
	private View view;
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		parent=(CreateSocietyActivity)activity;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_createsociety_lookover_society, container,false);
		init();
		initView();
		return view;
	}

	private void init(){
		parent.setTopBar("族族概况",parent.LOOK_OVER_SOCIETY);
		parent.setRightButtonVisibility(View.GONE);
	}

	private void initView() {
		Button createSociety=(Button)view.findViewById(R.id.btn_create_society);
		createSociety.setOnClickListener(this);
		Button cancel=(Button)view.findViewById(R.id.btn_cancel);
		cancel.setOnClickListener(this);
		
	}
	
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.btn_create_society){
			parent.finish();
			ToastUtil.showTextShort(parent, "创建族族成功");
			Intent i = new Intent(parent, SocietyMainActivity.class);
			startActivity(i);
			parent.overridePendingTransition(R.anim.anim_go_up,
					R.anim.anim_activity_out);
		}
		else if(v.getId()==R.id.btn_cancel){
			parent.finish();
			ToastUtil.showTextShort(parent, "您已取消创建该族族");
		}
	}
}
