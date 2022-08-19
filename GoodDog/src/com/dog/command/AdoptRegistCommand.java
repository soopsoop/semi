package com.dog.command;

import java.util.Date;

import com.dog.dto.happydog.DogVO;

public class AdoptRegistCommand {

	private String dogNo;
	private String dogPicCurrent;
	private String memId;

	public String getDogNo() {
		return dogNo;
	}

	public void setDogNo(String dogNo) {
		this.dogNo = dogNo;
	}

	public String getDogPicCurrent() {
		return dogPicCurrent;
	}

	public void setDogPicCurrent(String dogPicCurrent) {
		this.dogPicCurrent = dogPicCurrent;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public DogVO toDogVO() {

		DogVO dog = new DogVO();

		dog.setDogNo(dogNo);
		dog.setMemId(memId);
		dog.setDogPicCurrent(dogPicCurrent);

		return dog;
	}

}
