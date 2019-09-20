package com.njust.edu.test;

import com.gobbs.ip.*;

import java.util.List;

public class ipTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IpLoad ip = new IpLoad();
 		String ip_str ="127.0.0.1";
 		int uid_int=Integer.valueOf("2").intValue();
 		try
 		{
 			System.out.println("uid="+uid_int+",ip="+ip_str);
 			ip.login(uid_int, ip_str);
 		}
 		catch(Exception ex)
 		{
 		}

	}

}
