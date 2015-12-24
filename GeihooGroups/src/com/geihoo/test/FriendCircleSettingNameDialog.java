package com.geihoo.test;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geihoo.activity.SocietySettingsActivity;
import com.geihoo.base.BaseDialog;
import com.geihoo.base.BaseFragment;
import com.geihoo.groups.R;
import com.geihoo.utils.DialogUtil;
/**
 * 
 * 族族设置
 *
 * @author yy_cai
 *
 * 2015年11月25日
 */
public class FriendCircleSettingNameDialog extends BaseDialog {
	public FriendCircleSettingNameDialog(Context context) {
        super(context, R.style.Dialog);
        setContentView(R.layout.dialog_fc_set_name);
        initTopBarAndBack("编辑名称");
	}
}
