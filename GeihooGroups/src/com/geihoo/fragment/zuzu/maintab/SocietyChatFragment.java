package com.geihoo.fragment.zuzu.maintab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geihoo.base.BaseFragment;
import com.geihoo.groups.R;
/**
 * 通知
 * @author yy_cai
 *
 * 2015年7月16日
 */
public class SocietyChatFragment extends BaseFragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_society_chat, container,false);
		return view;
	}
}
