package com.njust.edu.impl;

import java.util.List;

import com.njust.edu.pojo.*;
import com.njust.edu.dao.*;
import org.apache.ibatis.session.SqlSession;

public class UserDaoImpl implements UserDao{
	public SqlSession sqlSession;
	
	public UserDaoImpl(SqlSession sqlSession)
	{
		this.sqlSession=sqlSession;
	}
	
	public void insertUser(User user)
	{
		this.sqlSession.insert("UserDao.insertUser",user);
	}
	
	public User queryUserByUid(int uid)
	{
		return this.sqlSession.selectOne("UserDao.queryUserByUid",uid);
	}
	
	public User queryuserByUserName(String user_name)
	{
		return this.sqlSession.selectOne("UserDao.queryUserByUserName",user_name);
	}
	
	public List<User> queryUserAll()
	{
		return this.sqlSession.selectList("UserDao.queryUserAll");
	}
	
	public void updateUserByUid(User user)//不需要改的也要提前从queryUserByUid查询出来写进去
	{
		this.sqlSession.update("UserDao.updateUserByUid",user);
	}
	
	public void updateUserByUserName(User user)//不需要改的也要提前从queryUserByUid查询出来写进去
	{
		this.sqlSession.update("UserDao.updateUserByUserName",user);
	}
	
	public void deleteUserByUid(int uid)
	{
		this.sqlSession.delete("UserDao.deleteUserByUid",uid);
	}
	
	public void deleteUserByUserName(String user_name)
	{
		this.sqlSession.delete("UserDao.deleteUserByUserName",user_name);
	}

}
