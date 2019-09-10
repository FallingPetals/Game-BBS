package com.njust.edu.impl;

import java.util.List;

import com.njust.edu.pojo.*;
import com.njust.edu.dao.*;
import org.apache.ibatis.session.SqlSession;

public class StateDaoImpl implements StateDao{
	
	public SqlSession sqlSession;
	
	public StateDaoImpl(SqlSession sqlSession)
	{
		this.sqlSession=sqlSession;
	}
	
	public void insertState(State state)
	{
		this.sqlSession.insert("StateDao.insertState",state);
	}
	
	public void updateStateByUidBid(State state)//只能根据uid和bid修改state_type和remove_date
	{
		this.sqlSession.update("StateDao.updateStateByUidBid",state);
	}
	
	public void deleteStateByUidBid(State state)//要同时根据uid和bid删除
	{
		this.sqlSession.delete("StateDao.deleteStateByUidBid",state);
	}
	
	public List<State> queryStateByUid(int uid)//查询某个人的所有状态信息
	{
		return this.sqlSession.selectList("StateDao.queryStateByUid",uid);
	}
	
	public List<State> queryStateByBid(int bid)//查询某个版块所有被禁言或者其他惩罚的人
	{
		return this.sqlSession.selectList("StateDao.queryStateByBid",bid);
	}
	
	public List<State> queryStateAll()
	{
		return this.sqlSession.selectList("StateDao.queryStateAll");
	}
	
	

}
