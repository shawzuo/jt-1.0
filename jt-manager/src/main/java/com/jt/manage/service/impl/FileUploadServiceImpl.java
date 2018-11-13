package com.jt.manage.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jt.common.vo.PicUploadResult;
import com.jt.manage.service.FileUploadService;

@Service
public class FileUploadServiceImpl implements FileUploadService {

	//private static 
	private static Logger logger = Logger.getLogger(FileUploadServiceImpl.class);
	
	private String dirPath = "D:/Users/jt-upload/";

	private String url = "http://image.jt.com/";
	
	
	@Override
	public PicUploadResult uploadFile(MultipartFile uploadFile) {
		PicUploadResult result = new PicUploadResult();
		String fileName = uploadFile.getOriginalFilename();
		String fileType = fileName.substring(fileName.lastIndexOf("."));
		if (!fileType.matches("^.*(jpg|png|gif)$")) {
			logger.error("不是一张图片");
			result.setError(1);
			return result;//不是图片直接返回
		}
		// 判断是否为恶意程序
		// 通过工具类判断
		try {
			BufferedImage bufferedImage = ImageIO.read(uploadFile.getInputStream());
			// 文件高度和宽度不为0  就是图片
			int height = bufferedImage.getHeight();
			int width = bufferedImage.getWidth();
			
			if (height == 0 || width == 0) {
				logger.error("不是一张图片");
				result.setError(1);
				return result;//不是图片直接返回
			}
			
			//准备时间文件夹
			String dataPathDir = new SimpleDateFormat("yyyy/MM/dd/HH").format(new Date());
			String radomPath = UUID.randomUUID().toString();
			String localPath = dirPath + dataPathDir;
			File file = new File(localPath);
			if (!file.exists()) {
				file.mkdirs();
			}
			
			String localPahtFile = localPath + "/" + radomPath + fileName;
			uploadFile.transferTo(new File(localPahtFile));
			String urlPath = url + "/" + dataPathDir + "/" + radomPath + fileName;
			
			result.setError(0);
			result.setHeight(height +"");
			result.setWidth(String.valueOf(width));
			result.setUrl(urlPath);
			return result;
			
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("图片解析失败");
			result.setError(1);
			return result;//不是图片直接返回	
		}
	}

}
