package com.geihoo.dialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.geihoo.adapter.CommonAdapter;
import com.geihoo.adapter.ViewHolder;
import com.geihoo.base.BaseDialog;
import com.geihoo.bean.ContactsBean;
import com.geihoo.groups.R;
import com.geihoo.test.Datas;

/**
 * 活动详情
 * @author yy_cai
 *
 * 2015年9月6日
 */
public class ActivityDetailsDialog extends BaseDialog{

	private ListView lvMembers;
	private Context context;
	public final static int GUO_QI=0x100;//过期
	public final static int KE_BAOMING=0x101;//可报名
	public final static int KE_QUXIAO=0x102;//可取消报名
	private int activityStatu=GUO_QI;
	public ActivityDetailsDialog(Context context,int activityStatu) {
        super(context);
        setContentView(R.layout.dialog_activity_details);
        this.context=context;
        this.activityStatu=activityStatu;
        initView();
        initMembersListView();
	}
	
	protected void initView() {
		TextView tvTitle = (TextView)this.findViewById(R.id.tv_top_title);
		tvTitle.setText("爬山");
		TextView tvBack = (TextView)this.findViewById(R.id.tv_top_left);
		tvBack.setOnClickListener(this);
		TextView tvNext = (TextView)this.findViewById(R.id.tv_top_right);
		tvNext.setVisibility(View.GONE);
		TextView btnApply = (TextView)this.findViewById(R.id.tv_act_apply);
		switch (activityStatu) {
		case GUO_QI:
			btnApply.setVisibility(View.GONE);
			break;
		case KE_BAOMING:
			btnApply.setText("报名参加");
			break;
		case KE_QUXIAO:
			btnApply.setText("取消报名");
			break;

		default:
			break;
		}
		btnApply.setOnClickListener(this);
		
		
	}
	private void initMembersListView() {
		lvMembers = (ListView) this.findViewById(R.id.lv_act_members);
		
		View v = LayoutInflater.from(context).inflate(R.layout.view_activity_details, null);
		
		lvMembers.addHeaderView(v,null,false);
		
		List<ContactsBean> members = Datas.getContacts(context);
		lvMembers.setAdapter(new CommonAdapter<ContactsBean>(context,members,R.layout.item_members) {
			@Override
			public void convert(ViewHolder helper, ContactsBean item) {
				// TODO Auto-generated method stub
				helper.setMyImageBitmap(R.id.civ_image, item.getImage());
				helper.setText(R.id.tv_member_name, item.getName());
			}
		});
	}
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.tv_act_apply){
			switch (activityStatu) {
			case KE_BAOMING:
				new ActivityApplyDialog(context).show();
				break;
			case KE_QUXIAO:
				this.cancel();
				Toast.makeText(context, "已经取消报名该活动", 0).show();
				break;

			default:
				break;
			}
			
		}
		super.onClick(v);
	}
}
