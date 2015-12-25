package com.geihoo.test;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.geihoo.activity.SocietySettingsActivity;
import com.geihoo.base.BaseDialog;
import com.geihoo.base.BaseFragment;
import com.geihoo.groups.R;
import com.geihoo.utils.DialogUtil;
import com.geihoo.view.CustomImageView;
/**
 * 
 * 族族设置
 *
 * @author yy_cai
 *
 * 2015年11月25日
 */
public class FriendCircleSettingPhotoDialog extends BaseDialog {
	public FriendCircleSettingPhotoDialog(Context context,int type) {
        super(context, R.style.Dialog);
        setContentView(R.layout.fragment_society_set_photo);
        initView(type);
	}

	protected void initView(int type) {
		TextView tv = (TextView)this.findViewById(R.id.tv_edit_img);
		ImageView ivBgImg = (ImageView)this.findViewById(R.id.iv_zz_tx);
		CustomImageView civHeadImg = (CustomImageView)this.findViewById(R.id.civ_image);
		if(type==2){
			initTopBarAndBack("选择封面照片");
			tv.setText("更改封面照片");
		}
		else if(type==1){
			initTopBarAndBack("选择朋友圈头像");
			tv.setText("更改朋友圈头像");
			civHeadImg.setVisibility(View.VISIBLE);
			ivBgImg.setVisibility(View.GONE);
		}
	}

}
