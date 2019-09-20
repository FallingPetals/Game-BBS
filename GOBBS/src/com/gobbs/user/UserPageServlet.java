package com.gobbs.user;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import com.njust.edu.*;
import com.njust.edu.impl.UserDaoImpl;
import com.njust.edu.pojo.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserPageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserPageServlet() {
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
        User user=new UserDaoImpl(sqlSession).queryUserByUid(uid);
        sqlSession.commit();
        String username=user.getUser_name();
        String nickname=user.getNickname();
        String email=user.getEmail();
        String phone=user.getPhone();
        String point=user.getPoint()+"";
        String personID=user.getId();
        String level=user.getLevel()+"";
        request.setAttribute("username", username);
        request.setAttribute("nickname",nickname);
        request.setAttribute("email", email);
        request.setAttribute("phone",phone);
        request.setAttribute("point",point);
        request.setAttribute("personID",personID);
        request.setAttribute("level",level);
        int statusi=user.getStatus();
        String status;
        if(statusi==0){
        	status="0";
        }
        else if(statusi==1){
        	status="1";
        }else{
        	status="2";
        }
        String postnum=user.getPost_num()+"";
        String Uid=uid+"";
        request.setAttribute("status",status);
        request.setAttribute("uid", Uid);
        request.setAttribute("postnum", postnum);
        request.getRequestDispatcher("../UserPage.jsp").forward(request, response);
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
