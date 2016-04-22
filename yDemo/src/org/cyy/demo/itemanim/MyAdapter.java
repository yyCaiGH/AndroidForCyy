package org.cyy.demo.itemanim;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cyy.demo.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{

	private List<String> mActivitys;
	private Context context;
	private Map<Integer, Boolean> isFrist; 
	public MyAdapter(List<String> mActivitys,Context context) {
		this.mActivitys=mActivitys;
		this.context=context;
		isFrist = new HashMap<Integer,Boolean>();
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
	public int getViewTypeCount() {
		return 2;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder vh=null;
		if(convertView==null){
			convertView = LayoutInflater.from(context).inflate(R.layout.my_listitem, null);
			vh = new ViewHolder();
			vh.name=(TextView)convertView.findViewById(R.id.textView1);
			convertView.setTag(vh);
		}
		else{
			vh=(ViewHolder)convertView.getTag();
		}
		vh.name.setText(mActivitys.get(position));
		if (isFrist.get(position) == null || isFrist.get(position)) {
			isFrist.put(position, false);    
			if(position%4!=0){
				convertView.setAnimation(AnimationUtils.loadAnimation(context, R.anim.bottom_item_in));
			}
		} 
		
		return convertView;
	}
	private static class ViewHolder{
		TextView name;
	}
}
