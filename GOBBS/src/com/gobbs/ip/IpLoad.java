package com.gobbs.ip;

import com.njust.edu.impl.*;
import com.njust.edu.dao.*;
import com.njust.edu.pojo.*;
import com.njust.edu.test.PostDaoTest;
import com.njust.edu.tool.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class IpLoad {
	
	public OperationDao operationDao;
	public SqlSession sqlSession;
	
	public void login (int uid,String ip)throws Exception
	{
		
		// mybatis-config.xml
        String resource = "mybatis-config.xml";
        // ��ȡ�����ļ�
        InputStream is = Resources.getResourceAsStream(resource);
        // ����SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // ��ȡsqlSession
        this.sqlSession = sqlSessionFactory.openSession();
        this.operationDao = new OperationDaoImpl(this.sqlSession);
        String dateNow=DateTime.getDate();
        String timeNow=DateTime.getTime();
        Operation operation=new Operation(uid,0,dateNow,timeNow,ip,1);//1表示登陆
        this.operationDao.insertOperation(operation);
		List<Operation> operationList=this.operationDao.queryOperationAll();
		for(Operation operation2 : operationList)
		{
			System.out.println(operation2);
		}
		// TODO Auto-generated method stub
		this.sqlSession.commit();
	}
	
	
	public void logout (int uid,String ip)throws Exception
	{
		
		// mybatis-config.xml
        String resource = "mybatis-config.xml";
        // ��ȡ�����ļ�
        InputStream is = Resources.getResourceAsStream(resource);
        // ����SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // ��ȡsqlSession
        this.sqlSession = sqlSessionFactory.openSession();
        this.operationDao = new OperationDaoImpl(this.sqlSession);
        String dateNow=DateTime.getDate();
        String timeNow=DateTime.getTime();
        Operation operation=new Operation(uid,0,dateNow,timeNow,ip,0);//1表示登陆,0表示注销
        this.operationDao.insertOperation(operation);
		List<Operation> operationList=this.operationDao.queryOperationAll();
		for(Operation operation2 : operationList)
		{
			System.out.println(operation2);
		}
		// TODO Auto-generated method stub
		this.sqlSession.commit();
		sqlSession.close();
	}
	
}
