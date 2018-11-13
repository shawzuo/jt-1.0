package com.jt.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.manage.dao.ItemDao;
import com.jt.manage.pojo.Item;
import com.jt.manage.pojo.ItemDesc;
import com.jt.manage.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;
	
	public List<Item> findAll() {
		
		return itemDao.findAll();
	}

	public int findTotalNum() {
		return itemDao.findTotalNum();
	}

	public List<Item> findItemByPage(int pageNo, int pageSize) {
		return itemDao.findItemByPage(pageNo, pageSize);
	}

	@Override
	public int savaItem(Item item, String desc) {
		return itemDao.saveItem(item, desc);
	}

	@Override
	public void updateItem(Item item, String desc) {
		itemDao.updateItem(item, desc);
	}

	@Override
	public int deleteItem(Long[] ids) {
		return itemDao.deleteItems(ids);
	}


	@Override
	public int updateItemStatus(Long[] ids, int status) {
		return itemDao.updateItemStatus(ids, status);
	}

	@Override
	public ItemDesc findItemDesc(Long itemId) {
		return itemDao.findItemDesc(itemId);
	}

}
