package org.cyy.util;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * 
 * 说明：键盘操作
 *
 * @author yy_cai
 *
 * 2016年2月2日
 */
public class KeyBoardUtil {

	private KeyBoardUtil(){

        throw new UnsupportedOperationException("KeyBoardUtil cannot be instantiated");

    }

    /**

     * 打卡软键盘

     */

    public static void openKeybord(EditText mEditText, Context mContext){

        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);

        imm.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN);

        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);

    }

    /**

     * 关闭软键盘

     */

    public static void closeKeybord(EditText mEditText, Context mContext) {

        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);

        imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);

    }

    /**
     * 打开键盘.无EditText
     *
     * @param context the context
     */
    public static void showSoftInput(Context context){
        InputMethodManager inputMethodManager = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }
    /**
     * 关闭键盘事件.无EditText
     *
     * @param context the context
     */
    public static void closeSoftInput(Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager)context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null && ((Activity)context).getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(((Activity)context).getCurrentFocus()
                    .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
