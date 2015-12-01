package com.geihoo.fragment.zuzu.file;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.geihoo.activity.SocietyDocumentActivity;
import com.geihoo.adapter.DocumentBaseExpandableListAdapter;
import com.geihoo.adapter.DocumentByTimeAdapter;
import com.geihoo.base.BaseFragment;
import com.geihoo.groups.R;

public class SocietyDocumentTypeFragment extends BaseFragment {

	private SocietyDocumentActivity parent;
	private View view;
	private ExpandableListView mainlistview = null;
	private List<String> parentList = null;
	private Map<String, List<HashMap<String, Object>>> map = null;
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		parent=(SocietyDocumentActivity)activity;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_society_document_type, container,false);
		//初始化patentList
		getParentList();
		getMap(parentList);
		initView();
		return view;
	}
	private void initView() {
		mainlistview = (ExpandableListView) view.findViewById(R.id.expandableListView_type_id);
		mainlistview.setAdapter(new DocumentBaseExpandableListAdapter(parentList, map, parent));
		mainlistview.expandGroup(0);
	}
	/**
	 * 给parentList赋值
	 */
	private void getParentList(){
		parentList = new ArrayList<String>();
		parentList.add("文档");
		parentList.add("图片");
		parentList.add("视频");
		parentList.add("音频");
	}
	/**
	 * 给map赋值
	 */
	private void getMap(List<String> list){
		map = new HashMap<String, List<HashMap<String,Object>>>();
		for(int i=0;i<list.size();i++){
			map.put(list.get(i), getimageList(i+1));
		}
				
	}
	private List<HashMap<String, Object>> getimageList(int i){
		List<HashMap<String, Object>> imagelist = new ArrayList<HashMap<String,Object>>();
		 // 使用HashMap将图片添加到一个数组中，注意一定要是HashMap<String,Object>类型的，因为装到map中的图片要是资源ID，而不是图片本身
		  // 如果是用findViewById(R.drawable.image)这样把真正的图片取出来了，放到map中是无法正常显示的
		  HashMap<String,Object> map1 = new HashMap<String,Object>();
		  map1.put("image", R.drawable.tx1);
		  map1.put("name", "诚信专业代理注册记账纳税欢迎咨询.txt");
		  map1.put("detailinfo", "2.04MB  陈翔  2015-8-31");
		  imagelist.add(map1);
		  if(i==imagelist.size()){
			  return imagelist;
		  }
		  HashMap<String,Object> map2 = new HashMap<String,Object>();
		  map2.put("image", R.drawable.tx2);
		  map2.put("name", "诚信专业刷单代理.txt");
		  map2.put("detailinfo", "1.04KB  汪宏达  2015-9-2");
		  imagelist.add(map2);
		  if(i==imagelist.size()){
			  return imagelist;
		  }
		  HashMap<String,Object> map3 = new HashMap<String,Object>();
		  map3.put("image", R.drawable.tx3);
		  map3.put("name", "中国古典文学集地址链接.txt");
		  map3.put("detailinfo", "1.04MB  小饶  2015-9-3");
		  imagelist.add(map3);
		  if(i==imagelist.size()){
			  return imagelist;
		  }
		  HashMap<String,Object> map4 = new HashMap<String,Object>();
		  map4.put("image", R.drawable.tx4);
		  map4.put("name", "福建哥汉族族社交软件使用手册.txt");
		  map4.put("detailinfo", "5.55MB  余总  2015-9-4");
		  imagelist.add(map4);
		  if(i==imagelist.size()){
			  return imagelist;
		  }
		  HashMap<String,Object> map5 = new HashMap<String,Object>();
		  map5.put("image", R.drawable.tx5);
		  map5.put("name", "福建哥汉科技有限公司招聘简章.word");
		  map5.put("detailinfo", "500KB  陈子正  2015-9-5");
		  imagelist.add(map5);
		  if(i==imagelist.size()){
			  return imagelist;
		  }
		  HashMap<String,Object> map6 = new HashMap<String,Object>();
		  map6.put("image", R.drawable.tx6);
		  map6.put("name", "福州哥汉企业文化交流案例.word");
		  map6.put("detailinfo", "2.04MB  黄进生  2015-9-6");
		  imagelist.add(map6);
		  if(i==imagelist.size()){
			  return imagelist;
		  }
		  HashMap<String,Object> map7 = new HashMap<String,Object>();
		  map7.put("image", R.drawable.tx7);
		  map7.put("name", "中国最好玩的网游排行.txt");
		  map7.put("detailinfo", "1.04MB  什么鬼  2015-9-31");
		  imagelist.add(map7);
		  
		  return imagelist;
	}
}
