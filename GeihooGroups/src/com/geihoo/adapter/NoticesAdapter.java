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
import com.geihoo.view.CustomImageView;

public class NoticesAdapter extends BaseAdapter {

	private List<HashMap<String, Object>> notices;
	private Context context;
	public NoticesAdapter(List<HashMap<String, Object>> notices,
			Context context) {
		this.notices=notices;
		this.context=context;
	}

	@Override
	public int getCount() {
		return notices.size();
	}

	@Override
	public Object getItem(int position) {
		return notices.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder vh=null;
		if(convertView==null){
			convertView = LayoutInflater.from(context).inflate(R.layout.item_notice, null);
			vh = new ViewHolder();
			vh.civImage=(CustomImageView)convertView.findViewById(R.id.civ_image);
			vh.noticeDesc=(TextView)convertView.findViewById(R.id.tv_notice_desc);
			vh.noticeTime=(TextView)convertView.findViewById(R.id.tv_notice_time);
			convertView.setTag(vh);
		}
		else{
			vh=(ViewHolder)convertView.getTag();
		}
		vh.civImage.setPic(postScale((Bitmap)notices.get(position).get("image")));
		vh.noticeDesc.setText(notices.get(position).get("notice_desc").toString());
		vh.noticeTime.setText(notices.get(position).get("notice_time").toString());
		return convertView;
	}
	private static class ViewHolder{
		CustomImageView civImage;
		TextView noticeDesc;
		TextView noticeTime;
	}
	
	private Bitmap postScale(Bitmap bitmap) {
		int bitmapWidth = bitmap.getWidth();
		int bitmapHeight = bitmap.getHeight();
		int dimen = (int) context.getResources().getDimension(R.dimen.icon_small_size);//缩放图片
		float scaleWidth = ((float) dimen) / bitmapWidth;
		float scaleHeight = ((float) dimen) / bitmapHeight;
		Matrix matrix = new Matrix();
		matrix.postScale(scaleWidth, scaleHeight);
		Bitmap newbm = Bitmap.createBitmap(bitmap, 0, 0, bitmapWidth,
				bitmapHeight, matrix, true);

		return newbm;
	}

}
