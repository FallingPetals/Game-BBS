package com.njust.edu.dao;

import com.njust.edu.pojo.*;

import java.util.List;

public interface Password_protectionDao {
	
	public void insertPassword_Protection(Password_protection password_protection);//order_number�����������ţ�1~3����Ҫ�ֶ����룬�����Զ�����
	
	public void updatePassword_protection(Password_protection Password_protection);
	
	public List<Password_protection> queryPassword_protectionByUid(int uid);
	
	public List<Password_protection> queryPassword_protectionAll();

}
