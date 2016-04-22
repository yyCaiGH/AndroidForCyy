package org.cyy.demo.fragment;

import org.cyy.demo.R;
import org.cyy.demo.utils.ImageLoaderUtils;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class OneFragment extends Fragment{

	static String tag = "OneFragment";
	ImageView ivFace;
	TextView tv;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i(tag, "onCreateView");
		View view = inflater.inflate(R.layout.fragment_one, container,false);
		ivFace = (ImageView)view.findViewById(R.id.iv_face);
		String url = "http://d.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=603e37439313b07ebde8580c39e7bd15/a8014c086e061d9591b7875a7bf40ad163d9cadb.jpg";
		ImageLoaderUtils.getInstance().loadImage(url, ivFace, null, null);
		
		tv = (TextView)view.findViewById(R.id.textView1);
	        
		return view;
	}

	@Override
	public void onAttach(Activity activity) {
		Log.i(tag, "onAttach");
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i(tag, "onCreate");
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onStart() {
		Log.i(tag, "onStart");
		super.onStart();
	}

	@Override
	public void onResume() {
		Log.i(tag, "onResume");
		super.onResume();
	}

	@Override
	public void onPause() {
		Log.i(tag, "onPause");
		super.onPause();
		 Display My_Display=getActivity().getWindow().getWindowManager().getDefaultDisplay();
	        int Max_X=My_Display.getWidth();
	        int Max_Y=My_Display.getHeight();
	        
	        int[] locations = new int[2];
//	        ivFace.getLocationOnwin(locations);
	        tv.getLocationInWindow(locations);
	        int x = locations[0];//获取组件当前位置的横坐标
	        int y = locations[1];//获取组件当前位置的纵坐标
	        Log.i("System.out", "mx:"+Max_X+",my:"+Max_Y+"-----x:" + x + ",y:" + y);
	}

	@Override
	public void onStop() {
		Log.i(tag, "onStop");
		super.onStop();
	}

	@Override
	public void onDestroyView() {
		Log.i(tag, "onDestroyView");
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		Log.i(tag, "onDestroy");
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		Log.i(tag, "onDetach");
		super.onDetach();
	}

	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);
		if(isVisibleToUser){
			Log.i(tag, "可见");
		}else{
			Log.i(tag, "不可见");
		}
	}
}
