package com.jt.manage.service;

import java.util.List;

import com.jt.manage.pojo.ItemCat;

public interface ItemCatService {

	String findItemCatNameById(long itemCatId);

	List<ItemCat> findItemCatByParntId(Long parentId);
	
}
