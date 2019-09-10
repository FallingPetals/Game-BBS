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
        // ��ȡ�����ļ�
        InputStream is = Resources.getResourceAsStream(resource);
        // ����SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // ��ȡsqlSession
        applyDaoTest.sqlSession = sqlSessionFactory.openSession();
        applyDaoTest.applyDao = new ApplyDaoImpl(applyDaoTest.sqlSession);
        String dateNow=DateTime.getDate();
        String timeNow=DateTime.getTime();
        Apply apply = new Apply(1,1,0,dateNow,timeNow,"��Ҫ����Ůǰ�߰�İ���!GKD��","��");
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
