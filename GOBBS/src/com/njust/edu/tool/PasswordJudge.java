package com.njust.edu.tool;

public class PasswordJudge {
	
	public static int Judge(String key)//0��ʾ��ȷ��1��ʾ���ȴ���,���ȷ�ΧΪ8~20λ��2��ʾ��ʽ���󣬺��г����ֺ���ĸ������ַ���3��ʾ��ʽ����δ������ĸ��������
	{
		if(key.length()>=8&&key.length()<=20)//�жϳ����Ƿ����Ҫ�� 
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
