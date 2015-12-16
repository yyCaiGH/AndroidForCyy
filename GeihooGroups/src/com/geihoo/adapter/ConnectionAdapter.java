package com.geihoo.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.geihoo.activity.MeActivity;
import com.geihoo.bean.ContactsBean;
import com.geihoo.groups.R;
import com.geihoo.utils.ImageUtil;
import com.geihoo.utils.PingYinUtils;
import com.geihoo.view.CustomImageView;

public class ConnectionAdapter extends BaseAdapter{

	private List<ContactsBean> friends;
	private Map<String, Integer> alphaIndexer;
	private Context context;
	public ConnectionAdapter(List<ContactsBean>  friends,
			Context context) {
		this.friends=friends;
		this.context=context;
		alphaIndexer = new HashMap<String, Integer>();
		for (int i = 0; i < friends.size(); i++) {
			String curName=friends.get(i).getName();
			char letter = getLetter(i,curName);
			if(letter!=' '){
				alphaIndexer.put(letter+"", i);
				Log.i("cyy-cyy", "letter="+letter+",i="+i);
			}
		}
	}

	@Override
	public int getCount() {
		return friends.size();
	}

	@Override
	public Object getItem(int position) {
		return friends.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public Integer getLetterIndex(String letter){
		return alphaIndexer.get(letter);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ContactsBean contact = friends.get(position);
		ViewHolder vh=null;
		if(convertView==null){
			convertView = LayoutInflater.from(context).inflate(R.layout.item_txl_contacts, null);
			vh = new ViewHolder();
			vh.civImage=(CustomImageView)convertView.findViewById(R.id.civ_contact_img);
			vh.name=(TextView)convertView.findViewById(R.id.tv_contact_name);
			vh.letter=(TextView)convertView.findViewById(R.id.tv_letter);
			convertView.setTag(vh);
		}
		else{
			vh=(ViewHolder)convertView.getTag();
		}
		String curName=contact.getName();
		char letter = getLetter(position,curName);
//		Log.i("cyy-cyy", "position="+position+",letter="+letter);
		if(letter!=' '){
			vh.letter.setVisibility(View.VISIBLE);
			vh.letter.setText(letter+"");
		}
		else{//空格符代表相同就不再设置
			vh.letter.setVisibility(View.GONE);
		}
		vh.civImage.setPic(contact.getImage());
		vh.civImage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(context,MeActivity.class);
				i.putExtra("type", MeActivity.ME_HOME);
				i.putExtra("contact", contact);
				context.startActivity(i);
				
			}
		});
		vh.name.setText(curName);
		return convertView;
	}
	private static class ViewHolder{
		CustomImageView civImage;
		TextView name,letter;
	}

	/**
	 * 获得当前位置该显示的字母
	 * @param position
	 * @param curName
	 * @return
	 */
	private char getLetter(int position,String curName){
		String preName=null;
		if(position==0){
			preName=" ";
		}
		else{
			preName=friends.get(position-1).getName();
		}
		char letter=PingYinUtils.isSame(preName, curName);
		return letter;
	}

}
