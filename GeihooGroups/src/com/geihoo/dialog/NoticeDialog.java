package com.geihoo.dialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.geihoo.adapter.NoticesAdapter;
import com.geihoo.base.BaseDialog;
import com.geihoo.groups.R;
import com.geihoo.utils.ImageUtil;

/**
 * 通知
 * @author yy_cai
 *
 * 2015年7月24日
 */
public class NoticeDialog extends BaseDialog{

	private ListView lvNotices;
	private Context context;
	public NoticeDialog(Context context) {
        super(context);
        setContentView(R.layout.fragment_sm_notice);
        this.context=context;
        initView();
        initNoticeListView();
	}
	
	protected void initView() {
		TextView tvTitle = (TextView)this.findViewById(R.id.tv_top_title);
		tvTitle.setText(context.getResources().getString(R.string.top_title_tz));
		TextView tvBack = (TextView)this.findViewById(R.id.tv_top_left);
		tvBack.setText("返回");
		tvBack.setOnClickListener(this);
		TextView tvNext = (TextView)this.findViewById(R.id.tv_top_right);
		tvNext.setVisibility(View.GONE);
		lvNotices = (ListView)this.findViewById(R.id.lv_notice);
	}
	
	private void initNoticeListView() {
		List<HashMap<String, Object>> notices = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(context, R.drawable.geihoo_logo));
		map.put("notice_desc", "瓜瓜将你添加到私密社团瓜瓜也");
		map.put("notice_time", "昨天下午2:45");
		notices.add(map);
		map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(context, R.drawable.ahpicture));
		map.put("notice_desc", "TT将你添加到私密社团瓜瓜也");
		map.put("notice_time", "周三下午3:22");
		notices.add(map);
		lvNotices.setAdapter(new NoticesAdapter(notices, context));
	}

	
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.tv_top_left){
			this.cancel();
		}
	}

}
