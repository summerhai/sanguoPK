package com.minglaihan.gosanguo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.minglaihan.generalpk.ChooseGeneral1;
import com.minglaihan.sanguopk.R;
import com.minglaihan.tools.Exit;

public class SanguoHistory extends Activity {
	private Button history1Button;
	private Button history2Button;
	private Button history3Button;
	private Button history4Button;
	private Button history5Button;
	private Button history6Button;
	private Button history7Button;
	private Button history11Button;
	private Button history12Button;
	private Button history13Button;
	private Button history14Button;
	private Button history15Button;
	private Button history16Button;
	private Button history17Button;
	private Button history8Button;
	private Button history9Button;
	private Button history10Button;
	private Button history18Button;
	private Button history19Button;
	private Button history20Button;
	private static int id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sanguohistory);
		Exit.getInstance().addActivity(this);
		
		history1Button = (Button)findViewById(R.id.history1);
		history2Button = (Button)findViewById(R.id.history2);
		history3Button = (Button)findViewById(R.id.history3);
		history4Button = (Button)findViewById(R.id.history4);
		history5Button = (Button)findViewById(R.id.history5);
		history6Button = (Button)findViewById(R.id.history6);
		history7Button = (Button)findViewById(R.id.history7);
		history11Button = (Button)findViewById(R.id.history11);
		history12Button = (Button)findViewById(R.id.history12);
		history13Button = (Button)findViewById(R.id.history13);
		history14Button = (Button)findViewById(R.id.history14);
		history15Button = (Button)findViewById(R.id.history15);
		history16Button = (Button)findViewById(R.id.history16);
		history17Button = (Button)findViewById(R.id.history17);
		history8Button = (Button)findViewById(R.id.history8);
		history9Button = (Button)findViewById(R.id.history9);
		history10Button = (Button)findViewById(R.id.history10);
		history18Button = (Button)findViewById(R.id.history18);
		history19Button = (Button)findViewById(R.id.history19);
		history20Button = (Button)findViewById(R.id.history20);
		
		history1Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoHistory.this, History.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 1);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);

			}
		});
		history2Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoHistory.this, History.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 2);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);
				SanguoHistory.this.finish();
			}
		});
		history3Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoHistory.this, History.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 3);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);
			}
		});
		history4Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoHistory.this, History.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 4);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);
			}
		});
		history5Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoHistory.this, History.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 5);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);
			}
		});
		history6Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoHistory.this, History.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 6);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);
			}
		});
		history7Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoHistory.this, History.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 7);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);
			}
		});
		
		history8Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoHistory.this, History.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 8);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);

			}
		});
		history9Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoHistory.this, History.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 9);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);
			}
		});
		history10Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoHistory.this, History.class);
				Bundle bl = new Bundle();
				bl.putInt("id",10);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);
			}
		});
		history11Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoHistory.this, History.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 11);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);
			}
		});
		history12Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoHistory.this, History.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 12);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);
			}
		});
		history13Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoHistory.this, History.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 13);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);
			}
		});
		history14Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoHistory.this, History.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 14);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);
			}
		});
		history15Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoHistory.this, History.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 15);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);

			}
		});
		history16Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoHistory.this, History.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 16);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);
			}
		});
		history17Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoHistory.this, History.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 17);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);
			}
		});
		history18Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoHistory.this, History.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 18);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);
			}
		});
		history19Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoHistory.this, History.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 19);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);
			}
		});
		history20Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SanguoHistory.this, History.class);
				Bundle bl = new Bundle();
				bl.putInt("id", 20);
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
