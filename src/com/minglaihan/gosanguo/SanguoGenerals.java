package com.minglaihan.gosanguo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.minglaihan.generalpk.General;
import com.minglaihan.sanguopk.R;
import com.minglaihan.tools.DBHelper;
import com.minglaihan.tools.Exit;

import android.R.integer;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class SanguoGenerals extends Activity{
	
	public ListView generalNameListView;
	public ImageView generalImageView;
	public TextView generalTextView;
	
	public ArrayList<General> generals;
	public General general;
	public static int count = 0;
	public static int id;
	public static String[] name = new String[98];
	public static String[] generalName = new String[98];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sanguogenerals);
		Exit.getInstance().addActivity(this);
		
		generalImageView = (ImageView)findViewById(R.id.generalPicture);
		generalNameListView = (ListView)findViewById(R.id.generalNameList);
		generalTextView = (TextView)findViewById(R.id.generalInfo);
		
		
		generalName = getGeneralName();
		
		generalNameListView.setItemsCanFocus(false);
		generalNameListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE); //设置单选模式
		generalNameListView.setAdapter(new ArrayAdapter<String>(this,
              android.R.layout.simple_list_item_single_choice,
              generalName));
        
        
		generalNameListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				id = generalNameListView.getCheckedItemPosition();
				System.out.println(id);
				//根据id获得数据然后填写到布局里
				insertDataToGeneral(id);
								
			}       	
		});
		
	}
	

	private String[] getGeneralName(){
    	DBHelper helper = new DBHelper(getApplicationContext());    	
	
    	Cursor cursor= helper.getReadableDatabase().rawQuery(DBHelper.SQL_RAWQUERY, null);
    	if(cursor!=null){
	    	startManagingCursor(cursor);
	    	generals = new ArrayList<General>();
	    	
	    	cursor.moveToFirst();
			while(!cursor.isAfterLast()){
				General general = new General();
				general.setName(cursor.getString(1));				
				generals.add(general);
				cursor.moveToNext();
			}
			
			
			String tmp="";       
	        Iterator<General> iterator  = generals.iterator();  
	        while(iterator.hasNext()){
	        	General general = (General)iterator.next();	
	        		tmp =general.getName();
	    		        	name[count]= tmp;
	    		        	count++;
	        	}		        
	        return name;
	}
	return null;
}
	

	
	/*
	 * (non-Javadoc)
	 * 通过id插入武将头像及资料
	 */
	
	public void insertDataToGeneral(int i) {
		if(i==0){
			generalImageView.setImageResource(R.drawable.zhaoyun);
		}else if(i==1){
			generalImageView.setImageResource(R.drawable.machao);
		}else if(i==2){
			generalImageView.setImageResource(R.drawable.guanyu);
		}else if(i==3){
			generalImageView.setImageResource(R.drawable.zhangfei);
		}else if(i==4){
			generalImageView.setImageResource(R.drawable.huangzhong);
		}else if(i==5){
			generalImageView.setImageResource(R.drawable.liubei);
		}else if(i==6){
			generalImageView.setImageResource(R.drawable.zhugeliang);
		}else if(i==7){
			generalImageView.setImageResource(R.drawable.jiangwei);
		}else if(i==8){
			generalImageView.setImageResource(R.drawable.weiyan);
		}else if(i==9){
			generalImageView.setImageResource(R.drawable.xushu);
		}else if(i==10){
			generalImageView.setImageResource(R.drawable.liyan);
		}else if(i==11){
			generalImageView.setImageResource(R.drawable.madai);
		}else if(i==12){
			generalImageView.setImageResource(R.drawable.yanyan);
		}else if(i==13){
			generalImageView.setImageResource(R.drawable.pangtong);
		}else if(i==14){
			generalImageView.setImageResource(R.drawable.fazheng);
		}else if(i==15){
			generalImageView.setImageResource(R.drawable.zhangbao);
		}else if(i==16){
			generalImageView.setImageResource(R.drawable.guanxing);
		}else if(i==17){
			generalImageView.setImageResource(R.drawable.guanping);
		}else if(i==18){
			generalImageView.setImageResource(R.drawable.wangping);
		}else if(i==19){
			generalImageView.setImageResource(R.drawable.liaohua);
		}else if(i==20){
			generalImageView.setImageResource(R.drawable.guansuo);
		}else if(i==21){
			generalImageView.setImageResource(R.drawable.zhoucang);
		}else if(i==22){
			generalImageView.setImageResource(R.drawable.guanyinping);
		}else if(i==23){
			generalImageView.setImageResource(R.drawable.caocao);
		}else if(i==24){
			generalImageView.setImageResource(R.drawable.simayi);
		}else if(i==25){
			generalImageView.setImageResource(R.drawable.guojia);
		}else if(i==26){
			generalImageView.setImageResource(R.drawable.zhangliao);
		}else if(i==27){
			generalImageView.setImageResource(R.drawable.xuhuang);
		}else if(i==28){
			generalImageView.setImageResource(R.drawable.dengai);
		}else if(i==29){
			generalImageView.setImageResource(R.drawable.xiahoudun);
		}else if(i==30){
			generalImageView.setImageResource(R.drawable.xiahouyuan);
		}else if(i==31){
			generalImageView.setImageResource(R.drawable.caoren);
		}else if(i==32){
			generalImageView.setImageResource(R.drawable.zhanghe);
		}else if(i==33){
			generalImageView.setImageResource(R.drawable.zhonghui);
		}else if(i==34){
			generalImageView.setImageResource(R.drawable.yangku);
		}else if(i==35){
			generalImageView.setImageResource(R.drawable.guohuai);
		}else if(i==36){
			generalImageView.setImageResource(R.drawable.haozhao);
		}else if(i==37){
			generalImageView.setImageResource(R.drawable.yujin);
		}else if(i==38){
			generalImageView.setImageResource(R.drawable.xuchu);
		}else if(i==39){
			generalImageView.setImageResource(R.drawable.dianwei);
		}else if(i==40){
			generalImageView.setImageResource(R.drawable.xunyu);
		}else if(i==41){
			generalImageView.setImageResource(R.drawable.xunyou);
		}else if(i==42){
			generalImageView.setImageResource(R.drawable.lidian);
		}else if(i==43){
			generalImageView.setImageResource(R.drawable.wenpin);
		}else if(i==44){
			generalImageView.setImageResource(R.drawable.yuejin);
		}else if(i==45){
			generalImageView.setImageResource(R.drawable.wangshuang);
		}else if(i==46){
			generalImageView.setImageResource(R.drawable.caozhen);
		}else if(i==47){
			generalImageView.setImageResource(R.drawable.jiaxu);
		}else if(i==48){
			generalImageView.setImageResource(R.drawable.caohong);
		}else if(i==49){
			generalImageView.setImageResource(R.drawable.sunli);
		}else if(i==50){
			generalImageView.setImageResource(R.drawable.caozhang);
		}else if(i==51){
			generalImageView.setImageResource(R.drawable.simashi);
		}else if(i==52){
			generalImageView.setImageResource(R.drawable.simazhao);
		}else if(i==53){
			generalImageView.setImageResource(R.drawable.zhouyu);
		}else if(i==54){
			generalImageView.setImageResource(R.drawable.sunce);
		}else if(i==55){
			generalImageView.setImageResource(R.drawable.sunjian);
		}else if(i==56){
			generalImageView.setImageResource(R.drawable.sunquan);
		}else if(i==57){
			generalImageView.setImageResource(R.drawable.ganning);
		}else if(i==58){
			generalImageView.setImageResource(R.drawable.taishici);
		}else if(i==59){
			generalImageView.setImageResource(R.drawable.luxun);
		}else if(i==60){
			generalImageView.setImageResource(R.drawable.lukang);
		}else if(i==61){
			generalImageView.setImageResource(R.drawable.lvmeng);
		}else if(i==62){
			generalImageView.setImageResource(R.drawable.zhoutai);
		}else if(i==63){
			generalImageView.setImageResource(R.drawable.lusu);
		}else if(i==64){
			generalImageView.setImageResource(R.drawable.xusheng);
		}else if(i==65){
			generalImageView.setImageResource(R.drawable.huanggai);
		}else if(i==66){
			generalImageView.setImageResource(R.drawable.zhuheng);
		}else if(i==67){
			generalImageView.setImageResource(R.drawable.chengpu);
		}else if(i==68){
			generalImageView.setImageResource(R.drawable.handang);
		}else if(i==69){
			generalImageView.setImageResource(R.drawable.lingtong);
		}else if(i==70){
			generalImageView.setImageResource(R.drawable.jiangqin);
		}else if(i==71){
			generalImageView.setImageResource(R.drawable.sunshangxiang);
		}else if(i==72){
			generalImageView.setImageResource(R.drawable.sunhuan);
		}else if(i==73){
			generalImageView.setImageResource(R.drawable.zhangzhao);
		}else if(i==74){
			generalImageView.setImageResource(R.drawable.zhanghong);
		}else if(i==75){
			generalImageView.setImageResource(R.drawable.lvbu);
		}else if(i==76){
			generalImageView.setImageResource(R.drawable.gaoshun);
		}else if(i==77){
			generalImageView.setImageResource(R.drawable.kongrong);
		}else if(i==78){
			generalImageView.setImageResource(R.drawable.yuanshao);
		}else if(i==79){
			generalImageView.setImageResource(R.drawable.yanliang);
		}else if(i==80){
			generalImageView.setImageResource(R.drawable.wenchou);
		}else if(i==81){
			generalImageView.setImageResource(R.drawable.tianfeng);
		}else if(i==82){
			generalImageView.setImageResource(R.drawable.jushou);
		}else if(i==83){
			generalImageView.setImageResource(R.drawable.yuanshu);
		}else if(i==84){
			generalImageView.setImageResource(R.drawable.jiling);
		}else if(i==85){
			generalImageView.setImageResource(R.drawable.mateng);
		}else if(i==86){
			generalImageView.setImageResource(R.drawable.pangde);
		}else if(i==87){
			generalImageView.setImageResource(R.drawable.dongzhuo);
		}else if(i==88){
			generalImageView.setImageResource(R.drawable.huaxiong);
		}else if(i==89){
			generalImageView.setImageResource(R.drawable.xurong);
		}else if(i==90){
			generalImageView.setImageResource(R.drawable.hansui);
		}else if(i==91){
			generalImageView.setImageResource(R.drawable.zhanglu);
		}else if(i==92){
			generalImageView.setImageResource(R.drawable.zhangren);
		}else if(i==93){
			generalImageView.setImageResource(R.drawable.menghuo);
		}else if(i==94){
			generalImageView.setImageResource(R.drawable.huangfusong);
		}else if(i==95){
			generalImageView.setImageResource(R.drawable.zhujun);
		}else if(i==96){
			generalImageView.setImageResource(R.drawable.luzhi);
		}else if(i==97){
			generalImageView.setImageResource(R.drawable.gongsunzan);
		}
		
		DBHelper dbHelper = new DBHelper(getApplicationContext());
		general = dbHelper.queryGeneralByID(i+1);
//		System.out.println(general.getName());
		generalTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
		generalTextView.setText(general.getIntroduction());
		
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
