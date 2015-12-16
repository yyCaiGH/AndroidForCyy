package com.geihoo.adapter;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.geihoo.bean.FunBean;
import com.geihoo.groups.R;
import com.geihoo.test.Datas;
import com.geihoo.view.CustomImageView;
/**
 * 
 * 功能市场
 *
 * @author yy_cai
 *
 * 2015年12月15日
 */
public class FunMarketAdapter extends BaseAdapter {

	private List<FunBean> marketFuns;//所有功能，包括未添加和已添加的
	private Context context;
	public FunMarketAdapter(List<FunBean> myFuns,
			Context context) {
		this.marketFuns=myFuns;
		this.context=context;
	}

	@Override
	public int getCount() {
		return marketFuns.size();
	}

	@Override
	public Object getItem(int position) {
		return marketFuns.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder vh=null;
		final int index = position;
		final FunBean item = marketFuns.get(position);
		if(convertView==null){
			convertView = LayoutInflater.from(context).inflate(R.layout.item_fun_market, null);
			vh = new ViewHolder();
			vh.image=(ImageView)convertView.findViewById(R.id.iv_image);
			vh.title=(TextView)convertView.findViewById(R.id.tv_title);
			vh.add=(Button)convertView.findViewById(R.id.btn_add);
			convertView.setTag(vh);
		}
		else{
			vh=(ViewHolder)convertView.getTag();
		}
		vh.image.setImageBitmap(item.getImage());
		vh.title.setText(item.getName());
		if(item.isAdd()){
			vh.add.setText("取消");
		}
		else{
			vh.add.setText("添加");
			
		}
		vh.add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Button btn = (Button)v;
				if(!item.isAdd()){
//					marketFuns.get(index).setAdd(false);
					btn.setText("取消");
					Datas.getAllFuns(context).get(index).setAdd(true);
//					FunMarketAdapter.this.notifyDataSetChanged();
				}
				else{
					btn.setText("添加");
					Datas.getAllFuns(context).get(index).setAdd(false);
				}
			}
		});
		return convertView;
	}
	private static class ViewHolder{
		ImageView image;
		TextView title;
		Button add;
	}
	

}
