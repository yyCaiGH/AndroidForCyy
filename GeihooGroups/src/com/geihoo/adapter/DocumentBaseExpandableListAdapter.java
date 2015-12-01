package com.geihoo.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.geihoo.groups.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DocumentBaseExpandableListAdapter extends BaseExpandableListAdapter {
    
	private List<String> parentList = null;
    private Map<String, List<HashMap<String, Object>>> map = null;
	private Context context;
	public DocumentBaseExpandableListAdapter(List<String> parentList,Map<String, List<HashMap<String, Object>>> map,
			Context context) {
		this.map=map;
		this.context=context;
		this.parentList = parentList;
	}

    //得到子item需要关联的数据
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        String key = parentList.get(groupPosition);
        return (map.get(key).get(childPosition));
    }

    //得到子item的ID
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    //设置子item的组件
    @Override
    public View getChildView(int groupPosition, int childPosition,
            boolean isLastChild, View convertView, ViewGroup parent) {
        String key = parentList.get(groupPosition);
        //String info = map.get(key).get(childPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_documents_list, null);
        }
        ImageView imageView=(ImageView)convertView.findViewById(R.id.iv_document_id);
        imageView.setBackgroundResource((Integer)map.get(key).get(childPosition).get("image"));
        
        TextView name = (TextView) convertView.findViewById(R.id.tv_document_name);
        name.setText(map.get(key).get(childPosition).get("name").toString());
        
        TextView detailinfo = (TextView) convertView.findViewById(R.id.tv_doucument_detail_id);
		detailinfo.setText(map.get(key).get(childPosition).get("detailinfo").toString());
		
        return convertView;
    }

    //获取当前父item下的子item的个数
    @Override
    public int getChildrenCount(int groupPosition) {
        String key = parentList.get(groupPosition);
        int size=map.get(key).size();
        return size;
    }
  //获取当前父item的数据
    @Override
    public Object getGroup(int groupPosition) {
        return parentList.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return parentList.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }
   //设置父item组件
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
            View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.expand_document_layout_parent, null);
        }
        TextView tv = (TextView) convertView
                .findViewById(R.id.parent_textview);
        tv.setText(parentList.get(groupPosition));
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
