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
	
	public void insertApply(Apply apply)//���ص�sid�ᴢ����apply��
	//�޷��޸ģ�ֻ�ܳ��أ���ɾ��
	{
		this.sqlSession.insert("ApplyDao.insertApply",apply);
	}
	
	public void deleteApplyBySid(int sid)
	{
		this.sqlSession.delete("ApplyDao.deleteApplyBySid",sid);
	}
	
	public Apply queryApplyBySid(int sid)//����sid��ѯ�ض�ĳ������
	{
		return this.sqlSession.selectOne("ApplyDao.queryApplyBySid",sid);
	}
	
	public List<Apply> queryApplyByBid(int bid)//��ѯĳ��������������
	{
		return this.sqlSession.selectList("ApplyDao.queryApplyByBid",bid);
	}
	
	public List<Apply> queryApplyAll()
	{
		return this.sqlSession.selectList("ApplyDao.queryApplyAll");
	}
	
	

}
