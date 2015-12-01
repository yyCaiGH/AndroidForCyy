package com.geihoo.adapter;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.geihoo.groups.R;

public class CommentAdapter extends BaseAdapter {

	private List<HashMap<String, String>> comments;
	private Context context;

	public CommentAdapter(Context context, List<HashMap<String, String>> comments) {
		this.comments = comments;
		this.context = context;
	}

	@Override
	public int getCount() {
		return comments.size();
	}

	@Override
	public Object getItem(int position) {
		return comments.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder vh = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.item_comment, null);
			vh = new ViewHolder();
			vh.userNameView = (TextView)convertView.findViewById(R.id.user_name_view);
			vh.speechView = (TextView)convertView.findViewById(R.id.speech_view);
			convertView.setTag(vh);
		} else {
			vh = (ViewHolder) convertView.getTag();
		}
		vh.userNameView.setText(comments.get(position).get("userName").toString()+":");
		vh.speechView.setText(comments.get(position).get("speech").toString());
		return convertView;
	}

	private static class ViewHolder {
		TextView userNameView;
		TextView speechView;
	}
}
