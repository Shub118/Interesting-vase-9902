package com.hrm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.hrm.bean.Employee;
import com.hrm.dao.DeptDao;
import com.hrm.dao.DeptDaoImpl;
import com.hrm.dao.EmpDaoImpl;
import com.hrm.dao.LeaveDao;
import com.hrm.dao.LeaveDaoImpl;
import com.hrm.exceptions.DeptException;
import com.hrm.exceptions.EmpException;
import com.hrm.util.DBConnect;

public class AdminAcc {
	public static void Start(String lid, String password) throws DeptException {
		Scanner sc = new Scanner(System.in);
		
		try(Connection con = DBConnect.start()){
			ResultSet rs = con.prepareStatement("select * from Admin where username = '"+lid+"' AND password = '"+password+"'").executeQuery();
			if(rs.next()){
				String lname = rs.getString("username");
				System.out.println("welcome "+lname);
				System.out.println();
				System.out.println("Please select the operation\r\n"+ " 1. Add new employee .\r\n"
						+ " 2. Add new department\r\n"
						+ " 3. update department\r\n"
						+ " 4. Transfer Employee\r\n"
						+ " 5. show all departments\r\n"
						+ " 6.  Review Leave applications\r\n"
						+ " 7.Update Employee's Profile");
				
				int opt = sc.nextInt();
				
				switch(opt) {
				case 1 : 
					
					System.out.println("Enter Employee id");
					int eid = sc.nextInt();
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
					
					Employee emp = new Employee( eid,  name,  role,  salary,  DeptId,  pass, Leav, username);
					
					try {
						new EmpDaoImpl().registerEmp(emp);
					} catch (EmpException e) {
						// TODO Auto-generated catch block
						e.getMessage();
					}
					break;
				case 2 :
					DeptDaoImpl deptDao = new DeptDaoImpl();

					try {
						deptDao.insertDept();
					} catch (DeptException e) {
						e.getMessage();
					}
					break;
				case 3:
					DeptDao dptdao = new DeptDaoImpl();
					
					try {
						dptdao.UpdateDept();
					} catch (DeptException e) {
						// TODO Auto-generated catch block
						e.getMessage();
					}
					break;
				case 4:
					System.out.println("Enter Employee Id");
					int tid = sc.nextInt();
					
					System.out.println("Enter Id of Department where to transfer");
					int deptNo = sc.nextInt();
					
					EmpDaoImpl edao= new EmpDaoImpl();
					try {
						edao.Transfer(tid, deptNo);
					} catch (EmpException e) {
						System.out.println(e.getMessage());
					} 
					break;
				case 5:
					DeptDao dptDao = new DeptDaoImpl();
					
					try {
						dptDao.getAllDept();
					} catch (DeptException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 6:
					LeaveDao Ld = new LeaveDaoImpl();
					
					try {
						Ld.LeaveApproval();
					} catch (EmpException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 7:
					try {
						new EmpDaoImpl().updateEmpByAdm();
					} catch (EmpException e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					System.out.println("Wrong Input");
						
				}
				
				
			}else {
				throw new DeptException("No Matching Profile Found");
			}
			
		}catch(InputMismatchException se){
			throw new DeptException("Please Enter correct Input login again to continue");
		} catch (SQLException e1) {
			throw new DeptException(e1.getMessage());
		}
	}

}
