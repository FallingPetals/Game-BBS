package com.njust.edu.tool;

public class PasswordJudge {
	
	public static int Judge(String key)//0表示正确；1表示长度错误,长度范围为8~20位；2表示格式错误，含有除数字和字母以外的字符；3表示格式错误，未含有字母或者数字
	{
		if(key.length()>=8&&key.length()<=20)//判断长度是否符合要求 
		{
			int count1=0;//数字 
			int count2=0;//字母 
			int count3=0;//其他字符
			for(int j=0;j<key.length();j++)//判断每一位的密码 
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
				return 0;
			}
			else
				return 3;
		}
		else
		{
			return 1;
		}
		
	}

}
