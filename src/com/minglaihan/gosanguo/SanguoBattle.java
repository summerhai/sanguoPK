package com.minglaihan.gosanguo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.minglaihan.sanguopk.R;
import com.minglaihan.tools.Exit;

public class SanguoBattle extends Activity {
	private Button battle1Button;
	private Button battle2Button;
	private Button battle3Button;
	private Button battle4Button;
	private Button battle5Button;
	private Button battle6Button;
	private Button battle7Button;
	private Button battle8Button;

	private static int id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sanguobattle);
		Exit.getInstance().addActivity(this);
		
		battle1Button = (Button)findViewById(R.id.battle1);
		battle2Button = (Button)findViewById(R.id.battle2);
		battle3Button = (Button)findViewById(R.id.battle3);
		battle4Button = (Button)findViewById(R.id.battle4);
		battle5Button = (Button)findViewById(R.id.battle5);
		battle6Button = (Button)findViewById(R.id.battle6);
		battle7Button = (Button)findViewById(R.id.battle7);
		battle8Button = (Button)findViewById(R.id.battle8);

		
		battle1Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoBattle.this, Battle.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 1);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);

			}
		});
		battle2Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoBattle.this, Battle.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 2);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);
			}
		});
		battle3Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoBattle.this, Battle.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 3);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);
			}
		});
		battle4Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoBattle.this, Battle.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 4);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);
			}
		});
		battle5Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoBattle.this, Battle.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 5);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);
			}
		});
		battle6Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoBattle.this, Battle.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 6);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);
			}
		});
		battle7Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoBattle.this, Battle.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 7);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);
			}
		});
		
		battle8Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoBattle.this, Battle.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 8);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
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
