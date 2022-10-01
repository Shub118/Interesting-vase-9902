package com.hrm.useCase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.hrm.bean.Employee;
import com.hrm.dao.EmpDaoImpl;
import com.hrm.exceptions.EmpException;
import com.hrm.util.DBConnect;

public class UpdateProfile {
	public static void main(String[] arg) {
Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter employee Id");
		int id = sc.nextInt();
		Employee emp;
		
		try(Connection con = DBConnect.start()){
			ResultSet rs;
				rs = con.prepareStatement("select * from Employee where EmpId ="+id ).executeQuery();
				if(rs.next()){
					 emp = new Employee(rs.getInt("EmpId"), rs.getString("EmpName"),rs.getString("EmpRole"),rs.getInt("EmpSalary"),rs.getInt("EmpDeptId"), rs.getString("EmpPassword"), rs.getInt("LeavesAvl"), rs.getString("userName"));
					System.out.println("welcome "+ emp.getEmpName());
					new EmpDaoImpl().updateEmp(emp);
				}else {
					System.out.println("wrong Input");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EmpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
