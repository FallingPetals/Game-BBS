package com.njust.edu.impl;

import java.util.List;

import com.njust.edu.pojo.*;
import com.njust.edu.dao.*;
import org.apache.ibatis.session.SqlSession;

public class Special_postDaoImpl implements Special_postDao{
	
	public SqlSession sqlSession;
	
	public Special_postDaoImpl(SqlSession sqlSession)
	{
		this.sqlSession=sqlSession;
	}
	
	public void insertSpecial_post(Special_post special_post)
	{
		this.sqlSession.insert("Special_postDao.insertSpecial_post",special_post);
	}
	
	public void updateSpecial_postByTid(Special_post special_post)//Ö»ÄÜÐÞ¸Äpost_type
	{
		this.sqlSession.update("Special_postDao.updateSpecial_postByTid",special_post);
	}
	
	public void deleteSpecial_postByTid(int tid)
	{
		this.sqlSession.delete("Special_postDao.deleteSpecial_postByTid",tid);
	}
	
	public Special_post querySpecial_postByTid(int tid)
	{
		return this.sqlSession.selectOne("Special_postDao.querySpecial_postByTid",tid);
	}
	
	public List<Special_post> querySpecial_postByBid(int tid)
	{
		return this.sqlSession.selectList("Special_postDao.querySpecial_postByBid",tid);
	}
	
	public List<Special_post> querySpecial_postAll()
	{
		return this.sqlSession.selectList("Special_postDao.querySpecial_postAll");
	}
	

}
