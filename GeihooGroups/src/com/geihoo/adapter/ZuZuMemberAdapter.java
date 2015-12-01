package com.geihoo.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.geihoo.groups.R;
import com.geihoo.utils.DialogUtil;
import com.geihoo.view.CustomImageView;

public class ZuZuMemberAdapter extends BaseAdapter {

	private List<HashMap<String, Object>> members;
	private Context context;
	public ZuZuMemberAdapter(List<HashMap<String, Object>> members,
			Context context) {
		this.members=members;
		this.context=context;
	}

	@Override
	public int getCount() {
		return members.size();
	}

	@Override
	public Object getItem(int position) {
		return members.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder vh=null;
		if(convertView==null){
			convertView = LayoutInflater.from(context).inflate(R.layout.member_listitem, null);
			vh = new ViewHolder();
			vh.civImage=(CustomImageView)convertView.findViewById(R.id.img);
			vh.memberName=(TextView)convertView.findViewById(R.id.tv_member);
			vh.tvTab = (TextView)convertView.findViewById(R.id.tv_tab);
			vh.ivMoreOpe = (ImageView)convertView.findViewById(R.id.iv_more_ope);
			convertView.setTag(vh);
		}
		else{
			vh=(ViewHolder)convertView.getTag();
		}
		String memberName = members.get(position).get("member_name").toString();
		vh.civImage.setPic((Bitmap)members.get(position).get("image"));
		vh.memberName.setText(memberName);
		int tab = Integer.parseInt(members.get(position).get("menmber_tab").toString());
		
		final ArrayList<String> items = new ArrayList<String>();//以族长的身份进来
		if(tab==0){
			vh.tvTab.setText("");//如果不设的话，有可能因为设过其他值而保留着
			items.add("设为管理员");
			items.add("删除成员");
			items.add("禁言");
		}
		else if(tab==1){
			vh.tvTab.setText("族主");
			items.add("交接族主");
		}
		else if(tab==2){
			vh.tvTab.setText("管理员");
			items.add("删除管理员");
			items.add("删除成员");
			items.add("禁言");
		}
		else if(tab==3){
			vh.tvTab.setText("");
			items.add("设为管理员");
			items.add("删除成员");
			items.add("取消禁言");
		}
		else if(tab==4){
			vh.tvTab.setText("管理员");
			items.add("删除管理员");
			items.add("删除成员");
			items.add("取消禁言");
		}
		items.add("查看个人主页");
		items.add("发消息");
		
		vh.ivMoreOpe.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				DialogUtil.createSelectDialog(context,items);
			}
		});
		return convertView;
	}
	private static class ViewHolder{
		CustomImageView civImage;
		TextView memberName;
		TextView tvTab;
		ImageView ivMoreOpe;
	}

}
