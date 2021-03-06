package com.geihoo.listener;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
/**
 * 
 * 说明：搜索更新适配器
 * 
 * @author yy_cai
 *
 * 2016年2月2日
 */
public class SearchEditTextWatcher implements TextWatcher{

	private Handler handler;
	private Runnable mSearch;
	/**
	 * @param handler
	 * @param search
	 */
	public SearchEditTextWatcher(Handler handler,Runnable search){
		this.handler=handler;
		this.mSearch=search;
	}
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterTextChanged(Editable s) {
		handler.removeCallbacks(mSearch);//第一次无消息该代码被忽略？？
		handler.post(mSearch);
		
	}

}
