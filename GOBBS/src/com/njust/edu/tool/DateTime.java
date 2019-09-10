package com.njust.edu.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {

	public static String getDate()
	{
		String resultDate;
		Date date=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		resultDate=sf.format(date);
		//System.out.println(resultDate);
		return resultDate;
	}
	
	public static String getTime()
	{
		String resultTime;
		Date date=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("HH:mm:ss");
		resultTime=sf.format(date);
		//System.out.println(resultTime);
		return resultTime;
	}
	/*
	public static void main(String[] args) throws Exception{
		DateTime dateTime=new DateTime();
		dateTime.getDate();
		dateTime.getTime();
	}
	*/

}
