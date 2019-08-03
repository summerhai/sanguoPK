package com.minglaihan.generalpk;


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
import android.widget.Toast;


public class GeneralPK extends Activity {
	
	private  Button chooseGeneralButton1;
	private  Button chooseGeneralButton2;
	private  Button startPKButton;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.generalpk);
		Exit.getInstance().addActivity(this);
		
		chooseGeneralButton1 = (Button)findViewById(R.id.chooseGeneralButton1);
		chooseGeneralButton2 = (Button)findViewById(R.id.chooseGeneralButton2);
		startPKButton = (Button)findViewById(R.id.startPKButton);
		
		chooseGeneralButton1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//加载选择武将的头像置于选择武将按钮的上方
				Intent intent = new Intent();  
	             intent.setClass(GeneralPK.this, ChooseGeneral1.class);  
	             startActivity(intent);
	             GeneralPK.this.finish();
			}
		});
		
		chooseGeneralButton2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//加载选择武将的头像置于选择武将按钮的上方
				Intent intent = new Intent();  
	             intent.setClass(GeneralPK.this, ChooseGeneral2.class);  
	             startActivity(intent);
	             GeneralPK.this.finish();
			}
		});
		
		startPKButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(GeneralPK.this, "必须选择两名武将参与PK",Toast.LENGTH_SHORT ).show();
				// TODO Auto-generated method stub
				//两个头像之间有个动态的PK效果，然后通过PK算法计算出结果
//				if(name1 == null||name2 == null){
//					Toast.makeText(GeneralPK.this, "必须选择两名武将参与PK",Toast.LENGTH_SHORT ).show();
//				}
//				else if(name1.equals(name2)){
//					Toast.makeText(GeneralPK.this, "不能选择相同的武将",Toast.LENGTH_SHORT ).show();
//				}
				
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
