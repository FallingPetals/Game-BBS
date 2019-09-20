package com.gobbs.register;

import org.apache.commons.mail.HtmlEmail;

public  class Mail implements Runnable{
	public static String emailaddress;//收件人邮箱
	public static String code;//激活码
	public Mail(String emailaddress,String code){
		Mail.emailaddress=emailaddress;
		Mail.code=code;
	}
	public void run(){
		try {
			HtmlEmail email = new HtmlEmail();//
			email.setHostName("smtp.qq.com");//
			email.setCharset("UTF-8");
			email.addTo(emailaddress);// 收件地址
			email.setFrom("gobbs@foxmail.com", "游戏技术论坛");
			email.setAuthentication("gobbs@foxmail.com", "pgelkyibmjaabjei");
 
			email.setSubject("邮箱验证");
			email.setMsg("尊敬的用户您好,您本次注册的验证码是:" + code);
			email.send();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
