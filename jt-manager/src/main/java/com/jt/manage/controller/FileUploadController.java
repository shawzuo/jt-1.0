package com.jt.manage.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jt.common.vo.PicUploadResult;
import com.jt.manage.service.FileUploadService;

@Controller
@RequestMapping("/pic")
public class FileUploadController {

	private static Logger logger = Logger.getLogger(FileUploadController.class);

	
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping("/upload")
	@ResponseBody
	public PicUploadResult uploadFile(MultipartFile uploadFile) {
		logger.info("======= start to uploadFile." + uploadFile.getName());
		
		PicUploadResult picUploadResult= fileUploadService.uploadFile(uploadFile);
		
		return picUploadResult;
	}
	
	
}
