package com.gobbs.register;
import java.io.IOException;
import java.io.InputStream;

import com.njust.edu.pojo.User;
import com.njust.edu.tool.*;
import com.njust.edu.dao.UserDao;
import com.njust.edu.impl.UserDaoImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.njust.edu.test.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class RegisterServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
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
			throws ServletException, IOException {
	  	 response.setContentType("text/html"); 
	     request.setCharacterEncoding("utf-8");
	     response.setCharacterEncoding("utf-8");
	     String username=request.getParameter("username");	
	     String nickname=request.getParameter("nickname");
	     String phone=request.getParameter("phone");
	     String personID=request.getParameter("personID");
	     String pwd=request.getParameter("pwd");
	     String rpwd=request.getParameter("rpwd");
	     String email=request.getParameter("email");
	     String ucode=request.getParameter("ucode");
	     String code=request.getParameter("code");
	     String usernameEr=null;	
	     String nicknameEr=null;
	     String phoneEr=null;
	     String personIDEr=null;
	     String pwdEr=null;
	     String rpwdEr=null;
	     String emailEr=null;
	     int flag=0;
	     //Âà§ÂÆöËæìÂÖ•‰ø°ÊÅØ
	     Judge judge=new Judge();
	     if(judge.user_nameJudge(username)==0){
	    	 usernameEr="”√ªß√˚ ‰»Î¥ÌŒÛ£°";
	     }
	     else if(judge.nicknameJudge(nickname)==0){
	    	 nicknameEr="Í«≥∆ ‰»Î¥ÌŒÛ£°";
	     }
	     else if(judge.phoneJudge(phone)==0){
	    	 phoneEr="µÁª∞ ‰»Î¥ÌŒÛ£°";
	     }
	     else if(judge.passwordJudge(pwd)==0){
	    	 pwdEr="√‹¬Î ‰»Î¥ÌŒÛ£°";
	     }
	     else if(pwd.equals(rpwd)==false){
	    	 rpwdEr="÷ÿ∏¥√‹¬Î ‰»Î¥ÌŒÛ£°";
	     }
	     else if(judge.emailJudge(email)==0){
	    	 emailEr="” œ‰ ‰»Î¥ÌŒÛ£°";
	     }
	     else if(ucode!=null&&code!=null&&ucode.equals(code)){
	    	 flag=1;
	    	 //ÂΩïÂÖ•Ê≥®ÂÜåÁî®Êà∑‰ø°ÊÅØ
	    	 int uid=1;
	    	 int level=1;
	    	 int point=0;
	    	 new DateTime();
			String join_date=DateTime.getDate();
	    	 int post_num=0;
	    	 int status=1;
	    	 String resource = "mybatis-config.xml";
	         InputStream is = Resources.getResourceAsStream(resource);
	         SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
	     	 UserDao userDao;
	    	 SqlSession sqlSession;
	         sqlSession = sqlSessionFactory.openSession();
	         userDao = new UserDaoImpl(sqlSession);
	         User user=new User(uid,username,pwd,nickname,email,phone,personID,level,point,join_date,post_num,status);
	         userDao.insertUser(user);
	         sqlSession.commit();
	    	 request.getRequestDispatcher("/servlet/MainPageServlet").forward(request, response);//response.sendRedirect("../MainPage.jsp");
	    	 sqlSession.close();
	     }
	     if(flag==0){
	    	 RequestDispatcher rd=request.getRequestDispatcher("../register.jsp");
		     request.setAttribute( "username",username);
		     request.setAttribute( "nickname",nickname);
		     request.setAttribute( "phone",phone);
		     request.setAttribute( "personID",personID);
		     request.setAttribute( "pwd",pwd);
		     request.setAttribute( "rpwd",rpwd);
		     request.setAttribute( "email",email);
		     request.setAttribute( "ucode",ucode);
		     request.setAttribute( "code",code);
		     request.setAttribute( "usernameEr",usernameEr);
		     request.setAttribute( "nicknameEr",nicknameEr);
		     request.setAttribute( "phoneEr",phoneEr);
		     request.setAttribute( "personIDEr",personIDEr);
		     request.setAttribute( "pwdEr",pwdEr);
		     request.setAttribute( "rpwdEr",rpwdEr);
		     request.setAttribute( "emailEr",emailEr);
	    	 rd.forward(request,response);
	     }
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
