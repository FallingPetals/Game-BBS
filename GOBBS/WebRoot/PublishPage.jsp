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
 </style>
</head>
<body>
    <div id="mainMenu">
        <div class="menu">
        <div class="right">
        <%
        String sectionid=request.getParameter("sectionid");
        String uid=(String)request.getSession().getAttribute("uid");
        String nickname=(String)request.getSession().getAttribute("nickname");
          %>
            <div class="item">
                    <a href="/GOBBS/servlet/UserPageServlet">${nickname}</a>
                </div>
                <div class="item">
                    <a href="/GOBBS/servlet/LogoutServlet">注销</a>
                </div>
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
    <div id="mainPage">
      <h1>说出你的看法</h1>
      <form action="/GOBBS/servlet/PublishPostServlet" method="post" enctype="multipart/form-data">
        <table border="1"  cellspacing="0" width="100%" >
          <tbody>
            <tr>
              <td>标题：</td>
              <td><input name="posttitle" type="text" size="160"></td>
            </tr>
            <tr>
              <td colspan="2">
                <span>字体
                  <select name="font">
                    <option value="0">默认</option>
                    <option value="1">黑体</option>
                    <option value="2">楷体</option>
                    <option value="3">微软雅黑</option>
                    <option value="4">微软正黑体</option>
                  </select>
                </span>
                <span>字号
                  <select name="fontweight">
                    <option value="0">默认</option><!-- 16px -->
                    <option value="1">1.2x</option>
                    <option value="2">1.5x</option>
                    <option value="3">1.8x</option>
                    <option value="4">2.0x</option>
                  </select>
                </span>
                <span>颜色
                  <select name="fontcolor">
                    <option value="0">默认</option>
                    <option value="1">红色</option>
                    <option value="2">蓝色</option>
                    <option value="3">绿色</option>
                    <option value="4">黄色</option>
                  </select>
                </span>
                <button title="粗体" type="button" style="background:#31393c;color:#f8e5c3;" onclick="document.getElementById('s').value += '<b></b>'"><b>B</b></button>
                <button title="下划线" type="button" style="background:#31393c;color:#f8e5c3;" onclick="document.getElementById('s').value += '<u></u>'"><u>U</u></button>
                <button title="斜体" type="button" style="background:#31393c;color:#f8e5c3;" onclick="document.getElementById('s').value += '<i></i>'"><i>I</span></i>
                <button title="换行" type="button" style="background:#31393c;color:#f8e5c3;" onclick="document.getElementById('s').value += '<br>'">换行</button>
              </td>
            </tr>
            <tr >
              <td colspan="2">
                <textarea autofocus name="postbody" id="s" style="width:98%;height:400px;line-height:25px;"></textarea>
              </td>
            </tr>
            <tr>
            	<td colspan="2">
            	 	<div style="float:right;width:66%;"><input style="width:40%" type="file" accept="image/png,image/jpeg,image/gif,image/jpg" name="uploadPic"></input></div>
    			 </td>
            </tr>
            <tr>
            	<td colspan="2">
            	 		<div style="float:right;width:66%;"><input style="width:40%" type="file" accept="image/png,image/jpeg,image/gif,image/jpg" name="uploadPic2"></input></div>
    			 </td>
            </tr>
            
            <tr>
            <%System.out.println(sectionid); %>
              <td colspan="2"><div style="float:right;width:56%;"><input type="hidden" name="sectionid" value=<%=sectionid %>> <input type="submit" name="submit" value="提交" style="background:#31393c;color:#f8e5c3;padding: 15px 32px;font-weight:bold;"></div></td></tr>
          </tbody>
        </table>
      </form>
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