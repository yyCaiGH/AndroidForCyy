package com.geihoo.fragment.createsociety;

import java.io.ByteArrayOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geihoo.activity.CreateSocietyActivity;
import com.geihoo.base.BaseFragment;
import com.geihoo.groups.R;
import com.geihoo.view.CustomImageView;

/**
 * 设置族族
 * 
 * @author yy_cai
 * 
 *         2015年7月16日
 */
public class SetSocietyFragment extends BaseFragment {

	private CreateSocietyActivity parent;
	private CustomImageView civZzHeadImg;
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		parent = (CreateSocietyActivity) activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(
				R.layout.fragment_createsociety_set_society, container, false);
		initView(view);
		return view;
	}

	protected void initView(View view) {
		parent.setTopBar("族族设置", CreateSocietyActivity.SET_SOCIETY);
		civZzHeadImg = (CustomImageView)view.findViewById(R.id.civ_add_zz_tx);
		civZzHeadImg.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.civ_add_zz_tx) {// 选择头像
			Intent intent = new Intent(Intent.ACTION_PICK, null);
			intent.setType("image/*");
			intent.putExtra("crop", "true");
			intent.putExtra("aspectX", 1);
			intent.putExtra("aspectY", 1);
			intent.putExtra("outputX", 200);
			intent.putExtra("outputY", 200);
			intent.putExtra("scale", true);
			intent.putExtra("return-data", true);
			// intent.putExtra("outputFormat",
			// Bitmap.CompressFormat.JPEG.toString());
//			 intent.putExtra("noFaceDetection", false); // no face detection
			startActivityForResult(intent, 1);
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
			photo.compress(Bitmap.CompressFormat.JPEG, 75, stream);// (0-100)压缩文件
			// 此处可以把Bitmap保存到sd卡中，具体请看：http://www.cnblogs.com/linjiqin/archive/2011/12/28/2304940.html
			civZzHeadImg.setPic(photo); // 把图片显示在ImageView控件上
		}
	}
}
