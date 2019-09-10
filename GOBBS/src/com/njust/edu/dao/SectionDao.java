package com.njust.edu.dao;

import com.njust.edu.pojo.*;

import java.util.List;

public interface SectionDao {
	
	public void insertSection(Section section);//ֻ������û���������ԣ��������Զ�Ҫ�ֶ����룬��bid�����Զ�����
	
	public void updateSectionByBid(Section section);//���޸�section_name,section_type,headline
	
	public void updateSectionBySectionName(Section section);//�����޸�section_name,ֻ���޸�section_type,headline
	
	public void deleteSectionByBid(int bid);
	
	public void deleteSectionBySectionName(String section_name);
	
	public Section querySectionByBid(int bid);//���ݰ���Ų�ѯ
	
	public Section querySectionBySectionName(String section_name);//���ݰ�����ֲ�ѯ
	
	public List<Section> querySectionAll();

}
