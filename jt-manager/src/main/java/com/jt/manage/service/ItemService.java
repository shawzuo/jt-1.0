package com.jt.manage.service;

import java.util.List;

import com.jt.manage.pojo.Item;
import com.jt.manage.pojo.ItemDesc;

public interface ItemService {
	
	List<Item> findAll();
	
	int findTotalNum();
	
	List<Item> findItemByPage(int pageNo, int pageSize);

	int savaItem(Item item, String desc);

	void updateItem(Item item,String desc);

	int deleteItem(Long[] ids);

	int updateItemStatus(Long[] ids, int status);

	ItemDesc findItemDesc(Long itemId);

	
}
