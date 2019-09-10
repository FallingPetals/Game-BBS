package com.njust.edu.pojo;

import java.io.Serializable;

public class Administrator implements Serializable{
	private int uid;
	private int aid;
	private String get_date;
	private String lose_date;
	
	public Administrator()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Administrator(int uid,int aid,String get_date,String lose_date)
	{
		this.uid=uid;
		this.aid=aid;
		this.get_date=get_date;
		this.lose_date=lose_date;
	}
	
	public void setUid(int uid)
	{
		this.uid=uid;
	}
	public int getUid()
	{
		return uid;
	}
	public void setAid(int aid)
	{
		this.aid=aid;
	}
	public int getAid()
	{
		return aid;
	}
	public void setGet_date(String get_date)
	{
		this.get_date=get_date;
	}
	public String getGet_date()
	{
		return get_date;
	}
	public void setLose_date(String lose_date)
	{
		this.lose_date=lose_date;
	}
	public String getLose_date()
	{
		return lose_date;
	}
	public String toString()
	{
		return "Administrator[uid="+uid+",aid="+aid+",get_date="+get_date+",lose_date="+lose_date+"]";
	}
}
