package com.hrm.useCase;

import java.util.Scanner;

public class RegisterEmp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee id");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter Employee Name");
		String name = sc.nextLine();
		
		System.out.println("Enter Employee Role");
		String role = sc.next();
		
		System.out.println("Enter Employee Salary");
		int salary = sc.nextInt();
		
		System.out.println("Enter Employee Department Id");
		int DeptId = sc.nextInt();
		
		System.out.println("Enter Employee Salary");
		int salary = sc.nextInt();
	}

}
