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

import com.njust.edu.impl.PostDaoImpl;
import com.njust.edu.impl.ReplyDaoImpl;
import com.njust.edu.impl.UserDaoImpl;
import com.njust.edu.pojo.Post;
import com.njust.edu.pojo.Reply;
import com.njust.edu.pojo.User;

public class NextReplyPageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public NextReplyPageServlet() {
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
	     String postid=(String)request.getParameter("postid");
	     String resource="mybatis-config.xml";
	     InputStream is=Resources.getResourceAsStream(resource);
	     SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
	     SqlSession sqlSession=sqlSessionFactory.openSession();
	     Post post=new PostDaoImpl(sqlSession).queryPostByTid(Integer.parseInt(postid));
	     int postuid=post.getUid();
	     User postuser=new UserDaoImpl(sqlSession).queryUserByUid(postuid);
	     String postnickname=postuser.getNickname();
	     String postlevel=postuser.getLevel()+"";
	     String postbody=post.getBody();
	     String postcollectnum=post.getCollect_num()+"";
	     String postreplynum=post.getHave_reply()+"";
	     String postlikenum=post.getLike_num()+"";
	     String postdate=post.getPost_date();
	     String posttime=post.getPost_time();
	     String posttitle=post.getTitle();
	     request.setAttribute("postid", postid);
	     request.setAttribute("postbody", postbody);
	     request.setAttribute("postlevel", postlevel);
	     request.setAttribute("postnickname", postnickname);
	     request.setAttribute("posttitle", posttitle);
	     List<Reply> replylist= new ReplyDaoImpl(sqlSession).queryReplyByTid(Integer.parseInt(postid));
	     List<Map> list =new ArrayList<Map>();//创建list集合用于存入map的键值对集合
	     int replynum=0;
	     for(Reply reply:replylist){
		     replynum++;
	     }
	     List<Map> numlist=new ArrayList<Map>();
	     int isumPage=replynum/10+1;
	     for(int n=1;n<=isumPage;n++){
	    	 Map nummap=new HashMap();
	    	 nummap.put("NOP",n);
	    	 System.out.println(n);
	    	 numlist.add(nummap);
	     }
	     String sumPage=isumPage+"";
	     String nowPage=(String)request.getParameter("nowPage");
	     String mode=(String)request.getParameter("mode");
	     if(mode=="++"){
	    	 nowPage=sumPage+"";
	     }
	     else if(mode=="+"){
	    	 nowPage=(Integer.parseInt(nowPage)+1)+"";
	     }
	     else if(mode=="-"){
	    	 nowPage=(Integer.parseInt(nowPage)-1)+"";
	     }
	     else if(mode=="--"){
	    	 nowPage="1";
	     }
	     replynum=0;
	     int flag=(Integer.parseInt(nowPage)-1)*10;
	     for(Reply reply:replylist){
	    	 replynum++;
	    	 if(replynum>flag&&replynum<=flag){
		     Map replymap=new HashMap();
	    	 replymap.put("ror", reply.getHave_reply_of_reply());
	    	 replymap.put("hid", reply.getHid());
	    	 replymap.put("replylikenum", reply.getLike_num());
	    	 replymap.put("replybody", reply.getReply_body());
	    	 replymap.put("replydate", reply.getReply_date());
	    	 replymap.put("replyorder", reply.getReply_order());
	    	 replymap.put("replytime", reply.getReply_time());
	    	 replymap.put("rornum", reply.getRor_num());
	    	 int replyuid=reply.getUid();
	    	 System.out.println(reply.getReply_body());
	    	 User replyuser=new UserDaoImpl(sqlSession).queryUserByUid(replyuid);
	    	 replymap.put("replynickname", replyuser.getNickname());
	    	 replymap.put("replylevel", replyuser.getLevel());
		     list.add(replymap);
	    	 }
	     }
	     sqlSession.commit();
	     request.setAttribute("nowPage", nowPage);
	     request.setAttribute("sumPage", sumPage);
	     request.setAttribute("replymap", list);
	     request.setAttribute("numlist",numlist);
	     request.setAttribute("postid", postid);
	     sqlSession.close();
	     request.getRequestDispatcher("../PostPage.jsp").forward(request, response);
	     
	     
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
