<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <div style="background:#f8e5c3;">
        <form name="from" method="post">
    <table align="center">
      <thead>
        <tr>
            <th colspan="2">注册</th>
        </tr>
      </thead>
      <tbody>
      <%
      request.setCharacterEncoding("UTF-8");
      String username=(String)request.getAttribute("username");
      String nickname=(String)request.getAttribute("nickname");
      String phone=(String)request.getAttribute("phone");
      String personID=(String)request.getAttribute("personID");
      String pwd=(String)request.getAttribute("pwd");
      String rpwd=(String)request.getAttribute("rpwd");
      String email=(String)request.getAttribute("email");
      String ucode=(String)request.getAttribute("ucode");
      String code=(String)request.getAttribute("code");
      String usernameEr;
      String nicknameEr;
      String phoneEr;
      String personIDEr;
      String pwdEr;
      String rpwdEr;
      String emailEr;
      String ucodeEr;
      
      if(request.getAttribute("usernameEr")==null)
      usernameEr=" ";
      else
      usernameEr=(String)request.getAttribute("usernameEr");
      if(request.getAttribute("nicknameEr")==null)
      nicknameEr=" ";
      else
      nicknameEr=(String)request.getAttribute("nicknameEr");
      if(request.getAttribute("phoneEr")==null)
      phoneEr=" ";
      else
      phoneEr=(String)request.getAttribute("phoneEr");
      if(request.getAttribute("personIDEr")==null)
      personIDEr=" ";
      else
      personIDEr=(String)request.getAttribute("personIDEr");
      if(request.getAttribute("pwdEr")==null)
      pwdEr=" ";
      else
      pwdEr=(String)request.getAttribute("pwdEr");
      if(request.getAttribute("rpwdEr")==null)
      rpwdEr=" ";
      else
      rpwdEr=(String)request.getAttribute("rpwdEr");
      if(request.getAttribute("emailEr")==null)
      emailEr=" ";
      else
      emailEr=(String)request.getAttribute("emailEr");
      if(request.getAttribute("ucodeEr")==null)
      ucodeEr=" ";
      else
      ucodeEr=(String)request.getAttribute("ucodeEr");
       %>
        <tr>
            <td>用户名：</td>
            <td><input name="username" type="text" size="29" placeholder="长度16个字符以内" value="${requestScope.username}"><div style="color:#FF0000;
            font-size:15">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <%=usernameEr%></div></td>
            
        </tr>
        <tr>
            <td>昵称：</td>
            <td><input name="nickname" type="text" size="29" placeholder="长度20个字符以内" value="${requestScope.nickname}"><div style="color:#FF0000;
            font-size:15">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <%=nicknameEr%></div></td>
        </tr>
        <tr>
            <td>手机号：</td>
            <td><input name="phone" type="text" size="29" placeholder="必须为11位数字" value="${requestScope.phone}"><div style="color:#FF0000;
            font-size:15">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <%=phoneEr%></div></td>
        </tr>
        <tr>
            <td>身份证：</td>
            <td><input name="personID" type="text" size="29" placeholder="必须为18位数字" value="${requestScope.personID}"><div style="color:#FF0000;
            font-size:15">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <%=personIDEr%></div></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input name="pwd" type="password" size="29" placeholder="长度8-20位，由数字和字母组成" value="${requestScope.pwd}"><div style="color:#FF0000;
            font-size:15">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <%=pwdEr%></div></td>
        </tr>
        <tr>
            <td>重复密码：</td>
            <td><input name="rpwd" type="password" size="30" placeholder="必须与“密码”输入项内容一致" value="${requestScope.rpwd}"><div style="color:#FF0000;
            font-size:15">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <%=rpwdEr%></div></td>
        </tr>
        <tr>
            <td>邮箱：</td>
            <td><input name="email" type="text" size="30" placeholder="符合邮箱格式" value="${requestScope.email}"><div style="color:#FF0000;
            font-size:15">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <%=emailEr%></div></td>
        </tr>
        <tr>
            <td>验证码：</td>
            <td><input name="ucode" type="text" size="20" >
            <input name="code" type="hidden" value="${requestScope.code}"></input>
            <div style="color:#FF0000;
            font-size:15">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <%=ucodeEr%></div>
            <input type="button" value="发送验证码" onclick="addAction()"></td>
        </tr>
        <tr>
        <td colspan="2" align="center">
        <input type="button" value="提交" onclick="deleteAction()"></td>
        </tr>
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
<script type="text/javascript">
    function addAction(){
        document.from.action="/GOBBS/servlet/MailVerifyServlet";//提交的url
        document.from.submit();
    }

    function deleteAction(){
        document.from.action="/GOBBS/servlet/RegisterServlet";//提交的url
        document.from.submit();
    }
</script>
<script>
    var jh=new Array();
jh[0]="url(images/1.jpg)";
jh[1]="url(images/2.jpg)";
jh[2]="url(images/3.jpg)";
jh[3]="url(images/4.jpg)";
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