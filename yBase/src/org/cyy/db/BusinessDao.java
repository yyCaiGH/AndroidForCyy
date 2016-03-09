package org.cyy.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * 
 * 说明：业务dao（Demo举例）
 *
 * @author yy_cai
 *
 * 2016年2月5日
 */
public class BusinessDao {

	
	private static final String TAG = "BusinessDao";

	private DBHelper helper;

	public BusinessDao(Context ctx) {
		helper = new DBHelper(ctx, 1);
	}

	/**
	 * 增加业务
	 * @param business
	 */
	public void addBusiness(ContentValues  business) {

		SQLiteDatabase db = helper.getWritableDatabase();
		db.insert("tb_business", null, business);
		db.close();
	}

	/**
	 * 查询所有信息
	 * @param columns
	 * @param whereStr
	 * @param whereArgs
	 * @param order
	 * @return
	 */
	public Cursor query(String[] columns,String whereStr,String[] whereArgs, String order) {

		SQLiteDatabase db = helper.getReadableDatabase();
		return db.query("tb_business", columns, whereStr, whereArgs, null, null, order);
	}
	
	/**
	 * 删除业务
	 * @param whereClause
	 * @param whereArgs
	 */
	public int deleteBusiness(String whereClause, String[] whereArgs){
		SQLiteDatabase db=helper.getWritableDatabase();
		return db.delete("tb_business", whereClause, whereArgs);
	}
	/**
	 * 更新业务
	 * @param values
	 * @param whereClause
	 * @param whereArgs
	 * @return
	 */
	public int updateBusiness(ContentValues values, String whereClause, String[] whereArgs){
		SQLiteDatabase db=helper.getWritableDatabase();
		return db.update("tb_business", values, whereClause, whereArgs);
	}
	
	
	


}
