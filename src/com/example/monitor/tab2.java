package com.example.monitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.R.mipmap;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class tab2 extends ListFragment{ 
	 
	
	//variables 
	  //code to fetch installed applications 
	  int j;
	  ArrayList<String> app_name1 = new ArrayList<String>();
	  ArrayList<String> package_name = new ArrayList<String>();
	  ApplicationInfo appinfo = MainActivity.context.getApplicationInfo();
	  PackageManager packmgr = MainActivity.context.getPackageManager();
	  List<ApplicationInfo> installed_apps = packmgr.getInstalledApplications(PackageManager.GET_PERMISSIONS | 
            PackageManager.GET_META_DATA);
	  //code to fetch permissions
	  PackageInfo pinfo = new PackageInfo();
	  
	
	  //Code just to know the size of permissions
	  List<PackageInfo> packs = packmgr.getInstalledPackages(PackageManager.GET_PERMISSIONS);
	  
	  
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
		 int x=0;
		 int z=0;
		
	  /*
	  ApplicationInfo appinfo = null;
	  StringBuffer appNameAndPermissions=new StringBuffer();
	  PackageManager p = MainActivity.context.getPackageManager(); 
	 // PackageInfo pinfo = new PackageInfo();
	  
	  List<PackageInfo> packs = p.getInstalledPackages(PackageManager.GET_PERMISSIONS);
	  
	  List appinstall = p.getInstalledApplications(PackageManager.GET_PERMISSIONS | 
              PackageManager.GET_META_DATA);//PackageManager.GET_META_DATA);
	  
	
	  
	  //List<PackageInfo> perm = MainActivity.context.getPackageManager().getInstalledPackages(PackageManager.GET_PERMISSIONS); 
	  StringBuffer permissions=new StringBuffer();
	  String app_name[] = new String[appinstall.size()];
	 // String app_perm[] = new String[perm.size()];
	  
	
	 // Log.d("Saurav", "Appinstall size is"+appinstall.size()+"Permission Array Size"+perm.size());
	  
	  for(int i=0; i<appinstall.size() ; i++)
	  { 
		//code for fetching permission  
		 
		
	
			//PackageInfo packageInfo = p.getPackageInfo(packageInfo.packageName, PackageManager.GET_PERMISSIONS);
				for(int j=0;j<packs.size();j++)
				{
				
				PackageInfo pi = packs.get(j);
				
				String[] reqPer = pi.requestedPermissions;
				if(reqPer != null) {
					 for (int k = 0; k < reqPer.length; k++) {
				//Toast.makeText(MainActivity.context, "Permission"+reqPer[j], Toast.LENGTH_SHORT);
					 }

				}
				// TODO Auto-generated catch block
		
         
		  
				app_name[i] = p.getApplicationLabel((ApplicationInfo) appinstall.get(i)).toString();	
				}
		//PackageInfo packageInfo = MainActivity.context.getPackageManager().getPackageInfo(app_name[i], PackageManager.GET_PERMISSIONS);
			 
	  ListAdapter listAdapter = new ArrayAdapter(MainActivity.context, android.R.layout.simple_list_item_1, app_name);
	  setListAdapter(listAdapter);
	 }
	 */
	  
	
	  String app_name[] = new String[installed_apps.size()];
	  
	  
	  String app_perm[] = new String[packs.size()];
	  
	  Log.d("Saurav", "Pack size is:"+installed_apps.size());
	//  for(int i=0;i<installed_apps.size();i++)
	//  {  
		  
	  try {
		  Log.d("Saurav", "Test Try Start"+packs.size());
			PackageInfo packageInfo =  packmgr.getPackageInfo(appinfo.packageName, PackageManager.GET_PERMISSIONS);
			 for(j=0;j<packs.size();j++)
			  {
				  	
				  	packageInfo = packs.get(j);
					Log.d("Saurav","PackageInfo"+Arrays.toString(packageInfo.requestedPermissions));
					//List<String> perm =  Arrays.asList(packageInfo.requestedPermissions);
					ArrayList<String> list = new ArrayList<String>();
					String[] array1= packageInfo.requestedPermissions;
					if(array1 != null)
					{
						
						//List<String> perm =  Arrays.asList(packageInfo.requestedPermissions);
						//z++;
						if(Arrays.asList(array1).contains("android.permission.USE_CREDENTIALS")
								|| Arrays.asList(array1).contains("com.android.email.permission.READ_ATTACHMENT"))
								//&& Arrays.asList(array1).contains("android.permission.SEND_SMS"))
								//&& perm.contains("android.permission.RECEIVE_EMERGENCY_BROADCAST")
								//&& perm.contains("android.permission.INTERNET")
								//&& perm.contains("android.permission.GET_ACCOUNTS")
								//&& perm.contains("android.permission.ACCESS_NETWORK_STATE")
								//&& perm.contains("android.permission.WRITE_EXTERNAL_STORAGE"))
						{
							//Log.d("Saurav", "The ArrayList now points to:"+packmgr.getApplicationLabel(installed_apps.get(j)).toString().contains("com"));
							if(!(packmgr.getApplicationLabel(installed_apps.get(j)).toString().contains("com")))
							{
								app_name1.add(packmgr.getApplicationLabel(installed_apps.get(j)).toString());
								package_name.add(installed_apps.get(j).toString());	
							}
							Log.d("Saurav","Apps to be added is:"+app_name[j]);
							x++;
						}
						
					}
					
					//String[] perm_without_null = (packageInfo.requestedPermissions);
					
					//if(perm.contains("android.permission.SEND_SMS"))
					//{	
					//app_name[i] = packmgr.getApplicationLabel(installed_apps.get(i)).toString();
					//}
			 
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 // }
	  Log.d("Saurav","Val X:"+x+"z:"+z);
	  //filling the name of aplication installed
	  /*
	  for(int i=0;i<installed_apps.size();i++)
	  {
		  app_name[i] = packmgr.getApplicationLabel(installed_apps.get(i)).toString();
	  }
	  */
	  ListAdapter listAdapter = new ArrayAdapter(MainActivity.context, android.R.layout.simple_list_item_1, app_name1);
	  setListAdapter(listAdapter);
	  
	 }
	 @Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	  return inflater.inflate(R.layout.tab1_view, container, false);
	 }
	 
	 @Override
	 public void onListItemClick(ListView list, View v, int position, long id) {
		
		
		Toast.makeText(getActivity(), getListView().getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
		// Toast.makeText(getActivity(), "package:com."+getListView().getItemAtPosition(position).toString().toLowerCase(), Toast.LENGTH_LONG).show();
		 
		//Uri packageURI = Uri.parse(packs.get(position).toString());
		String packagename = (package_name.get(position)).substring(25, (package_name.get(position)).length()-1);
		//Uri packageURI = Uri.parse("package:"+packagename);
		//Uri packageURI = Uri.parse(app_name1.get(position).toString());
		Log.d("Saurav","PackageName:"+packagename+" "+package_name.get(position)/*(package_name.get(position)).substring(25, (package_name.get(position)).length()-1)*/);
        //Intent uninstallIntent = new Intent(Intent.ACTION_UNINSTALL_PACKAGE, packageURI);
        //Intent uninstallIntent= new Intent();
        //startActivity(uninstallIntent);
        //Intent uninstallIntent = new Intent(Intent.ACTION_UNINSTALL_PACKAGE);
        //uninstallIntent.setData(packageURI);
        //uninstallIntent.setData(Uri.parse("package:" + app_name1.get(position)));
        //startActivity(uninstallIntent);
		Intent i = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
		i.addCategory(Intent.CATEGORY_DEFAULT);
		i.setData(Uri.parse("package:"+packagename));
		startActivity(i);
		


         
	   // Intent intent = new Intent(MainActivity.context, UninstallApp.class);
	    //intent.setClassName("com.example.monitor","com.example.monitor.UninstallApp.class");
       // startActivity(intent); 
		//handleUninstallDialog();
		
		// FragmentTransaction ft = getChildFragmentManager().beginTransaction();
	        // Create and show the dialog.
		// UninstallApp newFragment = new UninstallApp(getListView().getItemAtPosition(position).toString());
	     //   newFragment.show(ft, "dialog");
		
		//Uri packageURI = Uri.parse(getListView().getItemAtPosition(position).toString());
        // Intent uninstallIntent = new Intent(Intent.ACTION_UNINSTALL_PACKAGE, packageURI);
        // startActivity(uninstallIntent);
	  
	 
	 }

	 private void handleUninstallDialog () {
		 AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.context.getApplicationContext());
	        builder.setMessage("Uninstall App")
	               .setPositiveButton("Uninstall", new DialogInterface.OnClickListener() {
	                   public void onClick(DialogInterface dialog, int id) {
	                       // FIRE ZE MISSILES!
	                   }
	               })
	               .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
	                   public void onClick(DialogInterface dialog, int id) {
	                       // User cancelled the dialog
	                   }
	               });
	        // Create the AlertDialog object and return it
	        AlertDialog alert =  builder.create();
	        alert.show();
	 }
	}