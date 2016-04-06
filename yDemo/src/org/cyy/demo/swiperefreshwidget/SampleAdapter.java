package org.cyy.demo.swiperefreshwidget;

import java.util.ArrayList;
import java.util.List;

import org.cyy.demo.R;
import org.cyy.view.RotateImageView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
public class SampleAdapter extends RecyclerView.Adapter<ViewHolder> {
	private List<Integer> list;
	private Context ctx;
	private final static int FULL_SCREEN_DATA_COUNT=11;//几条数据占满屏幕
	private static final int TYPE_ITEM = 0;
	private static final int TYPE_FOOTER = 1;//最后一个item
	private static final int TYPE_NULL = -1;
	public List<Integer> getList() {
		return list;
	}

	public SampleAdapter(Context ctx) {
		list = new ArrayList<Integer>();
		this.ctx = ctx;
	}

	// RecyclerView的count设置为数据总条数+ 1（footerView）
	@Override
	public int getItemCount() {
		return list.size() + 1;
	}

	@Override
	public int getItemViewType(int position) {
		if(getItemCount()<=FULL_SCREEN_DATA_COUNT&&position + 1 == getItemCount()){//当屏幕没有占满的时候，最后一个item用空白view代替footerView
			return TYPE_NULL;
		}
		else if (getItemCount()>FULL_SCREEN_DATA_COUNT&&position + 1 == getItemCount()) {// 最后一个item设置为footerView
			return TYPE_FOOTER;
		} 
		else {
			return TYPE_ITEM;
		}
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, final int position) {
		Log.i("tag", "onBindViewHolder----------------");
		if (holder instanceof ItemViewHolder) {
			((ItemViewHolder) holder).textView.setText(String.valueOf(list
					.get(position)));
		}
		if(holder instanceof FooterViewHolder){
			FooterViewHolder h = (FooterViewHolder)holder;
			if(h.riv.getVisibility()==View.VISIBLE){
				h.riv.startRotate();
			}
		}
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		Log.i("tag", "onCreateViewHolder----------------");
		if (viewType == TYPE_ITEM) {
			View view = LayoutInflater.from(parent.getContext()).inflate(
					R.layout.list_item_text, null);
			view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.WRAP_CONTENT));
			return new ItemViewHolder(view);
		}
		// type == TYPE_FOOTER 返回footerView
		else if (viewType == TYPE_FOOTER) {
			View view = LayoutInflater.from(parent.getContext()).inflate(
					R.layout.footerview, null);
			view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.WRAP_CONTENT));
			return new FooterViewHolder(view);
		}
		else if(viewType == TYPE_NULL){
			return new NullViewHolder(new TextView(ctx));
		}
		return null;
	}

	class FooterViewHolder extends ViewHolder {
		RotateImageView riv;
		public FooterViewHolder(View view) {
			super(view);
			riv = (RotateImageView)view.findViewById(R.id.riv_footer_load);
		}

	}

	class ItemViewHolder extends ViewHolder {
		TextView textView;

		public ItemViewHolder(View view) {
			super(view);
			textView = (TextView) view.findViewById(R.id.text);
		}
	}
	class NullViewHolder extends ViewHolder {
		public NullViewHolder(View view) {
			super(view);
		}

	}
}