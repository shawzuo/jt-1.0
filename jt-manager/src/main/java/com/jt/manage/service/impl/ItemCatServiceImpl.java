package com.jt.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.manage.dao.ItemCatDao;
import com.jt.manage.pojo.ItemCat;
import com.jt.manage.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private ItemCatDao itemCatDao;
	
	public String findItemCatNameById(long itemCatId) {
		return itemCatDao.findItemCatNameById(itemCatId);
	}

	@Override
	public List<ItemCat> findItemCatByParntId(Long parentId) {
		
		List<ItemCat> itemCatList = itemCatDao.findItemCatByParntId(parentId);
		return itemCatList;
	}

}
