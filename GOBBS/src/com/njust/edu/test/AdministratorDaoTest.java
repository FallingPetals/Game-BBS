package com.njust.edu.test;

import com.njust.edu.impl.*;
import com.njust.edu.dao.*;
import com.njust.edu.pojo.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AdministratorDaoTest {
	
	public AdministratorDao administratorDao;
	public SqlSession sqlSession;
	
	public static void main(String[] args) throws Exception {
		AdministratorDaoTest administratorDaoTest=new AdministratorDaoTest();
		// mybatis-config.xml
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        administratorDaoTest.sqlSession = sqlSessionFactory.openSession();
        administratorDaoTest.administratorDao = new AdministratorDaoImpl(administratorDaoTest.sqlSession);
        //Administrator administrator=administratorDaoTest.administratorDao.queryAdministratorByUid(1);
        //Administrator administrator=new Administrator(2,0,"2011-1-1","1999-1-1");
        //administratorDaoTest.administratorDao.insertAdministrator(administrator);
        List<Administrator> administratorList=administratorDaoTest.administratorDao.queryAdministratorAll();
        for (Administrator administrator : administratorList) {
            System.out.println(administrator);
        }
        //System.out.println(administrator.getAid());
        //administratorDaoTest.sqlSession.commit();
	}

}
