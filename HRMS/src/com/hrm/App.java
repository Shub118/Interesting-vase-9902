package com.hrm;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		System.out.println("Welcome to Human Resource Management System");
//		String str = "";
//		for(int i=0; i< 5; i++) {
//			str += "*";
//			
//				for(int j=4; j>=i; j--) {
//					str += " ";
//				}
//				str += "*";
//				for(int j=i*2; j>=0; j--) {
//					str += " ";
//				}
//				str += "*";
//				for(int j=4; j>=i; j--) {
//					str += " ";
//				}
//				str += "*\r\n";
//		}
		
//		System.out.println(str);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Login As 1. Admin 2. Employee");
		int ans = sc.nextInt();
		
		
		String cont = "Y";
		while(cont.equalsIgnoreCase("y")) {
			
			System.out.println("Please Enter your username");
			String id = sc.next();
			
			System.out.println("Please Enter your password");
			String password = sc.next();
			
			if(ans == 1) {	
				Admin.Start(id,password);
			}else if(ans == 2) {
				
				Employee.Start(id,password);
			}else {
				System.out.println("pleases Enter correct option");
			}
			System.out.println("Want to continue ? (y/n)");
			cont = sc.next();
		}
		System.out.println("See you soon Visit again");
	}
}
