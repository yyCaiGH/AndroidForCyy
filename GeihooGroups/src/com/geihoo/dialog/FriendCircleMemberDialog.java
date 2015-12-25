package com.geihoo.dialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.geihoo.adapter.ZuZuMemberAdapter;
import com.geihoo.base.BaseDialog;
import com.geihoo.base.BaseFragment;
import com.geihoo.groups.R;
import com.geihoo.test.Datas;
import com.geihoo.utils.ImageUtil;
/**
 * 朋友圈成员管理
 * @author cyy
 *
 */
public class FriendCircleMemberDialog extends BaseDialog{

	private ListView managerList;
	public FriendCircleMemberDialog(Context context) {
        super(context, R.style.Dialog);
        setContentView(R.layout.dialog_fc_members);
        initTopBarAndBack("成员管理");
        initView();
	}

	protected void initView() {
		managerList=(ListView) this.findViewById(R.id.lv_fc_members);
		List<HashMap<String, Object>> members = Datas.getFcMembers(getContext());
		managerList.setAdapter(new ZuZuMemberAdapter(members, getContext()));	//借用族族的适配器
		}

}
