package com.njust.edu.dao;

import com.njust.edu.pojo.*;

import java.util.List;

public interface CollectionDao {
	
	public void insertCollection(Collection collection);
	
	public void deleteCollection(Collection collection);
	
	public List<Collection> queryCollectionByUid(int uid);
	
	public List<Collection> queryCollectionAll();

}
