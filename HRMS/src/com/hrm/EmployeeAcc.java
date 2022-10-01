package com.hrm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.hrm.bean.Employee;
import com.hrm.dao.EmpDaoImpl;
import com.hrm.dao.LeaveDao;
import com.hrm.dao.LeaveDaoImpl;
import com.hrm.exceptions.EmpException;
import com.hrm.util.DBConnect;

public class EmployeeAcc {
	public static void Start(String id, String password) throws EmpException {
		Scanner sc = new Scanner(System.in);
	
		try(Connection con = DBConnect.start()){
			ResultSet rs = con.prepareStatement("select * from Employee where userName = '"+id+"' AND EmpPassword = '"+password+"'").executeQuery();
			if(rs.next()){
				Employee emp = new Employee(rs.getInt("EmpId"), rs.getString("EmpName"),rs.getString("EmpRole"),rs.getInt("EmpSalary"),rs.getInt("EmpDeptId"), rs.getString("EmpPassword"), rs.getInt("LeavesAvl"), rs.getString("userName"));
				System.out.println("welcome "+ emp.getEmpName());
//				 EmpId | EmpName | EmpRole    | EmpSalary | EmpDeptId | EmpPassword | LeavesAvl | userName
				System.out.println("Please select the operation\r\n" +" 1. view profile\r\n"
						+ "  2. Update profile\r\n"
						+ "  3. Apply Leave");
				
				int opt = sc.nextInt();
				
				switch(opt) {
				case 1 : 
					new EmpDaoImpl().viewProfl(emp); 
					break;
					
				case 2 :
					 try {
							new EmpDaoImpl().updateEmp(emp);
						} catch (EmpException e) {
							System.out.println(e.getMessage());
						};
					break;
				case 3:
					LeaveDao emdao = new LeaveDaoImpl();
					
					try {
						emdao.ApplyLeave(emp);
					} catch (EmpException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					break;
				default:
				}
			}else {
				throw new EmpException("No Matching Profile Found");
			}
			
		}catch(InputMismatchException se){
			throw new EmpException("Please Enter correct Input login again to continue");
		} catch (SQLException e1) {
			throw new EmpException(e1.getMessage());
		}
	}
	
}
