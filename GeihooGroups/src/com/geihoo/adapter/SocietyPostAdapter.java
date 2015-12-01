package com.geihoo.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.geihoo.activity.MeActivity;
import com.geihoo.bean.PostContentBean;
import com.geihoo.dialog.PostsDetailedDialog;
import com.geihoo.groups.R;
import com.geihoo.utils.Constants;
import com.geihoo.utils.DialogUtil;
import com.geihoo.utils.ImageUtil;
import com.geihoo.utils.ListViewUtil;
import com.geihoo.view.CustomImageView;

public class SocietyPostAdapter extends BaseAdapter implements OnClickListener{
	public final static int MY_DYNAMIC=0x300;
	public final static int MY_COLLECT=0x301;
	public final static int ZZ_DYNAMIC=0x302;
	ArrayList<PostContentBean> postList;
	Activity activity;
	LayoutInflater inflater = null;
	int type;
	/** 弹出的更多选择框  */
	public SocietyPostAdapter(Activity activity, ArrayList<PostContentBean> postList,int type) {
		this.activity = activity;
		this.postList = postList;
		this.type = type;
		inflater = LayoutInflater.from(activity);
	}

	@Override
	public int getCount() {
		return postList == null ? 0 : postList.size();
	}

	@Override
	public PostContentBean getItem(int position) {
		if (postList != null && postList.size() != 0) {
			return postList.get(position);
		}
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		ViewHolder vh=null;
		PostContentBean postContentBean = getItem(position);
		if (view == null) {
			view = inflater.inflate(R.layout.item_society_no_titile, null);
			vh = new ViewHolder();
			vh.headImg=(CustomImageView)view.findViewById(R.id.head_img);
			vh.ivSelect=(ImageView)view.findViewById(R.id.iv_select);
			vh.nameText=(TextView)view.findViewById(R.id.name_text);
			vh.timeText=(TextView)view.findViewById(R.id.time_text);
			vh.contentText=(TextView)view.findViewById(R.id.content_text);
			vh.postImg=(ImageView)view.findViewById(R.id.post_img);
			vh.userInfoLayout=(RelativeLayout)view.findViewById(R.id.user_info_layout);
			vh.likeView=(TextView)view.findViewById(R.id.like_view);
			vh.commentView=(TextView)view.findViewById(R.id.comment_view);
			vh.postRespLayout=(RelativeLayout)view.findViewById(R.id.post_resp_layout);
			vh.ivDynPinglun=(ImageView)view.findViewById(R.id.iv_dyn_pinglun);
			view.setTag(vh);
		} else {
			vh=(ViewHolder)convertView.getTag();
		}
			vh.ivSelect.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					String[] items =null;
					if(type==MY_DYNAMIC){
						items =new String[]{"收藏","编辑帖子","删除","举报"};
					}
					else if(type==MY_COLLECT){
						items =new String[]{"取消收藏","举报"};
					}
					else if(type==ZZ_DYNAMIC){
						items =new String[]{"收藏","编辑帖子","置顶","删除","举报"};
					}
					DialogUtil.createSelectDialog(activity,items);
				}
			});
			vh.nameText.setText(postContentBean.getName());
			vh.timeText.setText(postContentBean.getTime());
			vh.contentText.setText(postContentBean.getContent());
			vh.headImg.setPic(ImageUtil.getImageById(activity, postContentBean.getHeadImgId(), R.dimen.icon_small_size));
			vh.postImg.setImageBitmap(ImageUtil.readBitMap(activity, postContentBean.getImageId1()));
			vh.headImg.setOnClickListener(this);
			vh.contentText.setOnClickListener(this);
			vh.ivDynPinglun.setOnClickListener(this);
		return view;
	}
	
	private static class ViewHolder{
		private CustomImageView headImg;
		private ImageView ivSelect;
		private TextView nameText;
		private TextView timeText;
		private TextView contentText;
		private ImageView postImg;
		private RelativeLayout userInfoLayout;
		private TextView likeView;
		private TextView commentView;
		private RelativeLayout postRespLayout;
		private ImageView ivDynPinglun;
	}

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.head_img){
			Intent i = new Intent(activity,MeActivity.class);
			i.putExtra("type", MeActivity.ME_INFO);
			activity.startActivity(i);
		}
		else if(v.getId()==R.id.content_text){
			new PostsDetailedDialog(activity,0).show();//浏览内容为主
		}
		else if(v.getId()==R.id.iv_dyn_pinglun){
			new PostsDetailedDialog(activity,1).show();//直接进行评论
		}
	}

}
