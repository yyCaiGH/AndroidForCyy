package com.geihoo.adapter;

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

public class MessageDetailedAdapter extends BaseAdapter {

	private List<HashMap<String, Object>> messages;
	private Context context;
	public MessageDetailedAdapter(List<HashMap<String, Object>> notices,
			Context context) {
		this.messages=notices;
		this.context=context;
	}

	@Override
	public int getCount() {
		return messages.size();
	}

	@Override
	public Object getItem(int position) {
		return messages.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder vh=null;
		if(convertView==null){
			convertView = LayoutInflater.from(context).inflate(R.layout.item_message_detailed, null);
			vh = new ViewHolder();
			vh.civImage=(CustomImageView)convertView.findViewById(R.id.civ_image);
			vh.name=(TextView)convertView.findViewById(R.id.tv_mes_name);
			vh.type=(TextView)convertView.findViewById(R.id.tv_mes_type);
			convertView.setTag(vh);
		}
		else{
			vh=(ViewHolder)convertView.getTag();
		}
		vh.civImage.setPic(ImageUtil.postScale(context, (Bitmap)messages.get(position).get("image"), R.dimen.icon_small_size));
		vh.name.setText(messages.get(position).get("name").toString());
		vh.type.setText(messages.get(position).get("type").toString());
		return convertView;
	}
	private static class ViewHolder{
		CustomImageView civImage;
		TextView name;
		TextView type;
	}
	
}
