package com.example.monitor;

import java.util.Arrays;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Log;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {



	@SuppressLint("NewApi")
	@Override
	public void onReceive(Context context, Intent intent) {
	

		Log.d("Saurav", "Broadcast Received:Give command adb shell am broadcast -a android.intent.action.PACKAGE_ADDED");
		// Toast.makeText(MainActivity.context, "Broadcast receiver", Toast.LENGTH_LONG).show();
		String installed_app;
		installed_app = intent.getData().toString();
		//Toast.makeText(MainActivity.context,"Installed App is:"+installed_app,Toast.LENGTH_LONG).show();





		//notification 
		NotificationCompat.Builder mBuilder =
				new NotificationCompat.Builder(context)
		.setSmallIcon(R.drawable.notification)
		.setAutoCancel(true)
		.setContentTitle("Monitor Alert")
		.setContentText("New Application installed");



		NotificationManager mNotificationManager = 
				(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
		// mId allows you to update the notification later on.
		mNotificationManager.notify(0, mBuilder.build());


		//code for fetching permission of individual app
		Log.d("Saurav", "Entering installed app permissions");
		PackageManager packmgr = /*MainActivity.*/context.getPackageManager();
		try {
			String packageName = intent.getData().toString().replace("package:", "");
			PackageInfo packageInfo =  packmgr.getPackageInfo(packageName, PackageManager.GET_PERMISSIONS);

			String[] array1= packageInfo.requestedPermissions;

			if(Arrays.asList(array1).contains("android.permission.CALL_PHONE") || Arrays.asList(array1).contains("android.permission.READ_CONTACTS"))
			{
				 // Toast.makeText(/*MainActivity.*/context,"Man This app is dangerous!",Toast.LENGTH_LONG).show();
				//  Intent intent1 = new Intent(/*MainActivity.*/context, warning.class);
				//  Log.d("Saurav", "Launched Intent");
			     // /*MainActivity.*/context.startActivity(intent1);
			      
			      Intent i=new Intent(context,warning.class);
			      i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			      context.startActivity(i);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}



	}
}