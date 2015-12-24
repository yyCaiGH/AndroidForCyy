package com.geihoo.fragment.me;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.geihoo.activity.MeActivity;
import com.geihoo.adapter.CommonAdapter;
import com.geihoo.adapter.MyHomeAdapter;
import com.geihoo.adapter.ViewHolder;
import com.geihoo.base.BaseFragment;
import com.geihoo.bean.ContactsBean;
import com.geihoo.bean.HomePageBean;
import com.geihoo.groups.R;
import com.geihoo.test.Datas;
import com.geihoo.utils.Constant;
import com.geihoo.utils.ImageUtil;
import com.geihoo.utils.ToastUtil;
import com.geihoo.view.CustomImageView;
import com.geihoo.view.HorizontalListView;
/**
 * 我的主页
 * @author yy_cai
 *
 * 2015年9月1日
 */
public class MyHomeFragment extends BaseFragment{

	private MeActivity activity;
	private ListView dynamicList;
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
		View view = inflater.inflate(R.layout.fragment_my_home, container,
				false);
		contactBundle = this.getArguments();
		initView(view);
		return view;
	}


	protected void initView(View view) {
		initTopView();
		boolean isFriend = true;
		List<Bitmap> imgs = new ArrayList<Bitmap>();//横向listview的照片展示数据
		dynamicList = (ListView)view.findViewById(R.id.lv_home_dyn);
		View v = LayoutInflater.from(activity).inflate(R.layout.view_my_home_head, null);
		if(contactBundle!=null){
			isFriend = contactBundle.getBoolean("friendly");
			ContactsBean contact = contactBundle.getParcelable("contact");
			if(contact!=null){
				CustomImageView headImg = (CustomImageView)v.findViewById(R.id.civ_contact_head);
				headImg.setPic(contact.getImage());
				imgs.add(contact.getImage());
				TextView nameSex = (TextView)v.findViewById(R.id.tv_contact_name_sex);
				int imgId = contact.getSex()==Constant.CONTACT_SEX_MAN?R.drawable.sex_boy:R.drawable.sex_girl;
				Log.i("cyy-cyy", "imgId="+imgId);
				nameSex.setText(contact.getName());
				nameSex.setCompoundDrawablesWithIntrinsicBounds(null, null, activity.getResources().getDrawable(imgId), null);
			}
		}
		if(imgs.size()==0){
			imgs.add(ImageUtil.readBitMap(activity, R.drawable.imgs_demo));
			imgs.add(ImageUtil.readBitMap(activity, R.drawable.imgs_demo2));
			imgs.add(ImageUtil.readBitMap(activity, R.drawable.imgs_demo));
			imgs.add(ImageUtil.readBitMap(activity, R.drawable.imgs_demo2));
			imgs.add(ImageUtil.readBitMap(activity, R.drawable.imgs_demo));
		}
			
		dynamicList.addHeaderView(v,null,false);
		List<HomePageBean> listDatas=new ArrayList<HomePageBean>();
		if(isFriend){
			listDatas = Datas.getHomePageContent(activity);
		}
		else{
			Button addZzFriend = (Button)view.findViewById(R.id.btn_add_zz_friend);
			addZzFriend.setOnClickListener(this);
			addZzFriend.setVisibility(View.VISIBLE);
		}
		dynamicList.setAdapter(new MyHomeAdapter(listDatas, activity));
		
		HorizontalListView hlvUserImgs = (HorizontalListView) v.findViewById(R.id.hlv_user_img);
		
		// 创建一个匿名适配器对象，对item进行赋值
		hlvUserImgs.setAdapter(new CommonAdapter<Bitmap>(getActivity(),imgs, R.layout.item_simple_img_for_userhome) {

			@Override
			public void convert(ViewHolder helper, Bitmap item) {
				helper.setMyImageBitmap(R.id.civ_image, item);
			}
		});
	}

	private void initTopView() {
		activity.setTitle(activity.getResources().getString(R.string.top_title_wdzy));
		activity.setRightStyle(null, 0);
	}
	
	@Override
	public void onClick(View v) {
		super.onClick(v);
		if(v.getId()==R.id.btn_add_zz_friend){
			ToastUtil.showTextShort(activity, "已经发送邀请！");
		}
	}
}
