package com.njust.edu.pojo;

import java.io.Serializable;

public class User implements Serializable{
	private int uid;
	private String user_name;
	private String password;
	private String nickname;
	private String email;
	private String phone;
	private String id;
	private int level;
	private int point;
	private String join_date;
	private int post_num;
	private int status;
	
	public User()
	{
		super();
	}
	public User(int uid,String user_name,String password,String nickname,String email,String phone,String id,int level,int point,String join_date,int post_num,int status)
	{
		this.uid=uid;
		this.user_name=user_name;
		this.password=password;
		this.nickname=nickname;
		this.email=email;
		this.phone=phone;
		this.id=id;
		this.level=level;
		this.point=point;
		this.join_date=join_date;
		this.post_num=post_num;
		this.status=status;
	}
	
	public void setUid(int uid)
	{
		this.uid=uid;
	}
	public int getUid()
	{
		return uid;
	}
	public void setUser_name(String user_name)
	{
		this.user_name=user_name;
	}
	public String getUser_name()
	{
		return user_name;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public String getPassword()
	{
		return password;
	}
	public void setNickname(String nickname)
	{
		this.nickname=nickname;
	}
	public String getNickname()
	{
		return nickname;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getEmail()
	{
		return email;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setId(String id)
	{
		this.id=id;
	}
	public String getId()
	{
		return id;
	}
	public void setLevel(int level)
	{
		this.level=level;
	}
	public int getLevel()
	{
		return level;
	}
	public void setPoint(int point)
	{
		this.point=point;
	}
	public int getPoint()
	{
		return point;
	}
	public void setJoin_date(String join_date)
	{
		this.join_date=join_date;
	}
	public String getJoin_date()
	{
		return join_date;
	}
	public void setPost_num(int post_num)
	{
		this.post_num=post_num;
	}
	public int getPost_num()
	{
		return post_num;
	}
	public void setStatus(int status)
	{
		this.status=status;
	}
	public int getStatus()
	{
		return status;
	}
	
	public String toString()
	{
		return "User[uid="+uid+",user_name="+user_name+",password="+password+",nickname="+nickname+",email="+email+"]";
	}

}
