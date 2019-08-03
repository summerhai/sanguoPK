package com.minglaihan.generalpk;


/*
 * 目的是呈现所有武将的数据，然后用户选择后通过Intent传送过去
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.minglaihan.sanguopk.R;
import com.minglaihan.tools.DBHelper;
import com.minglaihan.tools.Exit;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;


public class ChooseGeneral2 extends Activity {
	private List<General> generals;

	private ListView generaldataListView;
	private Button okButton;
	public static int id2 = 0 ;
	public static String name2;
	public static int count=0;
	public static int idInInfo = 0;
	public String[] info = new String[98] ;
	

    
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.generaldata);
        Exit.getInstance().addActivity(this);
     
        /*按钮事件*/
        okButton = (Button)findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				
				//传送数据回去
				Intent intent = new Intent();
				intent.setClass(ChooseGeneral2.this, AfterGeneralPK.class);
	
				Bundle bl = new Bundle();				
				
				int hh = Integer.valueOf(String.valueOf(info[0].charAt(0))).intValue()-1;
				System.out.println("hh"+hh);
				//根据id获取name
				for(int i=0;i<count;i++){
					int idNumbers = 0;//用于标记id位
				
					
					if(info[i].charAt(1)==' '){
						idInInfo = Integer.valueOf(String.valueOf(info[i].charAt(0))).intValue();
						idNumbers = 1;
					}else if(info[i].charAt(2)==' '){
						String temp11 = info[i].substring(0, 2);
						idInInfo = Integer.valueOf(String.valueOf(temp11)).intValue();
						idNumbers = 11;
					}else if(info[i].charAt(3)==' '){
						String temp22 = info[i].substring(0, 3);
						idInInfo = Integer.valueOf(String.valueOf(temp22)).intValue();
						idNumbers =111;
					}

					if(idInInfo-1 == id2){
						System.out.println("进行判断");
						
						if(idNumbers == 1){
							if(info[i].charAt(7) == ' '){
								name2 = info[i].trim().substring(5, 7);
							}
							else{
								name2 = info[i].trim().substring(5, 8);
							}
						}
						if(idNumbers == 11){
						
							if(info[i].charAt(8) == ' '){
								name2 = info[i].trim().substring(6, 8);
							}
							else{
								name2 = info[i].trim().substring(6, 9);
							}
						}
						if(idNumbers == 111){
							
							if(info[i].charAt(9) == ' '){
								name2 = info[i].trim().substring(7, 9);
							}
							else{
								name2 = info[i].trim().substring(7, 10);
							}
						}	

					}					
				}
				bl.putString("name2", name2);
				//将Bundle放入Intent传入下一个Activity
				intent.putExtras(bl);
				//跳到下一个Activity,并且等待其返回结果
				startActivityForResult(intent, 0);
				startActivity(intent);
				ChooseGeneral2.this.finish();
				
				
			}
		});
    
        
     
        /*取数据，绑定*/

        generaldataListView = (ListView)findViewById(R.id.generaDatListView);
        getGeneralData();

        generaldataListView.setItemsCanFocus(false);
        generaldataListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE); //设置单选模式
        generaldataListView.setAdapter(new ArrayAdapter<String>(this,
              android.R.layout.simple_list_item_single_choice,
                info));
        
        generaldataListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				id2 = generaldataListView.getCheckedItemPosition();
			}       	
		});
    }
        
        

    
    
    private String[] getGeneralData(){
	    	DBHelper helper = new DBHelper(getApplicationContext());    	
    	
	    	Cursor cursor= helper.getReadableDatabase().rawQuery(DBHelper.SQL_RAWQUERY, null);
	    	if(cursor!=null){
		    	startManagingCursor(cursor);
		    	generals = new ArrayList<General>();
		    	
		    	cursor.moveToFirst();
				while(!cursor.isAfterLast()){
					General general = new General();
					general.setId(cursor.getInt(0));
					general.setName(cursor.getString(1));
					general.setSex(cursor.getString(2));
					general.setCaptain(cursor.getInt(3));
					general.setForce(cursor.getInt(4));
					general.setIntelligence(cursor.getInt(5));
					general.setIntroduction(cursor.getString(6));

					
					generals.add(general);
					cursor.moveToNext();
				}
				
				
				String tmp="";       
		        Iterator<General> iterator  = generals.iterator();  
		        while(iterator.hasNext()){
		        	General general = (General)iterator.next();	        	
		        	tmp =String.valueOf(general.getId()) +"    "+general.getName()+"       "+
	    		        	general.getSex()+"    "+String.valueOf(general.getCaptain()+"      "+
	    		        	String.valueOf(general.getForce())+"     "+String.valueOf(general.getIntelligence()));
	    		        	info[count]= tmp;
	    		        	count++;
		        }
		        
		        return info;
    	}
    	return null;
    }
    
    public String[] SplitString(String dataString){
    	String[] returnStrings = new String[7];
    	String[] tempStrings = null;
    	String[] temp1Strings = null;
    	
    	tempStrings = dataString.split(",");
        
        for(int i=0;i<tempStrings.length;i++){
        	temp1Strings = tempStrings[i].split("=");
        	returnStrings[i] = temp1Strings[1];
        }
        
    	return returnStrings;
    }
    
    
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
