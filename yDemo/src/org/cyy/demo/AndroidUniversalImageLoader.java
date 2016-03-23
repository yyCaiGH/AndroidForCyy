package org.cyy.demo;

import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

/**
 * 网络获取图片加载
 * @author Administrator
 *
 */
public class AndroidUniversalImageLoader {

	private static AndroidUniversalImageLoader instance = null;

	public synchronized static AndroidUniversalImageLoader getInstance() {
		if (instance == null) {
			instance = new AndroidUniversalImageLoader();
		}
		return instance;
	}
	
	private AndroidUniversalImageLoader() {
		if(options == null) {
			options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.ic_launcher)
				.showImageForEmptyUri(R.drawable.ic_launcher)
				.showImageOnFail(R.drawable.ic_launcher)
				.cacheInMemory(true)//内存缓存
				.cacheOnDisk(true)//sdcard缓存
				.considerExifParams(true)
				.displayer(new RoundedBitmapDisplayer(80))//图片圆角弧度
				.build();
		}
	}
	
	private static DisplayImageOptions options;
	
	public static void loadImage(String urlImage, ImageView imageView, DisplayImageOptions optionsSpec, SimpleImageLoadingListener simpleImageLoadingListener) {
		
		if(optionsSpec == null) {
			ImageLoader.getInstance().displayImage(urlImage, imageView, options, simpleImageLoadingListener);
		}
		else {
			ImageLoader.getInstance().displayImage(urlImage, imageView, optionsSpec, simpleImageLoadingListener);
		}
		
	}
}
