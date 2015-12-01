package com.geihoo.dialog;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.geihoo.adapter.CommentAdapter;
import com.geihoo.base.BaseDialog;
import com.geihoo.groups.R;
import com.geihoo.utils.Constants;
import com.geihoo.utils.ListViewUtil;
/**
 * 帖子详细内容，可评论
 * @author yy_cai
 *
 * 2015年9月21日
 */
public class PostsDetailedDialog extends BaseDialog{

	private ListView commentListView;
	public PostsDetailedDialog(Context context,int status) {
		super(context);
		this.setContentView(R.layout.dialog_posts_detailed);
		
		CommentAdapter commentAdapter = new CommentAdapter(context, Constants.getCommentList());
		commentListView = (ListView)this.findViewById(R.id.comment_list_view);
		commentListView.setAdapter(commentAdapter);
		ListViewUtil.setListViewHeightBasedOnChildren(commentListView, commentAdapter);
		TextView tvTitle = (TextView)this.findViewById(R.id.tv_top_title);
		tvTitle.setText("族族动态");
		TextView tvBack = (TextView)this.findViewById(R.id.tv_top_left);
		tvBack.setOnClickListener(this);
		EditText editText = (EditText)this.findViewById(R.id.et_common_post);
		if(status==0){
			editText.clearFocus();
		}
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
	}
	
}
