package com.geihoo.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.geihoo.groups.R;
import com.geihoo.utils.ImageUtil;

public class SendImageAdapter extends BaseAdapter {

	private List<Integer> imgs;
	private Context context;
	public SendImageAdapter(List<Integer> imgs,
			Context context) {
		this.imgs=imgs;
		this.context=context;
	}

	@Override
	public int getCount() {
		return imgs.size();
	}

	@Override
	public Object getItem(int position) {
		return imgs.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder vh=null;
		if(convertView==null){
			convertView = LayoutInflater.from(context).inflate(R.layout.send_message_item, null);
			vh = new ViewHolder();
			vh.imageView=(ImageView)convertView.findViewById(R.id.dialog_iv_id);
			convertView.setTag(vh);
		}
		else{
			vh=(ViewHolder)convertView.getTag();
		}
		
//		vh.imageView.setImageResource(imgs.get(position));
		vh.imageView.setImageBitmap(ImageUtil.readBitMap(context, imgs.get(position)));
		return convertView;
	}
	private static class ViewHolder{
		ImageView imageView;
	}

}
