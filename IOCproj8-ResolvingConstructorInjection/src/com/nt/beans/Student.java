package com.nt.beans;

public class Student {
          private int sid;
          private String sname;
          private String sadd;
          private int total;
          
          
		public Student(int sid, String sname, String sadd, int total) {
		System.out.println("Student::4-param constructor");
			this.sid = sid;
			this.sname = sname;
			this.sadd = sadd;
			this.total = total;
		}
		@Override
		public String toString() {
			return "Student [sid=" + sid + ", sname=" + sname + ", sadd=" + sadd + ", total=" + total + "]";
		}
          
          
}
