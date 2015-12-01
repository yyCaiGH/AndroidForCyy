package com.geihoo.fragment.maintab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.geihoo.activity.CreateSocietyActivity;
import com.geihoo.activity.MainTabActivity;
import com.geihoo.adapter.GroupsAdapter;
import com.geihoo.adapter.NearbyAdapter;
import com.geihoo.adapter.SwipeAdapter;
import com.geihoo.base.BaseFragment;
import com.geihoo.bean.WXMessage;
import com.geihoo.dialog.SearchSocietyDialog;
import com.geihoo.groups.R;
import com.geihoo.utils.ImageUtil;
import com.geihoo.view.SwipeListView;
/**
 * 附近
 * @author yy_cai
 *
 */
public class NearbyFragment extends BaseFragment{
	private List<WXMessage> data = new ArrayList<WXMessage>();
	private SwipeListView nearbyGroups;
	private View view ;
	private MainTabActivity activity;
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.activity=(MainTabActivity)activity;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i("NearbyFragment", "onCreateView");
		view = inflater.inflate(R.layout.fragment_nearby, container,false);
		initView();
		initData();
		initListView();
		return view;
	}
	
    protected void initData() {
		
    	
    		WXMessage msg = null;

    			msg = new WXMessage(R.drawable.tx9,"洪兴", "洪兴社原型为“新义安”，世袭社团，又叫“潮州帮”，源自1866 年在万安成立的“潮州鹤佬帮”", "454人");
//    			msg.setIcon_id(R.drawable.qq_icon);
    			WXMessage msg2=new WXMessage(R.drawable.tx1, "青协", "奉献爱心社团", "120人"); 
    			WXMessage msg3=new WXMessage(R.drawable.tx2, "义和团", "义和团，又称义和拳。义和团运动又称“庚子事变”，是19世纪末中国发生的一场以“扶清灭洋”为口号，针对西方在华人士包括在华传教士及中国基督徒所进行大规模群众暴力运动", "120人"); 
    			WXMessage msg4=new WXMessage(R.drawable.tx5, "漫画社", "漫画是一种艺术形式，是用简单而夸张的手法来描绘生活或时事的图画。", "120人"); 
    			WXMessage msg5=new WXMessage(R.drawable.tx7, "台球社", "台球是一项在国际上广泛流行的高雅室内体育运动，是一种用球杆在台上击球、依靠计算得分确定比赛胜负的室内娱乐体", "420人"); 
    			WXMessage msg6=new WXMessage(R.drawable.tx4, "摄影", "摄影是指使用某种专门设备进行影像记录的过程，一般我们使用机械照相机或者数码照相机进行摄影。", "28人"); 
    			WXMessage msg7=new WXMessage(R.drawable.tx10, "羽毛球社", "羽毛球是一项室内，室外兼顾的运动。依据参与的人数，可以分为单打与双打。", "20人"); 
    		data.add(msg);
    		data.add(msg2);
    		data.add(msg3);
    		data.add(msg4);
    		data.add(msg5);
    		data.add(msg6);
    		data.add(msg7);
    	
	}
	
	private void initView() {
		ImageView topHome = (ImageView)view.findViewById(R.id.iv_top_left);
		topHome.setOnClickListener(this);
		TextView title = (TextView)view.findViewById(R.id.tv_top_title);
		title.setText("附近");
		ImageView create = (ImageView)view.findViewById(R.id.iv_top_right);
		create.setOnClickListener(this);
	}
	private void initListView() {
		nearbyGroups = (SwipeListView)view.findViewById(R.id.lv_nearby_groups);
		
		final SwipeAdapter mAdapter = new SwipeAdapter(getActivity(),data,nearbyGroups.getRightViewWidth());
		 mAdapter.setOnRightItemClickListener(new SwipeAdapter.onRightItemClickListener() {
	        	
             @Override
             public void onRightItemClick(View v, int position) {
            	 Toast.makeText(getActivity(),  "item onclick " + position, 1000).show();
//             	mListView.deleteItem(mListView.getChildAt(position));
//             	data.remove(position);
//             	mAdapter.notifyDataSetChanged();
//             	CustomToast.showToast(MainActivity.this,  "删除第  " + (position+1)+" 对话记录", 1000);
             }
         });
		 
		 mAdapter.setIsShowRightItem(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				nearbyGroups.isshow();
			}
		});
 
		 nearbyGroups.setAdapter(mAdapter);
		 
		 nearbyGroups.setOnItemClickListener(new AdapterView.OnItemClickListener() {
		     @Override
		     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		     	Toast.makeText(getActivity(),  "item onclick " + position, 1).show();;
		     }
		 });
//		List<HashMap<String, Object>> groups = new ArrayList<HashMap<String, Object>>();
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		map.put("city", "上海");
//		map.put("image", ImageUtil.readBitMap(getActivity(), R.drawable.default_bg));
//		map.put("state_number", "封闭小组·1563名成员");
//		map.put("describe", "爱因斯坦的相对论说明的实际上是相对参照空间的时间显示，当你以光速反光源而行时，你看到的光源景物是静止的");
//		groups.add(map);
//		map = new HashMap<String, Object>();
//		map.put("city", "福州");
//		map.put("image", ImageUtil.readBitMap(getActivity(), R.drawable.default_bg));
//		map.put("state_number", "封闭小组·1500名成员");
//		map.put("describe", "哈哈的相对论说明的实际上是相对参照空间的时间显示，当你以光速反光源而行时，你看到的光源景物是静止的");
//		groups.add(map);
//		nearbyGroups.setAdapter(new NearbyAdapter(groups, getActivity()));
//		nearbyGroups.setOnItemClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.iv_top_left){
			activity.dealSlidingMenu();
		}
		else if(v.getId()==R.id.iv_top_right){
			Intent i = new Intent(getActivity(), CreateSocietyActivity.class);
			i.putExtra("startSite", CreateSocietyActivity.SELECT_TYPE);
			startActivity(i);
			getActivity().overridePendingTransition(R.anim.anim_go_up,R.anim.anim_activity_out);
		}
	}
}
