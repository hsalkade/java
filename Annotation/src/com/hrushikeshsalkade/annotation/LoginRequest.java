package com.hrushikeshsalkade.annotation;


public class LoginRequest {

	@Method("POST")
	public void execute() {
		System.out.println("Called execute");
	}
	
	@Method("GET")
	public void update() {
		System.out.println("Called update");
	}
}
