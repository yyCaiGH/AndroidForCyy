package com.geihoo.dialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.geihoo.adapter.CommonAdapter;
import com.geihoo.adapter.ViewHolder;
import com.geihoo.base.BaseDialog;
import com.geihoo.groups.R;
import com.geihoo.utils.ImageUtil;

/**
 * 选择活动地点
 * @author yy_cai
 *
 * 2015年9月7日
 */
public class SelectActivityPlaceDialog extends BaseDialog{

	private Context context;
	private ListView groupNoticeSet;
	public SelectActivityPlaceDialog(Context context) {
		super(context);
		this.context=context;
		this.setContentView(R.layout.dialog_select_activity_place);
		initView();
		initNoticeSetListView();
	}

	protected void initView() {
		EditText et = (EditText)this.findViewById(R.id.et_search);
		et.setHint("搜索地点");
		TextView back = (TextView)this.findViewById(R.id.tv_back);
		back.setOnClickListener(this);
	}

	/**
	 * 发帖通知设置
	 */
	private void initNoticeSetListView() {
		groupNoticeSet = (ListView) this.findViewById(R.id.lv_groups_notice_set);
		List<HashMap<String, Object>> groups = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("image",
				ImageUtil.readBitMap(context, R.drawable.tx1));
		map.put("group_name", "福州市鼓楼区华林路11号惠凤楼");
		map.put("notice_set", "13米");
		groups.add(map);
		map = new HashMap<String, Object>();
		map.put("image",
				ImageUtil.readBitMap(context, R.drawable.tx2));
		map.put("group_name", "福州市鼓楼区永兴洋楼");
		map.put("notice_set", "2000米");
		groups.add(map);
		map = new HashMap<String, Object>();
		map.put("image",
				ImageUtil.readBitMap(context, R.drawable.tx9));
		map.put("group_name", "福州西湖公园");
		map.put("notice_set", "144米");
		groups.add(map);
		
//		View v = LayoutInflater.from(parent).inflate(R.layout.item_groups_notice_set, null);
//		CustomImageView civ = (CustomImageView)v.findViewById(R.id.civ_image);
//		civ.setPic(ImageUtil.postScale(parent, ImageUtil.readBitMap(getActivity(), R.drawable.zz_num), R.dimen.icon_small_size));
//		TextView tv = (TextView)v.findViewById(R.id.tv_group_name);
//		tv.setText("所有族族");
//		groupNoticeSet.addFooterView(v);
		
		groupNoticeSet.setAdapter(new CommonAdapter<HashMap<String, Object>>(context,groups,R.layout.item_groups_notice_set) {
			@Override
			public void convert(ViewHolder helper, HashMap<String, Object> item) {
				// TODO Auto-generated method stub
				helper.setMyImageBitmap(R.id.civ_image, (Bitmap)item.get("image"));
				helper.setText(R.id.tv_group_name, item.get("group_name").toString());
				helper.setText(R.id.tv_notice_set, item.get("notice_set").toString());
			}
		});
	}
	
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.tv_back){
			this.cancel();
		}
	}
}
