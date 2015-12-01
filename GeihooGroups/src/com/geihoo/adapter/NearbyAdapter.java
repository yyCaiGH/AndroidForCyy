package com.geihoo.adapter;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.geihoo.groups.R;
import com.geihoo.utils.ToastUtil;
import com.geihoo.view.CustomImageView;

public class NearbyAdapter extends BaseAdapter{

	private List<HashMap<String, Object>> groups;
	private Context context;
	public NearbyAdapter(List<HashMap<String, Object>> groups,
			Context context) {
		this.groups=groups;
		this.context=context;
	}

	@Override
	public int getCount() {
		return groups.size();
	}

	@Override
	public Object getItem(int position) {
		return groups.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder vh=null;
		if(convertView==null){
			convertView = LayoutInflater.from(context).inflate(R.layout.item_nearby, null);
			vh = new ViewHolder();
//			vh.image=(CustomImageView)convertView.findViewById(R.id.civ_nearby_item_image);
//			vh.city=(TextView)convertView.findViewById(R.id.tv_nearby_item_city);
//			vh.describe=(TextView)convertView.findViewById(R.id.tv_nearby_item_desc);
//			vh.startAndNum=(TextView)convertView.findViewById(R.id.tv_nearby_item_state_num);
//			vh.btnJoin=(Button)convertView.findViewById(R.id.but_nearby_item_join);
//			vh.btnNoInterest=(Button)convertView.findViewById(R.id.but_nearby_item_no_interest);
			convertView.setTag(vh);
		}
		else{
			vh=(ViewHolder)convertView.getTag();
		}
		vh.image.setPic(postScale((Bitmap)groups.get(position).get("image")));
		vh.city.setText(groups.get(position).get("city").toString());
		vh.describe.setText(groups.get(position).get("describe").toString());
		vh.startAndNum.setText(groups.get(position).get("state_number").toString());
		vh.btnJoin.setOnClickListener(new MyOnClickListen(position));
		vh.btnNoInterest.setOnClickListener(new MyOnClickListen(position));
		return convertView;
	}
	private static class ViewHolder{
		CustomImageView image;
		TextView city;
		TextView describe;
		TextView startAndNum;
		Button btnJoin;
		Button btnNoInterest;
		
	}
	
	private Bitmap postScale(Bitmap bitmap) {
		int bitmapWidth = bitmap.getWidth();
		int bitmapHeight = bitmap.getHeight();
		int dimen = (int) context.getResources().getDimension(R.dimen.icon_size);//缩放图片
		float scaleWidth = ((float) dimen) / bitmapWidth;
		float scaleHeight = ((float) dimen) / bitmapHeight;
		Matrix matrix = new Matrix();
		matrix.postScale(scaleWidth, scaleHeight);
		Bitmap newbm = Bitmap.createBitmap(bitmap, 0, 0, bitmapWidth,
				bitmapHeight, matrix, true);

		return newbm;
	}

	private class MyOnClickListen implements OnClickListener{

		int position;
		public MyOnClickListen(int position){
			this.position = position;
		}
		@Override
		public void onClick(View v) {
			HashMap<String, Object> map = (HashMap<String, Object>)getItem(position);
//			if(v.getId()==R.id.but_nearby_item_join){
//				ToastUtil.showTextShort(context, map.get("city")+"参加");
//			}
//			else if(v.getId()==R.id.but_nearby_item_no_interest){
//				ToastUtil.showTextShort(context, map.get("city")+"不感兴趣");
//			}
		}
		
	}

}
