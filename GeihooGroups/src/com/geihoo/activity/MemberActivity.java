package com.geihoo.activity;

import java.util.ArrayList;
import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.geihoo.adapter.FragmentAdapter;
import com.geihoo.base.BaseActivity;
import com.geihoo.dialog.AddMemberDialog;
import com.geihoo.fragment.zuzu.member.BlacklistFragment;
import com.geihoo.fragment.zuzu.member.ManagerFragment;
import com.geihoo.fragment.zuzu.member.MemberFragment;
import com.geihoo.fragment.zuzu.photo.SocietyPhotoAlbumFragment;
import com.geihoo.fragment.zuzu.photo.SocietyPhotoPhotoFragment;
import com.geihoo.groups.R;
/**
 * 会员
 * @author czz
 *
 * 2015年7月22日
 */
public class MemberActivity extends BaseActivity{
	private RadioGroup member;
	private ViewPager viewPager;
	private TextView title,rightHead,leftHead;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_member);
		initView();
	}

	@Override
	protected void initView() {
		member=(RadioGroup) this.findViewById(R.id.rg_member);
		viewPager = (ViewPager) this.findViewById(R.id.member_viewpager);  
		title=(TextView) this.findViewById(R.id.tv_top_title);
		rightHead=(TextView) this.findViewById(R.id.tv_top_right);
		leftHead=(TextView) this.findViewById(R.id.tv_top_left);
		leftHead.setOnClickListener(this);
		//设置头部图标
		title.setText("成员资格");
		
		Drawable drawable=getResources().getDrawable(R.drawable.top_add_image);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
		rightHead.setCompoundDrawables(drawable, null,null,null);
		
		List<Fragment> fragments = new ArrayList<Fragment>();
		fragments.add(new MemberFragment());
		fragments.add(new ManagerFragment());
		fragments.add(new BlacklistFragment());
		
		
		
		viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),fragments));  

		member.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				
				if(R.id.rb_member==arg1){
					viewPager.setCurrentItem(0,false);
				}else if(R.id.rb_manager==arg1){
					viewPager.setCurrentItem(1,false);
				}else{
					viewPager.setCurrentItem(2,false);
				}
			}
		});
		
		rightHead.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new AddMemberDialog(MemberActivity.this).show();
			}
		});
	}
	@Override
	public void onClick(View v) {
		if(v ==leftHead){
			this.finish();
		}
	}
}
