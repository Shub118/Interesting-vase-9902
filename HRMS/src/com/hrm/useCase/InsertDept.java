package com.hrm.useCase;

import java.util.Scanner;

import com.hrm.bean.Department;
import com.hrm.dao.DeptDaoImpl;

public class useInsertDept {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Department Id");
		int id = sc.nextInt();
		
		System.out.println("Please Enter Department Name");
		String name = sc.next();
		
		System.out.println("Please Enter Department Location");
		String loc = sc.next();
		
		DeptDaoImpl deptDao = new DeptDaoImpl();
		
		Department dept = new Department(id,name,loc);
		
		deptDao.insertDept(dept);

	}

}
