package com.geihoo.fragment.createsociety;

import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.geihoo.activity.CreateSocietyActivity;
import com.geihoo.adapter.CommonAdapter;
import com.geihoo.adapter.ViewHolder;
import com.geihoo.base.BaseFragment;
import com.geihoo.groups.R;
import com.geihoo.test.Datas;
/**
 * 选择社团类型
 * @author yy_cai
 *
 * 2015年7月23日
 */
public class SelectSocietyTypeFragment extends BaseFragment{

	private CreateSocietyActivity parent;
	private GridView groupTypes;
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		parent=(CreateSocietyActivity)activity;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_select_society_type, container,false);
		initView(view);
		return view;
	}
	@SuppressWarnings("static-access")
	protected void initView(View view){
		parent.setTopBar("选择类型",parent.SELECT_TYPE);
		view.findViewById(R.id.civ_image).setOnClickListener(this);
		initGroupTypes(view);
	}
	private void initGroupTypes(View view) {
		groupTypes= (GridView)view.findViewById(R.id.gv_group_type);
		List<HashMap<String, Object>> groups = Datas.getZuzuTypes(parent);
		groupTypes.setAdapter(new CommonAdapter<HashMap<String, Object>>(parent,groups,R.layout.item_zuzu_type) {
			@Override
			public void convert(ViewHolder helper, HashMap<String, Object> item) {
				// TODO Auto-generated method stub
				helper.setMyImageBitmap(R.id.civ_image, (Bitmap)item.get("image"));
				helper.setText(R.id.tv_title, item.get("title").toString());
			}
		});
		groupTypes.setOnItemClickListener(this);
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		this.parent.replaceFragmentAndAddToBackStack(new SetSocietyFragment(), null,R.id.fl_create_society);
		this.parent.setRightButtonVisibility(View.VISIBLE);
	}
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.civ_image){
			this.parent.replaceFragmentAndAddToBackStack(new SetSocietyFragment(), null,R.id.fl_create_society);
			this.parent.setRightButtonVisibility(View.VISIBLE);
		}
	}
}
