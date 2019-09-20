package com.gobbs.user;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.njust.edu.impl.CollectionDaoImpl;
import com.njust.edu.impl.PostDaoImpl;
import com.njust.edu.impl.ReplyDaoImpl;
import com.njust.edu.pojo.Collection;
import com.njust.edu.pojo.Post;
import com.njust.edu.pojo.Reply;

public class CollectServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CollectServlet() {
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
		HttpSession session = request.getSession(true);
		InputStream is=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		String postid=request.getParameter("postid");
		String replyid=request.getParameter("replyid");
		int tid=Integer.parseInt(postid);
		int uid=Integer.parseInt((String)session.getAttribute("uid"));
			PostDaoImpl postDaoImpl=new PostDaoImpl(sqlSession);
			Post post=postDaoImpl.queryPostByTid(tid);
			int collect_num=post.getCollect_num();
			System.out.println(collect_num);
			collect_num++;
			System.out.println(collect_num);
			post.setCollect_num(collect_num);
			Collection collection=new Collection(uid,tid);
			new CollectionDaoImpl(sqlSession).insertCollection(collection);
			postDaoImpl.updatePostByTid(post);
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
