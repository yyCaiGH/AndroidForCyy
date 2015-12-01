package com.geihoo.fragment.zuzu.photo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.geihoo.activity.AlbumActivity;
import com.geihoo.base.BaseFragment;
import com.geihoo.groups.R;
import com.geihoo.test.Datas;
/**
 * 查看相册Fragment
 *
 * @author yy_cai
 *
 * 2015年11月26日
 */
public class AlbumFragment extends BaseFragment{
	private GridView photoGrids;
	private TextView addimage;
	private AlbumActivity parent;
	private List<HashMap<String,Object>> imagelist;
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		parent=(AlbumActivity)activity;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_album_info, container,false);
		initTvBackTopBar(view, "相册");
		initView(view);
		return view;
	}

	protected void initView(View view) {
		addimage = (TextView) view.findViewById(R.id.album_addimage_id);
		addimage.setOnClickListener(this);
		photoGrids = (GridView) view.findViewById(R.id.photo_gridview_id);
		imagelist= Datas.getPhotos(parent);
		SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), imagelist, R.layout.simple_grid_item, new String[] {"image"}, new int[]{R.id.image});
		photoGrids.setAdapter(simpleAdapter);
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		if(v==addimage){
			parent.replaceFragmentAndAddToBackStack(new AlbumAddImageFragment(), null, R.id.fragment_album_activity);
		}
		
	}
	
}
