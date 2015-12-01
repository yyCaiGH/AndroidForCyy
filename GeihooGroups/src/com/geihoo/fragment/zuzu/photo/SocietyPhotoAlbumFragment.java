package com.geihoo.fragment.zuzu.photo;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.geihoo.activity.AlbumActivity;
import com.geihoo.adapter.CommonAdapter;
import com.geihoo.adapter.ViewHolder;
import com.geihoo.base.BaseFragment;
import com.geihoo.bean.AlbumBean;
import com.geihoo.dialog.CreateAlbumDialog;
import com.geihoo.groups.R;
import com.geihoo.test.Datas;
/**
 * 照片之创建相册
 * @author czz
 *
 */
public class SocietyPhotoAlbumFragment extends BaseFragment{
	private LinearLayout createNewAlbum;
	private ListView albumList;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_society_photo_album, container,false);
		initView(view);
		return view;
	}
	
	protected void initView(View view) {
		createNewAlbum=(LinearLayout) view.findViewById(R.id.createnewalbum);
		createNewAlbum.setOnClickListener(this);
		
		albumList = (ListView) view.findViewById(R.id.album_list_id);
		
		List<AlbumBean> list = Datas.getAlbums(getActivity());
		albumList.setAdapter(new CommonAdapter<AlbumBean>(getActivity(),list,R.layout.item_album_list) {
			@Override
			public void convert(ViewHolder helper, AlbumBean item) {
				helper.setImageBitmap(R.id.album_photo_iv_id, item.getImage());
				helper.setText(R.id.album_photo_name_id, item.getName());
				helper.setText(R.id.album_photo_numinfo_id, item.getNum()+"张照片");
			}
		});
		albumList.setOnItemClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.createnewalbum){
			new CreateAlbumDialog(getActivity()).show();		
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent = new Intent();
		intent.setClass(getActivity(), AlbumActivity.class);
		startActivity(intent);
	}
}
