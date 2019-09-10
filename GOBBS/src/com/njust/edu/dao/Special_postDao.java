package com.njust.edu.dao;

import com.njust.edu.pojo.*;

import java.util.List;

public interface Special_postDao {
	
	public void insertSpecial_post(Special_post special_post);
	
	public void updateSpecial_postByTid(Special_post special_post);//Ö»ÄÜÐÞ¸Äpost_type
	
	public void deleteSpecial_postByTid(int tid);
	
	public Special_post querySpecial_postByTid(int tid);
	
	public List<Special_post> querySpecial_postByBid(int tid);
	
	public List<Special_post> querySpecial_postAll();

}
