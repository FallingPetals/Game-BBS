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

public class Reply_of_replyDaoTest {

	public Reply_of_replyDao reply_of_replyDao;
	public SqlSession sqlSession;
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Reply_of_replyDaoTest reply_of_replyDaoTest=new Reply_of_replyDaoTest();
		// mybatis-config.xml
        String resource = "mybatis-config.xml";
        // ��ȡ�����ļ�
        InputStream is = Resources.getResourceAsStream(resource);
        // ����SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // ��ȡsqlSession
        reply_of_replyDaoTest.sqlSession = sqlSessionFactory.openSession();
        reply_of_replyDaoTest.reply_of_replyDao = new Reply_of_replyDaoImpl(reply_of_replyDaoTest.sqlSession);
        String dateNow=DateTime.getDate();
        String timeNow=DateTime.getTime();
        //Reply_of_reply reply_of_reply=new Reply_of_reply(4,5,2,dateNow,timeNow,1,1,"����˵Ц�ˣ��㶼150���˻������װ����",0);
        //reply_of_replyDaoTest.reply_of_replyDao.insertRor(reply_of_reply);
        //reply_of_replyDaoTest.reply_of_replyDao.updateRorByLid(reply_of_reply);
        reply_of_replyDaoTest.reply_of_replyDao.deleteRorByLid(3);
        List<Reply_of_reply> reply_of_replyList=reply_of_replyDaoTest.reply_of_replyDao.queryRorAll();
        for(Reply_of_reply reply_of_reply2 : reply_of_replyList)
        {
        	System.out.println(reply_of_reply2);
        }
        reply_of_replyDaoTest.sqlSession.commit();
	}

}
