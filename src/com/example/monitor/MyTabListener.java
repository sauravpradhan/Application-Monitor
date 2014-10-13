package com.example.monitor;
import android.annotation.SuppressLint;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.widget.Toast;


@SuppressLint("NewApi")
public class MyTabListener implements TabListener {

	
	tab1 t1 = null;
	tab2 t2 = null;
	tab3 t3 = null;
	
	
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@SuppressLint("NewApi")
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		if(t1!=null)
		{
			
			ft.hide(t1);
		}
		if(t2!=null)
		{
			
			ft.hide(t2);
		}
		if(t3!=null)
		{
			
			ft.hide(t3);
		}
		switch(tab.getPosition())
		{
		case 0:
			//Toast.makeText(MainActivity.context, "Tab1 Selected", Toast.LENGTH_SHORT).show();
			
			if (t1 == null) {
				
				tab1 t1 = new tab1();
				
				ft.add(R.id.realtabcontent, t1, "tab1");
				
			} 
			else 
			{
				ft.show(t1);
				
			}
		
			break;
		case 1:
			//Toast.makeText(MainActivity.context, "Tab2 Selected", Toast.LENGTH_SHORT).show();
			if(t2 == null)
			{
				tab2 t2 = new tab2();
				
				ft.add(R.id.realtabcontent,t2,"tab2");
			}
			else
			{
				
				ft.show(t2);
			}
			break;
		case 2:
			//Toast.makeText(MainActivity.context, "Tab3 Selected", Toast.LENGTH_SHORT).show();
			if(t3 == null)
			{
				tab3 t3 = new tab3();
				
				ft.add(R.id.realtabcontent,t3,"tab3");
			}
			else
			{
				ft.show(t3);
			}
			break;
		}
	
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
		switch(tab.getPosition())
		{
		case 0:
		
			if(t1!=null)
			{
				
			ft.hide(t1);	
			
			}
			break;
		
		case 1:
		if(t2!=null)
		{
			
			ft.hide(t2);
			
		}
			break;
		
		case 2:
			if(t3!=null)
			{
				
			//	ft.hide(t3);
				
			}
				break;
		}
	}

}
