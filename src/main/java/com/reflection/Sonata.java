package com.reflection;

public class Sonata {
	public void start() {
		System.out.println("start 호출성공");
	}
	public void start(String args) {
		System.out.println("start "+args+"호출성공");
	}
	
	public void stop() {
		System.out.println("stop 호출성공");
	}
	public void stop(String args) {
		System.out.println("stop "+args+" 호출성공");
	}
}
