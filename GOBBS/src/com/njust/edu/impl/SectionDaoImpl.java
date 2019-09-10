package com.njust.edu.impl;

import java.util.List;

import com.njust.edu.pojo.*;
import com.njust.edu.dao.*;
import org.apache.ibatis.session.SqlSession;

public class SectionDaoImpl implements SectionDao{
	
	public SqlSession sqlSession;
	
	public SectionDaoImpl(SqlSession sqlSession)
	{
		this.sqlSession=sqlSession;
	}
	
	public void insertSection(Section section)
	{
		this.sqlSession.insert("SectionDao.insertSection",section);
	}
	
	public void updateSectionByBid(Section section)//能修改section_name,section_type,headline
	{
		this.sqlSession.update("SectionDao.updateSectionByBid",section);
	}
	
	public void updateSectionBySectionName(Section section)//不能修改section_name,只能修改section_type,headline
	{
		this.sqlSession.update("SectionDao.updateSectionBySectionName",section);
	}
	
	public void deleteSectionByBid(int bid)
	{
		this.sqlSession.delete("SectionDao.deleteSectionByBid",bid);
	}
	
	public void deleteSectionBySectionName(String section_name)
	{
		this.sqlSession.delete("SectionDao.deleteSectionBySectionName",section_name);
	}
	
	public Section querySectionByBid(int bid)//根据版块编号查询
	{
		return this.sqlSession.selectOne("SectionDao.querySectionByBid",bid);
	}
	
	public Section querySectionBySectionName(String section_name)//根据板块名字查询
	{
		return this.sqlSession.selectOne("SectionDao.querySectionBySectionName",section_name);
	}
	
	public List<Section> querySectionAll()
	{
		return this.sqlSession.selectList("SectionDao.querySectionAll");
	}

}
