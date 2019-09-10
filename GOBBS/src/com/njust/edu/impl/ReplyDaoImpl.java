package com.njust.edu.impl;

import java.util.List;

import com.njust.edu.pojo.*;
import com.njust.edu.dao.*;
import org.apache.ibatis.session.SqlSession;

public class ReplyDaoImpl implements ReplyDao{
	
	public SqlSession sqlSession;
	
	public ReplyDaoImpl(SqlSession sqlSession)
	{
		this.sqlSession=sqlSession;
	}
	
	public void insertReply(Reply reply)//reply在插入后，其hid会被更改成被赋予的hid
	{
		this.sqlSession.insert("ReplyDao.insertReply",reply);
	}
	
	public void updateReplyByHid(Reply reply)//楼层数就根据post表中的回复数量来赋值
											  //只能更新like_num,is_delete,have_reply_of_reply,ror_num
	{
		this.sqlSession.update("ReplyDao.updateReplyByHid",reply);
	}
	
	public void deleteReplyByHid(int hid)//根据回复编号来删除
	{
		this.sqlSession.delete("ReplyDao.deleteReplyByHid",hid);
	}
	
	public Reply queryReplyByHid(int hid)
	{
		return this.sqlSession.selectOne("ReplyDao.queryReplyByHid",hid);
	}
	
	public List<Reply> queryReplyByUidTid(Reply reply)//查询某个用户在某个帖子发的所有回复
	{
		return this.sqlSession.selectList("ReplyDao.queryReplyByUidTid",reply);
	}
	
	public List<Reply> queryReplyByTid(int tid)//查询某个帖子的所有回复
	{
		return this.sqlSession.selectList("ReplyDao.queryReplyByTid",tid);
	}
	
	public List<Reply> queryReplyAll()
	{
		return this.sqlSession.selectList("ReplyDao.queryReplyAll");
	}

}
