package com.gobbs.login;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import com.njust.*;
import com.njust.edu.dao.UserDao;
import com.njust.edu.impl.UserDaoImpl;
import com.njust.edu.pojo.User;
import com.gobbs.ip.*;

import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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
			throws ServletException, IOException{

		 response.setContentType("text/html"); 
	     request.setCharacterEncoding("utf-8");
	     response.setCharacterEncoding("utf-8");
	     //璇诲彇鐢ㄦ埛鍚嶅瘑鐮�
	     String username=request.getParameter("username");
	     String pwd=request.getParameter("pwd");
	     //璇诲彇鏁版嵁搴撶敤鎴峰悕瀵嗙爜
	     String resource = "mybatis-config.xml";
         InputStream is = Resources.getResourceAsStream(resource);
         SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
     	 UserDao userDao;
    	 SqlSession sqlSession;
         sqlSession = sqlSessionFactory.openSession();
         userDao = new UserDaoImpl(sqlSession);
         List<User> userlist=userDao.queryUserAll();
         int flag=0;
         int flagu=0;
  		sqlSession.commit();
         for(User user : userlist)
         {
        	 flag++;
         	if(username.equals(user.getUser_name())&&pwd.equals(user.getPassword())){
         		String uid=user.getUid()+"";
         		String nickname=user.getNickname();
         		String status=user.getStatus()+"";
         		HttpSession session = request.getSession(true);
         		session.setAttribute("uid",uid);
         		session.setAttribute("nickname",nickname);
         		session.setAttribute("status", status);
         		
         		IpLoad ip = new IpLoad();
         		String ip_str = request.getRemoteAddr();
         		int uid_int=Integer.valueOf(uid).intValue();
         		try
         		{
         			System.out.println("uid="+uid_int+",ip="+ip_str);
         			ip.login(uid_int, ip_str);
         		}
         		catch(Exception ex)
         		{
         			
         		}
         		request.getRequestDispatcher("/servlet/MainPageServlet").forward(request, response);
         	}
         	else{
         		flagu++;
         	}
         }
         if(flag==flagu){
        	 String loginEr="用户名或密码错误";
        	 request.setAttribute("username", username);
        	 request.setAttribute("pwd", pwd);
        	 request.setAttribute("loginEr", loginEr);
        	 RequestDispatcher rd=request.getRequestDispatcher("../LoginPage.jsp");
        	 rd.forward(request,response);
         }
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
