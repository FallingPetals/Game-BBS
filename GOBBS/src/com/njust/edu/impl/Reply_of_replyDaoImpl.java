package com.njust.edu.impl;

import java.util.List;

import com.njust.edu.pojo.*;
import com.njust.edu.dao.*;
import org.apache.ibatis.session.SqlSession;

public class Reply_of_replyDaoImpl implements Reply_of_replyDao{
	
	public SqlSession sqlSession;
	
	public Reply_of_replyDaoImpl(SqlSession sqlSession)
	{
		this.sqlSession=sqlSession;
	}
	
	public void insertRor(Reply_of_reply reply_of_reply)
	{
		this.sqlSession.insert("Reply_of_replyDao.insertRor",reply_of_reply);
	}
	
	public void updateRorByLid(Reply_of_reply reply_of_reply)//根据楼中楼编号修改
															  //只能修改like_num,is_delete
	{
		this.sqlSession.update("Reply_of_replyDao.updateRorByLid",reply_of_reply);
	}
	
	public void deleteRorByLid(int lid)
	{
		this.sqlSession.delete("Reply_of_replyDao.deleteRorByLid",lid);
	}
	
	public Reply_of_reply queryRorByLid(int lid)//根据楼中楼编号查询
	{
		return this.sqlSession.selectOne("Reply_of_replyDao.queryRorByLid",lid);
	}
	
	public List<Reply_of_reply> queryRorByHid(int hid)//查询某个回帖的所有楼中楼回复
	{
		return this.sqlSession.selectList("Reply_of_replyDao.queryRorByHid",hid);
	}
	
	public List<Reply_of_reply> queryRorAll()
	{
		return this.sqlSession.selectList("Reply_of_replyDao.queryRorAll");
	}

}
