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

public class Password_protectionDaoTest {
	
	public Password_protectionDao password_protectionDao;
	public SqlSession sqlSession;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Password_protectionDaoTest password_protectionDaoTest = new Password_protectionDaoTest();
		// mybatis-config.xml
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        password_protectionDaoTest.sqlSession = sqlSessionFactory.openSession();
        password_protectionDaoTest.password_protectionDao = new Password_protectionDaoImpl(password_protectionDaoTest.sqlSession);
        String dateNow=DateTime.getDate();
        String timeNow=DateTime.getTime();
        //Password_protection password_protection = new Password_protection(1,1,"我生日是几月几日","4月20日");
        //Password_protection password_protection = new Password_protection(1,2,"我小学的名字是什么","瓦市小学");
        //Password_protection password_protection = new Password_protection(1,3,"我爸爸叫什么名字","戴强");
        //password_protectionDaoTest.password_protectionDao.insertPassword_Protection(password_protection);
        //password_protectionDaoTest.password_protectionDao.updatePassword_protection(password_protection);
        List<Password_protection> password_protectionList=password_protectionDaoTest.password_protectionDao.queryPassword_protectionAll();
        //List<Password_protection> password_protectionList=password_protectionDaoTest.password_protectionDao.queryPassword_protectionByUid(1);
        for(Password_protection password_protection2 : password_protectionList)
        {
        	System.out.println(password_protection2);
        }
        password_protectionDaoTest.sqlSession.commit();

	}

}
