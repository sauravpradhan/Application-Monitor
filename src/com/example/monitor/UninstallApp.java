package com.example.monitor;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;



@SuppressLint("NewApi")
public class UninstallApp extends DialogFragment{
	
	//String passed_uri;
	
	 
	//public UninstallApp(String uri)
	//{
		//passed_uri = uri;
		
	//}
	@Override
	  public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Uninstall ")
        .setMessage("The application uses the following permission:")
        
               .setPositiveButton("Uninstall", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                	   
                	 //  Uri packageURI = Uri.parse("package:com.packageName");
                      // Intent uninstallIntent = new Intent(Intent.ACTION_UNINSTALL_PACKAGE, packageURI);
                      // startActivity(uninstallIntent);
                   }
               })
               .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       // User cancelled the dialog
                   }
               });
        // Create the AlertDialog object and return it
        return builder.create();
    }
	 }



