package com.hrm;

import java.util.Scanner;

import com.hrm.exceptions.DeptException;
import com.hrm.exceptions.EmpException;

public class App {

	public static void main(String[] args) {
		
		System.out.println("Welcome to HRMS");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Login As 1. Admin 2. Employee");
		int ans = sc.nextInt();
		
		System.out.println("Please Enter your username");
		String id = sc.next();
		
		System.out.println("Please Enter your password");
		String password = sc.next();
		
		
		String cont = "Y";
		while(cont.equalsIgnoreCase("y")) {
			
			if(ans == 1) {	
				try {
					AdminAcc.Start(id,password);
				} catch (DeptException e) {
					System.out.println( e.getMessage());
					System.out.println("Please Enter correct username");
					 id = sc.next();
					
					System.out.println("Please Enter correct password");
					 password = sc.next();
				}
			}else if(ans == 2) {
				
				try {
					EmployeeAcc.Start(id,password);
				} catch (EmpException e) {
					System.out.println( e.getMessage());
					System.out.println("Please Enter correct username");
					 id = sc.next();
					
					System.out.println("Please Enter correct password");
					 password = sc.next();
				}
			}else {
				System.out.println("please Enter correct option");
			}
			System.out.println("Want to continue ? (y/n)");
			cont = sc.next();
		}
		System.out.println("See you soon Visit again");
	}
}
