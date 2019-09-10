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
	
	public void updateStateByUidBid(State state)//ֻ�ܸ���uid��bid�޸�state_type��remove_date
	{
		this.sqlSession.update("StateDao.updateStateByUidBid",state);
	}
	
	public void deleteStateByUidBid(State state)//Ҫͬʱ����uid��bidɾ��
	{
		this.sqlSession.delete("StateDao.deleteStateByUidBid",state);
	}
	
	public List<State> queryStateByUid(int uid)//��ѯĳ���˵�����״̬��Ϣ
	{
		return this.sqlSession.selectList("StateDao.queryStateByUid",uid);
	}
	
	public List<State> queryStateByBid(int bid)//��ѯĳ��������б����Ի��������ͷ�����
	{
		return this.sqlSession.selectList("StateDao.queryStateByBid",bid);
	}
	
	public List<State> queryStateAll()
	{
		return this.sqlSession.selectList("StateDao.queryStateAll");
	}
	
	

}
