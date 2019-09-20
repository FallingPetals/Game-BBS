<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Reply.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>

  <body >
  <%String postbody=request.getParameter("postbody"); %>
  <%String postid=request.getParameter("postid");  %>
  <%String[] o=postbody.split("！@"); %>
  <% 
  
  	String u=null;
  	String i=null;
  	String p=null;
  			if("0".equals(o[0])){u="宋体";};
           if("1".equals(o[0])){u="黑体";};
           if("2".equals(o[0])){u="楷体";};
           if("3".equals(o[0])){u="微软雅黑";};
           if("4".equals(o[0])){u="Microsoft JhengHei";};
           if("0".equals(o[1])){i="16px";};
           if("1".equals(o[1])){i="19px";};
           if("2".equals(o[1])){i="24px";};
           if("3".equals(o[1])){i="29px";};
           if("4".equals(o[1])){i="32px";};
           if("0".equals(o[2])){p="black";};
           if("1".equals(o[2])){p="red";};
           if("2".equals(o[2])){p="#66ccff";};
           if("3".equals(o[2])){p="green";};
           if("4".equals(o[2])){p="yellow";};
           System.out.println(u+","+i+","+p);
  
  
  %>
  
  <%String temp=o[3];
  	String[] o2=temp.split("@#@");
  	System.out.println("o2的长度为："+o2.length);
  %>
  <div><table><tbody><tr><td id="index" style="font-size:<%=i%>;color:<%=p%>;font-family:<%=u%>"><%=o2[0] %></td></tr></tbody></table></div>
  <%
  	if(o2.length>1)
  	{
  		System.out.println(o2[1]);
  		String tomcatPath=getServletContext().getRealPath("/");//获取服务器路径
    	System.out.println(tomcatPath);
  		List<String> imgList = com.njust.edu.tool.Judge.imgJudge(o2[1]);//获取图片标签
  		for(String str : imgList)
  		{
  			System.out.println(str);
  			String imgUrl=tomcatPath+"upload\\"+postid+"\\"+str;
  			System.out.println(imgUrl);
  			%>
  			<div>
  			<img alt="1" src="<%=imgUrl%>" width="500px">
  			</div>
  			<%
  		}
  	
  	
  	}
  	
    
  
   %>
  
  </body>
</html>

