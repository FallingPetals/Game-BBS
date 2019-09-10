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
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        replyDaoTest.sqlSession = sqlSessionFactory.openSession();
        replyDaoTest.replyDao = new ReplyDaoImpl(replyDaoTest.sqlSession);
        String dateNow=DateTime.getDate();
        String timeNow=DateTime.getTime();
        //Reply reply=new Reply(2,2,1,2,dateNow,timeNow,2,2,"哇，现在大佬都自称萌新了吗，我才是真萌新QAQ",0,0,0);
        Reply reply=new Reply(3,2,1,2,dateNow,timeNow,2,2,"sdl,wsl!论坛地位-1",0,0,0);
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
