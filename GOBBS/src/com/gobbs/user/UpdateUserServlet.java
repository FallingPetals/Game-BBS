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

import com.njust.edu.impl.UserDaoImpl;
import com.njust.edu.pojo.User;

public class UpdateUserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateUserServlet() {
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
 		HttpSession session = request.getSession(true);
        int uid=Integer.parseInt((String)session.getAttribute("uid"));
        String resource="mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession;
        sqlSession=sqlSessionFactory.openSession();
        String nickname2=request.getParameter("nickname");
        String nickname=new String(nickname2.getBytes("ISO-8859-1"),"UTF-8");
        String email=request.getParameter("email");
        UserDaoImpl userDaoImpl=new UserDaoImpl(sqlSession);
        User user=userDaoImpl.queryUserByUid(uid);
        user.setEmail(email);
        user.setNickname(nickname);
        System.out.println(email);
        System.out.println(nickname);
        sqlSession.commit();
        userDaoImpl.updateUserByUid(user);
        sqlSession.commit();
        session.setAttribute("nickname", nickname);
        sqlSession.close();
        request.getRequestDispatcher("/servlet/UserPageServlet").forward(request, response);
        
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
