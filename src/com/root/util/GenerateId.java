package com.root.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateId {
	
	public static String generateId(){
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
		String current = dateFormat.format(date);
		System.out.println(current);
		return current;
	}
}
