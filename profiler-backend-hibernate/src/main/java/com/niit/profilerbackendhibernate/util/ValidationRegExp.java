package com.niit.profilerbackendhibernate.util;

import java.io.IOException;
import java.util.Properties;

public class ValidationRegExp {
	
	protected static Properties  properties;
	
	
	public ValidationRegExp()
	{
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream("reg_exp.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
