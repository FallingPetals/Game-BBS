package com.njust.edu.tool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
/**
 * 违禁词过滤：用于替换多个字符串的类
 * 说明：只能替换完全匹配的违禁词（不是模糊匹配）
 *
 */
public class ScreenNode
{
	/** 子节点列表，Map的key是子节点对应的字符 */
	private Map<Character, ScreenNode> childs = new HashMap<Character, ScreenNode>();
	
	//private Logger log = LocalLogger.getLogger("screening");
 
	/** 要替换的旧字符串*/
	private String oldWord;
	
	/** 新字符串*/
	private String newWord;
	
	
	public ScreenNode(){
		
	}
	
	/**
	 * 添加一对替换关键字
	 * @param oldWords	要替换的字符串
	 * @param newWords	新字符串
	 */
	private void add(String oldWords, String newWords){
		add(oldWords, 0, newWords);
	}
 
/**
 * 构建树结构
 * @param oldWords 要屏蔽的词，比如“我爱你”
 * @param idx 首次添加为0，递归调用会+1，直到等于屏蔽词的长度
 * @param newWords 屏蔽词的显示词，我爱你对应***
 */
private void add(String oldWords, int idx, String newWords){
	if(oldWords.length() == idx){
		//达了树的叶子节点，此时对该节点设置字符串对
		this.newWord = newWords;
		this.oldWord = oldWords;
		return;
	}
	
	//把屏蔽词拆分，一个字一个字建立子节点
	char next_ch = oldWords.charAt(idx);
	ScreenNode ti = childs.get(next_ch);
	if(ti == null){
		ti = new ScreenNode();
		childs.put(next_ch, ti);
	}
	
	//读下一个字符，递归建立下一个字节点
	ti.add(oldWords, idx + 1, newWords); //调用递归取下一个字
}
	
	/**
	 * 删除某个特定的key
	 * @param oldWords
	 */
	public void del(String oldWords){
		if(StringUtils.isBlank(oldWords))
			return;
		del(oldWords,0);
		
	}
	
	/**
	 * 删除
	 * @param oldWords
	 */
	private void del(String oldWords,int idx){
		if(oldWords.length() == idx){
			this.newWord = null;
			this.oldWord = null;
			return;
		}
		char next_ch = oldWords.charAt(idx);
		ScreenNode ti = childs.get(next_ch);
		if(ti == null)
			return;
		if(ti != null){
			ti.del(oldWords,idx+1);
		}
	}
	
	/**
	 * 添加单个关键字
	 * @param value
	 */
	public void add(String value){
		StringBuilder s = new StringBuilder();
		for(int i=0;i<value.length();i++)
			s.append("*");
		//根据违规字的长度，拼凑长度相同的*
		this.add(value, s.toString());
	}
	
	/**
	 * 批量添加
	 * @param values
	 */
	public void add(List<String> values){
		for(String oldWords : values){
			StringBuilder s = new StringBuilder();
			for(int i=0;i<oldWords.length();i++)
				s.append("*");
			this.add(oldWords, s.toString());
		}
	}
	
	
	/**
	 * 删除所有内存中的关键字Key
	 */
	public void delAllKey(){
		childs.clear();
	}
	
	/**
	 * 用于存放查找关键字时的位置信息
	 * @author meteor
	 *
	 */
	private static class FindResultPosInfo{
		String oldWord;		// 找到的旧关键字
		String newWord;		// 要替换成的新字符串
		int idx;			// 关键字出现的位置
		
		FindResultPosInfo(String oldWord, String newWord, int idx)
		{
			this.oldWord = oldWord;
			this.newWord = newWord;
			this.idx = idx;
		}
	}
	
	
	/**
	 * 从字符串指定位置开始比较当前位置是否有关键字匹配
	 */
		// 找到匹配节点，并且该节点没有子节点（满足此条件是为了最长匹配）时，直接返回当前位置
	private FindResultPosInfo compareWords(String s, int idx){
		if(this.oldWord != null && this.childs.size() == 0)
		{
			return new FindResultPosInfo(this.oldWord, this.newWord, idx - this.oldWord.length());
		}
		
		// 如果字符串结束，则返回null
		if(idx >= s.length())
			return null;
 
		// 查找匹配的字节点
		char c = s.charAt(idx);
		ScreenNode ti = childs.get(c);
		if(ti == null)
			return null;
		
		// 递归匹配其余的字节点
		FindResultPosInfo fi = ti.compareWords(s, idx + 1);
		
		// 如果其余的字节点不匹配，则检查当前节点是否需要替换的节点
		if(fi == null && ti.oldWord != null)
			return new FindResultPosInfo(ti.oldWord, ti.newWord, idx + 1 - ti.oldWord.length());
 
		return fi;
	}
	
	private FindResultPosInfo findWords(String s, int idx,Object userId,String source){
		// 逐个位置比较是否匹配替换关键字
		for(int i = idx; i < s.length(); ++i){
			FindResultPosInfo wi = compareWords(s, i);
			if(wi != null){
				//if(log.isInfoEnabled())
					//log.info(userId +"\t"+ source +"\t"+wi.oldWord +"\t"+s);
				return wi;
			}
		}
		return null;
	}
	
	/**
	 * 检查字符串中是否存在需要替换的关键字
	 * @param s		要检查的字符串
	 * @userId 用户id，主要为了打印日志记录
	 * @source 来源，可以不填，主要为了打印日志记录
	 * @return
	 */
	public boolean existWords(String s,Object userId,String source){
		return findWords(s, 0,userId,source) != null;
	}
	
	/**
	 * 替换字符串中的旧字符串
	 * @param s	要替换的字符串
	 * @userId 用户id，主要为了打印日志记录
	 * @source 来源，可以不填，主要为了打印日志记录
	 * @return 
	 */
	public String replace(String s,Object userId,String source){
		FindResultPosInfo wi = findWords(s, 0,userId,source);		// 查找第一个替换的位置
		if(wi == null)
			return s;
		StringBuilder sb = new StringBuilder(s.length());
		int writen = 0;
		for(; wi != null && wi.idx < s.length(); ){
			sb.append(s, writen, wi.idx);			// append 原字符串不需替换部分
			sb.append(wi.newWord);					// append 新字符串
			writen = wi.idx + wi.oldWord.length();	// 忽略原字符串需要替换部分
			wi = findWords(s, writen,userId,source);				// 查找下一个替换位置
		}
		sb.append(s, writen, s.length());			// 替换剩下的原字符串
		return sb.toString();
	}
	
	
	private static class SingletonContainer{     
        private static ScreenNode manager = new ScreenNode();  
    }
	
	public static ScreenNode getInstance(){
		return SingletonContainer.manager;
	}
	
	@Override
	public String toString() {
		return "ScreenUtil [childs=" + childs + ", oldWord=" + oldWord
				+ ", newWord=" + newWord + "]";
	}
 
	/*
	public static void main(String[] argv)
	{
		//这是用户输入的文字，中间可能有违禁词
		String s = "我叫范恒旭，我来自日本，我最喜欢的东西是Sakura";
		System.out.println("src: " + s);
		
		ScreenNode ti = ScreenNode.getInstance();
		//加入违禁词
		//ti.add("日本");
		//ti.add("");
		//ti.add("Sakura");
		
		//删除违禁词
		//ti.del("av",0);
//		ti.del(" av ", 0);
//		ti.delAllKey();
		
		String ss = ti.replace(s,null,null);
		
		Boolean flag = ti.existWords(s,null,null);
		System.out.println("是否含有违禁词：" + flag);
		System.out.println("result: " + ss);
	}
	*/
}