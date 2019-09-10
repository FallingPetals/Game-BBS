package com.njust.edu.impl;

import java.util.List;

import com.njust.edu.pojo.*;
import com.njust.edu.dao.*;
import org.apache.ibatis.session.SqlSession;

public class AdministratorDaoImpl implements AdministratorDao{//����impl����һ����ĸ��i�Ĵ�д������l
	public SqlSession sqlSession;
	
	public AdministratorDaoImpl(SqlSession sqlSession) 
	{
        this.sqlSession = sqlSession;
    }
	
	public void insertAdministrator(Administrator administrator)//����
	{
		this.sqlSession.insert("AdministratorDao.insertAdministrator",administrator);
	}
	
	public void updateAdminstartorLoseDateByUid(Administrator administrator)//administrator�е�uid����Ҫ�޸ĵ�administrator����һ���uid
	{
		this.sqlSession.update("AdministratorDao.updateAdminstartorLoseDateByUid",administrator);
	}
	
	public void updateAdminstartorLoseDateByAid(Administrator administrator)//administrator�е�aid����Ҫ�޸ĵ�administrator����һ���aid
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
	
	public List<Administrator> queryAdministratorAll()//��ѯ����
	{
		return this.sqlSession.selectList("queryAdministratorAll");
	}
	
	public Administrator queryAdministratorByUid(int uid)//ͨ��uid��ѯ
	{
		return this.sqlSession.selectOne("queryAdministratorByUid",uid);
	}
	
	public Administrator queryAdministratorByAid(int aid)//ͨ��aid��ѯ
	{
		return this.sqlSession.selectOne("queryAdministratorByAid",aid);
	}
}
