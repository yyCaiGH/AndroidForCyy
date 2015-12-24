package com.geihoo.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.geihoo.base.BaseDialog;
import com.geihoo.groups.R;
import com.geihoo.test.FriendCircleSettingNameDialog;
import com.geihoo.test.FriendCircleSettingPhotoDialog;
import com.geihoo.utils.ToastUtil;
/**
 * 
 * 族族设置
 *
 * @author yy_cai
 *
 * 2015年11月25日
 */
public class FriendCircleSettingsDialog extends BaseDialog {
	public FriendCircleSettingsDialog(Context context) {
        super(context, R.style.Dialog);
        setContentView(R.layout.dialog_friend_circle_settings);
        initTopBarAndBack("朋友圈设置");
        initView();
	}

	protected void initView() {
		TextView editBackGroundPhoto = (TextView) this.findViewById(R.id.tv_settings_background_photo);
		editBackGroundPhoto.setOnClickListener(this);
		TextView editPhoto = (TextView) this.findViewById(R.id.tv_settings_photo);
		editPhoto.setOnClickListener(this);
		TextView editName = (TextView) this.findViewById(R.id.tv_settings_name);
		editName.setOnClickListener(this);
		this.findViewById(R.id.btn_delete_fc).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		if(v.getId()==R.id.tv_settings_background_photo){
			new FriendCircleSettingPhotoDialog(getContext(), 2).show();;
		}
		else if(v.getId()==R.id.tv_settings_photo){
			new FriendCircleSettingPhotoDialog(getContext(), 1).show();;
		}
		else if(v.getId()==R.id.tv_settings_name){
			new FriendCircleSettingNameDialog(getContext()).show();;
		}
		else if(v.getId()==R.id.btn_delete_fc){
			ToastUtil.showTextShort(getContext(), "删除该朋友圈并通知服务器！");
		}
	}
}
