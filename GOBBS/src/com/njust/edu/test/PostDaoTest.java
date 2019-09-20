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

public class PostDaoTest {
	
	public PostDao postDao;
	public SqlSession sqlSession;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		PostDaoTest postDaoTest=new PostDaoTest();
		// mybatis-config.xml
        String resource = "mybatis-config.xml";
        // ��ȡ�����ļ�
        InputStream is = Resources.getResourceAsStream(resource);
        // ����SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // ��ȡsqlSession
        postDaoTest.sqlSession = sqlSessionFactory.openSession();
        postDaoTest.postDao = new PostDaoImpl(postDaoTest.sqlSession);
        String dateNow=DateTime.getDate();
        String timeNow=DateTime.getTime();
        //Post post=new Post(1,2,1,dateNow,timeNow,0,0,0,"������������!!!","�����Ǻã�������������ң�Ҥ�ӣ�������ָ�ӹ٣��ε�ͺ�ӣ������ָ�̣�",0);
        //postDaoTest.postDao.updatePostByTid(post);
        //postDaoTest.postDao.deletePostByTid(4);
        //Post post=postDaoTest.postDao.queryPostByTid(2);
        //System.out.println(post);
        //postDaoTest.postDao.insertPost(post);
        //System.out.println(post.getTid());
        String str = '%'+"森哥"+'%';
		//List<Post> postList=postDaoTest.postDao.queryPostAll();
		List<Post> postList=postDaoTest.postDao.searchPost(str);
		for(Post post2 : postList)
		{
			System.out.println(post2);
		}
		// TODO Auto-generated method stub
		postDaoTest.sqlSession.commit();

	}

}
