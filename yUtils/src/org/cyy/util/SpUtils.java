package org.cyy.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

/**
 * 
 * 说明：SharedPreferences，偏好设置工具
 *
 * @author yy_cai
 *
 * 2016年2月16日
 */
public class SpUtils {
	public final static String SP_ZGST_DEFAULT_FILE_NAME="zgst";
	/**
	 * 第一次启动存储一个偏好，每次都判断是否第一次启动
	 * 对第一次启动做针对性的处理
	 * @param ctx
	 * @return
	 */
	public static boolean isFirstStart(Context ctx){
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
		boolean first = prefs.getBoolean("first", true);
		if (first) {
			prefs.edit().putBoolean("first", false).commit();
			return true;
		}

		return false;
	}
	/**
	 * 存储List<String>到SharedPreferences
	 * @param context
	 * @param spFileName 
	 * @param key
	 * @param array
	 */
	public static void saveArray(Context context,String spFileName,String key,List<String> array) {
	    SharedPreferences prefs = context.getSharedPreferences(spFileName, Context.MODE_PRIVATE);
	    JSONArray jsonArray = new JSONArray();
	    for (String b : array) {
	      jsonArray.put(b);
	    }
	    SharedPreferences.Editor editor = prefs.edit();
	    editor.putString(key,jsonArray.toString());
	    editor.commit();
	  }
	/**
	 * 存储List<String>到SharedPreferences(默认存储文件名)
	 * @param context
	 * @param key
	 * @param array
	 */
	public static void saveArray(Context context,String key,List<String> array) {
		saveArray(context, SP_ZGST_DEFAULT_FILE_NAME, key, array);
	}
	/**
	 * 添加值到SharedPreferences的list中
	 * @param context
	 * @param spFileName sp文件名
	 * @param listKey 数据集的key
	 * @param value 欲添加到数据集的值
	 */
	public static void addValueToList(Context context,String spFileName,String listKey,String value){
		SharedPreferences prefs = context.getSharedPreferences(spFileName, Context.MODE_PRIVATE);
	    JSONArray jsonArray=null;
		try {
			jsonArray = new JSONArray(prefs.getString(listKey, "[]"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	    jsonArray.put(value);
	    SharedPreferences.Editor editor = prefs.edit();
	    editor.putString(listKey,jsonArray.toString());
	    editor.commit();
	}
	/**
	 * 添加值到SharedPreferences的list中(默认存储文件名)
	 * @param context
	 * @param spFileName sp文件名
	 * @param listKey 数据集的key
	 * @param value 欲添加到数据集的值
	 */
	public static void addValueToList(Context context,String listKey,String value){
		addValueToList(context, SP_ZGST_DEFAULT_FILE_NAME, listKey, value);
	}
	/**
	 * 从SharedPreferences的list中删除某值
	 * @param context
	 * @param spFileName
	 * @param listKey
	 * @param value
	 */
	public static void removeValueFromList(Context context,String spFileName,String listKey,String value){
		SharedPreferences prefs = context.getSharedPreferences(spFileName, Context.MODE_PRIVATE);
	    JSONArray jsonArray=null;
	    JSONArray newJsonArray = new JSONArray();
		try {
			jsonArray = new JSONArray(prefs.getString(listKey, "[]"));
			for (int i = 0; i < jsonArray.length(); i++) {
	        	if(!value.equals(jsonArray.getString(i))){
	        		newJsonArray.put(jsonArray.getString(i));
	        	}
	        }
		} catch (JSONException e) {
			e.printStackTrace();
		}
	    SharedPreferences.Editor editor = prefs.edit();
	    editor.putString(listKey,newJsonArray.toString());
	    editor.commit();
	}
	/**
	 * 从SharedPreferences的list中删除某值(默认存储文件名)
	 * @param context
	 * @param spFileName
	 * @param listKey
	 * @param value
	 */
	public static void removeValueFromList(Context context,String listKey,String value){
		removeValueFromList(context, SP_ZGST_DEFAULT_FILE_NAME, listKey, value);
	}
	/**
	 * 到SharedPreferences获取List<String>
	 * @param context
	 * @return
	 */
	public static List<String> getArray(Context context,String spFileName,String key)
	  {
	    SharedPreferences prefs = context.getSharedPreferences(spFileName, Context.MODE_PRIVATE);
	    List<String> array = new ArrayList<String>(); 
	    try {
	        JSONArray jsonArray = new JSONArray(prefs.getString(key, "[]"));
	        for (int i = 0; i < jsonArray.length(); i++) {
	        	array.add(jsonArray.getString(i));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return array;
	  }
	/**
	 * 到SharedPreferences获取List<String>(默认存储文件名)
	 * @param context
	 * @return
	 */
	public static List<String> getArray(Context context,String key){
		return getArray(context, SP_ZGST_DEFAULT_FILE_NAME, key);
	}
	
	/**
	 * 将List<map>存入sharedPreferences
	 * @param context
	 * @param key
	 * @param datas
	 */
	public static void saveInfo(Context context, String key, List<Map<String, String>> datas) {
	    JSONArray mJsonArray = new JSONArray();
	    for (int i = 0; i < datas.size(); i++) {
	        Map<String,String> itemMap = datas.get(i);
	        Iterator<Entry<String, String>> iterator = itemMap.entrySet().iterator();
	 
	        JSONObject object = new JSONObject();
	 
	        while (iterator.hasNext()) {
	            Entry<String, String> entry = iterator.next();
	            try {
	                object.put(entry.getKey(),entry.getValue());
	            } catch (JSONException e) {
	 
	            }
	        }
	        mJsonArray.put(object);
	    }
	 
	    SharedPreferences sp = context.getSharedPreferences("finals", Context.MODE_PRIVATE);
	    Editor editor = sp.edit();
	    editor.putString(key, mJsonArray.toString());
	    editor.commit();
	}
	/**
	 * 将List<map>从sharedPreferences取出
	 * @param context
	 * @param key
	 * @return
	 */
	public static List<Map<String, String>> getInfo(Context context, String key) {
	    List<Map<String, String>> datas = new ArrayList<Map<String, String>>();
	    SharedPreferences sp = context.getSharedPreferences("finals", Context.MODE_PRIVATE);
	    String result = sp.getString(key, "");
	    try {
	        JSONArray array = new JSONArray(result);
	        for (int i = 0; i < array.length(); i++) {
	            JSONObject itemObject = array.getJSONObject(i);
	            Map<String, String> itemMap = new HashMap<String, String>();
	            JSONArray names = itemObject.names();
	            if (names != null) {
	                for (int j = 0; j < names.length(); j++) {
	                    String name = names.getString(j);
	                    String value = itemObject.getString(name);
	                    itemMap.put(name, value);
	                }
	            }
	            datas.add(itemMap);
	        }
	    } catch (JSONException e) {
	 
	    }
	 
	    return datas;
	}
}
