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
/**
 * 我的主页动态
 * @author yy_cai
 *
 * 2015年8月31日
 */
public class MyHomeAdapter extends BaseAdapter {

	private List<HashMap<String, Object>> dynamicLists;
	private Context context;
	public MyHomeAdapter(List<HashMap<String, Object>> dynamicLists,
			Context context) {
		this.dynamicLists=dynamicLists;
		this.context=context;
	}

	@Override
	public int getCount() {
		return dynamicLists.size();
	}

	@Override
	public Object getItem(int position) {
		return dynamicLists.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder vh=null;
		if(convertView==null){
			convertView = LayoutInflater.from(context).inflate(R.layout.item_my_home, null);
			vh = new ViewHolder();
			vh.ivImage=(ImageView)convertView.findViewById(R.id.iv_image);
			vh.time=(TextView)convertView.findViewById(R.id.tv_time);
			vh.content=(TextView)convertView.findViewById(R.id.tv_content);
			vh.imageNum=(TextView)convertView.findViewById(R.id.tv_num);
			convertView.setTag(vh);
		}
		else{
			vh=(ViewHolder)convertView.getTag();
		}
		Bitmap bitmap=ImageUtil.postScale(context, (Bitmap)dynamicLists.get(position).get("image"), R.dimen.icon_size);
		vh.ivImage.setImageBitmap(bitmap);
		vh.time.setText(dynamicLists.get(position).get("time").toString());
		vh.content.setText(dynamicLists.get(position).get("content").toString());
		vh.imageNum.setText(dynamicLists.get(position).get("imageNum").toString());
		return convertView;
	}
	private static class ViewHolder{
		ImageView ivImage;
		TextView time;
		TextView imageNum;
		TextView content;
	}

}
