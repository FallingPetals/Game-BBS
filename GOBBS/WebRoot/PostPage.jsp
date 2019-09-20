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
            String uid=(String)request.getSession().getAttribute("uid");
            String nickname=(String)request.getSession().getAttribute("nickname");
            String status=(String)request.getSession().getAttribute("status");
            int flag=0;
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
    <%
    String postlevel=(String)request.getAttribute("postlevel");
    String posttitle=(String)request.getAttribute("posttitle");
    String postbody=(String)request.getAttribute("postbody");
    String likenum=(String)request.getAttribute("likenum");
    String collectnum=(String)request.getAttribute("collectnum");
    String postnickname=(String)request.getAttribute("postnickname");%>
    <div id="mainPage" width:100%>
        <div style="float:left" width:50%>
            <form action="NextReplyPageSerlvet" method="post"><!--这个改成跳页码的servlet  -->
                    <table border="1" cellspacing="0" >
                    <tbody>
                    <tr>
                    <%
                    String postid=(String)request.getAttribute("postid"); 
                    String nowPage=(String)request.getAttribute("nowPage");
                    String sumPage=(String)request.getAttribute("sumPage");
                    if(!sumPage.equals("1")){ %>
                    <td><a href="/GOBBS/servlet/NextReplyPageServlet?mode=--&postid=${postid}&nowPage=${nowPage}">首页</a></td><!--改超链接，传下一页的值 -->
                    <td><a href="/GOBBS/servlet/NextReplyPageServlet?mode=-&postid=${postid}&nowPage=${nowPage}">前页</a></td><!--改超链接，传下一页的值 -->
                    <c:forEach items="${numlist}" var="item"><!-- 需要一个list,比如有五页，就存12345 -->
                    <td>&nbsp;<a href="/GOBBS/servlet/NextReplyPageServlet?mode=0&postid=${postid}&nowPage=${item.NOP}">${item.NOP}</a>&nbsp;</td>  <!--这个改成跳页码的servlet  -->
        			</c:forEach>
        			<%if(!nowPage.equals(sumPage))
        			{ %>
        			<td><a href="/GOBBS/servlet/NextReplyPageServlet?mode=+&postid=${postid}&nowPage=${nowPage}">后页</a></td><!--改超链接，传下一页的值 -->
        			<td><a href="/GOBBS/servlet/NextReplyPageServlet?mode=++&postid=${postid}&nowPage=${nowPage}">末页</a></td><!--改超链接，传最后一页的值 -->
                    <%      
                    	}
                    } %>
                    </tr>
        </tbody> 
                    </table>
                </form>
        </div>
        <div style="float:right" width:50%>
            <form action="" method="post">
                <table border="1"  cellspacing="0">
                <tbody>
                <tr>
                <td>
                      第<%=nowPage %>页</a><!--需要当前页  -->
                    </td>
                <td>
                      共<%=sumPage %>页</a><!--需要总页数  -->
                    </td>
				<%if(status!="-1"){ %>
                <td>
                      <a href="/GOBBS/servlet/LikeServlet?postid=${postid }&replyid=0" style="color:#FF00FF;">点赞<%=likenum %>&nbsp;&nbsp;&nbsp;&nbsp;</a><!--改超链接以及要传的值  -->
                    </td>
                    <td>
                      <a href="/GOBBS/servlet/CollectServlet?postid=${postid }&replyid=0" style="color:#FF00FF;">收藏<%=collectnum %>&nbsp;&nbsp;&nbsp;&nbsp;</a><!--改超链接以及要传的值  -->
                    </td>
                    <td>
                      <a href="../ReplyPage.jsp?postid=${ postid}" style="color:#FF00FF;">发表回复</a><!--改超链接以及要传的值  -->
                    </td>
                    <%
                    String userspost=(String)request.getAttribute("userspost");
                    System.out.println(userspost+"usersPost");
                    if(userspost.equals("1")){ %>
                    <td>
                      <a href="/GOBBS/servlet/DeleteServlet?postid=${ postid}" style="color:#FF00FF;">删除帖子</a><!--改超链接以及要传的值  -->
                    </td>
                <%  }
                } %>
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
                        <div style="float:left;width:30%;"><%=postnickname %></div>
                        <div style="float:left;width:30%;"><%=postlevel %></div>
                    </div>
                    </td> 
                    <td style="width:80%;">
                    <div style="font-size:30px;font-weight: bold;"><!-- 帖子标题 -->
                    	<%=posttitle %>
                    </div>
                    <div style="font-weight: normal;"><!-- 帖子本体 -->
                    	<jsp:include page="Post.jsp" flush="true">
                    		<jsp:param name="postid" value="<%=postid %>"/>
                        	<jsp:param name="postbody" value="<%=postbody %>"/>
                        </jsp:include>
                    </div>
                    </td>
                </tr>
            
            <c:forEach  var="item" items="${replymap}">
                <tr>
                    <td style="width:20%;">
                        <div style="float:left;width:100%;">
                        <div style="float:left;width:30%;">${item.replynickname}</div>
                        <div style="float:left;width:30%;">${item.replylevel}</div>
                        
                    </div>
                    </td>
                    <td style="width:80%;">
                    	<div style="font-weight: normal;">
                        	<!--  ${item.replybody}-->
                        	<jsp:include page="Reply.jsp" flush="true">
                        		 <jsp:param name="replybody" value="${item.replybody}"/>
                        	</jsp:include>
                        	
                         </div>
                    	
                    <input type="hidden" id="t" name="javalearns"/>
                    <%String body=request.getParameter("javalearns"); %>
                        <div id="body" style="font-weight: normal;"></div>
                        <%if(status!="-1"){ %><div style="float:right;border:5px solid #31393c;background:#31393c;"><a href="/GOBBS/servlet/LikeServlet?postid=${postid }" style="color:#FF00FF;">点赞${item.likenum}</a></div>
                        <div style="float:right;border:5px solid #31393c;background:#31393c;"><a href="/GOBBS/servlet/PublishReplyServlet?postid=${postid}" style="color:#FF00FF;">回复</a></div>
                        <%} %>
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
