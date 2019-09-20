<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html"/>
 <meta charset="utf-8" />
 <title>NGAplus</title>
 <style type="text/css">
#mainMenu {font-size:13px;height:66px;overflow:hidden;}
#mainMenu .menu .logo {height:50px;padding:6px 3em 0 1.5em;float:left}
#mainMenu .menu .logo  a{color:#f8e5c3;font-size:30px;font-weight: bold;}
#mainMenu .menu .logo img,#mainMenu .menu .logo .svg1 {height:50px}
#mainMenu .menu {border-bottom:1px solid #31393c;height:65px;overflow:hidden;background:#31393c}
#mainMenu .menu .left {}
#mainMenu .menu .right {float:right}
#mainMenu .menu .right h1 {color:#f8e5c3;}
#mainMenu .menu .item {line-height:65px;height:65px;float:left;background:#f8e5c3}
#mainMenu .menu .item .half {padding-top:10px;line-height:18px;font-size:12px;text-align:center;}
#mainMenu .menu .item .spacer {line-height:10px;height:10px;width:10px}
#mainMenu .menu .item a {background:#31393c;display:block;padding:0 1.5em;height:65px;text-decoration:none;color:#f8e5c3;}
#mainMenu .menu .item:hover a {height:61px;overflow:hidden;background-color:#3d464a;color:#ffcc00;}
#mainMenu .menu .item .active {height:61px;overflow:hidden}
#mainMenu .menu .item .invert {background:#31393c;color:#f8e5c3}
#mainMenu .menu .item .invert:hover {background:#31393c;color:#ffcc00}
#mainMenu .menu .clear {clear:both;line-height:0px;font-size:0px;}
#mainMenu .menu .svg1 {fill:#f8e5c3;stroke:#f8e5c3}
#mainMenu .menu .item:hover .svg1 {fill:#ffcc00;stroke:#ffcc00}
#mainMenu .menu .item .svg1,#mainMenu .menu .item img {height:1.6em;vertical-align:-0.4em}
#mainPage {font-size:13px;overflow:hidden;background:#f8e5c3;}
#mainPage a{text-decoration: none;color:whihe;}
table {
            border-collapse: collapse;/*边框会合并为一个单一的边框*/
        }
        caption {
            margin: 1em 0 .7em 0;
            text-align: center;
            font-weight: bold;
            letter-spacing: .5px;
            color: #fff;
        }

        th {
            text-align: center;
            padding: .5em .5em;
            font-weight: bold;
            background: #66677c;color: #fff;
        }

        td {
            padding: .5em .5em;
            border-bottom: solid 1px #ccc;
        }

        table,table tr th, table tr td { border:1px solid #000000; }/*设置边框的*/
 </style>
</head>
<body>
    <div id="mainMenu">
        <div class="menu">
            <div class="left">
                <div class="logo">
                    <a>
                        GOBBS
                    </a>
                </div>
                <div class="item">
                    <a href="/GOBBS/servlet/MainPageServlet">
                      首页  
                    </a>
                </div>
            </div>
        </div>
    </div>
    <div id="mainPage">
      <form action="/GOBBS/servlet/UpdateUserServlet">
      <table border="1"  cellspacing="0" width="100%">
        <thead>
          <th colspan="3">用户信息界面</th>
        </thead>
        <tbody>
        <%
    String uid=(String)request.getAttribute("uid");
    String username=(String)request.getAttribute(("username"));
    String nickname=(String)request.getAttribute("nickname");
    String email=(String)request.getAttribute("email");
    String phone=(String)request.getAttribute("phone");
    String personID=(String)request.getAttribute("personID");
    String level=(String)request.getAttribute("level");
    String point=(String)request.getAttribute("point");
    String status=(String)request.getAttribute("status");
    String postnum=(String)request.getAttribute("postnum");
     %>
     	  <tr><td>用户编号:</td>
          <td><%=uid%></td></tr>
          <tr><td>用户名:</td>
          <td ><%=username%></td></tr>
          <tr><td>昵称:</td>
          <td><input type="text" name="nickname" value="${nickname}"></td><!--记得改路径-->
          <tr><td>邮箱:</td>
          <td><input type="text" name="email" value="${email}"></td><!--记得改路径-->
          <input type="hidden" name="uid" value="${uid}">
          <tr><td>手机号:</td>
          <td><%=phone %></td></tr>
          <tr><td>身份证:</td>
          <td><%=personID %></td></tr>
                    <tr><td>用户等级:</td>
          <td><%=level %></td></tr>
                    <tr><td>积分:</td>
          <td><%=point %></td></tr>
                    <tr><td>发帖数:</td>
          <td><%=postnum %></td></tr>
                    <tr><td>身份:</td>
          <td ><%=status %></td></tr>
          <tr><td colspan="2" align="center"><div><input type="submit" value="修改" 
          style="color:white;background:#31393c;"></a></div></td></tr>
        </tbody>
    </table>
        </form></div>

    <div id="mainMenu">
        <div class="menu">
            <div class="right">
                <div id="myclock"></div></div></div></div>
</body>
</html>
<script>
function disptime(){
 var today = new Date(); //获得当前时间
 var hh = today.getHours();  //获得小时、分钟、秒
 var mm = today.getMinutes();
 var ss = today.getSeconds();
 if(hh<10)hh="0"+hh;
 if(mm<10)mm="0"+mm;
 if(ss<10)ss="0"+ss;
  /*设置div的内容为当前时间*/
 document.getElementById("myclock").innerHTML="<h1>现在是："+hh+":"+mm+":"+ss+"<h1>";
/*
  使用setTimeout在函数disptime()体内再次调用setTimeout
  设置定时器每隔1秒（1000毫秒），调用函数disptime()执行，刷新时钟显示
  var myTime=setTimeout("disptime()",1000);
*/
}
/*使用setInterval()每间隔指定毫秒后调用disptime()*/
var myTime = setInterval("disptime()",1000);
  </script>