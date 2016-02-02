package org.cyy.util;

import java.io.File;

import android.content.Context;
import android.os.Environment;

/**
 * 
 * 说明：文件夹工具
 *
 * @author yy_cai
 *
 * 2016年2月3日
 */
public class FileUtils {

	/**

     * 获取缓存文件

     */

     public static File getDiskCacheFile(Context context,String filename,boolean isExternal) {

        if(isExternal && (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))) {

            return new File(context.getExternalCacheDir(),filename);

        }else {

            return new File(context.getCacheDir(),filename);

        }

    }

 

    /**

     * 获取缓存文件目录

     */

     public static File getDiskCacheDirectory(Context context) {

        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {

            return context.getExternalCacheDir();

        }else {

            return context.getCacheDir();

        }

    }

}
