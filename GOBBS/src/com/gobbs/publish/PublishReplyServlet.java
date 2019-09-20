package com.gobbs.publish;

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

import com.njust.edu.impl.PostDaoImpl;
import com.njust.edu.impl.ReplyDaoImpl;
import com.njust.edu.impl.UserDaoImpl;
import com.njust.edu.pojo.Post;
import com.njust.edu.pojo.Reply;
import com.njust.edu.pojo.User;
import com.njust.edu.tool.DateTime;

public class PublishReplyServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PublishReplyServlet() {
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
		String postid=request.getParameter("postid");
	    String reply_body=request.getParameter("replybody");
		String resource="mybatis-config.xml";
		InputStream is=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		HttpSession session = request.getSession(true);
		String uid=(String)session.getAttribute("uid");
		String reply_date=new DateTime().getDate();
		String reply_time=new DateTime().getTime();
		String font=request.getParameter("font");
	    String fontweight=request.getParameter("fontweight");
	    String fontcolor=request.getParameter("fontcolor");
		reply_body=font+"！@"+fontweight+"！@"+fontcolor+"！@"+reply_body;
		System.out.println(reply_body);
		int like_num=0;
		int collect_num=0;
		int reply_num=0;
		int is_delete=0;
		int tid=Integer.parseInt(postid);
		PostDaoImpl postDaoImpl=new PostDaoImpl(sqlSession);
		Post post=postDaoImpl.queryPostByTid(tid);
		int sectionid=post.getBid();
		int hid=1;
		int reply_order=post.getReply_num()+1;
		post.setReply_num(reply_order);
		postDaoImpl.updatePostByTid(post);
		int have_reply_of_reply=0;
		int ror_num=0;
		Reply reply=new Reply(Integer.parseInt(uid),Integer.parseInt(postid),sectionid,hid,reply_date,reply_time,like_num,reply_order,reply_body,is_delete,have_reply_of_reply,ror_num);
		new ReplyDaoImpl(sqlSession).insertReply(reply);
		UserDaoImpl userDaoImpl=new UserDaoImpl(sqlSession);
		User user=userDaoImpl.queryUserByUid(Integer.parseInt(uid));
		int point=user.getPoint();
		point+=1;
		user.setPoint(point);
		userDaoImpl.updateUserByUid(user);
		sqlSession.commit();
		request.setAttribute("tid", postid);
		System.out.println(postid);
		request.getRequestDispatcher("/servlet/PostPageServlet").forward(request, response);
		sqlSession.close();
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
