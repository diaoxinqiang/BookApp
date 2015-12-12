package com.diaoxinqiang.bookapp.utils;

import android.content.Context;

public class DisplayUtils {
	/*
	 * ��spת��px
	 */
public static int dp2px(Context context,float dp){
	//metrics  scale �ܶ�  density
	
	// mdpi : 160:1  320*480   ; hdpi: 240:1.5  480*800 ; xhdpi 720*1280 320:2   xxhdpi: 1080*1980 480:3  
	float scaledDensity =context.getResources().getDisplayMetrics().scaledDensity;
	return (int) (dp*scaledDensity+0.5f);//
}
public static int px2dp(Context context,float sp){
	//metrics  scale �ܶ�  density
	
	// mdpi : 160:1  320*480   ; hdpi: 240:1.5  480*800 ; xhdpi 720*1280 320:2   xxhdpi: 1080*1980 480:3  
	float scaledDensity =context.getResources().getDisplayMetrics().scaledDensity;
	return (int) (sp/(scaledDensity+0.5f));//
}
}
