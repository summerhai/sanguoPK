package com.minglaihan.gosanguo;

import com.minglaihan.generalpk.GeneralPK;
import com.minglaihan.sanguopk.MainActivity;
import com.minglaihan.sanguopk.R;
import com.minglaihan.tools.Exit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class GoSanguo extends Activity{
	private Button sanguoHistoryButton;
	private Button sanguoBattleButton;
	private Button sanguoGeneralsButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gosanguo);
		Exit.getInstance().addActivity(this);
		
		sanguoHistoryButton = (Button)findViewById(R.id.sanguoHistory);
		sanguoBattleButton = (Button)findViewById(R.id.sanguoBattle);
		sanguoGeneralsButton = (Button)findViewById(R.id.sanguoGenerals);
		
		sanguoHistoryButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(GoSanguo.this, SanguoHistory.class);
				startActivity(intent);
			}
		});
		
		sanguoBattleButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(GoSanguo.this, SanguoBattle.class);
				startActivity(intent);
			}
		});
		
		sanguoGeneralsButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(GoSanguo.this, SanguoGenerals.class);
				startActivity(intent);
			}
		});
		
		
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
