package com.njust.edu.impl;

import java.util.List;

import com.njust.edu.pojo.*;
import com.njust.edu.dao.*;
import org.apache.ibatis.session.SqlSession;

public class ApplyDaoImpl implements ApplyDao{
	
	public SqlSession sqlSession;
	
	public ApplyDaoImpl(SqlSession sqlSession)
	{
		this.sqlSession=sqlSession;
	}
	
	public void insertApply(Apply apply)//返回的sid会储存在apply中
	//无法修改，只能撤回（即删除
	{
		this.sqlSession.insert("ApplyDao.insertApply",apply);
	}
	
	public void deleteApplyBySid(int sid)
	{
		this.sqlSession.delete("ApplyDao.deleteApplyBySid",sid);
	}
	
	public Apply queryApplyBySid(int sid)//根据sid查询特定某个申请
	{
		return this.sqlSession.selectOne("ApplyDao.queryApplyBySid",sid);
	}
	
	public List<Apply> queryApplyByBid(int bid)//查询某版区的所有申请
	{
		return this.sqlSession.selectList("ApplyDao.queryApplyByBid",bid);
	}
	
	public List<Apply> queryApplyAll()
	{
		return this.sqlSession.selectList("ApplyDao.queryApplyAll");
	}
	
	

}
