package com.geihoo.activity;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.geihoo.adapter.SocietyPostAdapter;
import com.geihoo.base.BaseActivity;
import com.geihoo.bean.PostContentBean;
import com.geihoo.dialog.AddMemberDialog;
import com.geihoo.groups.R;
import com.geihoo.utils.Constants;
import com.geihoo.utils.ViewUtils;
/**
 * 
 * 朋友圈主Activity
 *
 * @author yy_cai
 *
 * 2015年11月29日
 */
public class FriendCircleActivity extends BaseActivity{

	ArrayList<PostContentBean> postList = new ArrayList<PostContentBean>();
	ListView postListView;
	TextView societyName,societyNameSus;
	RelativeLayout topSuspension;
	SocietyPostAdapter societyPostAdapter;

	LinearLayout topPosted,susTopPosted;//加入发帖顶部
	public final static int SET_POSTLIST = 0;
	private String mName;//朋友圈名称
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.fragment_society_main);
		mName=this.getIntent().getStringExtra("name");
		initView();
		initData();
		handler.obtainMessage(SET_POSTLIST).sendToTarget();
	}


	protected void initView() {
		ImageView close = (ImageView)this.findViewById(R.id.iv_zuzu_close);
		close.setOnClickListener(this);
		societyNameSus = (TextView)this.findViewById(R.id.society_name_sus);
		societyNameSus.setText(mName);
		topSuspension = (RelativeLayout)this.findViewById(R.id.rl_top_suspension);
		
		susTopPosted = (LinearLayout)this.findViewById(R.id.btn_group_layout);
		
		TextView postMessage = (TextView)this.findViewById(R.id.send_message_btn);
		postMessage.setOnClickListener(this);
		TextView postPic = (TextView)this.findViewById(R.id.send_pic_btn);
		postPic.setOnClickListener(this);
		
		initPostListView();
	}

	/**
	 * 初始化postListView
	 */
	private void initPostListView() {
		
		postListView = (ListView) this.findViewById(R.id.postListView);
		
		View v = LayoutInflater.from(this).inflate(R.layout.view_zuzu_cover, null);
		LinearLayout members = (LinearLayout)v.findViewById(R.id.ll_member);
		members.setOnClickListener(this);
		ImageView addMember = (ImageView)v.findViewById(R.id.iv_member_add);
		addMember.setOnClickListener(this);
		TextView postMessage = (TextView)v.findViewById(R.id.send_message_btn);
		postMessage.setOnClickListener(this);
		TextView postPic = (TextView)v.findViewById(R.id.send_pic_btn);
		postPic.setOnClickListener(this);
		TextView tv_stick_posts = (TextView)v.findViewById(R.id.tv_stick_posts);
		tv_stick_posts.setVisibility(View.GONE);
		societyName = (TextView)v.findViewById(R.id.tv_zz_name);
		societyName.setText(mName);
		topPosted = (LinearLayout)v.findViewById(R.id.btn_group_layout);
		
		TextView zuzuInfo = (TextView)v.findViewById(R.id.tv_zz_info);
		zuzuInfo.setVisibility(View.GONE);
		postListView.addHeaderView(v,null,false);//在onItemClick里就不会被点击到而发生错误
		
		
		postListView.setOnScrollListener(new OnScrollListener() {
			
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				
			}
			
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				int societyNameSusY = ViewUtils.getLocationY(societyNameSus);//记录悬浮标题在屏幕的位置y值
				int y = ViewUtils.getLocationY(societyName);
//				if(Math.abs(y-societyNameSusY)>200){//避免多次运行不必要的代码
//					return;
//				}
				if(y<0){
					societyNameSus.setVisibility(View.VISIBLE);
					topSuspension.setBackgroundColor(Color.parseColor("#deffffff"));
				}
				else if(y<=societyNameSusY){//往上滑高于悬浮标题时做替代处理
					societyNameSus.setVisibility(View.VISIBLE);
					societyName.setVisibility(View.INVISIBLE);
					int a=99-y;
					if(a<10){//alpha值必须是两位数
						a=10;
					}
					String alpha="#"+a+"ffffff";
					topSuspension.setBackgroundColor(Color.parseColor(alpha));
				}
				else{
					societyNameSus.setVisibility(View.INVISIBLE);
					societyName.setVisibility(View.VISIBLE);
					topSuspension.setBackgroundColor(Color.TRANSPARENT);
				}
				
				//发帖按钮悬浮
				int susTopPostedY = ViewUtils.getLocationY(susTopPosted);//记录悬浮标题在屏幕的位置y值
				int topPostedY = ViewUtils.getLocationY(topPosted);
				
				if(topPostedY<0){
					susTopPosted.setVisibility(View.VISIBLE);
					susTopPosted.setBackgroundColor(Color.parseColor("#deffffff"));
				}
				else if(topPostedY<=susTopPostedY){//往上滑高于悬浮标题时做替代处理
					susTopPosted.setVisibility(View.VISIBLE);
					topPosted.setVisibility(View.INVISIBLE);
					int a=99-topPostedY;
					if(a<10){//alpha值必须是两位数
						a=10;
					}
					String alpha="#"+a+"ffffff";
					susTopPosted.setBackgroundColor(Color.parseColor(alpha));
				}
				else{
					susTopPosted.setVisibility(View.INVISIBLE);
					topPosted.setVisibility(View.VISIBLE);
					susTopPosted.setBackgroundColor(Color.TRANSPARENT);
				}
			}
		});
	}

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.iv_zuzu_close){
			this.finish();
		}
		else if(v.getId()==R.id.ll_member){
			Intent intent = new Intent(this, MemberActivity.class);
			this.startActivity(intent);
		}
		else if(v.getId()==R.id.iv_member_add){
			new AddMemberDialog(this).show();
		}
		else if(v.getId()==R.id.send_message_btn){
			Intent intent = new Intent(this, SendMessageActivity.class);
			this.startActivity(intent);
		}
		else if(v.getId()==R.id.send_pic_btn){
			Intent intent = new Intent(this, SendPicActivity.class);
			this.startActivity(intent);
		}
	}

	
	protected void initData() {
		postList = Constants.getPostList();
	}


	@SuppressLint("HandlerLeak")
	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			switch (msg.what) {
			case SET_POSTLIST:
				societyPostAdapter = new SocietyPostAdapter(FriendCircleActivity.this, postList,SocietyPostAdapter.ZZ_DYNAMIC);
				postListView.setAdapter(societyPostAdapter);
				break;
			default:
				break;
			}
			super.handleMessage(msg);
		}
	};
}
