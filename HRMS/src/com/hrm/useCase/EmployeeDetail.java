package com.hrm.useCase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.hrm.bean.Employee;
import com.hrm.dao.EmpDaoImpl;
import com.hrm.util.DBConnect;

public class EmployeeDetail {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter employee Id");
		int id = sc.nextInt();
		Employee emp;
		
		try(Connection con = DBConnect.start()){
			ResultSet rs = con.prepareStatement("select * from Employee where EmpId ="+id ).executeQuery();
			if(rs.next()){
				 emp = new Employee(rs.getInt("EmpId"), rs.getString("EmpName"),rs.getString("EmpRole"),rs.getInt("EmpSalary"),rs.getInt("EmpDeptId"), rs.getString("EmpPassword"), rs.getInt("LeavesAvl"), rs.getString("userName"));
				System.out.println("welcome "+ emp.getEmpName());
			
				new EmpDaoImpl().viewProfl(emp); 
			}else {
				System.out.println("Wrong Input");
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
	}

}
