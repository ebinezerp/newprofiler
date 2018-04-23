package com.niit.profilerbackendhibernate.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class Validator {
	
	private static Properties  properties;
	private HashMap<String, String> errors;
	
	public Validator()
	{
		try {
			properties.load(new FileInputStream("reg_exp.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		errors=new HashMap<String, String>();
	}
	
	
	public <E> boolean  isNull(E e,String columnName)
	{
		if(e!=null)
			return false;
		else
		{
			errors.put(columnName, "Enter "+columnName);
			return true;
		}
	}
	
	
	public boolean isBlank(String string,String columnName)
	{
		if(string.trim().length()<=0)
		{
			errors.put(columnName, columnName+" should not empty");
			return true;
		}else
		{
			return false;
		}
	}
	
	
	
}
