package com.njust.edu.test;
import java.util.List;

import com.njust.edu.tool.*;


public class ImgJudgeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text="{t29p1.png}{t29p2.jpg}";
		List<String> imgList = com.njust.edu.tool.Judge.imgJudge(text);//获取图片标签
  		for(String str : imgList)
  		{
  			System.out.println(str);
  			
  		}

	}

}
