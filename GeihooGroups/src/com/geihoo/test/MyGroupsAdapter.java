package com.geihoo.test;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.geihoo.groups.R;
import com.geihoo.utils.ImageUtil;
import com.geihoo.view.CustomImageView;
/**
 * 
 * 朋友圈的适配器
 *
 * @author yy_cai
 *
 * 2015年11月27日
 */
public class MyGroupsAdapter extends BaseAdapter {

	private List<HashMap<String, Object>> groups;
	private Context context;
	public MyGroupsAdapter(List<HashMap<String, Object>> groups,
			Context context) {
		this.groups=groups;
		this.context=context;
	}

	@Override
	public int getCount() {
		return groups.size();
	}

	@Override
	public Object getItem(int position) {
		return groups.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder vh=null;
		if(convertView==null){
			convertView = LayoutInflater.from(context).inflate(R.layout.item_groups2, null);
			vh = new ViewHolder();
			vh.civImage=(CustomImageView)convertView.findViewById(R.id.civ_image);
			vh.title=(TextView)convertView.findViewById(R.id.tv_title);
			convertView.setTag(vh);
		}
		else{
			vh=(ViewHolder)convertView.getTag();
		}
		Bitmap bitmap=ImageUtil.postScale(context, (Bitmap)groups.get(position).get("image"), R.dimen.icon_medium_size);
		vh.civImage.setPic(bitmap);
		String title = groups.get(position).get("title").toString();
		if(title.length()>13){
			title = title.substring(0, 7)+"\n"+title.substring(7,13)+"...";
		}
		else if(title.length()>7){
			title = title.substring(0, 7)+"\n"+title.substring(7);
		}
		
		vh.title.setText(title);
		return convertView;
	}
	private static class ViewHolder{
		CustomImageView civImage;
		TextView title;
	}

}
