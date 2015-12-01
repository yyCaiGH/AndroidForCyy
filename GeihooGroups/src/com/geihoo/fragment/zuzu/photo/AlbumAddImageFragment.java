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
import com.geihoo.adapter.AlbumAddImageByAdapter;
import com.geihoo.base.BaseFragment;
import com.geihoo.groups.R;

public class AlbumAddImageFragment extends BaseFragment implements OnClickListener{
	private View view;
	private TextView title,headLeft,headRight;
	private AlbumActivity parent;
	private GridView photoGrids;
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		parent=(AlbumActivity)activity;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_album_addimage, container,false);
		initView();
		return view;
	}

	private void initView() {
		// TODO Auto-generated method stub
		title  = (TextView) view.findViewById(R.id.tv_top_title);
		title.setText("在相册中");
		headLeft = (TextView) view.findViewById(R.id.tv_top_left);
		headLeft.setOnClickListener(this);
		headRight = (TextView) view.findViewById(R.id.tv_top_right);
		headRight.setText("发布");
		headRight.setOnClickListener(this);
		photoGrids = (GridView) view.findViewById(R.id.gv_photo_add_id);
		AlbumAddImageByAdapter albumAddImageByAdapter = new AlbumAddImageByAdapter(getimageList(),getActivity());
		photoGrids.setAdapter(albumAddImageByAdapter);
	}

	@Override
	public void onClick(View v) {
		if(v==headLeft){
			this.parent.onBackPressed();
		}else if(v==headRight){
			//发布完 返回上一个页面
			this.parent.onBackPressed();
		}
	}
	private List<HashMap<String,Object>> getimageList(){
		List<HashMap<String,Object>> imagelist = new ArrayList<HashMap<String,Object>>();
		 // 使用HashMap将图片添加到一个数组中，注意一定要是HashMap<String,Object>类型的，因为装到map中的图片要是资源ID，而不是图片本身
		  // 如果是用findViewById(R.drawable.image)这样把真正的图片取出来了，放到map中是无法正常显示的
		  HashMap<String,Object> map1 = new HashMap<String,Object>();
		  map1.put("image", R.drawable.tx1);
		  imagelist.add(map1);
		  HashMap<String,Object> map2 = new HashMap<String,Object>();
		  map2.put("image", R.drawable.tx2);
		  imagelist.add(map2);
		  HashMap<String,Object> map3 = new HashMap<String,Object>();
		  map3.put("image", R.drawable.tx3);
		  imagelist.add(map3);
		  HashMap<String,Object> map4 = new HashMap<String,Object>();
		  map4.put("image", R.drawable.tx4);
		  imagelist.add(map4);
//		  HashMap<String,Object> map5 = new HashMap<String,Object>();
//		  map5.put("image", R.drawable.tx5);
//		  imagelist.add(map5);
//		  HashMap<String,Object> map6 = new HashMap<String,Object>();
//		  map6.put("image", R.drawable.tx6);
//		  imagelist.add(map6);
//		  HashMap<String,Object> map7 = new HashMap<String,Object>();
//		  map7.put("image", R.drawable.tx7);
//		  imagelist.add(map7);
		  return imagelist;
	}
}
