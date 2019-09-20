package com.njust.edu.impl;

import java.util.List;

import com.njust.edu.pojo.*;
import com.njust.edu.dao.*;
import org.apache.ibatis.session.SqlSession;

public class LexiconDaoImpl implements LexiconDao{
	
	public SqlSession sqlSession;
	
	public LexiconDaoImpl(SqlSession sqlSession)
	{
		this.sqlSession=sqlSession;
	}
	
	public void insertLexicon(String content)
	{
		this.sqlSession.insert("LexiconDao.insertLexicon",content);
	}
	
	public void deleteLexiconByContent(String content)
	{
		this.sqlSession.delete("LexiconDao.deleteLexiconByContent",content);
	}
	
	public List<Lexicon> queryLexiconAll()
	{
		return this.sqlSession.selectList("LexiconDao.queryLexiconAll");
	}

}
