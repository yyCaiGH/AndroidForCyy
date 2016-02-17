package org.cyy.demo.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

public class SearchFileFromSDcard {
	/*
	 * searchFile 查找文件并加入到ArrayList 当中去
	 * 
	 * @String keyword 查找的关键词
	 * 
	 * @File filepath 查找的目录
	 */
	public static List<HashMap<String,String>> searchFile(Context context, File filepath) {

		// 判断SD卡是否存在
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			File[] files = filepath.listFiles();
			
			if (files.length > 0) {
				List<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
				HashMap map=null;
				for (File file : files) {
					Log.d("cyy-cyy", file.getName());
					map=new HashMap();
					map.put("music", file.getName());
					list.add(map);
//					if (file.isDirectory()) {
//						// 如果目录可读就执行（一定要加，不然会挂掉）
//						if (file.canRead()) {
//							searchFile(keyword, file); // 如果是目录，递归查找
//						}
//					} else {
//						// 判断是文件，则进行文件名判断
//						try {
//							if (file.getName().indexOf(keyword) > -1
//									|| file.getName().indexOf(
//											keyword.toUpperCase()) > -1) {
//								rowItem = new HashMap<String, Object>();
//								rowItem.put("number", index); // 加入序列号
//								rowItem.put("bookName", file.getName());// 加入名称
//								rowItem.put("path", file.getPath()); // 加入路径
//								rowItem.put("size", file.length()); // 加入文件大小
//								bookList.add(rowItem);
//								index++;
//							}
//						} catch (Exception e) {
////							Toast.makeText(this, "查找发生错误", Toast.LENGTH_SHORT)
////									.show();
//						}
//					}
				}
				return list;
			}
			else{
				Toast.makeText(context, "没有找到文件", Toast.LENGTH_SHORT).show();
				
			}
			
		}
		return null;
	}
}
