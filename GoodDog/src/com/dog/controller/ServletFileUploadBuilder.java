package com.dog.controller;

import java.io.File;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ServletFileUploadBuilder {

	public static ServletFileUpload build(int MEMORY_THRESHOLD, 
										  int MAX_FILE_SIZE, 
										  int MAX_REQUEST_SIZE) {

		// �뾽濡쒕뱶瑜� �쐞�븳 upload �솚寃쎌꽕�젙 �쟻�슜.
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// ���옣�쓣 �쐞�븳 threshold memory �쟻�슜.
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		// �엫�떆 ���옣 �쐞移� 寃곗젙.
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);

		// �뾽濡쒕뱶 �뙆�씪�쓽 �겕湲� �쟻�슜.
		upload.setFileSizeMax(MAX_FILE_SIZE);
		// �뾽濡쒕뱶 request �겕湲� �쟻�슜.
		upload.setSizeMax(MAX_REQUEST_SIZE);

		return upload;
		
		
	}
}
