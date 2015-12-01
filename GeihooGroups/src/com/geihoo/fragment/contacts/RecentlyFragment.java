package com.geihoo.fragment.contacts;

import java.util.HashMap;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;

import com.geihoo.activity.MeActivity;
import com.geihoo.adapter.CommonAdapter;
import com.geihoo.adapter.ViewHolder;
import com.geihoo.base.BaseFragment;
import com.geihoo.bean.ContactsBean;
import com.geihoo.groups.R;
import com.geihoo.test.Datas;
import com.geihoo.utils.ImageUtil;
/**
 * 最近消息
 * @author czz
 *
 */
public class RecentlyFragment extends BaseFragment{
	public static String tag="RecentlyFragment";
	private ListView friendList; 
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_recently, container,false);
		friendList=(ListView) view.findViewById(R.id.lv_friend);
		
		List<HashMap<String, Object>> list=Datas.getAllRecentlyMes();

	    //创建一个匿名适配器对象，对item进行赋值
	    friendList.setAdapter(new CommonAdapter<HashMap<String, Object>>(getActivity(),list,R.layout.item_txl_recently_mes) {

			@Override
			public void convert(ViewHolder helper, HashMap<String, Object> item) {
				helper.setMyImageResource(R.id.civ_contact_img, (Integer)item.get("image"));
				helper.setText(R.id.tv_contact_name, String.valueOf(item.get("name")));
				helper.setText(R.id.tv_contact_mes, String.valueOf(item.get("mes")));
				helper.setText(R.id.tv_contact_time, String.valueOf(item.get("time")));
				
				final ContactsBean contact = new ContactsBean();
				contact.setImage(ImageUtil.readBitMap(getActivity(),(Integer)item.get("image")));
				contact.setName(String.valueOf(item.get("name")));
				helper.setCustomImageViewOnClickListener(R.id.civ_contact_img, new OnClickListener() {
					@Override
					public void onClick(View arg0) {
						Intent i = new Intent(getActivity(),MeActivity.class);
						i.putExtra("type", MeActivity.ME_INFO);
						i.putExtra("contact", contact);
						getActivity().startActivity(i);
					}
				});
			}
		});
		return view;
	}

}
