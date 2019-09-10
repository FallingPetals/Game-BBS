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

public class CollectionDaoTest {
	
	public CollectionDao collectionDao;
	public SqlSession sqlSession;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		CollectionDaoTest collectionDaoTest = new CollectionDaoTest();
		// mybatis-config.xml
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        collectionDaoTest.sqlSession = sqlSessionFactory.openSession();
        collectionDaoTest.collectionDao = new CollectionDaoImpl(collectionDaoTest.sqlSession);
        String dateNow=DateTime.getDate();
        String timeNow=DateTime.getTime();
        Collection collection=new Collection(1,2);
        collectionDaoTest.collectionDao.insertCollection(collection);
        //collectionDaoTest.collectionDao.deleteCollection(collection);
        List<Collection> collectionList = collectionDaoTest.collectionDao.queryCollectionAll();
        for(Collection collection2 : collectionList)
        {
        	System.out.println(collection2);
        }
        collectionDaoTest.sqlSession.commit();
	}

}
