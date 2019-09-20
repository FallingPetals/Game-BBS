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

import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.njust.edu.impl.PostDaoImpl;
import com.njust.edu.impl.UserDaoImpl;
import com.njust.edu.pojo.Post;
import com.njust.edu.pojo.User;
import com.njust.edu.tool.DateTime;
import com.njust.edu.tool.ScreenNode;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class PublishPostServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PublishPostServlet() {
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
		
		PrintWriter out = response.getWriter();
		SmartUpload upload = new SmartUpload();//创建组件对象
        upload.initialize(getServletConfig(),request,response);
        
        upload.setMaxFileSize(5 * 1024 * 1024);// 每个文件最大5M
        upload.setTotalMaxFileSize(20 * 1024 * 1024);// 总共最大10M
        upload.setAllowedFilesList("jpeg,png,gif,jpg");// 允许上传jpeg,png,gif.jpg
        
        String tomcatPath=getServletContext().getRealPath("/");//服务器路径
        
        
        try{
			upload.upload();
	        Files uploadFiles = upload.getFiles();
		
        	
    		
		
		String sectionid=upload.getRequest().getParameter("sectionid");
	    String posttitle=upload.getRequest().getParameter("posttitle");
	    String postbody=upload.getRequest().getParameter("postbody");
	    String font=upload.getRequest().getParameter("font");
	    String fontweight=upload.getRequest().getParameter("fontweight");
	    String fontcolor=upload.getRequest().getParameter("fontcolor");
		String resource="mybatis-config.xml";
		InputStream is=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		HttpSession session = request.getSession(true);
		String uid=(String)session.getAttribute("uid");
		int tid=1;
		String post_date=new DateTime().getDate();
		String post_time=new DateTime().getTime();
		int like_num=0;
		int collect_num=0;
		int reply_num=0;
		int is_delete=0;
		System.out.println(sectionid);
		System.out.println(posttitle);
		System.out.println(postbody);
		System.out.println(font);
		System.out.println(fontweight);
		System.out.println(fontcolor);
		postbody=font+"！@"+fontweight+"！@"+fontcolor+"！@"+postbody;
		System.out.println(postbody);
		Post post=new Post(Integer.parseInt(uid),tid,Integer.parseInt(sectionid),post_date,post_time,like_num,collect_num,reply_num,posttitle,postbody,is_delete);
        String inputTitle=post.getTitle();
		String inputBody=post.getBody();
		ScreenNode ti = ScreenNode.getInstance();
		String resultTitle=ti.replace(inputTitle, null, null);
		String resultBody=ti.replace(inputBody, null, null);
		post.setTitle(resultTitle);
		post.setBody(resultBody);
		
		/*
		String ss = ti.replace(s,null,null);//后面两个就填null就行,replace可以把屏蔽词按照它的长度换成等长度的*
        Boolean flag = ti.existWords(s,null,null);//这里也是一样，existWords可以返回是否含有屏蔽词
        */
		
		PostDaoImpl postDaoImpl=new PostDaoImpl(sqlSession);
		postDaoImpl.insertPost(post);
		
		tid=post.getTid();
		
		String tidStr=String.valueOf(tid);
		System.out.println("tomcatPath:"+tomcatPath);
    	java.io.File file=new java.io.File(tomcatPath+"upload/"+tidStr);//在部署服务器创建帖子相关的文件夹
    	//file.mkdirs();//创建文件夹
		if(!file.exists()){//如果文件夹不存在
			System.out.println("正在创建文件夹："+tomcatPath+"upload/"+tidStr);
			file.mkdirs();//创建文件夹
		}
		
		
		
		
		int pid=0;
		
		for(int i=0;i<uploadFiles.getCount();i++)//分别存放图片，若没上传则 不保存
		{
			if(uploadFiles.getFile(i).getSize()!=0)
			{
				pid++;
				String fileName = uploadFiles.getFile(i).getFileName();
				String prefix=fileName.substring(fileName.lastIndexOf(".")+1); //获取后缀
				if(pid==1)//若是第一个图片则加一个"@#@"作为分隔符
				{
					String newbody=post.getBody()+"@#@"+"{"+"t"+tid+"p"+pid+"."+prefix+"}";
					post.setBody(newbody);
				}
				else
				{
					String newbody=post.getBody()+"{"+"t"+tid+"p"+pid+"."+prefix+"}";
					post.setBody(newbody);
				}
				
				
				//uploadFiles.getFile(i).saveAs("/upload/"+fileName, File.SAVEAS_VIRTUAL);//将文件保存在磁盘根目录下的upload文件夹
				uploadFiles.getFile(i).saveAs("/upload/"+tidStr+"/"+"t"+tidStr+"p"+pid+"."+prefix, File.SAVEAS_VIRTUAL);//将文件保存在磁盘根目录下的upload文件夹
			}
		}
		
		
		postDaoImpl.updatePostByTid(post);//把图片信息更新到数据库
		
		
		UserDaoImpl userDaoImpl=new UserDaoImpl(sqlSession);
		User user=userDaoImpl.queryUserByUid(Integer.parseInt(uid));
		int point=user.getPoint();
		point+=5;
		user.setPoint(point);
		userDaoImpl.updateUserByUid(user);
		sqlSession.commit();
		response.sendRedirect("/GOBBS/servlet/SectionPageServlet?sectionid="+sectionid);
		sqlSession.close();
		
		
		}
		catch (SmartUploadException e) {
	            e.printStackTrace();
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
