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

public class ModeratorDaoTest {
	
	public ModeratorDao moderatorDao;
	public SqlSession sqlSession;
	
	public static void main(String[] args) throws Exception {
		ModeratorDaoTest moderatorDaoTest=new ModeratorDaoTest();
		// mybatis-config.xml
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        moderatorDaoTest.sqlSession = sqlSessionFactory.openSession();
        moderatorDaoTest.moderatorDao = new ModeratorDaoImpl(moderatorDaoTest.sqlSession);
        Moderator moderator=new Moderator(1,1,"2019-1-1","2019-2-1");
        moderatorDaoTest.moderatorDao.insertModerator(moderator);
        //moderatorDaoTest.moderatorDao.updateModeratorLoseDateByUid(moderator);
        //moderatorDaoTest.moderatorDao.deleteModeratorByUid(1);
        //Administrator administrator=administratorDaoTest.administratorDao.queryAdministratorByUid(1);
        //Administrator administrator=new Administrator(2,0,"2011-1-1","1999-1-1");
        //administratorDaoTest.administratorDao.insertAdministrator(administrator);
        List<Moderator> moderatorList=moderatorDaoTest.moderatorDao.queryModeratorAll();
        for (Moderator moderator2 : moderatorList) {
            System.out.println(moderator2);
        }
        //System.out.println(administrator.getAid());
        //administratorDaoTest.sqlSession.commit();
        moderatorDaoTest.sqlSession.commit();
	}

}
