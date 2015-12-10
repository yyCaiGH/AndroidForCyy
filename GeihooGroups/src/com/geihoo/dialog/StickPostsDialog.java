package com.geihoo.dialog;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.geihoo.adapter.SocietyPostAdapter;
import com.geihoo.base.BaseDialog;
import com.geihoo.bean.PostContentBean;
import com.geihoo.groups.R;
import com.geihoo.utils.Constants;

/**
 * 置顶帖
 * @author yy_cai
 *
 * 2015年9月18日
 */
public class StickPostsDialog extends BaseDialog{

	private Activity context;
	ArrayList<PostContentBean> postList = new ArrayList<PostContentBean>();
	ListView postListView;
	SocietyPostAdapter societyPostAdapter;
	public StickPostsDialog(Activity context,String title) {
        super(context, R.style.Dialog);
        setContentView(R.layout.dialog_stick_posts);
        this.context=context;
        initData();
        initView(title);
        
	}
	private void initView(String title) {
		TextView tvTitle = (TextView)this.findViewById(R.id.tv_top_title);
		tvTitle.setText(title);
		TextView tvBack = (TextView)this.findViewById(R.id.tv_top_left);
		tvBack.setOnClickListener(this);
		
		postListView = (ListView) this.findViewById(R.id.postListView);
		societyPostAdapter = new SocietyPostAdapter(context, postList,SocietyPostAdapter.MY_DYNAMIC);
		postListView.setAdapter(societyPostAdapter);
		
	}
	protected void initData() {
		postList = Constants.getPostList();
	}
	
	public void onClick(View v) {
		super.onClick(v);
	};
}
