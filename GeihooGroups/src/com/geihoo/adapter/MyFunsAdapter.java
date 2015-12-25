package com.geihoo.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.geihoo.activity.CreateSocietyActivity;
import com.geihoo.activity.FunMarketActivity;
import com.geihoo.bean.FunBean;
import com.geihoo.dialog.FunMarketDialog;
import com.geihoo.groups.R;

public class MyFunsAdapter extends BaseAdapter {

	private List<FunBean> myFuns;
	private Activity context;
	public MyFunsAdapter(List<FunBean> myFuns,
			Activity context) {
		this.myFuns=myFuns;
		this.context=context;
	}

	@Override
	public int getCount() {
		return myFuns.size();
	}

	@Override
	public Object getItem(int position) {
		return myFuns.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder vh=null;
		FunBean  item = myFuns.get(position);
		
		if(convertView==null){
			convertView = LayoutInflater.from(context).inflate(R.layout.item_my_fun, parent,false);
			vh = new ViewHolder();
			vh.image=(ImageView)convertView.findViewById(R.id.iv_image);
			vh.title=(TextView)convertView.findViewById(R.id.tv_title);
			convertView.setTag(vh);
		}
		else{
			vh=(ViewHolder)convertView.getTag();
		}
		vh.image.setImageBitmap(item.getImage());
		if(item.getName()==null){
			vh.title.setVisibility(View.GONE);
		}
		else{
			vh.title.setText(item.getName().toString());
		}
		
		return convertView;
	}
	private static class ViewHolder{
		ImageView image;
		TextView title;
	}
	

}
