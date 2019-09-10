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

public class Special_postDaoTest {

	public Special_postDao special_postDao;
	public SqlSession sqlSession;
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Special_postDaoTest special_postDaoTest=new Special_postDaoTest();
		// mybatis-config.xml
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        special_postDaoTest.sqlSession = sqlSessionFactory.openSession();
        special_postDaoTest.special_postDao = new Special_postDaoImpl(special_postDaoTest.sqlSession);
        String dateNow=DateTime.getDate();
        String timeNow=DateTime.getTime();
        Special_post special_post=new Special_post(1,2,1);
        special_postDaoTest.special_postDao.insertSpecial_post(special_post);
        //special_postDaoTest.special_postDao.updateSpecial_postByTid(special_post);
        //special_postDaoTest.special_postDao.deleteSpecial_postByTid(2);
        List<Special_post> special_postList=special_postDaoTest.special_postDao.querySpecial_postAll();
        for(Special_post special_post2 : special_postList)
        {
        	System.out.println(special_post2);
        }
        special_postDaoTest.sqlSession.commit();
	}

}
