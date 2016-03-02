package org.cyy.util;

import java.io.File;
import java.io.IOException;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;

/**
 * 
 * 说明：文件夹工具
 * 
 * @author yy_cai
 * 
 *         2016年2月3日
 */
public class FileUtils {

	private static AssetManager am;

	/**
	 * 获取sd卡的路径
	 * 
	 * @return
	 */
	public static String getSDPath() {
		if (isSdCardExit()) {
			return Environment.getExternalStorageDirectory().toString();
		}
		return null;
	}

	/**
	 * sd卡是否可用
	 * 
	 * @return
	 */
	public static boolean isSdCardExit() {
		return Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED);
	}

	/**
	 * 
	 * 获取缓存文件
	 */

	public static File getDiskCacheFile(Context context, String filename,
			boolean isExternal) {

		if (isExternal
				&& (Environment.getExternalStorageState()
						.equals(Environment.MEDIA_MOUNTED))) {

			return new File(context.getExternalCacheDir(), filename);// sd卡缓存路径下的文件

		} else {

			return new File(context.getCacheDir(), filename);// 应用内缓存路径下的文件

		}

	}

	/**
	 * 
	 * 获取缓存文件目录
	 */

	public static File getDiskCacheDirectory(Context context) {

		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {

			return context.getExternalCacheDir();// sd卡缓存路径

		} else {

			return context.getCacheDir();// 应用内缓存路径

		}

	}

	/**
	 * 创建目录，已经存在就不创建
	 * 
	 * @param path
	 *            目录路径
	 */
	public static File createDirectory(String path) {
		File file = new File(path);
		if (!file.exists() && !file.isDirectory()){
			file.mkdir();
		}
		return file;
	}

	/**
	 * 创建文件，如果文件已经存在，则删除，在创建。相当于覆盖
	 * 
	 * @param directory
	 *            文件目录
	 * @param fileName
	 *            文件名
	 * @return
	 */
	public static File createFile(File directory, String fileName) {
		File tempFile = new File(directory, fileName);
		if (tempFile.exists()){
			tempFile.delete();
		}
		try {
			tempFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tempFile;
	}
	
	/**
	 * 根据目录和文件名称获取文件
	 * @param directory
	 * @param fileName
	 * @return
	 */
	public static File getFile(File directory, String fileName) {
		File tempFile = new File(directory, fileName);
		if (tempFile.exists()){
			return tempFile;
		}
		else{
			return null;
		}
	}
	/**
	 * 根据文件的路径获取文件
	 * @param filePath 文件的具体路径
	 * @return
	 */
	public static File getFile(String filePath) {
		File tempFile = new File(filePath);
		if (tempFile.exists()){
			return tempFile;
		}
		else{
			return null;
		}
	}
}
