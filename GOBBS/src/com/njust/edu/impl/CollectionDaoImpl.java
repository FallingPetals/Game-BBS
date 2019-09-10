package com.njust.edu.impl;

import java.util.List;

import com.njust.edu.pojo.*;
import com.njust.edu.dao.*;
import org.apache.ibatis.session.SqlSession;

public class CollectionDaoImpl implements CollectionDao{
	
	public SqlSession sqlSession;
	
	public CollectionDaoImpl(SqlSession sqlSession)
	{
		this.sqlSession=sqlSession;
	}
	
	public void insertCollection(Collection collection)
	{
		this.sqlSession.insert("CollectionDao.insertCollection",collection);
	}
	
	public void deleteCollection(Collection collection)
	{
		this.sqlSession.delete("CollectionDao.deleteCollection",collection);
	}
	
	public List<Collection> queryCollectionByUid(int uid)
	{
		return this.sqlSession.selectList("CollectionDao.queryCollectionByUid",uid);
	}
	
	public List<Collection> queryCollectionAll()
	{
		return this.sqlSession.selectList("CollectionDao.queryCollectionAll");
	}

}
