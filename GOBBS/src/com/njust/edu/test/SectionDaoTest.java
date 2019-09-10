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

public class SectionDaoTest {

	public SectionDao sectionDao;
	public SqlSession sqlSession;
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		SectionDaoTest sectionDaoTest=new SectionDaoTest();
		// mybatis-config.xml
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        sectionDaoTest.sqlSession = sqlSessionFactory.openSession();
        sectionDaoTest.sectionDao = new SectionDaoImpl(sectionDaoTest.sqlSession);
        String dateNow=DateTime.getDate();
        String timeNow=DateTime.getTime();
        Section section=new Section(5,"最终幻想14",0,"欢迎来到最终幻想14版块！");
        sectionDaoTest.sectionDao.updateSectionBySectionName(section);
        //sectionDaoTest.sectionDao.deleteSectionBySectionName("最终幻想14");
        List<Section> sectionList = sectionDaoTest.sectionDao.querySectionAll();
        for(Section section2 : sectionList)
        {
        	System.out.println(section2);
        }
        sectionDaoTest.sqlSession.commit();
	}

}
