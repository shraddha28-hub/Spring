package com.nt.beans;

public class B {
	private A a;
	
	public B() {
		System.out.println("0-param constructor");
	}
	public void setA(A a) {
		System.out.println("B.setA()");
		this.a = a;
	}
	@Override
	public String toString() {
		return "B [a=" ;
	}
	
	

}
