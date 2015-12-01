package com.geihoo.adapter;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.geihoo.groups.R;
import com.geihoo.utils.ImageUtil;

public class AlbumAddImageByAdapter extends BaseAdapter {

	private List<HashMap<String, Object>> members;
	private Context context;
	public AlbumAddImageByAdapter(List<HashMap<String, Object>> members,
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
			convertView = LayoutInflater.from(context).inflate(R.layout.simple2_grid_item, null);
			vh = new ViewHolder();
			vh.imageView=(ImageView)convertView.findViewById(R.id.iv_addimage_id);
			vh.delete = (ImageView) convertView.findViewById(R.id.iv_addimage_delete);
			vh.info = (EditText) convertView.findViewById(R.id.et_addimage_edit);
			convertView.setTag(vh);
		}
		else{
			vh=(ViewHolder)convertView.getTag();
		}
		vh.imageView.setImageResource((Integer)members.get(position).get("image"));
		final int index = position;
		vh.delete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				members.remove(index);
				AlbumAddImageByAdapter.this.notifyDataSetChanged();//更新UI，因为与UI不是同线程
			}
		});
		return convertView;
	}
	private static class ViewHolder{
		ImageView imageView,delete;
		EditText info;
	}

}
