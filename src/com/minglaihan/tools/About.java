package com.minglaihan.tools;

import com.minglaihan.sanguopk.R;
import com.minglaihan.sanguopk.R.layout;
import com.minglaihan.sanguopk.R.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class About extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		 Exit.getInstance().addActivity(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		menu.add(0, 1, 1, R.string.exit);
		return super.onCreateOptionsMenu(menu);
	}
	
	
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId()==1)
		{
			Exit.getInstance().exit();
		}
		return super.onOptionsItemSelected(item);
	} 

}
