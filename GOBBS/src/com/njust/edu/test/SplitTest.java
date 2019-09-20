package com.njust.edu.test;

public class SplitTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String str1="啊@#@";
		String[] o2=str1.split("@#@");
		System.out.println(o2.length);
		System.out.println(o2[0]);
		System.out.println(o2[1]);

	}

}
