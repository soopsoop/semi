package com.dog.command;

import java.util.Date;

import com.dog.dto.happydog.DogVO;

public class DogRegistCommand {

	private String dogNo;
	private Date dogDate;
	private String dogFeature;
	private String dogBreed;
	private String dogName;
	private String dogGender;
	private String dogPic;
	private String dogPicCurrent;
	private String viewCntBoard;
	private String memId;
	private String adoptYn;
	private Date adoptDate;

	public String getDogNo() {
		return dogNo;
	}

	public void setDogNo(String dogNo) {
		this.dogNo = dogNo;
	}

	public Date getDogDate() {
		return dogDate;
	}

	public void setDogDate(Date dogDate) {
		this.dogDate = dogDate;
	}

	public String getDogFeature() {
		return dogFeature;
	}

	public void setDogFeature(String dogFeature) {
		this.dogFeature = dogFeature;
	}

	public String getDogBreed() {
		return dogBreed;
	}

	public void setDogBreed(String dogBreed) {
		this.dogBreed = dogBreed;
	}

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public String getDogGender() {
		return dogGender;
	}

	public void setDogGender(String dogGender) {
		this.dogGender = dogGender;
	}

	public String getDogPic() {
		return dogPic;
	}

	public void setDogPic(String dogPic) {
		this.dogPic = dogPic;
	}

	public String getDogPicCurrent() {
		return dogPicCurrent;
	}

	public void setDogPicCurrent(String dogPicCurrent) {
		this.dogPicCurrent = dogPicCurrent;
	}

	public String getViewCntBoard() {
		return viewCntBoard;
	}

	public void setViewCntBoard(String viewCntBoard) {
		this.viewCntBoard = viewCntBoard;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getAdoptYn() {
		return adoptYn;
	}

	public void setAdoptYn(String adoptYn) {
		this.adoptYn = adoptYn;
	}

	public Date getAdoptDate() {
		return adoptDate;
	}

	public void setAdoptDate(Date adoptDate) {
		this.adoptDate = adoptDate;
	}

	public DogVO toDogVO() {

		DogVO dog = new DogVO();

		dog.setDogName(dogName);
		dog.setDogBreed(dogBreed);
		dog.setDogGender(dogGender);
		dog.setDogFeature(dogFeature);
		dog.setDogPic(dogPic);
		dog.setAdoptYn(adoptYn);

		return dog;
	}

}
