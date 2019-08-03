package com.minglaihan.tools;

import java.util.ArrayList;
import java.util.List;

import com.minglaihan.generalpk.General;

import android.R.bool;
import android.R.integer;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

	public class DBHelper extends SQLiteOpenHelper {

		public static final String DATABASE_NAME = "sanguopk.db";
		private static final int DATABASE_VERSION = 1;
		private final static String TAG = "DBHelper";
		public final static String SQL_RAWQUERY ="select id,name,sex,captain,force,intelligence,introduction FROM general";
		
		
		public DBHelper(Context context) {
			//CursorFactory设置为null,使用默认值
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		//数据库第一次被创建时onCreate会被调用
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE IF NOT EXISTS general (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, sex VARCHAR, captain INTEGER, force INTEGER, intelligence INTEGER, introduction VARCHAR);");
		}

		//如果DATABASE_VERSION值被改为2,系统发现现有数据库版本不同,即会调用onUpgrade
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXIST general");
			onCreate(db);
		}
		
		public void clearTable(SQLiteDatabase db){
			db.execSQL("DROP TABLE general");
		}
		
		
		
		/*
		 * 添加一条General记录
		 * @param general 用户记录
		 * @return 返回插入的行 id
		 */
		public long addGeneral(General general){
			SQLiteDatabase db = null;
			try{	
				ContentValues values = new ContentValues();
				values.put("name", general.getName());
				values.put("sex", general.getSex());
				values.put("captain", general.getCaptain());
				values.put("force", general.getForce());
				values.put("intelligence", general.getIntelligence());
				values.put("introduction", general.getIntroduction());
				
				db = this.getWritableDatabase();
				
				long result =  db.insert("general", null, values);			
				return result;
			}catch(SQLiteException e){
				return -1;
			}finally{
				if(db.isOpen())
					db.close();
			}
		}
		
		/*
		 * 查询记录
		 * @return 获取到的行记录 
		 */
		public List<General> queryGenerals(){
			Cursor c = null;
			SQLiteDatabase db = null;
			List<General> result = new ArrayList<General>();		
			try
			{
				db = this.getReadableDatabase();			
				c = db.query("general",new String[]{"id","name","sex","captain","force","intelligence","introduction"},	null,null,null,null,null,"id asc");
				
				c.moveToFirst();
				while(!c.isAfterLast()){
					General general = new General();
					general.setId(c.getInt(0));
					general.setName(c.getString(1));
					general.setSex(c.getString(2));				
					general.setCaptain(c.getInt(3));
					general.setForce(c.getInt(4));
					general.setIntelligence(c.getInt(5));
					general.setIntroduction(c.getString(6));
					
					
					result.add(general);
					c.moveToNext();
				}			
				return result;
			}catch(SQLiteException e){
				Log.e(TAG, e.getMessage());
				return null;
			}finally{
				if(!c.isClosed()){
					c.close();
				}
				if(db.isOpen()){
					db.close();
				}
			}
		}	
		
		/*
		 * 根据id查询记录
		 * @return 获取到的行记录 
		 */
		public General queryGeneralByName(String name){
			Cursor c = null;
			SQLiteDatabase db = null;
			General result = new General();		
			try
			{
				db = this.getReadableDatabase();
				c = db.query("general",new String[]{"id","name","sex","captain","force","intelligence","introduction"},	null,null,null,null,null,"");
				
				c.moveToFirst();
				while(!c.isAfterLast()){
					General general = new General();
					if(c.getString(1).equals(name)){
						general.setId(c.getInt(0));
						general.setName(c.getString(1));
						general.setSex(c.getString(2));				
						general.setCaptain(c.getInt(3));
						general.setForce(c.getInt(4));
						general.setIntelligence(c.getInt(5));
						general.setIntroduction(c.getString(6));
						
						result = general;
					}															
					c.moveToNext();
				}
				
				return result;
			}catch(SQLiteException e){
				Log.e(TAG, e.getMessage());
				return null;
			}finally{
//				if(!c.isClosed()){
//					c.close();
//				}
				if(db.isOpen()){
					db.close();
				}
			}
		}	
		
		public General queryGeneralByID(int id){
			Cursor c = null;
			SQLiteDatabase db = null;
			General result = new General();		
			try
			{
				db = this.getReadableDatabase();
				c = db.query("general",new String[]{"id","name","sex","captain","force","intelligence","introduction"},	null,null,null,null,null,"");
				
				c.moveToFirst();
				while(!c.isAfterLast()){
					General general = new General();
//					System.out.println(id+"id"+"    c.getInt(0)"+c.getInt(0));
					if(c.getInt(0)==id){
						general.setId(c.getInt(0));
						general.setName(c.getString(1));
						general.setSex(c.getString(2));				
						general.setCaptain(c.getInt(3));
						general.setForce(c.getInt(4));
						general.setIntelligence(c.getInt(5));
						general.setIntroduction(c.getString(6));
						
						result = general;
					}															
					c.moveToNext();
				}
				
				return result;
			}catch(SQLiteException e){
				Log.e(TAG, e.getMessage());
				return null;
			}finally{
//				if(!c.isClosed()){
//					c.close();
//				}
				if(db.isOpen()){
					db.close();
				}
			}
		}	
		
		/*
		 * 删除一条用户记录 
		 * @return 是否删除成功
		 */
		public boolean delete(General general)
	    {
			SQLiteDatabase db=null;
			try{
		        db=this.getWritableDatabase();
		        String where="id"+"=?";
		        String[] whereValue={Integer.toString(general.getId())};
		        long result = db.delete("general", where, whereValue);
		        return result  > 0;
			}catch(SQLiteException e){
				return false;
			}finally{
				if(db.isOpen()){
					db.close();
				}
			}
	    }
		
		/*
		 * 更新一条记录
		 * @return 是否更新成功 
		 */
		public boolean update(General general){
			SQLiteDatabase db = null;
			try{
				db = this.getWritableDatabase();
				String where="id"+"=?";
				String[] whereValue={Integer.toString(general.getId())};
				ContentValues values=new ContentValues(); 
				values.put("name", general.getName());
				values.put("sex", general.getSex());
				
				long result = db.update("general", values, where, whereValue);			
				return result>0;
			}catch(SQLiteException e){
				return false;
			}finally{
				if(db.isOpen()){
					db.close();
				}
			}
		}

		
	}

