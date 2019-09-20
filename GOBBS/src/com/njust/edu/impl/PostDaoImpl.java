package com.njust.edu.impl;

import java.util.List;

import com.njust.edu.pojo.*;
import com.njust.edu.dao.*;
import org.apache.ibatis.session.SqlSession;

public class PostDaoImpl implements PostDao{
	
	public SqlSession sqlSession;
	
	public PostDaoImpl(SqlSession sqlSession)
	{
		this.sqlSession=sqlSession;
	}
	
	public void insertPost(Post post)//post�ڲ������tid�ᱻ��ĳɱ������tid
	{
		this.sqlSession.insert("PostDao.insertPost",post);
	}
	
	public void updatePostByTid(Post post)
	{
		this.sqlSession.update("PostDao.updatePostByTid",post);
	}
	
	public void deletePostByTid(int tid)
	{
		this.sqlSession.delete("PostDao.deletePostByTid",tid);
	}
	
	public Post queryPostByTid(int tid)
	{
		return this.sqlSession.selectOne("PostDao.queryPostByTid",tid);
	}
	
	public List<Post> queryPostByUid(int uid)//��ѯĳ���û�������������
	{
		return this.sqlSession.selectList("PostDao.queryPostByUid",uid);
	}
	
	public List<Post> queryPostByBid(int bid)//��ѯĳ��������������
	{
		return this.sqlSession.selectList("PostDao.queryPostByBid",bid);
	}
	
	public List<Post> queryPostAll()
	{
		return this.sqlSession.selectList("PostDao.queryPostAll");
	}
	
	public List<Post> searchPost(String str)//根据关键字搜索
	{
		return this.sqlSession.selectList("PostDao.searchPost",str);
	}


}
