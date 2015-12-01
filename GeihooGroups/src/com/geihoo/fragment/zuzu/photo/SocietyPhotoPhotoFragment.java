package com.geihoo.fragment.zuzu.photo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.TextView;

import com.geihoo.base.BaseFragment;
import com.geihoo.groups.R;
/**
 * 照片之照片查询
 * @author czz
 *
 */
public class SocietyPhotoPhotoFragment extends BaseFragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_society_photo_photo, container,false);

		return view;
	}

}
