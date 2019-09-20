package com.gobbs.img;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ServletConfig config;

    public UploadServlet() {
    }
    
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	this.config=config;
    }
    
    final public ServletConfig getServletConfig(){
    	return config;
    }
    
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=utf-8");
    	request.setCharacterEncoding("utf-8");
    	//response.setCharacterEncoding("utf-8");
    	
    	
    	
    	
    	
		PrintWriter out = response.getWriter();
        SmartUpload upload = new SmartUpload();//创建组件对象
        upload.initialize(getServletConfig(),request,response);
        //upload.initialize(this.getServletConfig(), request, response);// 初始化
        
        upload.setMaxFileSize(5 * 1024 * 1024);// 每个文件最大5M
        upload.setTotalMaxFileSize(20 * 1024 * 1024);// 总共最大10M
        upload.setAllowedFilesList("jpeg,png,gif,jpg");// 允许上传jpeg,png,gif.jpg
        String tomcatPath=getServletContext().getRealPath("/");//服务器路径
        System.out.println(tomcatPath);
        
        try {
        	String tid="1";
        	String pid="1";
        	java.io.File file=new java.io.File(tomcatPath+"upload/"+tid);
    		if(!file.exists()){//如果文件夹不存在
    			file.mkdir();//创建文件夹
    		}
        	
        	
        	
            upload.upload();
            Files uploadFiles = upload.getFiles();
            
            String text=upload.getRequest().getParameter("uploadText");
            System.out.println(text);
            //System.out.println("上传数量: " + uploadFiles.getCount());
            out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
            out.println("<HTML>");
    		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
    		out.println("  <BODY>");
    		out.print(text);
    		out.println("  </BODY>");
    		out.println("</HTML>");
            
    		for(int i=0;i<uploadFiles.getCount();i++)
    		{
    			if(uploadFiles.getFile(i).getSize()!=0)
    			{
    			String fileName = uploadFiles.getFile(i).getFileName();
                String prefix=fileName.substring(fileName.lastIndexOf(".")+1); //获取后缀
                //uploadFiles.getFile(i).saveAs("/upload/"+fileName, File.SAVEAS_VIRTUAL);//将文件保存在磁盘根目录下的upload文件夹
                uploadFiles.getFile(i).saveAs("/upload/"+tid+"/"+"t"+tid+"p"+pid+"."+prefix+"."+prefix, File.SAVEAS_VIRTUAL);//将文件保存在磁盘根目录下的upload文件夹
    			}
    		}
            
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        
        request.setAttribute("tomcatPath", tomcatPath);
        System.out.println("tomcatPath="+tomcatPath);
        request.getRequestDispatcher("../index.jsp").forward(request, response);

    }

}
