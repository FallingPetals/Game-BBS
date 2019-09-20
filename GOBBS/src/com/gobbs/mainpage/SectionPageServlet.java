package com.gobbs.mainpage;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.njust.edu.*;
import com.njust.edu.impl.PostDaoImpl;
import com.njust.edu.impl.SectionDaoImpl;
import com.njust.edu.impl.UserDaoImpl;
import com.njust.edu.pojo.*;
public class SectionPageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SectionPageServlet() {
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
	     String sectionid=(String)request.getParameter("sectionid");
	     String resource="mybatis-config.xml";
	     InputStream is=Resources.getResourceAsStream(resource);
	     SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
	     SqlSession sqlSession=sqlSessionFactory.openSession();
	     Section section=new SectionDaoImpl(sqlSession).querySectionByBid(Integer.parseInt(sectionid));
	     String scname=section.getSection_name();
	     String scheadline=section.getHeadline();
	     List<Post> postlist= new PostDaoImpl(sqlSession).queryPostByBid(Integer.parseInt(sectionid));
	     sqlSession.commit();
	     List<Map> list =new ArrayList<Map>();//创建list集合用于存入map的键值对集合
	     int postnum=0;
	     for(Post post:postlist){
	    	 if(postnum<10){
	    	 Map postmap=new HashMap();
	    	 postmap.put("postname", post.getTitle());
	         postmap.put("postid", post.getTid()); 	
	         postmap.put("postdate", post.getPost_date()); 	
	         list.add(postmap);
	    	 }
	         postnum++;
	     }
	     List<Map> numlist=new ArrayList<Map>();
	     int isumPage=(postnum-1)/10+1;
	     for(int n=1;n<=isumPage;n++){
	    	 Map nummap=new HashMap();
	    	 nummap.put("NOP",n);
	    	 numlist.add(nummap);
	     }
	     String sumPage=isumPage+"";
	     request.setAttribute("nowPage", "1");
	     request.setAttribute("sumPage", sumPage);
	     request.setAttribute("scheadline", scheadline);
	     request.setAttribute("postmap", list);
	     request.setAttribute("numlist",numlist);
	     request.setAttribute("sectionid", sectionid);
	     sqlSession.close();
	     request.getRequestDispatcher("../SectionPage.jsp").forward(request, response);
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
