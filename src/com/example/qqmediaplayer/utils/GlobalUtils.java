package com.example.qqmediaplayer.utils;

import android.R.integer;
import android.content.Context;
import android.view.WindowManager;

public class GlobalUtils {
	@SuppressWarnings("deprecation")
	public static int getHeight(Context c){
		WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
		return wm.getDefaultDisplay().getHeight();
	}
	public static int getWidth(Context c){
		WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
		return wm.getDefaultDisplay().getWidth();
	}
	
}
