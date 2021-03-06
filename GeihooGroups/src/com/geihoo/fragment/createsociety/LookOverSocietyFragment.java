package com.geihoo.fragment.createsociety;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.geihoo.activity.CreateSocietyActivity;
import com.geihoo.activity.SocietyMainActivity;
import com.geihoo.adapter.CommonAdapter;
import com.geihoo.adapter.ViewHolder;
import com.geihoo.base.BaseFragment;
import com.geihoo.bean.ContactsBean;
import com.geihoo.bean.ZuZuBean;
import com.geihoo.groups.R;
import com.geihoo.test.DataDemo;
import com.geihoo.utils.Constant;
import com.geihoo.utils.ImageLoader;
import com.geihoo.utils.ToastUtil;
import com.geihoo.view.CustomImageView;
import com.geihoo.view.HorizontalListView;

/**
 * 查看社团
 * 
 * @author yy_cai
 * 
 *         2015年7月23日
 */
public class LookOverSocietyFragment extends BaseFragment {

	private CreateSocietyActivity mActivity;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mActivity = (CreateSocietyActivity) activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(
				R.layout.fragment_createsociety_lookover_society, container,
				false);
		initView(view);
		return view;
	}

	protected void initView(View view) {
		mActivity.setTopBar("族族概况", CreateSocietyActivity.LOOK_OVER_SOCIETY);
		mActivity.setRightButtonVisibility(View.GONE);
		// 初始化族族信息
		ZuZuBean zuzu = mActivity.getNewZuZuBean();

		LinearLayout llZuzuBg = (LinearLayout) view.findViewById(R.id.ll_zz_bg);
		llZuzuBg.setBackgroundDrawable(new BitmapDrawable(zuzu.getBgIcon()));
		CustomImageView civZuzuHead = (CustomImageView) view.findViewById(R.id.civ_zz_head);
		civZuzuHead.setPic(zuzu.getHeadIcon());

		TextView zzName = (TextView) view.findViewById(R.id.tv_zz_name);
		zzName.setText(zuzu.getName());
		TextView zzInfo = (TextView) view.findViewById(R.id.tv_zz_info);
		String info = (zuzu.getType() == Constant.ZZ_TYPE_PRIVATE ? "私密" : "公开")
				+ " | " + zuzu.getContacts().size() + "位成员";
		zzInfo.setText(info);

		HorizontalListView hlvMembers = (HorizontalListView) view
				.findViewById(R.id.hlv_members);
		List<ContactsBean> contacts = mActivity.getNewZuZuBean().getContacts();
		// 创建一个匿名适配器对象，对item进行赋值
		hlvMembers.setAdapter(new CommonAdapter<ContactsBean>(getActivity(),
				contacts, R.layout.item_simple_img) {

			@Override
			public void convert(ViewHolder helper, ContactsBean item) {
				helper.setMyImageBitmap(R.id.civ_image, item.getImage());
			}
		});
		Button createSociety = (Button) view
				.findViewById(R.id.btn_create_society);
		createSociety.setOnClickListener(this);
		Button cancel = (Button) view.findViewById(R.id.btn_cancel);
		cancel.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btn_create_society) {
			ZuZuBean zuzu = mActivity.getNewZuZuBean();
			zuzu.setContacts(null);//联系人的头像太占内存
			if(zuzu.getType()==Constant.ZZ_TYPE_PRIVATE){
				DataDemo.getPrivateZuzu(mActivity).add(zuzu);
			}
			else{
				DataDemo.getPublicZuzus(mActivity).add(zuzu);
			}
			ToastUtil.showTextShort(mActivity, "创建族族成功");
			Intent i = new Intent(mActivity, SocietyMainActivity.class);
			i.putExtra("zuzu", zuzu);
			mActivity.finish();
			startActivity(i);
			mActivity.overridePendingTransition(R.anim.anim_go_up,R.anim.anim_activity_out);
		} else if (v.getId() == R.id.btn_cancel) {
			ToastUtil.showTextShort(mActivity, "您已取消创建该族族");
			mActivity.finish();
		}
	}
}
