package org.cyy.demo.utils;

import org.cyy.demo.R;
import org.cyy.demo.R.drawable;

import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

/**
 * 网络获取图片加载
 * @author cyy
 *
 */
public class ImageLoaderUtils {

	private static ImageLoaderUtils instance = null;

	private static DisplayImageOptions options;
	
	public synchronized static ImageLoaderUtils getInstance() {
		if (instance == null) {
			instance = new ImageLoaderUtils();
		}
		return instance;
	}
	private ImageLoaderUtils() {
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
	
	public static void loadImage(String imageUrl, ImageView imageView) {
		ImageLoader.getInstance().displayImage(imageUrl, imageView, options,
				null);
	}

	public static void loadImage(String imageUrl, ImageView imageView,
			DisplayImageOptions optionsSpec) {
		ImageLoader.getInstance().displayImage(imageUrl, imageView,
				optionsSpec, null);
	}

	public static void loadImage(String imageUrl, ImageView imageView,
			SimpleImageLoadingListener simpleImageLoadingListener) {
		ImageLoader.getInstance().displayImage(imageUrl, imageView, options,
				simpleImageLoadingListener);
	}

	public static void loadImage(String imageUrl, ImageView imageView,
			DisplayImageOptions optionsSpec,
			SimpleImageLoadingListener simpleImageLoadingListener) {

		ImageLoader.getInstance().displayImage(imageUrl, imageView,
				optionsSpec, simpleImageLoadingListener);

	}
}
