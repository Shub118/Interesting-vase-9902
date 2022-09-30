package com.hrm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.hrm.dao.EmpDaoImpl;
import com.hrm.dao.LeaveDao;
import com.hrm.dao.LeaveDaoImpl;
import com.hrm.exceptions.EmpException;
import com.hrm.util.DBConnect;

public class Employee {
	public static void Start(String id, String password) {
		Scanner sc = new Scanner(System.in);
	
		try(Connection con = DBConnect.start()){
			ResultSet rs = con.prepareStatement("select * from Employee where userName = '"+id+"' AND EmpPassword = '"+password+"'").executeQuery();
			if(rs.next()){
				String name = rs.getString("EmpName");
				System.out.println("welcome "+name);
				
				System.out.println("Please select the operation\r\n" +" 1. view profile\r\n"
						+ "  2. Update profile\r\n"
						+ "  3. Apply Leave");
				
				int opt = sc.nextInt();
				
				switch(opt) {
				case 1 : 
					try {
						new EmpDaoImpl().viewProfl();
					} catch (EmpException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						e.getMessage();
					} 
					break;
				case 2 :
					 try {
							new EmpDaoImpl().updateEmp();
						} catch (EmpException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						};
					break;
				case 3:
					LeaveDao emdao = new LeaveDaoImpl();
					
					try {
						emdao.ApplyLeave();
					} catch (EmpException e) {
						// TODO Auto-generated catch block
						e.getMessage();
					}
					break;
				default:
				}
			}else {
				System.out.println("Please Enter correct Username and Password");
			}
			
		}catch(SQLException se){
			se.printStackTrace();
		}
	}
	
}
