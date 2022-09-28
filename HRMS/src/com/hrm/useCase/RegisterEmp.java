package com.hrm.useCase;

import java.util.Scanner;

import com.hrm.bean.Employee;
import com.hrm.dao.EmpDaoImpl;
import com.hrm.exceptions.EmpException;

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
		
		System.out.println("Enter Employee UserName");
		String username = sc.next();
		
		System.out.println("Enter Employee Password");
		String pass = sc.next();
		
		System.out.println("Enter Employee Available Leaves");
		int Leav = sc.nextInt();
		
		Employee emp = new Employee( id,  name,  role,  salary,  DeptId,  pass, Leav, username);
		
		try {
			new EmpDaoImpl().registerEmp(emp);
		} catch (EmpException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}

}
