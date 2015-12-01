package com.geihoo.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.geihoo.bean.ZuZuBean;
import com.geihoo.dialog.CommonZuZuDialog;
import com.geihoo.groups.R;
import com.geihoo.utils.ImageUtil;
import com.geihoo.view.CustomImageView;

public class CommonZuZuAdapter extends BaseAdapter {  
    
    private Context context;  
    List<ZuZuBean> items;//适配器的数据源  
    private int type;  
       
    public CommonZuZuAdapter(Context context,List<ZuZuBean> list,int type){  
        this.context = context;  
        this.items = list; 
        this.type = type;
    }  
  
    @Override  
    public int getCount() {  
        // TODO Auto-generated method stub  
        return items.size();  
    }  
  
    @Override  
    public Object getItem(int arg0) {  
        // TODO Auto-generated method stub  
        return items.get(arg0);  
    }  
  
    @Override  
    public long getItemId(int arg0) {  
        // TODO Auto-generated method stub  
        return arg0;  
    }  
      
    public void remove(int arg0) {//删除指定位置的item  
        items.remove(arg0);  
        this.notifyDataSetChanged();//不要忘记更改适配器对象的数据源  
    }  
      
    public void insert(ZuZuBean item, int arg0) {//在指定位置插入item  
        items.add(arg0, item);  
        this.notifyDataSetChanged();  
    }  
  
    @Override  
    public View getView(int position, View convertView, ViewGroup parent) {  
    	ZuZuBean item = (ZuZuBean)getItem(position);  
        ViewHolder viewHolder;  
        if(convertView==null){  
            viewHolder = new ViewHolder();  
            convertView = LayoutInflater.from(context).inflate(R.layout.item_common_zuzu, null);  
            viewHolder.ZZname = (TextView) convertView.findViewById(R.id.tv_zuzu_name);  
            viewHolder.ZZLogo = (CustomImageView) convertView.findViewById(R.id.civ_zuzu_image);  
            viewHolder.ivDelete = (ImageView) convertView.findViewById(R.id.click_remove);  
            viewHolder.ivDragHandle = (ImageView) convertView.findViewById(R.id.drag_handle);  
            convertView.setTag(viewHolder);  
        }else{  
            viewHolder = (ViewHolder) convertView.getTag();  
        }  
          
        viewHolder.ZZname.setText(item.getName());  
        if(type==CommonZuZuDialog.noCommon_ZUZU){
        	
        	viewHolder.ivDelete.setImageBitmap(ImageUtil.readBitMap(context, R.drawable.icon_to_common));
        }
        Bitmap bitmap=ImageUtil.postScale(context, item.getHeadIcon(), R.dimen.contacts_icon_size);
//        Bitmap bitmap=ImageUtil.postScale(context, ImageUtil.readBitMap(context, (Integer)item.get("image")), R.dimen.contacts_icon_size);
        viewHolder.ZZLogo.setPic(bitmap);
//        viewHolder.ZZLogo.setImageResource(item.src);  
          
           
          
        return convertView;  
    }  
      
    class ViewHolder {  
        TextView ZZname;  
        CustomImageView ZZLogo;  
        ImageView ivDelete;  
        ImageView ivDragHandle;  
    }  
}  
