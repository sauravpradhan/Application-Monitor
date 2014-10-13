package com.example.monitor;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class warning extends Activity {
	

@Override
protected void onCreate(Bundle savedInstanceState) 
{
	
    super.onCreate(savedInstanceState);
    Log.d("Saurav", "Entering Warning Dialog");
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder
        .setTitle("Warning!")
        .setMessage("Application That access private data has been installed!")
        .setCancelable(false)
        .setPositiveButton("Okay!", new DialogInterface.OnClickListener() 
        {
            public void onClick(DialogInterface dialog, int id) 
            {
                dialog.cancel();
                warning.this.finish();


            }
        });
        /*.setNegativeButton("No", new DialogInterface.OnClickListener() 
        {
            public void onClick(DialogInterface dialog, int id) 
            {
                dialog.cancel();
            }
        });*/
    AlertDialog alert = builder.create();
    alert.show();
}
}
