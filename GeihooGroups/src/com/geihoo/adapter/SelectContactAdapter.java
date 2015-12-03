package com.geihoo.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.geihoo.bean.ContactsBean;
import com.geihoo.bean.ZuZuBean;
import com.geihoo.groups.R;
import com.geihoo.utils.ImageUtil;
import com.geihoo.view.CustomImageView;

/**
 * 
 * 选择联系人适配器
 * 
 * @author yy_cai
 * 
 *         2015年12月2日
 */
public class SelectContactAdapter extends BaseAdapter {

	private List<ContactsBean> contacts,selectedContacts;
	private Context context;
	public SelectContactAdapter(List<ContactsBean> contacts, Context context) {
		this.contacts = contacts;
		this.context = context;
		selectedContacts = new ArrayList<ContactsBean>();
	}

	@Override
	public int getCount() {
		return contacts.size();
	}

	@Override
	public Object getItem(int position) {
		return contacts.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	/**
	 * 直接获取已选中的联系人，避免多次遍历
	 * @return
	 */
	public List<ContactsBean> getSelectContacts(){
		return selectedContacts;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
//		final int index = position;
		final ContactsBean contact = contacts.get(position);
		ViewHolder vh = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.item_add_member, null);
			vh = new ViewHolder();
			vh.civImage = (CustomImageView) convertView
					.findViewById(R.id.civ_image);
			vh.name = (TextView) convertView.findViewById(R.id.tv_member_name);
			vh.check = (CheckBox) convertView.findViewById(R.id.cb_check);
			convertView.setTag(vh);
		} else {
			vh = (ViewHolder) convertView.getTag();
		}
		Bitmap bitmap = ImageUtil.postScale(context, contact.getImage(), R.dimen.icon_medium_size);
		vh.civImage.setPic(bitmap);
		String title = contact.getName().toString();
		vh.name.setText(title);
		vh.check.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
					if(!selectedContacts.contains(contact)){
						selectedContacts.add(contact);
					}
					contact.setChecked(true);
				}
				else{
					if(selectedContacts.contains(contact)){
						selectedContacts.remove(contact);
					}
					contact.setChecked(false);
				}
				
			}
		});
		if(contact.isChecked()){
			vh.check.setChecked(true);
		}
		else{
			vh.check.setChecked(false);
		}
		return convertView;
	}

	private static class ViewHolder {
		CustomImageView civImage;
		TextView name;
		CheckBox check;
	}

}
