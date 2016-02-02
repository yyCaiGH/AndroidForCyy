package org.cyy.provide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cyy.util.Logger;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
/**
 * 
 * 说明：（Demo举例）一般在其他应用中才需要该类
 * 通过ContentResolver访问内容提供者提供的数据
 * 
 * 补充：通过ContentObserver——内容观察者，可以观察(捕捉)特定Uri引起的数据库的变化，继而及时做一些相应的处理
 * @author yy_cai
 *
 * 2016年2月5日
 */
public class GetBusinessByContentResolver {

	private final static String TAG = "GetDateByContentResolver";
	private Context ctx;
	public GetBusinessByContentResolver(Context c){
		ctx=c;
	}
	
	/**
	 * 添加business
	 * @param cv
	 */
	public void insertBusiness(ContentValues cv) {
		Logger.i(TAG, "insertBusiness"+cv);
		if (null == cv)
			return;
		ContentResolver cr = ctx.getContentResolver();
		cr.insert(Uri.parse("content://com.xino.kdb.businessprovider/business"), cv); 
	}
	
	public List<Map<String, Object>> getAllBusiness() {
		return getAllBusiness(new ArrayList<Map<String, Object>>());
	}
	
	
	
	/**
	 * 获得所有的business信息
	 * @param l:数据源
	 * @param 
	 * @return
	 */
	public List<Map<String, Object>> getAllBusiness(List<Map<String, Object>> l) {
		l.clear();
		ContentResolver cr = ctx.getContentResolver();
		Cursor cur = cr.query(Uri.parse("content://com.xino.kdb.businessprovider/business"), null, null, null, null);
		Map<String, Object> m;
		while (cur.moveToNext()) {
			m = new HashMap<String, Object>();
			l.add(m);
			//需要知道表的字段名，或者cur.getColumnName(0)，可以获取第一个字段的字段名
			m.put("description", cur.getString(cur.getColumnIndex("description")));
			m.put("cmd", cur.getString(cur.getColumnIndex("cmd")));
			m.put("busid", cur.getString(cur.getColumnIndex("busid")));
			m.put("url", cur.getString(cur.getColumnIndex("url")));
			m.put("method", cur.getString(cur.getColumnIndex("method")));
			m.put("needmac", cur.getString(cur.getColumnIndex("needmac")));
			m.put("dynamic", cur.getString(cur.getColumnIndex("dynamic")));
		}
		Logger.i(TAG, l.toString());
		if(cur!=null)
			cur.close();//添加
		return l;
	}
	public List<Map<String,Object>> getQueryData(List<Map<String, Object>> list,String queryStr){
		Logger.i(TAG, "getQueryData");
		list.clear();
		ContentResolver cr = ctx.getContentResolver();
		Cursor cur = cr.query(Uri.parse("content://com.xino.kdb.businessprovider/business"), null, "description like ?", new String[]{"%"+queryStr+"%"}, null);
		Map<String, Object> m;
		while (cur.moveToNext()) {
			m = new HashMap<String, Object>();
			list.add(m);
			m.put("description", cur.getString(cur.getColumnIndex("description")));
			m.put("cmd", cur.getString(cur.getColumnIndex("cmd")));
			m.put("busid", cur.getString(cur.getColumnIndex("busid")));
			m.put("url", cur.getString(cur.getColumnIndex("url")));
			m.put("method", cur.getString(cur.getColumnIndex("method")));
			m.put("needmac", cur.getString(cur.getColumnIndex("needmac")));
			m.put("dynamic", cur.getString(cur.getColumnIndex("dynamic")));
		}
		Logger.i(TAG, list.toString());
		if(cur!=null)
			cur.close();//添加
		return list;
	}
	/**
	 * 获取所有的cmd
	 * @return
	 */
	public List<String> getAllCmd(){
		ContentResolver cr = ctx.getContentResolver();
		List<String> list=new ArrayList<String>();
		Cursor cur = cr.query(Uri.parse("content://com.xino.kdb.businessprovider/business"), new String[]{"cmd"}, null, null, null);
		while (cur.moveToNext()) {
			list.add(cur.getString(cur.getColumnIndex("cmd")));
		}
		return list;
	}
	/**
	 * 删除业务
	 * @param cmd
	 */
	public void deleteBusiness(String cmd){
		ContentResolver cr = ctx.getContentResolver();
		cr.delete(Uri.parse("content://com.xino.kdb.businessprovider/business"), "cmd=?", new String[]{cmd});
	}
	/**
	 * 更新业务
	 */
	public void updateBusiness(ContentValues cv,String cmd){
		ContentResolver cr = ctx.getContentResolver();
		cr.update(Uri.parse("content://com.xino.kdb.businessprovider/business"), cv, "cmd=?", new String[]{cmd});
	}
	
	
}
