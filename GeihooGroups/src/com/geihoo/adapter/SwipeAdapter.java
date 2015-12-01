package com.geihoo.adapter;

import java.util.List;

import com.geihoo.bean.WXMessage;
import com.geihoo.groups.R;
import com.geihoo.utils.ImageUtil;
import com.geihoo.view.CustomImageView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class SwipeAdapter extends BaseAdapter {
	/**
	 * 上下文对象
	 */
	private Context mContext = null;
	private List<WXMessage> data;

	private int mRightWidth = 0;

	/**
	 * @param mainActivity
	 */
	public SwipeAdapter(Context ctx, List<WXMessage> data, int rightWidth) {
		mContext = ctx;
		this.data = data;
		mRightWidth = rightWidth;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		
		ViewHolder holder;
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.item_nearby, parent, false);
			holder = new ViewHolder();
			holder.item_left = (RelativeLayout) convertView
					.findViewById(R.id.item_left);
			holder.item_right = (LinearLayout) convertView
					.findViewById(R.id.item_right);

			holder.iv_icon = (CustomImageView) convertView.findViewById(R.id.iv_icon);
			holder.tv_title = (TextView) convertView
					.findViewById(R.id.tv_title);
			holder.tv_msg = (TextView) convertView.findViewById(R.id.tv_msg);
			holder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
			holder.push=(TextView) convertView.findViewById(R.id.push);
			
			//holder.push=(Button) convertView.findViewById(R.id.push);

			holder.item_right_txt = (TextView) convertView
					.findViewById(R.id.item_right_txt);
			
			convertView.setTag(holder);
		} else {// 有直接获得ViewHolder
			holder = (ViewHolder) convertView.getTag();
		}

		LinearLayout.LayoutParams lp1 = new LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		holder.item_left.setLayoutParams(lp1);
		LinearLayout.LayoutParams lp2 = new LayoutParams(mRightWidth,
				LayoutParams.MATCH_PARENT);
		holder.item_right.setLayoutParams(lp2);

		WXMessage msg = data.get(position);

		holder.tv_title.setText(msg.getTitle());
		holder.tv_msg.setText(msg.getMsg());
		holder.tv_time.setText(msg.getTime());

		holder.iv_icon.setPic(ImageUtil.readBitMap(mContext, msg.getIcon_id()));

		holder.item_right.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mListener != null) {
					mListener.onRightItemClick(v, position);
				}
			}
		});
		holder.push.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (push != null) {
					push.onClick(v);
				}
			}
		});
		return convertView;
	}

	static class ViewHolder {
		RelativeLayout item_left;
		LinearLayout item_right;

		TextView tv_title;
		TextView tv_msg;
		TextView tv_time,push;
		CustomImageView iv_icon;

		TextView item_right_txt;
	}

	/**
	 * 单击事件监听器
	 */
	private onRightItemClickListener mListener = null;
	private OnClickListener push=null;

	public void setOnRightItemClickListener(onRightItemClickListener listener) {
		mListener = listener;
	}

	public interface onRightItemClickListener {
		void onRightItemClick(View v, int position);
	}
	
	public void setIsShowRightItem(OnClickListener listener){
		push=listener;
	}
}
