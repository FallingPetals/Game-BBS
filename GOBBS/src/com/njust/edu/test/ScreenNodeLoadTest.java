package com.njust.edu.test;

import com.njust.edu.tool.*;

public class ScreenNodeLoadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ScreenNodeLoad scl = new ScreenNodeLoad();
		try
		{
		scl.load();//导入内存
		}
		catch(Exception ex)
		{
			System.out.println("屏蔽词词库导入内存失败！");
		}
		
		ScreenNode ti = ScreenNode.getInstance();
		
		String s = "我叫徐嘉森，我来自日本，我最喜欢的东西是Sakura";
        System.out.println("src: " + s);
        String ss = ti.replace(s,null,null);//后面两个就填null就行,replace可以把屏蔽词按照它的长度换成等长度的*
        Boolean flag = ti.existWords(s,null,null);//这里也是一样，existWords可以返回是否含有屏蔽词
		System.out.println("是否含有违禁词：" + flag);
		System.out.println("result: " + ss);
		
		

	}

}
