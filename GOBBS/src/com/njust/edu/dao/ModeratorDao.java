package com.njust.edu.dao;

import com.njust.edu.pojo.*;
import java.util.List;

public interface ModeratorDao {
	public void insertModerator(Moderator moderator);//����
	
	public void updateModeratorLoseDateByUid(Moderator moderator);//moderator�е�uid����Ҫ�޸ĵ�moderator����һ���uid
	
	
	public void deleteModeratorByUid(int uid);
	
	public List<Moderator> queryModeratorAll();//��ѯ����
	
	public Moderator queryModeratorByUid(int uid);//ͨ��uid��ѯ
	
	public Moderator queryModeratorByBid(int bid);//ͨ��bid��ѯ

}
