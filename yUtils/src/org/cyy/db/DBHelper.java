/**
 * 
 */
package org.cyy.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

/**
 * 
 * 说明：创建数据库，数据初始化等操作
 *
 * @author yy_cai
 *
 * 2016年2月5日
 */
public class DBHelper extends SQLiteOpenHelper {
	
	private static final String DB_NAME="test.db";//数据库名称
	
	public DBHelper(Context context, int version){
		this(context, DB_NAME, null,version);
	}

	public DBHelper(Context context, String name, CursorFactory factory,int version) {
		super(context, name, factory, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		//创建表（如果是通过内容提供者提供给其他应用访问数据的话，主键字段名称必须是_id（有待考察））
		db.execSQL("create table tb_business (_id integer primary key autoincrement,description varchar(32),cmd varchar(8),busid varchar(8),url varchar(100),dynamic varchar(100),method varchar(8),needmac varchar(8))");
		//插入表数据操作（可选）
		
		Log.v("PAYMENT", "db create and initialize ok!");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//删除数据表
		db.execSQL("drop table tb_business");
		//重建数据表
		this.onCreate(db);
		
		Log.v("PAYMENT", "db recreate and upgrade ok!");

	}

}
