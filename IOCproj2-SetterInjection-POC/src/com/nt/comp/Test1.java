package com.nt.comp;

public class Test1 {
   private int a,b,c;
   
   static {
		System.out.println("Test::static block");
	}
	public Test1() {
		System.out.println("0-param constructor");
	}

public Test1(int a, int b,int c) {
	System.out.println("2-param constructor");
	this.a = a;
	this.b = b;
	this.c=c;
}

@Override
public String toString() {
	return "Test1 [a=" + a + ", b=" + b + ", c=" + c + "]";
}


  
}
