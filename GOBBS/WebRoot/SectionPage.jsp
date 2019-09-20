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
#mainHead{font-size:13px;overflow:hidden;background:#f8e5c3;}
#mainHead a{text-decoration: none;color:#383838;}
#mainHead table {border-collapse: collapse;}
#mainHead     caption {
            margin: 1em 0 .7em 0;
            text-align: center;
            font-weight: bold;
            letter-spacing: .5px;
            color: #fff;
            border:2px solid #31393c;
        }
#mainHead th {
            text-align: center;
            padding: .5em .5em;
            font-size: 30px;
            font-weight: bold;
            background: #31393c;color: #fff;
            border:2px solid #31393c;
        }
#mainHead    td {
            padding: .5em .5em;
            border-bottom: solid 1px #ccc;
            border:2px solid #31393c;
        }
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
            String uid=(String)request.getSession().getAttribute("uid");
            String nickname=(String)request.getSession().getAttribute("nickname");
            String status=(String)request.getSession().getAttribute("status");
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
    <div style="z-index:1;left:0px;top:0px;height:196px;overflow:hidden;"></div>
    <div style="position:absolute;z-index:2;left:10px;top:100px;height:302px;overflow:hidden;"></div><!-- 302*102 -->
    <div id="mainHead">
        <table align="center" width="100%">
      <thead >
        <tr>
        <%String scheadline=(String)request.getAttribute("scheadline"); %>
            <th colspan="2">版头须知</th>
        </tr>
      </thead>
      <tbody>
      <tr>
            <td colspan="2" style="background:#31393c;"></td>
        </tr>
        <tr>
            <td  colspan="2" align="center"><%=scheadline%></td>
        </tr>
        <tr>
            <td align="left">
                <div style="float:left" width:70%>
            <form action="NextPostPageSerlvet" method="post"><!--这个改成跳页码的servlet  -->
                    <table border="1" cellspacing="0" >
                    <tbody>
                    <tr>
                    <%
                    String sectionid=(String)request.getAttribute("sectionid"); 
                    String nowPage=(String)request.getAttribute("nowPage");
                    String sumPage=(String)request.getAttribute("sumPage");
                    if(!(sumPage.equals("1"))){
                    if(!(nowPage.equals("1"))){ %>
                    <td><a href="/GOBBS/servlet/NextPostPageServlet?mode=--&sectionid=${sectionid}&nowPage=${nowPage}">首页</a></td><!--改超链接，传下一页的值 -->
                    <td><a href="/GOBBS/servlet/NextPostPageServlet?mode=-&sectionid=${sectionid}&nowPage=${nowPage}">前页</a></td><!--改超链接，传下一页的值 -->
                                        <%} %>
                    <c:forEach items="${numlist}" var="item"><!-- 需要一个list,比如有五页，就存12345 -->
                    <td>&nbsp;<a href="/GOBBS/servlet/NextPostPageServlet?mode=0&sectionid=${sectionid}&nowPage=${item.NOP}">${item.NOP}</a></td>  <!--这个改成跳页码的servlet  -->
        			</c:forEach>
        			<%if(!nowPage.equals(sumPage))
        			{ %>
        			<td><a href="/GOBBS/servlet/NextPostPageServlet?mode=*&sectionid=${sectionid}&nowPage=${nowPage}">后页</a></td><!--改超链接，传下一页的值 -->
        			<td><a href="/GOBBS/servlet/NextPostPageServlet?mode=**&sectionid=${sectionid}&nowPage=${nowPage}">末页</a></td><!--改超链接，传最后一页的值 -->
        			
                    <%      
                    	}
                    } %>
                    </tr>
        </tbody> 
                    </table>
                </form>
        </div>
            </td>
            <td align="right">
            <div style="float:right" width:30%>
            
            <form action="collectSerlvet" method="post">
                <table border="1"  cellspacing="0">
                <tbody>
                <tr>
                <%if(status!="-1"){ %>
                <td><a href="../PublishPage.jsp?sectionid=${sectionid }" style="color:#FF00FF;">发表帖子</a><!--改超链接以及要传的值  -->
                </td>
                <% }
                %>
                <td>
                      第<%=nowPage %>页</a><!--需要当前页  -->
                    </td>
                <td>
                      共<%=sumPage %>页</a><!--需要总页数  -->
                    </td>
                </tr>
                </tbody>
                </table>
            </form>
            </div>
            </td>
        </tr>
        <c:forEach items="${postmap}" var="item"><!--需要帖子们的list  -->
            <tr><!--下面分别是标题和时间，可以自己灵性  -->
                <td width="80%"><a href="/GOBBS/servlet/PostPageServlet?tid=${ item.postid }">${ item.postname }</a></td>
                <td width="20%">${ item.postdate}</td>      
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
    <script type="text/javascript">
var imgID = new Image();
var i="../images/topbg3.png";//传背景的路径
imgID.src = i;
imgID.onload = function(){
document.getElementById("bg").innerHTML = "<img src="+imgID.src+" />";}
var imgIDw=new Image();
var p="../images/gflogo.png";//传logo的路径
imgIDw.src=p;
imgIDw.onload=function(){
  document.getElementById("logo").innerHTML="<img src="+imgIDw.src+" />";
}
</script>