package com.njust.edu.impl;

import java.util.List;

import com.njust.edu.pojo.*;
import com.njust.edu.dao.*;
import org.apache.ibatis.session.SqlSession;

public class Password_protectionDaoImpl implements Password_protectionDao{

	public SqlSession sqlSession;
	
	public Password_protectionDaoImpl(SqlSession sqlSession)
	{
		this.sqlSession=sqlSession;
	}
	
	public void insertPassword_Protection(Password_protection password_protection)//order_number代表问题的序号，1~3，需要手动输入，不会自动生成
	{
		this.sqlSession.insert("Password_protectionDao.insertPassword_Protection",password_protection);
	}
	
	public void updatePassword_protection(Password_protection Password_protection)
	{
		this.sqlSession.update("Password_protectionDao.updatePassword_protection",Password_protection);
	}
	
	public List<Password_protection> queryPassword_protectionByUid(int uid)
	{
		return this.sqlSession.selectList("Password_protectionDao.queryPassword_protectionByUid",uid);
	}
	
	public List<Password_protection> queryPassword_protectionAll()
	{
		return this.sqlSession.selectList("Password_protectionDao.queryPassword_protectionAll");
	}
	
}
