package com.njust.edu.dao;

import com.njust.edu.pojo.*;
import java.util.List;

public interface UserDao {
	public void insertUser(User user);
	
	public User queryUserByUid(int uid);
	
	public User queryuserByUserName(String user_name);
	
	public List<User> queryUserAll();
	
	public void updateUserByUid(User user);//����Ҫ�ĵ�ҲҪ��ǰ��queryUserByUid��ѯ����д��ȥ
	
	public void updateUserByUserName(User user);//����Ҫ�ĵ�ҲҪ��ǰ��queryUserByUid��ѯ����д��ȥ
	
	public void deleteUserByUid(int uid);
	
	public void deleteUserByUserName(String user_name);

}
