package com.dog.action.happydog;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dog.action.Action;
import com.dog.controller.FileUploadResolver;
import com.dog.controller.GetUploadPath;
import com.dog.controller.MultipartHttpServletRequestParser;
import com.dog.dto.happydog.DogVO;
import com.dog.exception.NotMultipartFormDataException;
import com.dog.service.happydog.DogService;

public class DogModifyAction implements Action {
	
	private DogService dogService;
	public void setSearchdogService(DogService dogService) {
		this.dogService=dogService;
	}
	
	// 업로드 파일 환경 설정
	private static final int MEMORY_THRESHOLD = 1024 * 500;
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 1;
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 2;

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="/dog/dogModify_success";
		
		MultipartHttpServletRequestParser multiReq = null;
		
		try {
			multiReq = new MultipartHttpServletRequestParser(request, MEMORY_THRESHOLD, 
																	  MAX_FILE_SIZE, 
																	  MAX_REQUEST_SIZE);
		} catch (NotMultipartFormDataException e) {
			response.sendError(response.SC_BAD_REQUEST);
			return null;
		}
		
		String dogNo = multiReq.getParameter("dogNo");
		String dogName = multiReq.getParameter("dogName");
		String dogBreed = multiReq.getParameter("dogBreed");
		String dogGender = multiReq.getParameter("dogGender");
		String adoptYn = multiReq.getParameter("adoptYn");
		String dogFeature = multiReq.getParameter("dogFeature");
		
		DogVO dog = new DogVO();
		
		dog.setDogNo(dogNo);
		dog.setDogName(dogName);
		dog.setDogBreed(dogBreed);
		dog.setDogGender(dogGender);
		dog.setAdoptYn(adoptYn);
		dog.setDogFeature(dogFeature);
		
		// file 처리
		// 기존 사진 변경 유무 확인
		DogVO olddog = dogService.getDog(dogNo);
		
		String uploadPicture = multiReq.getParameter("uploadPicture");
		if(uploadPicture != null && !uploadPicture.isEmpty()) { // 사진 변경
			
			// 저장 경로
			String uploadPath = GetUploadPath.getUploadPath("dog.picture.upload");
			File file = new File(uploadPath);
			
			// 최근 사진 이미지 저장
			List<File> fileList = FileUploadResolver.fileUpload(multiReq.getFileItems("dogPic"), uploadPath);
			File saveFile = fileList.get(0);
			
			// 최근 사진 이미지 파일명 vo에 추가
			dog.setDogPic(saveFile.getName());
			
			// 기존 사진 이미지 삭제
			String oldPicture = olddog.getDogPic();
			File deleteFile = new File(uploadPath, oldPicture);
			if(deleteFile.exists()) {
				deleteFile.delete();
			}
		} else { // 사진 변경 X
			dog.setDogPic(olddog.getDogPic());
		}
		
		// DB 처리
		dogService.modify(dog);
		
		// 화면 처리
		request.setAttribute("dog", dogService.getDog(dog.getDogNo()));
		
		// 로그인 사용자 확인
		request.setAttribute("parentReload", false);
		
		HttpSession session = request.getSession();
		DogVO loginUser = (DogVO) session.getAttribute("loginUser");
		if(loginUser != null && dog.getDogNo().equals(loginUser.getDogNo())) {
			request.setAttribute("parentReload", true);
			session.setAttribute("loginUser", dogService.getDog(dog.getDogNo()));
		}
		return url;
	}

}
