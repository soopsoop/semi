package com.dog.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

public class FileUploadResolver {

	public static List<File> fileUpload(FileItem[] items,String uploadPath) throws Exception{
		
		List<File> uploadFileList = new ArrayList<File>();
		
		File file = new File(uploadPath);
		file.mkdirs();
		
		if (items != null)for (FileItem item : items) {
			
			String fileName = new File(item.getName()).getName(); // �궗�슜�옄 �뙆�씪紐�
			fileName = MakeFileName.toUUIDFileName(fileName, "$$"); // 怨좎쑀�븳 �뙆�씪紐�
			
			String filePath = uploadPath + File.separator + fileName;
			File storeFile = new File(filePath);
			
			// local HDD �뿉 ���옣.
			try {
				item.write(storeFile);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
			
			uploadFileList.add(storeFile);
		}
		
		
		return uploadFileList;
	}
}



