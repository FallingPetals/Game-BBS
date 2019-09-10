package com.njust.edu.impl;

import java.util.List;

import com.njust.edu.pojo.*;
import com.njust.edu.dao.*;
import org.apache.ibatis.session.SqlSession;

public class OperationDaoImpl implements OperationDao{
	
	public SqlSession sqlSession;
	
	public OperationDaoImpl(SqlSession sqlSession)
	{
		this.sqlSession=sqlSession;
	}
	
	public void insertOperation(Operation operation)
	{
		this.sqlSession.insert("OperationDao.insertOperation",operation);
	}
	
	public Operation queryOperationByCid(int cid)
	{
		return this.sqlSession.selectOne("OperationDao.queryOperationByCid",cid);
	}
	
	public List<Operation> queryOperationByIp(String ip)
	{
		return this.sqlSession.selectList("OperationDao.queryOperationByIp",ip);
	}
	
	public List<Operation> queryOperationByDate(String operation_date)
	{
		return this.sqlSession.selectList("OperationDao.queryOperationByDate",operation_date);
	}
	
	public List<Operation> queryOperationAll()
	{
		return this.sqlSession.selectList("OperationDao.queryOperationAll");
	}
	

}
