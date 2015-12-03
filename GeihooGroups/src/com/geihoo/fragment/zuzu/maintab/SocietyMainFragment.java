package com.geihoo.fragment.zuzu.maintab;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.geihoo.activity.MemberActivity;
import com.geihoo.activity.SendMessageActivity;
import com.geihoo.activity.SendPicActivity;
import com.geihoo.adapter.SocietyPostAdapter;
import com.geihoo.base.BaseFragment;
import com.geihoo.bean.PostContentBean;
import com.geihoo.bean.ZuZuBean;
import com.geihoo.dialog.AddMemberDialog;
import com.geihoo.dialog.SocietySwitchDialog;
import com.geihoo.dialog.StickPostsDialog;
import com.geihoo.groups.R;
import com.geihoo.test.Datas;
import com.geihoo.utils.Constant;
import com.geihoo.utils.Constants;
import com.geihoo.utils.ImageUtil;
import com.geihoo.utils.ToastUtil;
import com.geihoo.utils.ViewUtils;
import com.geihoo.view.CustomImageView;

/**
 * 族族主页
 * 
 * @author hjs 2015.7.28
 */
public class SocietyMainFragment extends BaseFragment {

	Activity activity;
	ArrayList<PostContentBean> postList = new ArrayList<PostContentBean>();
	ListView postListView;
	TextView societyName,societyNameSus;
	RelativeLayout topSuspension;
	SocietyPostAdapter societyPostAdapter;
	ZuZuBean mZuzu;
	LinearLayout topPosted,susTopPosted;//加入发帖顶部
	public final static int SET_POSTLIST = 0;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		initData();
		Log.i("cyy-cyy", "来到族族首页");
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		this.activity = activity;
		super.onAttach(activity);
	}

	/** 此方法意思为fragment是否可见 ,可见时候加载数据 */
	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		if (isVisibleToUser) {
			// fragment可见时加载数据
			if (postList != null && postList.size() != 0) {
				handler.obtainMessage(SET_POSTLIST).sendToTarget();
			} else {
				new Thread(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						handler.obtainMessage(SET_POSTLIST).sendToTarget();
					}
				}).start();
			}
		} else {
			// fragment不可见时不执行操作
		}
		super.setUserVisibleHint(isVisibleToUser);
	}

	@SuppressLint("NewApi")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = LayoutInflater.from(getActivity()).inflate(
				R.layout.fragment_society_main, null);
		mZuzu = this.getArguments().getParcelable("zuzu");
		initView(view);
		initPostListView(view);
		return view;
	}

	protected void initView(View view) {
		ImageView close = (ImageView)view.findViewById(R.id.iv_zuzu_close);
		close.setOnClickListener(this);
		societyNameSus = (TextView)view.findViewById(R.id.society_name_sus);
		if(mZuzu!=null){
			societyNameSus.setText(mZuzu.getName());
		}
		
		topSuspension = (RelativeLayout)view.findViewById(R.id.rl_top_suspension);
		
		susTopPosted = (LinearLayout)view.findViewById(R.id.btn_group_layout);
		
		TextView postMessage = (TextView)view.findViewById(R.id.send_message_btn);
		postMessage.setOnClickListener(this);
		TextView postPic = (TextView)view.findViewById(R.id.send_pic_btn);
		postPic.setOnClickListener(this);
		
	}

	private void initPostListView(View view) {
		postListView = (ListView) view.findViewById(R.id.postListView);
		
		View v = LayoutInflater.from(activity).inflate(R.layout.view_zuzu_cover, null);
		LinearLayout members = (LinearLayout)v.findViewById(R.id.ll_member);
		members.setOnClickListener(this);
		ImageView addMember = (ImageView)v.findViewById(R.id.iv_member_add);
		addMember.setOnClickListener(this);
		TextView postMessage = (TextView)v.findViewById(R.id.send_message_btn);
		postMessage.setOnClickListener(this);
		TextView postPic = (TextView)v.findViewById(R.id.send_pic_btn);
		postPic.setOnClickListener(this);
		TextView tv_stick_posts = (TextView)v.findViewById(R.id.tv_stick_posts);
		tv_stick_posts.setOnClickListener(this);
		topPosted = (LinearLayout)v.findViewById(R.id.btn_group_layout);
		
		//设置族族名称
		societyName = (TextView)v.findViewById(R.id.tv_zz_name);
		if(mZuzu!=null){
			societyName.setText(mZuzu.getName());
		}
		//设置族族公开程度和族族成员数量
		String type ="";
		if(mZuzu!=null){
			if(mZuzu.getType()==Constant.ZZ_TYPE_PRIVATE){
				type = "私密";
			}
			else{
				type = "公开";
			}
		}
		TextView zuzuInfo = (TextView)v.findViewById(R.id.tv_zz_info);
		zuzuInfo.setText(type+" | 10位成员");
		//设置背景
		ImageView zuzubg = (ImageView)v.findViewById(R.id.iv_zuzu_bg);
		if(mZuzu!=null){
			if(mZuzu.getBgIcon()==null){
				zuzubg.setImageBitmap(ImageUtil.readBitMap(activity, R.drawable.zz_def_bg));
			}
			else{
				zuzubg.setImageBitmap(mZuzu.getBgIcon());
			}
		}
		//设置头像
		CustomImageView zuzuHeadImg = (CustomImageView)v.findViewById(R.id.civ_zuzu_head);
		if(mZuzu!=null){
			if(mZuzu.getHeadIcon()==null){
				zuzuHeadImg.setPic(ImageUtil.readBitMap(activity, R.drawable.zz_def_head));
			}
			else{
				zuzuHeadImg.setPic(mZuzu.getHeadIcon());
			}
		}
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
			activity.finish();
		}
		else if(v.getId()==R.id.ll_member){
			Intent intent = new Intent(activity, MemberActivity.class);
			activity.startActivity(intent);
		}
		else if(v.getId()==R.id.iv_member_add){
			new AddMemberDialog(activity).show();
		}
		else if(v.getId()==R.id.send_message_btn){
			Intent intent = new Intent(activity, SendMessageActivity.class);
			activity.startActivity(intent);
		}
		else if(v.getId()==R.id.send_pic_btn){
			Intent intent = new Intent(activity, SendPicActivity.class);
			activity.startActivity(intent);
		}
		else if(v.getId()==R.id.tv_stick_posts){
			new StickPostsDialog(activity,"置顶帖").show();
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
				societyPostAdapter = new SocietyPostAdapter(activity, postList,SocietyPostAdapter.ZZ_DYNAMIC);
				postListView.setAdapter(societyPostAdapter);
				break;
			default:
				break;
			}
			super.handleMessage(msg);
		}
	};
}
