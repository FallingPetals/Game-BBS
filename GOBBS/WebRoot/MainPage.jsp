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
#kuangjia
{width:100%; height:400px; border:white solid 0px; background-size:cover; background-repeat:no-repeat;}
.t1
{width:100px; height:100px; background-repeat:no-repeat; background-size:cover;}
#t2
{float:left; margin:150px 0px 0px 0px; background-image:url(../Images/zuo.png);}
#t3
{float:right; margin:150px 0px 0px 0px; background-image:url(../Images/you.png);}
#t4
{float:right; margin:300px -60px 0px 0px; background-image:url(../Images/more.png);}
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
			String uid=(String)request.getSession().getAttribute("uid");
            if(uid=="0"){
            %>
            <div class="item">
            <a href="/GOBBS/register.jsp">注册</a>
            </div>
            <div class="item">
            <a href="/GOBBS/LoginPage.jsp">登录</a>
            </div>
            <% }
            else{
                  String nickname=(String)request.getSession().getAttribute("nickname");
            %>
            <div class="item">
                    <a href="/GOBBS/servlet/UserPageServlet">${nickname}</a>
                </div>
                <div class="item">
                    <a href="/GOBBS/servlet/LogoutServlet">注销</a>
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
                    <a href="/GOBBS/servlet/MainPageServlet">
                      首页  
                    </a>
                </div>
            </div>
        </div>
    </div>
    <div id="kuangjia"><!--大div作为框架-->
  
    <div class="t1" id="t2" onclick="(dd(-1))"></div>
    <div class="t1" id="t3" onclick="(dd(1))"></div>
    <div class="t1" id="t4" onclick="(link())"></div>
    </div>
    
    <div id="mainPage">
    <table align="center" width="100%" style="border:0px solid #000000;">
        <tbody>
        <tr><td><div><form action="xxServlet" method="post"><!-- 搜索servlet -->
            <table><tr>
            	<td><input type="text" name="search"/></td>
            	<td><input type="submit" value="搜索"/></td>
            </tr></table>
            </form></div></td></tr>
            <c:forEach items="${sectionmap}" var="item">
            <tr>
            <td><a href="/GOBBS/servlet/SectionPageServlet?sectionid=${ item.sectionid }">${item.sectionname}</a></td>         
            </tr>
        </c:forEach>
    </table>
    </div>
    <div id="mainMenu">
        <div class="menu">
            <div class="right">
                <div id="myclock"></div></div></div></div>
</body>
</html>
<script>
    var jh=new Array();
jh[0]="url(../Images/main1.png)";
jh[1]="url(../Images/main2.jpg)";
jh[2]="url(../Images/main3.jpg)";
jh[3]="url(../Images/main4.png)";
var kj=document.getElementById("kuangjia");
var x=-1;
var l=jh.length;
function lb()
{
    x++;
    if (x==l)
    {
        x=0;
    }
    kj.style.backgroundImage=jh[x];
    t=window.setTimeout("lb()",3000);
}
t=window.setTimeout("lb()",0);
function dd(m)
{
    clearTimeout(t);
    x=x+m;
    if(x==l)    
    {x=0;}
    else if(x==-1)
    {x=l;}
    kj.style.backgroundImage=jh[x];
    t=window.setTimeout("lb()",3000);
}
function link(){
    if(x==0)window.location.href="end.htm";
    if(x==1)window.location.href="test.html";
    if(x==2)window.location.href="end.htm";
    if(x==3)window.location.href="test.html";
}
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