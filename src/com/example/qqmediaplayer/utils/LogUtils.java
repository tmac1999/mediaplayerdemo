/**    
 * @Title: Logger.java  
 * @Package com.im_cmcc.common.utils
 */
package com.example.qqmediaplayer.utils;

import android.util.Log;


/**
 * @ClassName: Logger
 * @Description: Log工具类，便于发布版本时关闭log输出
 * @author WQ
 * @date 2014-4-30 下午3:57:01
 */
public class LogUtils {
	private static boolean debug = Constants.DEBUG_FLAG;

	public static void d(String tag, String msg) {
		if (debug)
			Log.d(tag, msg);
	}

	public static void e(String tag, String msg) {
		if (debug)
			Log.e(tag, msg);
	}

	public static void e(String tag, String msg, Throwable tr) {
		if (debug)
			Log.e(tag, msg, tr);
	}

	public static void i(String tag, Object msg) {
		if (debug)
			Log.i(tag, msg.toString());
	}

	public static void i(String tag, String msg) {
		if (debug)
			Log.i(tag, msg);
	}

	public static void v(String tag, String msg) {
		if (debug)
			Log.v(tag, msg);
	}

	public static void w(String tag, String msg) {
		if (debug)
			Log.w(tag, msg);
	}
	
	public static void system_print (String msg){
		if(debug)
			System.out.println(msg);
	}
	
	public static void system_print (Object msg){
		if(debug)
			System.out.println(msg.toString());
	}
}
