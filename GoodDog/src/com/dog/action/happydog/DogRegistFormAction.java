package com.dog.action.happydog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;

<<<<<<<< HEAD:GoodDog/src/com/dog/controller/member/ErrorAction.java
public class ErrorAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(1/0);
		return null;
========
public class DogRegistFormAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="/dog/dogRegist";
		return url;
>>>>>>>> 36a24d88d228bdc983616bb8ccb07f11f9c457ec:GoodDog/src/com/dog/action/happydog/DogRegistFormAction.java
	}

}
