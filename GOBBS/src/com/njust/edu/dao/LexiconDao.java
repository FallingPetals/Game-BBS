package com.njust.edu.dao;

import com.njust.edu.pojo.*;

import java.util.List;

public interface LexiconDao {
	
	public void insertLexicon(String content);
	
	public void deleteLexiconByContent(String content);
	
	public List<Lexicon> queryLexiconAll();

}
