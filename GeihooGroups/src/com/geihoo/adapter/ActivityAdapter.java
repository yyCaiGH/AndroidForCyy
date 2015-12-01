package com.geihoo.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.geihoo.bean.ActivityBean;
import com.geihoo.groups.R;
import com.geihoo.utils.PingYinUtils;
import com.geihoo.view.CustomImageView;

public class ActivityAdapter extends BaseAdapter{

	private List<ActivityBean> mActivitys;
	private Context context;
	public ActivityAdapter(List<ActivityBean> mActivitys,Context context) {
		this.mActivitys=mActivitys;
		this.context=context;
	}

	@Override
	public int getCount() {
		return mActivitys.size();
	}

	@Override
	public Object getItem(int position) {
		return mActivitys.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ActivityBean bean = mActivitys.get(position);
		ViewHolder vh=null;
		if(convertView==null){
			convertView = LayoutInflater.from(context).inflate(R.layout.advance_listitem, null);
			vh = new ViewHolder();
			vh.image=(ImageView)convertView.findViewById(R.id.img);
			vh.name=(TextView)convertView.findViewById(R.id.name);
			vh.date=(TextView)convertView.findViewById(R.id.date);
			vh.place=(TextView)convertView.findViewById(R.id.place);
			vh.organizer=(TextView)convertView.findViewById(R.id.organizer);
			vh.num=(TextView)convertView.findViewById(R.id.tv_num);
			vh.publishDate=(TextView)convertView.findViewById(R.id.tv_publish_date);
			vh.showPublishDate=(LinearLayout)convertView.findViewById(R.id.ll_publish_date);
			convertView.setTag(vh);
		}
		else{
			vh=(ViewHolder)convertView.getTag();
		}
		String dt=bean.getDt();
		if(showDt(position, dt)){
			vh.showPublishDate.setVisibility(View.VISIBLE);
			vh.publishDate.setText(dt);
		}
		else{
			vh.showPublishDate.setVisibility(View.GONE);
		}
		vh.image.setImageBitmap(bean.getImage());
		vh.name.setText(bean.getTitle());
		vh.date.setText(bean.getDate());
		vh.place.setText(bean.getPlace());
		vh.organizer.setText(bean.getOrganizer());
		vh.num.setText(bean.getNum()+"人参加");
		return convertView;
	}
	private static class ViewHolder{
		ImageView image;
		TextView name;
		TextView date;
		TextView place;
		TextView organizer;
		TextView num;
		TextView publishDate;
		LinearLayout showPublishDate;
	}
	/**
	 * 是否显示月份归档标记
	 * @param position
	 * @param curDate
	 * @return
	 */
	private boolean showDt(int position,String curDate){
		String preDate=null;
		if(position==0){
			preDate="";
		}
		else{
			preDate=mActivitys.get(position-1).getDt();
		}
		if(!preDate.equals(curDate)){
			return true;
		}
		return false;
	}
}
