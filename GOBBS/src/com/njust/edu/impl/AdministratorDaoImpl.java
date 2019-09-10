package com.njust.edu.impl;

import java.util.List;

import com.njust.edu.pojo.*;
import com.njust.edu.dao.*;
import org.apache.ibatis.session.SqlSession;

public class AdministratorDaoImpl implements AdministratorDao{//这是impl，第一个字母是i的大写，不是l
	public SqlSession sqlSession;
	
	public AdministratorDaoImpl(SqlSession sqlSession) 
	{
        this.sqlSession = sqlSession;
    }
	
	public void insertAdministrator(Administrator administrator)//插入
	{
		this.sqlSession.insert("AdministratorDao.insertAdministrator",administrator);
	}
	
	public void updateAdminstartorLoseDateByUid(Administrator administrator)//administrator中的uid是需要修改的administrator的那一组的uid
	{
		this.sqlSession.update("AdministratorDao.updateAdminstartorLoseDateByUid",administrator);
	}
	
	public void updateAdminstartorLoseDateByAid(Administrator administrator)//administrator中的aid是需要修改的administrator的那一组的aid
	{
		this.sqlSession.update("AdministratorDao.updateAdminstartorLoseDateByAid",administrator);
	}
	
	public void deleteAdminstartorByUid(int uid)
	{
		this.sqlSession.delete("deleteAdminstartorByUid",uid);
	}
	
	public void deleteAdminstartorByAid(int aid)
	{
		this.sqlSession.delete("deleteAdminstartorByAid",aid);
	}
	
	public List<Administrator> queryAdministratorAll()//查询所有
	{
		return this.sqlSession.selectList("queryAdministratorAll");
	}
	
	public Administrator queryAdministratorByUid(int uid)//通过uid查询
	{
		return this.sqlSession.selectOne("queryAdministratorByUid",uid);
	}
	
	public Administrator queryAdministratorByAid(int aid)//通过aid查询
	{
		return this.sqlSession.selectOne("queryAdministratorByAid",aid);
	}
}
