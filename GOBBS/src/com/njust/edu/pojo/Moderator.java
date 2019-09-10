package com.njust.edu.pojo;

import java.io.Serializable;

public class Moderator implements Serializable{
	private int uid;
	private int bid;
	private String get_date;
	private String lose_date;
	
	public Moderator()
	{
		super();
	}
	
	public Moderator(int uid,int bid,String get_date,String lose_date)
	{
		this.uid=uid;
		this.bid=bid;
		this.get_date=get_date;
		this.lose_date=lose_date;
	}
	
	public int getUid()
	{
		return uid;
	}
	public void setUid(int uid)
	{
		this.uid=uid;
	}
	public int getBid()
	{
		return bid;
	}
	public void setBid(int bid)
	{
		this.bid=bid;
	}
	public String getGet_date()
	{
		return get_date;
	}
	public void setGet_date(String get_date)
	{
		this.get_date=get_date;
	}
	public String getLose_date()
	{
		return lose_date;
	}
	public void setLose_date(String lose_date)
	{
		this.lose_date=lose_date;
	}
	
	public String toString()
	{
		return "Moderator[uid="+uid+",bid="+bid+",get_date="+get_date+",lose_date="+lose_date+"]";
	}

}
