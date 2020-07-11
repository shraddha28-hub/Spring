package com.nt.comp;

public class Test {
	static {
		System.out.println("Test::static block");
	}
	public Test() {
		System.out.println("0-param constructor");
	}
	@Override
	public String toString() {
		return "Test []";
	}

}
