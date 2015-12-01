package com.geihoo.adapter;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.geihoo.groups.R;
import com.geihoo.utils.ImageUtil;
import com.geihoo.utils.ToastUtil;

public class AddImageByAdapter extends BaseAdapter {

	private List<HashMap<String, Object>> members;
	private Context context;
	public AddImageByAdapter(List<HashMap<String, Object>> members,
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
		if(position!=getCount()-1){//最后一个位置 固定为添加照片的位置
			if(convertView==null){
				convertView = LayoutInflater.from(context).inflate(R.layout.simple3_grid_item, null);
				vh = new ViewHolder();
				vh.imageView=(ImageView)convertView.findViewById(R.id.iv_addimage_id);
				vh.delete = (ImageView) convertView.findViewById(R.id.iv_addimage_delete);
				convertView.setTag(vh);
			}
			else{
				vh=(ViewHolder)convertView.getTag();
			}
		}else{
			convertView = LayoutInflater.from(context).inflate(R.layout.simple_grid_item, null);
			vh = new ViewHolder();
			vh.imageView=(ImageView)convertView.findViewById(R.id.image);
			vh.delete=null;
			convertView.setTag(vh);
		}
		final int index = position;
		vh.imageView.setImageResource((Integer)members.get(position).get("image"));
		if(position==getCount()-1){
			vh.imageView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					//添加照片 并跳转到原来的页面
					ToastUtil.showTextLong(context, "添加图片");
				}
			});
		}else{
			if(vh.delete!=null){
				vh.delete.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View arg0) {
						members.remove(index);
						AddImageByAdapter.this.notifyDataSetChanged();//更新UI，因为与UI不是同线程
					}
				});
			}
		}
		
		return convertView;
	}
	private static class ViewHolder{
		ImageView imageView,delete;
	}

}
