<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
#mainPage a{text-decoration: none;color:#383838;}
/*设置奇数行颜色*/
table tr:nth-child(odd)
{
    background: #f8e5c3;
}
/*设置偶数行颜色*/
table tr:nth-child(even)
{
    background: #FFD39B;
}
 </style>
</head>
<body>
    <div id="mainMenu">
        <div class="menu">
        <div class="right">
            <% 
            System.out.println(request.getAttribute("userinfo"));
            if(request.getAttribute("userinfo")==null){
            %>
            <div class="item">
            <a href="/GOBBS/register.jsp">注册</a>
            </div>
            <div class="item">
            <a href="/GOBBS/LoginPage.jsp">登录</a>
            </div>
            <% }
            else{
                  String[] userinfo=(String[])request.getAttribute("userinfo");
            %>
            <div class="item">
                    <a href="/GOBBS/servlet/UserPageServlet?uid=<%=userinfo[0]%>">${requestScope.userinfo[1]}</a>
                </div>
                <div class="item">
                    <a href="/GOBBS/MainPage.jsp">注销</a>
                </div>
            <%
                 }
            %>
            </div>
            <div class="left">
                <div class="logo">
                    <a>
                        GOBBS
                    </a>
                </div>
                <div class="item">
                    <a href="MainPage.jsp">
                      首页  
                    </a>
                </div>
                
            </div>
        </div>
    </div>
    <%
    String level=(String)request.getAttribute("level");
    String title=(String)request.getAttribute("title");
    String body=(String)request.getAttribute("body");
    String nickname=(String)request.getAttribute("nickname");%>
    <div id="mainPage" width:100%>
        <div style="float:left" width:50%>
            <form action="cfSerlvet" method="post"><!--这个改成跳页码的servlet  -->
                    <table border="1" cellspacing="0" >
                    <tbody>
                    <tr>
                    <td><a href>下一页</a></td><!--改超链接，传下一页的值 -->
                    <c:forEach items="${xxlist}" var="item"><!-- 需要一个list,比如有五页，就存12345 -->
                    <td>&nbsp;<a href="/GOBBS/servlet/xxServlet?id=${xxlist.id }">${xxlist.id}</a>&nbsp;</td>  <!--这个改成跳页码的servlet  -->
        			</c:forEach>
        			<td><a href>最后页</a></td><!--改超链接，传最后一页的值 -->
                    </tr>
        </tbody> 
                    </table>
                </form>
        </div>
        <div style="float:right" width:50%>
            <form action="collectSerlvet" method="post">
                <table border="1"  cellspacing="0">
                <tbody>
                <tr>
                <td>
                      第<%=当前页 %>页</a><!--需要当前页  -->
                    </td>
                <td>
                      共<%=总共页数 %>页</a><!--需要总页数  -->
                    </td>
                <td>
                      <a href="/GOBBS/servlet/UserPageServlet?uid=<%=userinfo[0]%>" style="color:#FF00FF;">点赞&nbsp;&nbsp;&nbsp;&nbsp;</a><!--改超链接以及要传的值  -->
                    </td>
                    <td>
                      <a href="/GOBBS/servlet/UserPageServlet?uid=<%=userinfo[0]%>" style="color:#FF00FF;">收藏&nbsp;&nbsp;&nbsp;&nbsp;</a><!--改超链接以及要传的值  -->
                    </td>
                    <td>
                      <a href="/GOBBS/servlet/UserPageServlet?uid=<%=userinfo[0]%>" style="color:#FF00FF;">发表帖子</a><!--改超链接以及要传的值  -->
                    </td>
                </tr>
                </tbody>
                </table>
            </form>
        </div>
    </div>
    <div id="mainPage">
        <table border="1"  cellspacing="0" width="100%">
            <tbody style="min-height:100px">
                <tr>
                    <td style="width:20%;">
                    <div style="float:left;width:100%;">
                        <div style="float:left;width:30%;"><%=nickname %></div>
                        <div style="float:left;width:30%;"><%=level %></div>
                    </div>
                    </td> 
                    <td style="width:80%;">
                    <div style="font-size:30px;font-weight: bold;"><%=title %></div>
                    <div style="font-weight: normal;"><%=body%></div>
                    </td>
                </tr>
            <c:forEach items="${postmap}" var="item">
                <tr>
                    <td style="width:20%;text-align:center;">
                        <div style="float:left;width:100%;">
                        <div style="float:left;width:30%;">item.replynickname</div>
                        <div style="float:left;width:30%;">item.replylevel</div>
                    </div>
                    </td>
                    <td>
                    <div style="background:	#E0FFFF;border:1px solid black;">
                    	<table  border="1"  cellspacing="0" width="100%"><tbody><tr>
                    	<td  style="width:20%;"><div style="float:left;background:#E0FFFF;">
                        <div style="float:left;width:50%;background:	#E0FFFF;">item.replynickname</div>
                        <div style="float:left;width:50%;background:	#E0FFFF;">item.replylevel</div>
                    </div></td>
                    <td  style="width:80%;"><div style="background:	#E0FFFF;">item.replybody</div></td>
                    	</tr></tbody></table>
                    </div>
                        <div style="font-weight: normal;">item.replybody</div>
                        <div style="float:right">
                        <table><tbody><tr>
                        <td><div style="float:right;border:5px solid #31393c;background:#31393c;"><a href="/GOBBS/servlet/UserPageServlet?uid=<%=userinfo[0]%>" style="color:#FF00FF;">点赞</a></div></td>
                        <td><div style="float:right;border:5px solid #31393c;background:#31393c;"><a href="/GOBBS/servlet/UserPageServlet?uid=<%=userinfo[0]%>" style="color:#FF00FF;">回复</a></div></td>
                        </tr></tbody></table>
                        </div>
                    </td>
                </tr>
                </c:forEach>
            </tbody>         
        
        </table>
    </div>
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
