package com.jt.manage.service;

import java.util.List;

import com.jt.manage.pojo.Item;

public interface ItemService {
	
	List<Item> findAll();
	
	int findTotalNum();
	
	List<Item> findItemByPage(int pageNo, int pageSize);
	
}
