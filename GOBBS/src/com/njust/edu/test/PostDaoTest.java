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
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        postDaoTest.sqlSession = sqlSessionFactory.openSession();
        postDaoTest.postDao = new PostDaoImpl(postDaoTest.sqlSession);
        String dateNow=DateTime.getDate();
        String timeNow=DateTime.getTime();
        //Post post=new Post(1,2,1,dateNow,timeNow,0,0,0,"萌新来报道辣!!!","大佬们好！我是新来格里芬（窑子）的萌新指挥官（肝帝秃子），请多指教！",0);
        //postDaoTest.postDao.updatePostByTid(post);
        //postDaoTest.postDao.deletePostByTid(4);
        //Post post=postDaoTest.postDao.queryPostByTid(2);
        //System.out.println(post);
        //postDaoTest.postDao.insertPost(post);
        //System.out.println(post.getTid());
		List<Post> postList=postDaoTest.postDao.queryPostAll();
		for(Post post2 : postList)
		{
			System.out.println(post2);
		}
		// TODO Auto-generated method stub
		postDaoTest.sqlSession.commit();

	}

}
