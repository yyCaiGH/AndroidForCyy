package com.geihoo.adapter;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.geihoo.groups.R;
import com.geihoo.utils.ImageUtil;

public class DocumentByTimeAdapter extends BaseAdapter {

	private List<HashMap<String, Object>> members;
	private Context context;
	public DocumentByTimeAdapter(List<HashMap<String, Object>> members,
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
			convertView = LayoutInflater.from(context).inflate(R.layout.item_documents_list, null);
			vh = new ViewHolder();
			vh.imageView=(ImageView)convertView.findViewById(R.id.iv_document_id);
			vh.name = (TextView) convertView.findViewById(R.id.tv_document_name);
			vh.detailinfo = (TextView) convertView.findViewById(R.id.tv_doucument_detail_id);
			convertView.setTag(vh);
		}
		else{
			vh=(ViewHolder)convertView.getTag();
		}
		
//		vh.imageView.setImageResource(imgs.get(position));
		//vh.imageView.setImageBitmap(ImageUtil.readBitMap(context, members.get(position)));
		vh.imageView.setBackgroundResource((Integer)members.get(position).get("image"));
		vh.name.setText(members.get(position).get("name").toString());
		vh.detailinfo.setText(members.get(position).get("detailinfo").toString());
		return convertView;
	}
	private static class ViewHolder{
		ImageView imageView;
		TextView name;
		TextView detailinfo;
	}

}
