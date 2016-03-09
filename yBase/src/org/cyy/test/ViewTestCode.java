package org.cyy.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.cyy.adapter.CommonAdapter;
import org.cyy.adapter.ViewHolder;
import org.cyy.ybase.R;

import android.content.Context;
import android.widget.ListView;

public class ViewTestCode {

	ListView mLsv;

	/**
	 * 万能适配器的使用demo
	 * @param ctx
	 */
	public void Test(Context ctx) {
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		// 创建一个匿名适配器对象，对item进行赋值
		mLsv.setAdapter(new CommonAdapter<HashMap<String, Object>>(ctx, list,R.layout.item_demo) {

			@Override
			public void convert(ViewHolder helper, HashMap<String, Object> item) {
				helper.setText(R.id.textView1, item.get("key") + "");
			}
		});
	}
}
