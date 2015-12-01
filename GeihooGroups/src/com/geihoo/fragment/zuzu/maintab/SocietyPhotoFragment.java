package com.geihoo.fragment.zuzu.maintab;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.geihoo.activity.MainTabActivity;
import com.geihoo.activity.SocietyMainActivity;
import com.geihoo.adapter.FragmentAdapter;
import com.geihoo.base.BaseFragment;
import com.geihoo.dialog.CreateAlbumDialog;
import com.geihoo.fragment.zuzu.photo.SocietyPhotoAlbumFragment;
import com.geihoo.fragment.zuzu.photo.SocietyPhotoPhotoFragment;
import com.geihoo.groups.R;
import com.geihoo.listener.MyOnPageChangeListener;
/**
 * 
 * 照片模块（照片，相册）
 * 
 * @author czz
 *
 */
public class SocietyPhotoFragment extends BaseFragment{
	private ViewPager viewPager; 
	private SocietyMainActivity activity;
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		this.activity=(SocietyMainActivity)activity;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_society_photo, container,false);
		
		initTvBackTopBar(view, "照片");
		
		RadioGroup rg=(RadioGroup) view.findViewById(R.id.rg_photo);
		
		List<Fragment> fragments = new ArrayList<Fragment>();
		fragments.add(new SocietyPhotoPhotoFragment());
		fragments.add(new SocietyPhotoAlbumFragment());
		
		viewPager = (ViewPager) view.findViewById(R.id.search_viewpager);  
		
		viewPager.setAdapter(new FragmentAdapter(getChildFragmentManager(),fragments));  

		viewPager.setOnPageChangeListener(new MyOnPageChangeListener(activity,viewPager,rg,null,null));
		return view;
	}
	@Override
	protected void initTvBackTopBar(View view, String title) {
		super.initTvBackTopBar(view, title);
		TextView headRight=(TextView) view.findViewById(R.id.tv_top_right);
		Drawable drawable=getResources().getDrawable(R.drawable.top_add_image);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
		headRight.setCompoundDrawables(drawable, null, null,null);
		headRight.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		super.onClick(v);
		if(v.getId()==R.id.tv_top_right){
			//创建相册监听
			new CreateAlbumDialog(activity).show();	
		}
	}
}
