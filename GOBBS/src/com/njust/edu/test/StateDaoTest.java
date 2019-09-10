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

public class StateDaoTest {
	
	public StateDao stateDao;
	public SqlSession sqlSession;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		StateDaoTest stateDaoTest = new StateDaoTest();
		// mybatis-config.xml
        String resource = "mybatis-config.xml";
        // ��ȡ�����ļ�
        InputStream is = Resources.getResourceAsStream(resource);
        // ����SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // ��ȡsqlSession
        stateDaoTest.sqlSession = sqlSessionFactory.openSession();
        stateDaoTest.stateDao = new StateDaoImpl(stateDaoTest.sqlSession);
        String dateNow=DateTime.getDate();
        String timeNow=DateTime.getTime();
        State state=new State(1,1,1,"2019-9-11");
        //stateDaoTest.stateDao.updateStateByUidBid(state);
        stateDaoTest.stateDao.deleteStateByUidBid(state);
        //stateDaoTest.stateDao.insertState(state);
        List<State> stateList=stateDaoTest.stateDao.queryStateAll();
        for(State state2 : stateList)
        {
        	System.out.println(state2);
        }
        stateDaoTest.sqlSession.commit();

	}

}
