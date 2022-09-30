package com.hrm;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Human Resource Management System \r\n Login As 1. Admin 2. Employee");
		int ans = sc.nextInt();
		String cont = "Y";
		while(cont.equalsIgnoreCase("y")) {
			if(ans == 1) {
				
				Admin.Start();
			}else if(ans == 2) {
				
				Employee.Start();
			}else {
				System.out.println("pleases Enter correct option");
			}
			System.out.println("Want to continue ? (y/n)");
			cont = sc.next();
		}	
	}
}
