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

public class LexiconDaoTest {
	
	public LexiconDao lexiconDao;
	public SqlSession sqlSession;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		LexiconDaoTest lexiconDaoTest = new LexiconDaoTest();
		String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        lexiconDaoTest.sqlSession = sqlSessionFactory.openSession();
        lexiconDaoTest.lexiconDao = new LexiconDaoImpl(lexiconDaoTest.sqlSession);
        String dateNow=DateTime.getDate();
        String timeNow=DateTime.getTime();
        //Lexicon lexicon=new Lexicon(1,"日本");
        //lexiconDaoTest.lexiconDao.insertLexicon("日本");
        ScreenNode ti = ScreenNode.getInstance();
        List<Lexicon> lexiconList=lexiconDaoTest.lexiconDao.queryLexiconAll();
        for(Lexicon lexicon2 : lexiconList)//查询屏蔽词之前必须执行这个循环，里面的println可以去掉，但是add必须保留，这一步是把数据库里的屏蔽词存入ScreenNode这个屏蔽树中
        {
        	System.out.println(lexicon2);
        	ti.add(lexicon2.getContent());
        }
        String s = "我叫范恒旭，我来自日本，我最喜欢的东西是Sakura";
        System.out.println("src: " + s);
        String ss = ti.replace(s,null,null);//后面两个就填null就行,replace可以把屏蔽词按照它的长度换成等长度的*
        Boolean flag = ti.existWords(s,null,null);//这里也是一样，existWords可以返回是否含有屏蔽词
		System.out.println("是否含有违禁词：" + flag);
		System.out.println("result: " + ss);
        lexiconDaoTest.sqlSession.commit();
        
	}

}
