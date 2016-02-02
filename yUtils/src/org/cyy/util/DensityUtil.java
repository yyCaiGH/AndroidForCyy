package org.cyy.util;

import android.content.Context;
import android.util.TypedValue;
/**
 * 
 * 说明：像素单位转换
 *
 * @author yy_cai
 *
 * 2016年2月2日
 */
public class DensityUtil {

	private DensityUtil() {

        throw new UnsupportedOperationException("DensityUtil cannot be instantiated");

    }

    public static int dip2px(Context context,int dipValue) {

        final float scale = context.getResources().getDisplayMetrics().density;

        return (int)(dipValue*scale + 0.5f);

    }

    public static int px2dip(Context context,float pxValue) {

        final float scale = context.getResources().getDisplayMetrics().density;

        return (int)(pxValue/scale + 0.5f);

    }

    public static float px2sp(Context context, float pxValue){

        return (pxValue / context.getResources().getDisplayMetrics().scaledDensity);

    }

    public static int sp2px(Context context, int spValue){

        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,

                spValue, context.getResources().getDisplayMetrics());

    }
}
