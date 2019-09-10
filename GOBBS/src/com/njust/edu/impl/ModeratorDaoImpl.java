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
	
	public void insertModerator(Moderator moderator)//插入
	{
		this.sqlSession.insert("ModeratorDao.insertModerator",moderator);
	}
	
	public void updateModeratorLoseDateByUid(Moderator moderator)//moderator中的uid是需要修改的moderator的那一组的uid
	{
		this.sqlSession.update("ModeratorDao.updateModeratorLoseDateByUid",moderator);
	}
	
	
	public void deleteModeratorByUid(int uid)
	{
		this.sqlSession.delete("ModeratorDao.deleteModeratorByUid",uid);
	}
	
	
	public List<Moderator> queryModeratorAll()//查询所有
	{
		return this.sqlSession.selectList("ModeratorDao.queryModeratorAll");
	}
	
	public Moderator queryModeratorByUid(int uid)//通过uid查询
	{
		return this.sqlSession.selectOne("ModeratorDao.queryModeratorByUid",uid);
	}
	
	public Moderator queryModeratorByBid(int bid)//通过bid查询
	{
		return this.sqlSession.selectOne("ModeratorDao.queryModeratorByBid",bid);
	}

}
