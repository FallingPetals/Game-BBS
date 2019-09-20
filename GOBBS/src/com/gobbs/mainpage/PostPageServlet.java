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
import com.njust.edu.*;
public class PostPageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PostPageServlet() {
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
	     int uid=Integer.parseInt((String)session.getAttribute("uid"));
	     InputStream is=Resources.getResourceAsStream(resource);
	     SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
	     SqlSession sqlSession=sqlSessionFactory.openSession();
		int tid;
		if(request.getParameter("tid")==null){
			tid=Integer.parseInt((String)request.getAttribute("tid"));
		}else{
		tid=Integer.parseInt(request.getParameter("tid"));
		}
	     Post post=new PostDaoImpl(sqlSession).queryPostByTid(tid);
	     int postuid=post.getUid();
	     String userspost="0";
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
	     String postid=tid+"";
	     if(uid==postuid){
	    	 userspost="1";
	     }
	     System.out.println(userspost);
	     request.setAttribute("userspost", userspost);
	     request.setAttribute("postid", postid);
	     request.setAttribute("postbody", postbody);
	     request.setAttribute("postlevel", postlevel);
	     request.setAttribute("postnickname", postnickname);
	     request.setAttribute("posttitle", posttitle);
	     List<Reply> replylist= new ReplyDaoImpl(sqlSession).queryReplyByTid(tid);
	     List<Map> list =new ArrayList<Map>();//创建list集合用于存入map的键值对集合
	     int replynum=0;
    	 String[] usersreply=new String[1000];
    	 int flag=0;
	     for(Reply reply:replylist){
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
	    	 User replyuser=new UserDaoImpl(sqlSession).queryUserByUid(replyuid);
	    	 replymap.put("usersreply", usersreply);
	    	 replymap.put("replynickname", replyuser.getNickname());
	    	 replymap.put("replylevel", replyuser.getLevel());
		     list.add(replymap);
		     replynum++;
	     }
	     List<Map> numlist=new ArrayList<Map>();
	     int isumPage=replynum/10+1;
	     for(int n=1;n<=isumPage;n++){
	    	 Map nummap=new HashMap();
	    	 nummap.put("NOP",n);
	    	 numlist.add(nummap);
	     }
	     String sumPage=isumPage+"";
	     sqlSession.commit();
	     request.setAttribute("nowPage", "1");
	     request.setAttribute("sumPage", sumPage);
	     request.setAttribute("replymap", list);
	     request.setAttribute("numlist",numlist);
	     request.setAttribute("likenum", postlikenum);
	     request.setAttribute("collectnum", postcollectnum);
	     
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
