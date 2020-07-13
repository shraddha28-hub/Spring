package com.nt.beans;

public class Employee {
               private int eno;
               private String ename;
               private float salary;
               
               //alt+shift+s,o
			public Employee(int eno, String ename, float salary) {
			System.out.println("Employee::3-param constructor");
				this.eno = eno;
				this.ename = ename;
				this.salary = salary;
			}

			@Override
			public String toString() {
				return "Employee [eno=" + eno + ", ename=" + ename + ", salary=" + salary + "]";
			}
}
