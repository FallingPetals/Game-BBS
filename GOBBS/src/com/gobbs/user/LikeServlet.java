package com.gobbs.user;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.njust.edu.impl.PostDaoImpl;
import com.njust.edu.impl.ReplyDaoImpl;
import com.njust.edu.pojo.Post;
import com.njust.edu.pojo.Reply;

public class LikeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LikeServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html"); 
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String resource="mybatis-config.xml";
		InputStream is=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		String postid=request.getParameter("postid");
		String replyid=request.getParameter("replyid");
		int tid=Integer.parseInt(postid);
		int hid=Integer.parseInt(replyid);
		if(!(hid==0)){
			ReplyDaoImpl replyDaoImpl=new ReplyDaoImpl(sqlSession);
			Reply reply=replyDaoImpl.queryReplyByHid(hid);
			int like_num=reply.getLike_num();
			like_num++;
			reply.setLike_num(like_num);
		}
		else{
			PostDaoImpl postDaoImpl=new PostDaoImpl(sqlSession);
			Post post=postDaoImpl.queryPostByTid(tid);
			int like_num=post.getLike_num();
			System.out.println(like_num);
			like_num++;
			System.out.println(like_num);
			post.setLike_num(like_num);
			postDaoImpl.updatePostByTid(post);
		}
		sqlSession.commit();
		request.setAttribute("tid", postid);
		sqlSession.close();
		request.getRequestDispatcher("/servlet/PostPageServlet").forward(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
