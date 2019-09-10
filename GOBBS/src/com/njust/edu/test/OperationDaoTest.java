package com.njust.edu.test;

import com.njust.edu.impl.*;
import com.njust.edu.dao.*;
import com.njust.edu.pojo.*;
import com.njust.edu.tool.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class OperationDaoTest {
	
	public OperationDao operationDao;
	public SqlSession sqlSession;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		OperationDaoTest operationDaoTest = new OperationDaoTest();
		// mybatis-config.xml
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        operationDaoTest.sqlSession = sqlSessionFactory.openSession();
        operationDaoTest.operationDao = new OperationDaoImpl(operationDaoTest.sqlSession);
        String dateNow=DateTime.getDate();
        String timeNow=DateTime.getTime();
        Operation operation=new Operation(1,0,dateNow,timeNow,"112.2.79.197",0);
        //operationDaoTest.operationDao.insertOperation(operation);
        //System.out.println(operation.getCid());
        List<Operation> operationList=operationDaoTest.operationDao.queryOperationAll();
        //List<Operation> operationList=operationDaoTest.operationDao.queryOperationByDate("2019-9-9");
        for(Operation operation2 : operationList)
        {
        	System.out.println(operation2);
        }
        operationDaoTest.sqlSession.commit();
	}

}
