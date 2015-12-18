package com.geihoo.fragment.createfc;

import java.io.ByteArrayOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import com.geihoo.activity.CreateFriendCircleActivity;
import com.geihoo.activity.CreateSocietyActivity;
import com.geihoo.base.BaseFragment;
import com.geihoo.bean.ZuZuBean;
import com.geihoo.groups.R;
import com.geihoo.utils.Constant;
import com.geihoo.utils.GetSysImage;
import com.geihoo.utils.ImageLoader;
import com.geihoo.utils.ImageUtil;
import com.geihoo.utils.ToastUtil;
import com.geihoo.view.CustomImageView;

/**
 * 设置族族
 * 
 * @author yy_cai
 * 
 *         2015年7月16日
 */
public class SetFriendCircleFragment extends BaseFragment {

	private static String tag = "SetFriendCircleFragment";
	private final static int FOR_HEAD_IMG = 0x100;
	private final static int FOR_BG_IMG = 0x101;
	private CreateFriendCircleActivity mActivity;
	private CustomImageView civZzHeadImg;
	private ImageView ivZzBgImg;
	private EditText etZzName;

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		mActivity = (CreateFriendCircleActivity) activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(
				R.layout.fragment_createfc_set, container, false);
		initView(view);
		return view;
	}

	protected void initView(View view) {
		mActivity.setTopBar("朋友圈设置", CreateFriendCircleActivity.SET_FC);
		civZzHeadImg = (CustomImageView) view.findViewById(R.id.civ_add_zz_tx);
		civZzHeadImg.setOnClickListener(this);
		ivZzBgImg = (ImageView) view.findViewById(R.id.iv_add_zz_bg);
		ivZzBgImg.setOnClickListener(this);
		etZzName = (EditText) view.findViewById(R.id.et_zz_name);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.civ_add_zz_tx) {// 选择头像
			GetSysImage.fromAlbumAndCrop(this, FOR_HEAD_IMG, 1, 1, 200, 200);
		} else if (v.getId() == R.id.iv_add_zz_bg) {
			GetSysImage.fromAlbumAndCrop(this, FOR_BG_IMG, 3, 2, 300, 200);
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.i("cyy-cyy", "requestCode=" + requestCode);
		if (data == null) {
			// TODO 如果之前以后有设置过显示之前设置的图片 否则显示默认的图片
			return;
		}
		Bundle extras = data.getExtras();
		if (extras != null) {

			Bitmap photo = extras.getParcelable("data");
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
//			photo.compress(Bitmap.CompressFormat.PNG, 100, stream);// (0-100)压缩文件
			// 此处可以把Bitmap保存到sd卡中，具体请看：http://www.cnblogs.com/linjiqin/archive/2011/12/28/2304940.html
			if (requestCode == FOR_HEAD_IMG) {
				mActivity.getNewZuZuBean().setHeadIcon(photo);// zuzu对象设置bitmap的话，由于过大不能用intent传参
				civZzHeadImg.setPic(photo); // 把图片显示在ImageView控件上
			} else if (requestCode == FOR_BG_IMG) {
				mActivity.getNewZuZuBean().setBgIcon(photo);
				ivZzBgImg.setImageBitmap(photo);
			}

		}
	}

	@Override
	public void onResume() {
		super.onResume();
		ZuZuBean zuzu = mActivity.getNewZuZuBean();
		if (zuzu != null) {
			ivZzBgImg.setImageBitmap(zuzu.getBgIcon());
			civZzHeadImg.setPic(zuzu.getHeadIcon());
			etZzName.setText(zuzu.getName());
		}
	}

	/**
	 * 保存族族信息 这里只保存了名字，其他信息分别在选择的时候已经保存
	 * 
	 * @return true保存成功 false 保存失败
	 */
	public boolean saveZuZuInfo() {
		String zzName = etZzName.getText().toString();
		if (TextUtils.isEmpty(zzName)) {
			ToastUtil.showTextLong(mActivity, "朋友圈名字不能为空！");
			return false;
		}
		mActivity.getNewZuZuBean().setName(zzName);
		return true;
	}
}
