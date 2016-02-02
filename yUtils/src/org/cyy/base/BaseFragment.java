package org.cyy.base;

import org.cyy.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.TextView;

public class BaseFragment extends Fragment implements OnItemClickListener,OnClickListener,OnTouchListener,OnItemLongClickListener{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	/**
	 * 初始化标题栏
	 * @param view
	 * @param title
	 */
	protected void initTopBar(View view,String title){
		TextView tvTitle = (TextView)view.findViewById(R.id.tv_top_title);
		tvTitle.setText(title);
	}
	/**
	 * 初始化标题栏并处理view_common_top的back事件
	 */
	protected void initTvBackTopBar(View view,String title){
		TextView back = (TextView)view.findViewById(R.id.tv_top_left);
		back.setOnClickListener(this);
		initTopBar(view, title);
	}
	/**
	 * 初始化界面
	 * @param view
	 */
	protected void initView(View view){
		
	}
	/**
	 * 初始化数据
	 */
	protected void initData(){
		
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		
	}
	
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.tv_top_left){
			getActivity().onBackPressed();
		}
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view,
			int position, long id) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
