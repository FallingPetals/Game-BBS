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
  <%String replybody=request.getParameter("replybody"); %>
  <%String[] o=replybody.split("！@"); %>
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
  <div><table><tbody><tr><td id="index" style="font-size:<%=i%>;color:<%=p%>;font-family:<%=u%>"><%=o[3] %></td></tr></tbody></table></div>
  <div id="po"></div>
  </body>
</html>

