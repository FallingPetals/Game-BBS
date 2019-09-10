package com.njust.edu.impl;

import java.util.List;

import com.njust.edu.pojo.*;
import com.njust.edu.dao.*;

import org.apache.ibatis.session.SqlSession;

public class ModeratorDaoImpl implements ModeratorDao{
	
	public SqlSession sqlSession;
	
	public ModeratorDaoImpl(SqlSession sqlSession) 
	{
        this.sqlSession = sqlSession;
    }
	
	public void insertModerator(Moderator moderator)//����
	{
		this.sqlSession.insert("ModeratorDao.insertModerator",moderator);
	}
	
	public void updateModeratorLoseDateByUid(Moderator moderator)//moderator�е�uid����Ҫ�޸ĵ�moderator����һ���uid
	{
		this.sqlSession.update("ModeratorDao.updateModeratorLoseDateByUid",moderator);
	}
	
	
	public void deleteModeratorByUid(int uid)
	{
		this.sqlSession.delete("ModeratorDao.deleteModeratorByUid",uid);
	}
	
	
	public List<Moderator> queryModeratorAll()//��ѯ����
	{
		return this.sqlSession.selectList("ModeratorDao.queryModeratorAll");
	}
	
	public Moderator queryModeratorByUid(int uid)//ͨ��uid��ѯ
	{
		return this.sqlSession.selectOne("ModeratorDao.queryModeratorByUid",uid);
	}
	
	public Moderator queryModeratorByBid(int bid)//ͨ��bid��ѯ
	{
		return this.sqlSession.selectOne("ModeratorDao.queryModeratorByBid",bid);
	}

}
