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

import com.njust.edu.dao.SectionDao;
import com.njust.edu.dao.UserDao;
import com.njust.edu.impl.SectionDaoImpl;
import com.njust.edu.impl.UserDaoImpl;
import com.njust.edu.pojo.Section;
import com.njust.edu.pojo.User;
import com.njust.edu.tool.*;

public class MainPageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MainPageServlet() {
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
        
        ScreenNodeLoad scl = new ScreenNodeLoad();
		try
		{
		scl.load();//导入内存
		}
		catch(Exception ex)
		{
			System.out.println("屏蔽词词库导入内存失败！");
		}
        
		String resource = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
      	SqlSession sqlSession = sqlSessionFactory.openSession();
        SectionDao sectiondao=new SectionDaoImpl(sqlSession);
        List<Section> sectionlist=sectiondao.querySectionAll();      
        sqlSession.commit();   
        List<Map> list =new ArrayList<Map>();//创建list集合用于存入map的键值对集合
        for(Section section:sectionlist){
        	Map sectionmap=new HashMap();
        	sectionmap.put("sectionname", section.getSection_name());
        	sectionmap.put("sectionid", section.getBid());
        	list.add(sectionmap);
        }
        //sectionmap.put("sectionname", "caonima");
        request.setAttribute("sectionmap", list);
		//response.sendRedirect("../MainPage.jsp?sectionmap="+sectionmap);
        sqlSession.close();
        request.getRequestDispatcher("../MainPage.jsp").forward(request, response);
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
