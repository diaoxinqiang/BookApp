package com.diaoxinqiang.bookapp.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
/*
 * ����û�����״��
 * û�������ʱ��,��ϵͳ�Դ������activity
 * ��ʽ��ͼ.
 */
public class NetWorkUtil {
public static void checkNetWork(final Activity activity){

	ConnectivityManager connectivityManager =(ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
	NetworkInfo info =connectivityManager.getActiveNetworkInfo();
	if(info==null){

		AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
		dialog.setTitle("û����·");
		dialog.setPositiveButton("设置网络", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {

				Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
				activity.startActivity(intent);
			}
		});
		dialog.setNegativeButton("取消", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		dialog.show();
	}
}
}
