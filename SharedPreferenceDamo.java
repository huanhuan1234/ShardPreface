package com.baway.zuoye;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPreferenceDamo {

	private static final String FILE_NAME="info";
	
	public static void saveParams(Context context,String key,Object value){
		
		SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
		Editor edit = sp.edit();
		String type = value.getClass().getSimpleName();
		if ("Integer".equals(type)) {
			edit.putInt(key, (int) value);
		}else if ("Long".equals(type)) {
			edit.putLong(key, (long) value);
		}else if ("Float".equals(type)) {
			edit.putFloat(key, (float) value);
		}else if ("Boolean".equals(type)) {
			edit.putBoolean(key, (Boolean) value);
		}else if ("String".equals(type)) {
			edit.putString(key, "");
		}
		edit.commit();
	}
	public static Object getParams(Context context,String key,Object value){
		SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
		String type = value.getClass().getSimpleName();
		if ("Integer".equals(type)) {
			return sp.getInt(key, 0);
		}else if ("Long".equals(type)) {
			return sp.getLong(key, 0);
		}else if ("Float".equals(type)) {
			return sp.getFloat(key, 0f);
		}else if ("Boolean".equals(type)) {
			return sp.getBoolean(key,false);
		}else if ("String".equals(type)) {
			return sp.getString(key, "");
		}
		return null;
	}
}
