package com.geihoo.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.geihoo.adapter.AddImageByAdapter;
import com.geihoo.adapter.AlbumAddImageByAdapter;
import com.geihoo.adapter.SendImageAdapter;
import com.geihoo.base.BaseActivity;
import com.geihoo.groups.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TableLayout.LayoutParams;
/**
 * 社团中发布照片
 * @author whd
 *
 */
public class SendPicActivity extends BaseActivity {
	private GridView list;
	private List<Integer> datalist = new ArrayList<Integer>();
	private TextView backView,titleView;
	private TextView sendView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_send_pic);
		initView();
	}

	protected void initView() {
		initTopBar();
		list = (GridView) findViewById(R.id.dialog_imgs_list_pic);
		AddImageByAdapter addImageByAdapter = new AddImageByAdapter(getimageList(),this);
		list.setAdapter(addImageByAdapter);
	}
	
	@Override
	protected void initTopBar() {
		backView = (TextView) findViewById(R.id.tv_top_left);
		backView.setOnClickListener(this);
		titleView = (TextView) findViewById(R.id.tv_top_title);
		titleView.setText("在 周末旅游 中");
		sendView = (TextView) findViewById(R.id.tv_top_right);
		sendView.setText("发布");
		sendView.setOnClickListener(this);
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
		  HashMap<String,Object> map5 = new HashMap<String,Object>();
		  map5.put("image", R.drawable.tx5);
		  imagelist.add(map5);
		  HashMap<String,Object> map6 = new HashMap<String,Object>();
		  map6.put("image", R.drawable.tx6);
		  imagelist.add(map6);
		  HashMap<String,Object> map7 = new HashMap<String,Object>();
		  map7.put("image", R.drawable.add_window);
		  imagelist.add(map7);
		  return imagelist;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==backView){
			//返回社团页面
			this.finish();
		}
		if(v==sendView){
			//1.保存照片
			
			//2.返回社团页面
			this.finish();
		}
	}


	
	
}
