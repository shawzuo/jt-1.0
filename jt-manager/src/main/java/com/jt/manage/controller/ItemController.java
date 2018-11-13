package com.jt.manage.controller;

import java.util.List;
import java.util.UUID;

import javax.websocket.server.PathParam;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.EasyUIResult;
import com.jt.common.vo.SysResult;
import com.jt.manage.pojo.Item;
import com.jt.manage.pojo.ItemDesc;
import com.jt.manage.service.ItemService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/item")
public class ItemController {

	private static Logger logger = Logger.getLogger(ItemController.class);

	@Autowired
	private ItemService itemServie;
	
	@RequestMapping("/findAll")
	@ResponseBody
	public List<Item> findAll() {
		
		return itemServie.findAll();
	}
	
	//http://localhost:8091/item/query?page=1&rows=20
	@RequestMapping("/query")
	@ResponseBody
	public EasyUIResult findItemByPage (@PathParam("page") int page, @PathParam("rows") int rows) {
 		EasyUIResult result = new EasyUIResult();
		
		result.setTotal(itemServie.findTotalNum());
		result.setRows(itemServie.findItemByPage(page, rows));
		return result;
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public SysResult saveItem(Item item, String desc) {
		try {
			logger.info("==== start save item." + JSONObject.fromObject(item).toString());
			itemServie.savaItem(item, desc);
			logger.info("==== save item successful." + JSONObject.fromObject(item).toString());
			return SysResult.oK();
		} catch (Exception e) {
			logger.error("==== save item failed." + e.getMessage());
			return SysResult.build(201, "新增商品失败");
		}
		
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public SysResult updateItem(Item item, String desc) {
		logger.info("==== start update item." + JSONObject.fromObject(item).toString());
		try {
			itemServie.updateItem(item,desc);
			logger.info("==== update item successful. item id [" + item.getId() +"];");
			return SysResult.oK();
		} catch (Exception e) {
			logger.error("==== update item failed." + e.getMessage());
			return SysResult.build(201, "新增商品失败");
		}
		
	}
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public SysResult deleteItem(Long[] ids) {
		try {
			logger.info("==== start delete item." + ids.toString());
			int num = itemServie.deleteItem(ids);
			logger.info("==== delete item successful. item ids [" + ids +"];");
			String msg = "delete " + num + " items";
			return SysResult.build(200, msg);
		} catch (Exception e) {
			logger.error("==== delete item failed." + e.getMessage());
			return SysResult.build(201, "新增商品失败");
		}
		
	}
	
	//item/instock
	@RequestMapping("/instock")
	@ResponseBody
	public SysResult instockItem(Long[] ids) {
		try {
			logger.info("==== start instock item." + ids.toString());
			int num = itemServie.updateItemStatus(ids, 2);
			logger.info("==== instock item successful. item ids [" + ids +"];");
			String msg = "instock " + num + " items";
			return SysResult.build(200, msg);
		} catch (Exception e) {
			logger.error("==== instock item failed." + e.getMessage());
			return SysResult.build(201, "新增商品失败");
		}
		
	}
	
	//item/reshelf
	@RequestMapping("/reshelf")
	@ResponseBody
	public SysResult reshelfItem(Long[] ids) {
		try {
			logger.info("==== start reshelf item." + ids.toString());
			int num = itemServie.updateItemStatus(ids, 1);
			logger.info("==== reshelf item successful. item ids [" + ids +"];");
			String msg = "reshelf " + num + " items";
			return SysResult.build(200, msg);
		} catch (Exception e) {
			logger.error("==== reshelf item failed." + e.getMessage());
			return SysResult.build(201, "新增商品失败");
		}
		
	}
	
	//query/item/desc/1474391950
	@RequestMapping("/query/item/desc/{itemId}")
	@ResponseBody
	public SysResult findItemDesc(@PathVariable("itemId") Long itemId) {
		try {
			logger.info("==== start findItemDesc." + itemId);
			ItemDesc itemDesc = itemServie.findItemDesc(itemId);
			logger.info("==== findItemDesc successful. item id [" + itemId +"];");
			String msg = "findItemDesc successful.";
			return SysResult.build(200, msg, itemDesc);
		} catch (Exception e) {
			logger.error("==== findItemDesc failed." + e.getMessage());
			return SysResult.build(201, "新增商品失败");
		}
		
	}
	
	
}
