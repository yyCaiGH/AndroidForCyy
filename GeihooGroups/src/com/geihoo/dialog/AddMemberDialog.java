package com.geihoo.dialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import com.geihoo.base.BaseDialog;
import com.geihoo.groups.R;
import com.geihoo.test.ArrayAdapter;
import com.geihoo.utils.ImageUtil;
import com.geihoo.utils.ToastUtil;

public class AddMemberDialog extends BaseDialog {

	Context context;

	public AddMemberDialog(Context context) {
		super(context);
		this.context = context;
		setContentView(R.layout.dialog_add_member);
		initView();
	}

	protected void initView() {
		TextView tvTitle = (TextView) this.findViewById(R.id.tv_top_title);
		tvTitle.setText("添加成员");
		TextView tvBack = (TextView) this.findViewById(R.id.tv_top_left);
		tvBack.setOnClickListener(this);
		TextView tvFinish = (TextView) this.findViewById(R.id.tv_top_right);
		tvFinish.setText("完成");
		tvFinish.setOnClickListener(this);

		List<HashMap<String, Object>> members = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(context, R.drawable.rao));
		map.put("member_name", "诗韵斋");
		members.add(map);
		map = new HashMap<String, Object>();
		map.put("image", ImageUtil.readBitMap(context, R.drawable.ahpicture));
		map.put("member_name", "饶云间来");
		members.add(map);
//		addZuZuSet.setAdapter(new ClanSetAdapter(members, getActivity()));
		
		MultiAutoCompleteTextView mCompTextView = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);
		mCompTextView.setHint("搜索好友");
		mCompTextView.setThreshold(1);
		// 提示框必需要有适配器
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context,
				R.layout.item_simple_test, new String[] {
						"饶赛云", "蔡跃勇", "黄进生", "余能斌", "陈翔", "陈子正",
						"汪宏达", "王劭文", "翁翔","白蔡","白云","胜白","ac","cb","acc","aacsd" });

		mCompTextView.setAdapter(arrayAdapter);
		// 为自动多提示框添加逗号分词器
		mCompTextView
				.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		if (v.getId() == R.id.tv_top_right) {
			ToastUtil.showTextLong(context, "添加成功");
			this.cancel();
		}
	}

}
