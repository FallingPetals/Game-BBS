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

public class UserDaoTest {
	public UserDao userDao;
	public SqlSession sqlSession;
	
	public static void main(String[] args) throws Exception {
		UserDaoTest userDaoTest=new UserDaoTest();
		// mybatis-config.xml
        String resource = "mybatis-config.xml";
        // ��ȡ�����ļ�
        InputStream is = Resources.getResourceAsStream(resource);
        // SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // ��ȡsqlSession
        userDaoTest.sqlSession = sqlSessionFactory.openSession();
        userDaoTest.userDao = new UserDaoImpl(userDaoTest.sqlSession);
        
        //User user=userDaoTest.userDao.queryUserByUid(1);
        //System.out.println(user);
        User user=new User(1,"ffkamisama","134679","森哥爸爸","2404612773@qq.com","18767731268","510504199906060311",9,9,"2019-9-8",0,0);
        //userDaoTest.userDao.updateUserByUserName(user);
        userDaoTest.userDao.insertUser(user);
        //System.out.println(user.getUid());
       // userDaoTest.userDao.deleteUserByUserName("���Ķ�");
        
        List<User> userList=userDaoTest.userDao.queryUserAll();
        for(User user2 : userList)
        {
        	System.out.println(user2);
        }
        
        userDaoTest.sqlSession.commit();
	}

}
