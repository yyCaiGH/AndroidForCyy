package org.cyy.provide;

import org.cyy.db.BusinessDao;
import org.cyy.util.Logger;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
/**
 * 
 * 说明：（Demo举例）
 * 业务内容提供者，提供给其他应用一个统一的访问该业务数据库的方式
 * 通过内容提供者提供给其他应用访问数据库的话，主键字段名称必须是_id（有待考察）
 * 不仅仅可以操作数据库，也可以操作文件，网络数据，转化为Cursor对象即可
 * 需要在AndroidManifest.xml文件中注册该提供者
 * <provider
            android:name="org.cyy.provide.BusinessContentProvider"
            android:authorities="com.xino.kdb.businessprovider"
            android:exported="true" />
            
 * @author yy_cai
 *
 * 2016年2月5日
 */
public class BusinessContentProvider extends ContentProvider {

	private final static String TAG = "BusinessContentProvider";
	private UriMatcher matcher = null;
	private BusinessDao dao = null;

	@Override
	public boolean onCreate() {
		Logger.i(TAG, "onCreate");
		dao = new BusinessDao(getContext());
		matcher = new UriMatcher(UriMatcher.NO_MATCH);
		matcher.addURI("com.xino.kdb.businessprovider", "business", 1);
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
		Logger.i(TAG, "query");
		Cursor cursor = null;
		switch (matcher.match(uri)) {
		case 1:
			cursor = dao.query(projection, selection, selectionArgs, sortOrder);
			break;
		default:
			throw new IllegalArgumentException("无法解析的URI");
		}
		return cursor;
	}

	@Override
	public String getType(Uri uri) {
		switch (matcher.match(uri)) {
		case 1:
			return "vnd.android.cursor.dir/student";
		default:
			throw new IllegalArgumentException("无法解析的URI");
		}
	}

	@Override
	public Uri insert(Uri uri, ContentValues cv) {
		Logger.i(TAG, "insert");
		switch (matcher.match(uri)) {
		case 1:
			dao.addBusiness(cv);
			getContext().getContentResolver().notifyChange(uri, null);
			break;
		default:
			throw new IllegalArgumentException("无法解析的URI");
		}
		return uri;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		
		return dao.deleteBusiness(selection,selectionArgs);
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		return dao.updateBusiness(values, selection, selectionArgs);
	}

}
