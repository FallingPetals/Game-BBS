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

public class ReplyDaoTest {
	
	public ReplyDao replyDao;
	public SqlSession sqlSession;
	
	public static void main(String[] args) throws Exception{
		ReplyDaoTest replyDaoTest=new ReplyDaoTest();
		// mybatis-config.xml
        String resource = "mybatis-config.xml";
        // ��ȡ�����ļ�
        InputStream is = Resources.getResourceAsStream(resource);
        // ����SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // ��ȡsqlSession
        replyDaoTest.sqlSession = sqlSessionFactory.openSession();
        replyDaoTest.replyDao = new ReplyDaoImpl(replyDaoTest.sqlSession);
        String dateNow=DateTime.getDate();
        String timeNow=DateTime.getTime();
        //Reply reply=new Reply(2,2,1,2,dateNow,timeNow,2,2,"�ۣ����ڴ��ж��Գ����������Ҳ���������QAQ",0,0,0);
        Reply reply=new Reply(3,2,1,2,dateNow,timeNow,2,2,"sdl,wsl!��̳��λ-1",0,0,0);
        replyDaoTest.replyDao.insertReply(reply);
        //replyDaoTest.replyDao.deleteReplyByHid(4);
        //replyDaoTest.replyDao.updateReplyByHid(reply);
        List<Reply> replyList=replyDaoTest.replyDao.queryReplyAll();
        for(Reply reply2 : replyList)
        {
        	System.out.println(reply2);
        }
        replyDaoTest.sqlSession.commit();
	}

}
