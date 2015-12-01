package com.geihoo.dialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.geihoo.adapter.SearchSocietyAdapter;
import com.geihoo.base.BaseDialog;
import com.geihoo.groups.R;
import com.geihoo.utils.ImageUtil;
/**
 * 搜索社团
 * @author yy_cai
 *
 * 2015年9月23日
 */
public class SearchSocietyDialog extends BaseDialog{

	private GridView HotSociety;
	private Context context;
	public SearchSocietyDialog(Context context) {
        super(context, R.style.Dialog);
        setContentView(R.layout.dialog_search_society);
        this.context=context;
        initView();
        initHotSociety();
	}

	protected void initView() {
		TextView cancel = (TextView)this.findViewById(R.id.tv_search_cancel);
		cancel.setVisibility(View.VISIBLE);
        cancel.setOnClickListener(this);
        HotSociety = (GridView)this.findViewById(R.id.gv_hot_society);
	}
	
	private void initHotSociety() {
		List<HashMap<String, Object>> groups = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(context, R.drawable.tx8));
		map.put("society_name", "人生初见");
		groups.add(map);
		map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(context, R.drawable.rao));
		map.put("society_name", "初心始终");
		groups.add(map);
		map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(context, R.drawable.tx12));
		map.put("society_name", "科技云相册");
		groups.add(map);
		map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(context, R.drawable.tx3));
		map.put("society_name", "骑行王者");
		groups.add(map);
		map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(context, R.drawable.tx6));
		map.put("society_name", "雨与伞");
		groups.add(map);
		map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(context, R.drawable.tx9));
		map.put("society_name", "风韵犹存");
		groups.add(map);
		map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(context, R.drawable.tx11));
		map.put("society_name", "花溪丫头");
		groups.add(map);
		map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(context, R.drawable.tx10));
		map.put("society_name", "开心街头");
		groups.add(map);
		HotSociety.setAdapter(new SearchSocietyAdapter(groups, context));
	}
	
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.tv_search_cancel){
			this.cancel();
		}
	}

}
