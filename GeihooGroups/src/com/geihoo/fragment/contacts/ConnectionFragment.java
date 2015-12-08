package com.geihoo.fragment.contacts;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.geihoo.activity.AddFriendsActivity;
import com.geihoo.adapter.ConnectionAdapter;
import com.geihoo.base.BaseFragment;
import com.geihoo.bean.ContactsBean;
import com.geihoo.groups.R;
import com.geihoo.listener.SearchEditTextWatcher;
import com.geihoo.test.Datas;
import com.geihoo.view.MyLetterListView;
import com.geihoo.view.MyLetterListView.OnTouchingLetterChangedListener;
/**
 * 通讯录
 * @author czz
 *
 */
public class ConnectionFragment extends BaseFragment{
	private final static int UPDATE_ADAPTER=0x100;
	public static String tag="ConnectionFragment";
	private ListView friendList; 
	private TextView overlay;
	private EditText etSearch;
	private OverlayThread overlayThread;
	private LetterListViewListener letterListViewListener;
	private MyLetterListView letterListView;
	private ConnectionAdapter connectionAdapter;
	private List<ContactsBean> members,searchedMembers;
	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case UPDATE_ADAPTER:
				connectionAdapter.notifyDataSetChanged();
				break;
			default:
				break;
			}
		};
	};
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i(tag, "onCreate");
		super.onCreate(savedInstanceState);
		searchedMembers = new ArrayList<ContactsBean>();
		members = Datas.getContacts(getActivity());//获取所有联系人
		searchedMembers.addAll(members);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_connection, container,false);
		
		overlayThread = new OverlayThread();
		letterListViewListener = new LetterListViewListener();
		letterListView = (MyLetterListView) view.findViewById(R.id.my_letter_view);
		overlay = (TextView)view.findViewById(R.id.tv_showLetters);
		letterListView.setOnTouchingLetterChangedListener(letterListViewListener);
		
		
		friendList=(ListView) view.findViewById(R.id.lv_friend);
		etSearch = (EditText)view.findViewById(R.id.et_search);
		etSearch.setHint("搜索好友（昵称/账号）");
		etSearch.addTextChangedListener(new SearchEditTextWatcher(handler, mSearch));
		LinearLayout addFriends = (LinearLayout)view.findViewById(R.id.ll_add_friends);
		addFriends.setOnClickListener(this);
		//添加item中数据
//		List<ContactsBean> list = Datas.getContacts(getActivity());
	    //创建一个匿名适配器对象，对item进行赋值
		connectionAdapter = new ConnectionAdapter(searchedMembers, getActivity());
	    friendList.setAdapter(connectionAdapter);
	    
		return view;
	}

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.ll_add_friends){
			Intent i = new Intent(getActivity(),AddFriendsActivity.class);
			startActivity(i);
		}
	}

	Runnable mSearch = new Runnable() {
		
		@Override
		public void run() {
			 String data = etSearch.getText().toString();
             searchedMembers.clear();
	          for(ContactsBean contact:members){
	        	  if(contact.getName().contains(data)){
	        		  searchedMembers.add(contact);
	        	  }
	          }
	          handler.sendEmptyMessage(UPDATE_ADAPTER);
		}
	};
	private class LetterListViewListener implements OnTouchingLetterChangedListener {
        @Override
        public void onTouchingLetterChanged(final String s) {
            overlay.setText(s);
            overlay.setVisibility(View.VISIBLE);
            handler.removeCallbacks(overlayThread);
            // 延迟一秒后执行，让overlay为不可见
            handler.postDelayed(overlayThread, 1500);
            Integer index = connectionAdapter.getLetterIndex(s);
            if (index != null) {
				friendList.setSelection(index);
			}
        }
    }
	// 设置overlay不可见
	private class OverlayThread implements Runnable {
		@Override
		public void run() {
			overlay.setVisibility(View.GONE);
		}

	}
}
