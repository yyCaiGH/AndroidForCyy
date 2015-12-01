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
//	HomeDynamicAdapter homeDynamicAdapter;
	SocietyPostAdapter societyPostAdapter;
	public final static int SET_POSTLIST = 0;
	public StickPostsDialog(Activity context,String title) {
        super(context, R.style.Dialog);
        setContentView(R.layout.dialog_stick_posts);
        this.context=context;
        initData();
        initView(title);
        handler.obtainMessage(SET_POSTLIST).sendToTarget();//先放着，不卡
	}
	private void initView(String title) {
		postListView = (ListView) this.findViewById(R.id.postListView);
		
		TextView tvTitle = (TextView)this.findViewById(R.id.tv_top_title);
		tvTitle.setText(title);
		TextView tvBack = (TextView)this.findViewById(R.id.tv_top_left);
		tvBack.setOnClickListener(this);
	}
	protected void initData() {
		postList = Constants.getPostList();
	}
	
	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			switch (msg.what) {
			case SET_POSTLIST:
				societyPostAdapter = new SocietyPostAdapter(context, postList,SocietyPostAdapter.MY_DYNAMIC);
				postListView.setAdapter(societyPostAdapter);
				break;
			default:
				break;
			}
			super.handleMessage(msg);
		}
	};
	public void onClick(View v) {
		super.onClick(v);
	};
}
