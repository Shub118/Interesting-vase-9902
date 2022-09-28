package com.hrm.useCase;

import java.util.Scanner;
import com.hrm.dao.EmpDaoImpl;
import com.hrm.exceptions.EmpException;
public class TransferEmp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Id");
		int id = sc.nextInt();
		
		System.out.println("Enter Id of Department where to transfer");
		int deptNo = sc.nextInt();
		
		EmpDaoImpl edao= new EmpDaoImpl();
		try {
			edao.Transfer(id, deptNo);
		} catch (EmpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
