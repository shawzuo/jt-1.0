package com.jt.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.manage.dao.ItemDao;
import com.jt.manage.pojo.Item;
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

}
