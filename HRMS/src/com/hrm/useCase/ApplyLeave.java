package com.hrm.useCase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.hrm.bean.Employee;
import com.hrm.dao.LeaveDao;
import com.hrm.dao.LeaveDaoImpl;
import com.hrm.exceptions.EmpException;
import com.hrm.util.DBConnect;

public class ApplyLeave {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		LeaveDao emdao = new LeaveDaoImpl();
		
		System.out.println("Enter employee Id");
		int id = sc.nextInt();
		Employee emp;
		
		try(Connection con = DBConnect.start()){
			ResultSet rs = con.prepareStatement("select * from Employee where EmpId ="+id ).executeQuery();
			if(rs.next()){
				 emp = new Employee(rs.getInt("EmpId"), rs.getString("EmpName"),rs.getString("EmpRole"),rs.getInt("EmpSalary"),rs.getInt("EmpDeptId"), rs.getString("EmpPassword"), rs.getInt("LeavesAvl"), rs.getString("userName"));
				System.out.println("welcome "+ emp.getEmpName());
				emdao.ApplyLeave(emp);
			}else {	
				System.out.println("Invalid input");
			}
		} catch (EmpException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
