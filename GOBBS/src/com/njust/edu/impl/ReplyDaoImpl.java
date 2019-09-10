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
	
	public void insertReply(Reply reply)//reply�ڲ������hid�ᱻ���ĳɱ������hid
	{
		this.sqlSession.insert("ReplyDao.insertReply",reply);
	}
	
	public void updateReplyByHid(Reply reply)//¥�����͸���post���еĻظ���������ֵ
											  //ֻ�ܸ���like_num,is_delete,have_reply_of_reply,ror_num
	{
		this.sqlSession.update("ReplyDao.updateReplyByHid",reply);
	}
	
	public void deleteReplyByHid(int hid)//���ݻظ������ɾ��
	{
		this.sqlSession.delete("ReplyDao.deleteReplyByHid",hid);
	}
	
	public Reply queryReplyByHid(int hid)
	{
		return this.sqlSession.selectOne("ReplyDao.queryReplyByHid",hid);
	}
	
	public List<Reply> queryReplyByUidTid(Reply reply)//��ѯĳ���û���ĳ�����ӷ������лظ�
	{
		return this.sqlSession.selectList("ReplyDao.queryReplyByUidTid",reply);
	}
	
	public List<Reply> queryReplyByTid(int tid)//��ѯĳ�����ӵ����лظ�
	{
		return this.sqlSession.selectList("ReplyDao.queryReplyByTid",tid);
	}
	
	public List<Reply> queryReplyAll()
	{
		return this.sqlSession.selectList("ReplyDao.queryReplyAll");
	}

}
