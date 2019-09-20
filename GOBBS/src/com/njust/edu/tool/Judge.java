package com.njust.edu.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Judge {
	
	//�ж������Ƿ����
	public static int passwordJudge(String key)//0��ʾ��ȷ��1��ʾ���ȴ���,���ȷ�ΧΪ8~20λ��2��ʾ��ʽ���󣬺��г����ֺ���ĸ������ַ�3��ʾ��ʽ����δ������ĸ��������
	{
		if(key.length()>=8&&key.length()<=20)//�жϳ����Ƿ���Ҫ�� 
		{
			int count1=0;//���� 
			int count2=0;//��ĸ 
			int count3=0;//�����ַ�
			for(int j=0;j<key.length();j++)//�ж�ÿһλ������ 
			{
				if(key.charAt(j)>=48&&key.charAt(j)<=57)
					count1=1;
				else if(key.charAt(j)>=65&&key.charAt(j)<=90)
					count2=1;
				else if(key.charAt(j)>=97&&key.charAt(j)<=122)
					count2=1;
				else
					count3=1;
			}
			if(count3==1)
			{
				return 2;
			}
			else if(count1==1&&count2==1&&count3==0)
			{
				return 1;
			}
			else
				return 3;
		}
		else
		{
			return 0;
		}
		
	}
	
	//�ж��ǳ��Ƿ����
	public static int emailJudge(String email)//����1��ʾ��ȷ��0��ʾ����
	{
		String pattern = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		boolean matches = Pattern.matches(pattern,email);
		if(email==null || email=="")
			matches=false;
		if(matches==true)
			return 1;
		else
			return 0;
	}
	
	//�ж��ֻ���Ƿ����
	public static int phoneJudge(String phone)//����1��ʾ��ȷ��0��ʾ����
	{
		String pattern = "^1[3|4|5|8][0-9]\\d{8}$";
		boolean matches = Pattern.matches(pattern, phone);
		if(phone==null || phone=="")
			matches=false;
		if(matches==true)
			return 1;
		else
			return 0;	
	}

	//�ж�ip�Ƿ����
	public static int ipJudge(String ip)//����1��ʾ��ȷ��0��ʾ����
	{
		String pattern = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
	            + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
	            + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
	            + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
		boolean matches = Pattern.matches(pattern, ip);
		if(ip==null || ip=="")
			matches=false;
		if(matches==true)
			return 1;
		else
			return 0;
	}
	
	//�ж��ǳ��Ƿ���ȷ	
	public static int nicknameJudge(String nickname)//����1��ʾ��ȷ��0��ʾ����
	{
		String pattern = "^[\u4E00-\u9FA5A-Za-z0-9_]{1,8}$";//1~8λ���ġ����֡���Сд��ĸ���»���
		boolean matches = Pattern.matches(pattern, nickname);
		if(nickname==null || nickname=="")
			matches=false;
		if(matches==true)
			return 1;
		else
			return 0;
	}
	
	//�ж��û����Ƿ���ȷ
	public static int user_nameJudge(String user_name)//����1��ʾ��ȷ��0��ʾ����
	{
		String pattern = "^[A-Za-z0-9]{6,20}$";//6-20λ���֡���Сд��ĸ
		boolean matches = Pattern.matches(pattern, user_name);
		if(user_name==null || user_name=="")
			matches=false;
		if(matches==true)
			return 1;
		else
			return 0;
	}
	public static int idJudge(String id)
	{
		String pattern = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";//6-20λ   ֡   Сд  ĸ
		boolean matches = Pattern.matches(pattern, id);
		if(id==null || id=="")
			matches=false;
		if(matches==true)
			return 1;
		else
			return 0;
	}
	
	public static List<String> imgJudge(String text)
	{
				//String text="cao艹[t22p2]草啊[t22p3]";
		
				String pattern = "\\{"+"t"+"\\d{1,5}"+"p"+"\\d{1,6}"+"\\."+"[a-z]{3,4}"+"\\}";
				
				Pattern p = Pattern.compile(pattern);
				Matcher m = p.matcher(text);
				
				List<String> strList=new ArrayList<String>();
				
				while(m.find())
				{
					String temp=m.group();
					String temp2=temp.substring(1,temp.length()-1);//把{和}去掉
					strList.add(temp2);
				}
				
				
				for(String str2 : strList)
				{
					System.out.println(str2);
				}
				
				return strList;
	}
	
	
	//测试
	/*
	public static void main (String[] args) throws Exception
	{
		
		String text="{t2p1.png}{t2p2.jpg}";
		
		String pattern = "\\{"+"t"+"\\d{1,5}"+"p"+"\\d{1,6}"+"\\."+"[a-z]{3,4}"+"\\}";
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(text);
		
		List<String> strList=new ArrayList<String>();
		
		while(m.find())
		{
			String temp=m.group();
			String temp2=temp.substring(1,temp.length()-1);//把{和}去掉
			strList.add(temp2);
		}
		
		
		for(String str2 : strList)
		{
			System.out.println(str2);
		}
		
		//boolean matches = Pattern.matches(pattern, text);
		//System.out.println("matches = " + matches);
		
		
		//String text = "123[t1p121]4123";
		//String pattern = ".*\\[+t+d[0-9]+p+d[0-9]+\\]";
		//String pattern = ".*\\[[t]\\d{1,3}[p]\\d{1,3}\\].*";
		//boolean matches = Pattern.matches(pattern, text);
		//System.out.println("matches = " + matches);
		
		
		
	}*/


}
