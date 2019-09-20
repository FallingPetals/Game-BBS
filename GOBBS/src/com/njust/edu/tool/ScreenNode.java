package com.njust.edu.tool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
/**
 * Υ���ʹ��ˣ������滻����ַ�������
 * ˵����ֻ���滻��ȫƥ���Υ���ʣ�����ģ��ƥ�䣩
 *
 */
public class ScreenNode
{
	/** �ӽڵ��б�Map��key���ӽڵ��Ӧ���ַ� */
	private Map<Character, ScreenNode> childs = new HashMap<Character, ScreenNode>();
	
	//private Logger log = LocalLogger.getLogger("screening");
 
	/** Ҫ�滻�ľ��ַ���*/
	private String oldWord;
	
	/** ���ַ���*/
	private String newWord;
	
	
	public ScreenNode(){
		
	}
	
	/**
	 * ���һ���滻�ؼ���
	 * @param oldWords	Ҫ�滻���ַ���
	 * @param newWords	���ַ���
	 */
	private void add(String oldWords, String newWords){
		add(oldWords, 0, newWords);
	}
 
/**
 * �������ṹ
 * @param oldWords Ҫ���εĴʣ����硰�Ұ��㡱
 * @param idx �״����Ϊ0���ݹ���û�+1��ֱ���������δʵĳ���
 * @param newWords ���δʵ���ʾ�ʣ��Ұ����Ӧ***
 */
private void add(String oldWords, int idx, String newWords){
	if(oldWords.length() == idx){
		//��������Ҷ�ӽڵ㣬��ʱ�Ըýڵ������ַ�����
		this.newWord = newWords;
		this.oldWord = oldWords;
		return;
	}
	
	//�����δʲ�֣�һ����һ���ֽ����ӽڵ�
	char next_ch = oldWords.charAt(idx);
	ScreenNode ti = childs.get(next_ch);
	if(ti == null){
		ti = new ScreenNode();
		childs.put(next_ch, ti);
	}
	
	//����һ���ַ����ݹ齨����һ���ֽڵ�
	ti.add(oldWords, idx + 1, newWords); //���õݹ�ȡ��һ����
}
	
	/**
	 * ɾ��ĳ���ض���key
	 * @param oldWords
	 */
	public void del(String oldWords){
		if(StringUtils.isBlank(oldWords))
			return;
		del(oldWords,0);
		
	}
	
	/**
	 * ɾ��
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
	 * ��ӵ����ؼ���
	 * @param value
	 */
	public void add(String value){
		StringBuilder s = new StringBuilder();
		for(int i=0;i<value.length();i++)
			s.append("*");
		//����Υ���ֵĳ��ȣ�ƴ�ճ�����ͬ��*
		this.add(value, s.toString());
	}
	
	/**
	 * �������
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
	 * ɾ�������ڴ��еĹؼ���Key
	 */
	public void delAllKey(){
		childs.clear();
	}
	
	/**
	 * ���ڴ�Ų��ҹؼ���ʱ��λ����Ϣ
	 * @author meteor
	 *
	 */
	private static class FindResultPosInfo{
		String oldWord;		// �ҵ��ľɹؼ���
		String newWord;		// Ҫ�滻�ɵ����ַ���
		int idx;			// �ؼ��ֳ��ֵ�λ��
		
		FindResultPosInfo(String oldWord, String newWord, int idx)
		{
			this.oldWord = oldWord;
			this.newWord = newWord;
			this.idx = idx;
		}
	}
	
	
	/**
	 * ���ַ���ָ��λ�ÿ�ʼ�Ƚϵ�ǰλ���Ƿ��йؼ���ƥ��
	 */
		// �ҵ�ƥ��ڵ㣬���Ҹýڵ�û���ӽڵ㣨�����������Ϊ���ƥ�䣩ʱ��ֱ�ӷ��ص�ǰλ��
	private FindResultPosInfo compareWords(String s, int idx){
		if(this.oldWord != null && this.childs.size() == 0)
		{
			return new FindResultPosInfo(this.oldWord, this.newWord, idx - this.oldWord.length());
		}
		
		// ����ַ����������򷵻�null
		if(idx >= s.length())
			return null;
 
		// ����ƥ����ֽڵ�
		char c = s.charAt(idx);
		ScreenNode ti = childs.get(c);
		if(ti == null)
			return null;
		
		// �ݹ�ƥ��������ֽڵ�
		FindResultPosInfo fi = ti.compareWords(s, idx + 1);
		
		// ���������ֽڵ㲻ƥ�䣬���鵱ǰ�ڵ��Ƿ���Ҫ�滻�Ľڵ�
		if(fi == null && ti.oldWord != null)
			return new FindResultPosInfo(ti.oldWord, ti.newWord, idx + 1 - ti.oldWord.length());
 
		return fi;
	}
	
	private FindResultPosInfo findWords(String s, int idx,Object userId,String source){
		// ���λ�ñȽ��Ƿ�ƥ���滻�ؼ���
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
	 * ����ַ������Ƿ������Ҫ�滻�Ĺؼ���
	 * @param s		Ҫ�����ַ���
	 * @userId �û�id����ҪΪ�˴�ӡ��־��¼
	 * @source ��Դ�����Բ����ҪΪ�˴�ӡ��־��¼
	 * @return
	 */
	public boolean existWords(String s,Object userId,String source){
		return findWords(s, 0,userId,source) != null;
	}
	
	/**
	 * �滻�ַ����еľ��ַ���
	 * @param s	Ҫ�滻���ַ���
	 * @userId �û�id����ҪΪ�˴�ӡ��־��¼
	 * @source ��Դ�����Բ����ҪΪ�˴�ӡ��־��¼
	 * @return 
	 */
	public String replace(String s,Object userId,String source){
		FindResultPosInfo wi = findWords(s, 0,userId,source);		// ���ҵ�һ���滻��λ��
		if(wi == null)
			return s;
		StringBuilder sb = new StringBuilder(s.length());
		int writen = 0;
		for(; wi != null && wi.idx < s.length(); ){
			sb.append(s, writen, wi.idx);			// append ԭ�ַ��������滻����
			sb.append(wi.newWord);					// append ���ַ���
			writen = wi.idx + wi.oldWord.length();	// ����ԭ�ַ�����Ҫ�滻����
			wi = findWords(s, writen,userId,source);				// ������һ���滻λ��
		}
		sb.append(s, writen, s.length());			// �滻ʣ�µ�ԭ�ַ���
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
		//�����û���������֣��м������Υ����
		String s = "�ҽз������������ձ�������ϲ���Ķ�����Sakura";
		System.out.println("src: " + s);
		
		ScreenNode ti = ScreenNode.getInstance();
		//����Υ����
		//ti.add("�ձ�");
		//ti.add("");
		//ti.add("Sakura");
		
		//ɾ��Υ����
		//ti.del("av",0);
//		ti.del(" av ", 0);
//		ti.delAllKey();
		
		String ss = ti.replace(s,null,null);
		
		Boolean flag = ti.existWords(s,null,null);
		System.out.println("�Ƿ���Υ���ʣ�" + flag);
		System.out.println("result: " + ss);
	}
	*/
}