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

public class ApplyDaoTest {
	
	public ApplyDao applyDao;
	public SqlSession sqlSession;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ApplyDaoTest applyDaoTest = new ApplyDaoTest();
		// mybatis-config.xml
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        applyDaoTest.sqlSession = sqlSessionFactory.openSession();
        applyDaoTest.applyDao = new ApplyDaoImpl(applyDaoTest.sqlSession);
        String dateNow=DateTime.getDate();
        String timeNow=DateTime.getTime();
        Apply apply = new Apply(1,1,0,dateNow,timeNow,"我要当少女前线版的版主!GKD！","无");
        //applyDaoTest.applyDao.deleteApplyBySid(1);
        applyDaoTest.applyDao.insertApply(apply);
        System.out.println(apply.getSid());
        List<Apply> applyList=applyDaoTest.applyDao.queryApplyAll();
        for(Apply apply2 : applyList)
        {
        	System.out.println(apply2);
        }
        applyDaoTest.sqlSession.commit();

	}

}
