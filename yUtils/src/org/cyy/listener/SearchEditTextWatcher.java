package org.cyy.listener;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
/**
 * 
 * 说明：搜索EditText监听，更新数据
 * 
 * @author yy_cai
 *
 * 2016年2月2日
 */
public class SearchEditTextWatcher implements TextWatcher{

	private Handler handler;
	private Runnable mSearch;
	/**
	 * @param handler 外部处理适配器更新
	 * @param search 外部处理数据加载
	 */
	public SearchEditTextWatcher(Handler handler,Runnable search){
		this.handler=handler;
		this.mSearch=search;
	}
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		
	}

	@Override
	public void afterTextChanged(Editable s) {
		handler.removeCallbacks(mSearch);//第一次无消息该代码被忽略？？
		handler.post(mSearch);
		
	}

}
