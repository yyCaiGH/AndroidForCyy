package com.geihoo.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.geihoo.base.BaseActivity;
import com.geihoo.base.BaseFragment;
import com.geihoo.fragment.zuzu.file.SocietyDocumentAuthorFragment;
import com.geihoo.fragment.zuzu.file.SocietyDocumentTimeFragment;
import com.geihoo.fragment.zuzu.file.SocietyDocumentTypeFragment;
import com.geihoo.groups.R;

public class SocietyDocumentActivity extends BaseActivity {

	private TextView title,headLeft,headRight,orderByTime,orderByType,orderByAuthor;
	/**
	 * Fragment事务
	 */
	private FragmentTransaction ft;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_society_document);
		initView();
		
	}
	public void initView() {
		headLeft = (TextView)findViewById(R.id.tv_top_left);
		headLeft.setOnClickListener(this);
		title=(TextView)findViewById(R.id.tv_top_title);
		title.setText("族族文件");
		headRight = (TextView)findViewById(R.id.tv_top_right);
		headRight.setText("上传");
		headRight.setOnClickListener(this);
		
		orderByTime = (TextView)findViewById(R.id.tv_document_sort_time);
		orderByTime.setOnClickListener(this);
		orderByType = (TextView)findViewById(R.id.tv_document_sort_type);
		orderByType.setOnClickListener(this);
		orderByAuthor = (TextView)findViewById(R.id.tv_document_sort_author);
		orderByAuthor.setOnClickListener(this);
		
		SocietyDocumentTimeFragment societyDocumentTimeFragment = new SocietyDocumentTimeFragment();
		initFragment(societyDocumentTimeFragment, null);
	}
	/**
	 * 第一次加载Fragment不要将事务加进后台栈,防止后退出现空白的现象
	 */
	public void initFragment(BaseFragment f, Bundle bundle) {
		ft = getSupportFragmentManager().beginTransaction();
		ft.replace(R.id.fragment_society_document_id, f);
		f.setArguments(bundle);
		ft.commit();
	}
	private void changeColor(int i){
		if(i==0){
			orderByTime.setTextColor(getResources().getColor(R.color.headcolor));
			orderByType.setTextColor(getResources().getColor(R.color.black));
			orderByAuthor.setTextColor(getResources().getColor(R.color.black));
		}else if(i==1){
			orderByTime.setTextColor(getResources().getColor(R.color.black));
			orderByType.setTextColor(getResources().getColor(R.color.headcolor));
			orderByAuthor.setTextColor(getResources().getColor(R.color.black));
		}else if(i==2){
			orderByTime.setTextColor(getResources().getColor(R.color.black));
			orderByType.setTextColor(getResources().getColor(R.color.black));
			orderByAuthor.setTextColor(getResources().getColor(R.color.headcolor));
		}
	}
	@Override
	public void onClick(View v) {
		if(v==headLeft){
			this.finish();
		}else if(v==orderByTime){
			changeColor(0);
			SocietyDocumentTimeFragment societyDocumentTimeFragment = new SocietyDocumentTimeFragment();
			initFragment(societyDocumentTimeFragment, null);
		}else if(v==orderByType){
			changeColor(1);
			SocietyDocumentTypeFragment societyDocumentTypeFragment = new SocietyDocumentTypeFragment();
			initFragment(societyDocumentTypeFragment, null);
		}else if(v==orderByAuthor){
			changeColor(2);
			SocietyDocumentAuthorFragment societyDocumentAuthorFragment = new SocietyDocumentAuthorFragment();
			initFragment(societyDocumentAuthorFragment, null);
		}
	}
}
