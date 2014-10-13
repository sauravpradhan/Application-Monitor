package com.example.monitor;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


@SuppressLint("NewApi")
public class MainActivity extends Activity {
	public static Context context;

	public void onCreate(Bundle savedInstanceState)
	{
			context = getApplicationContext();
		   super.onCreate(savedInstanceState);
	       setContentView(R.layout.activity_main);
	       DisplayTabs();
	}
	
	public void DisplayTabs()
	{
	    final ActionBar actionBar = getActionBar();

	    // Specify that tabs should be displayed in the action bar.
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

	    
	    MyTabListener tabListener = new MyTabListener() ;
	    
	 
	        actionBar.addTab(
	                actionBar.newTab()
	                        .setText("Costs Money" )
	                        .setTabListener(tabListener));
	        actionBar.addTab(
	                actionBar.newTab()
	                        .setText("Private Data" )
	                        .setTabListener(tabListener));
	        actionBar.addTab(
	                actionBar.newTab()
	                        .setText("Normal" )
	                        .setTabListener(tabListener));
	 

	}
	
//	public void uninstallApp (Uri packageURI) {
////       Intent uninstallIntent = new Intent(Intent.ACTION_UNINSTALL_PACKAGE, packageURI);
//       Intent uninstallIntent = new Intent("android.intent.action.DELETE");
//       uninstallIntent.setData(Uri.parse("package:com.example.monitor"));
//       startActivity(uninstallIntent);
//	}

	
	
}