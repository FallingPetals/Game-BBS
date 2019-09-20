package com.gobbs.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MailVerifyServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MailVerifyServlet() {
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

		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
		request.setCharacterEncoding("utf-8");
	     response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取信息
		String username=request.getParameter("username");
		String nickname=request.getParameter("nickname");
		String phone=request.getParameter("phone");
		String personID=request.getParameter("personID");
		String pwd=request.getParameter("pwd");
		String rpwd=request.getParameter("rpwd");
		String email=request.getParameter("email");
		String ucode=request.getParameter("ucode");
		//验证码
		StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
		 String code=str.toString();
		 Runnable sendmail=new Mail(email,code);
		 Thread mailthread=new Thread(sendmail);
	     mailthread.start();
	     //返回
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
         rd.forward(request,response);
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
