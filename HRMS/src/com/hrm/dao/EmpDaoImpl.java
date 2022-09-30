package com.hrm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.hrm.bean.Employee;
import com.hrm.exceptions.EmpException;
import com.hrm.util.DBConnect;

public class EmpDaoImpl implements EmpDao {

	@Override
	public void registerEmp(Employee emp) throws EmpException {
		
		try(Connection con = DBConnect.start()){
			PreparedStatement ps = con.prepareStatement("insert into Employee values(?,?,?,?,?,?,?,?)");
			
			ps.setInt(1, emp.getEmpId());
			ps.setString(2,emp.getEmpName());
			ps.setString(3, emp.getEmpRole());
			ps.setInt(4, emp.getEmpSalary());
			ps.setInt(5, emp.getEmpDeptId());
			ps.setString(6, emp.getEmpPassword());
			ps.setInt(7, emp.getLeavesAvl());
			ps.setString(8, emp.getUserName());
			
			int rows = ps.executeUpdate();
			
			if(rows>0) {
				System.out.println("The Registration was Succesfull");
			}else {
				throw new EmpException("No record inserted");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void Transfer(int empId, int Dept) throws EmpException {
		
		try(Connection con = DBConnect.start()){
			
			PreparedStatement ps = con.prepareStatement("update Employee set EmpDeptId = ? where EmpId = ?");
			
			ps.setInt(1, Dept);
			ps.setInt(2,empId);
			
			int rows = ps.executeUpdate();
			
			if(rows > 0) {
				
				System.out.println("Transfer was successfull and rows affected" + rows);
			}else {
				throw new EmpException("Transfer was unsuccesful");
			}
			
		}catch(SQLException se) {
			
		}
		
	}

	@Override
	public void viewProfl() throws EmpException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee id");
		int id = sc.nextInt();
		
		try(Connection con = DBConnect.start()){
			ResultSet rs = con.prepareStatement("select * from Employee where EmpId = "+id).executeQuery();
			
			if(rs.next()) {
				System.out.println("Employee id is "+rs.getInt("EmpId"));
				System.out.println(" Employee Name is "+rs.getString("EmpName"));
				System.out.println(" Employee role is "+rs.getString("EmpRole"));
				System.out.println(" Employee Salary is "+rs.getString("EmpSalary"));
				System.out.println(" Employee Username is "+rs.getString("UserName"));
				System.out.println(" Employee Available leaves are "+rs.getString("LeavesAvl"));
				
			}else {
				throw new EmpException("Invalid Id");
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}

	@Override
	public void updateEmp() throws EmpException {
	Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee id");
		int id = sc.nextInt();
		
		try(Connection con = DBConnect.start()){
			System.out.println("What do you wnat to change \r\n"+"1. Name 2. Password 3. Username");
			int ans = sc.nextInt();
			int row = 0;
			if(ans == 1) {
				System.out.println("Enter Name");
				String name = sc.next();
				
				PreparedStatement ps = con.prepareStatement(" update Employee set EmpName = ? where EmpId = "+id);
				ps.setString(1, name);
				row = ps.executeUpdate();
				
			}
			else if(ans == 2) {
				System.out.println("Enter password");
				String pass = sc.next();
				
				PreparedStatement ps = con.prepareStatement(" update Employee set EmpPassword = ? where EmpId = "+id);
				ps.setString(1, pass);
				row = ps.executeUpdate();
				
			}else if(ans==3) {
				System.out.println("Enter Username");
				String usrnm = sc.next();
				
				PreparedStatement ps = con.prepareStatement(" update Employee set userName = ? where EmpId = "+id);
				ps.setString(1, usrnm);
				row = ps.executeUpdate();
				
			}else {
				throw new EmpException("Invalid Input");
			}
			
			if(row > 0) {
				System.out.println("Entry Updated");
			}else {
				throw new EmpException("Update was not succesful");
			}
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
	}

	@Override
	public void updateEmpByAdm() throws EmpException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee id");
		int id = sc.nextInt();
		
		try(Connection con = DBConnect.start()){
				
			System.out.println("What do you wnat to change \r\n"+"1. Id 2. Name 3. role 4. Password 5. Username 6.salary 7.leaves");
			int ans = sc.nextInt();
			int row = 0;
			if(ans ==1) {
				System.out.println("Enter first Id");
				int Id = sc.nextInt();

				PreparedStatement ps = con.prepareStatement(" update Employee set EmpId = ? where EmpId = "+id);
				ps.setInt(1, Id);
				row = ps.executeUpdate();
			}else if(ans == 2) {
				System.out.println("Enter Name");
				String name = sc.next();
				
				PreparedStatement ps = con.prepareStatement(" update Employee set EmpName = ? where EmpId = "+id);
				ps.setString(1, name);
				row = ps.executeUpdate();
				
			}else if(ans==3) {
				System.out.println("Enter Role");
				String role = sc.next();
				
				PreparedStatement ps = con.prepareStatement(" update Employee set EmpRole = ? where EmpId = "+id);
				ps.setString(1, role);
				row = ps.executeUpdate();
				
			}else if(ans==4) {
				System.out.println("Enter password");
				String pass = sc.next();
				
				PreparedStatement ps = con.prepareStatement(" update Employee set EmpPassword = ? where EmpId = "+id);
				ps.setString(1, pass);
				row = ps.executeUpdate();
				
			}else if(ans==5) {
				System.out.println("Enter Username");
				String usrnm = sc.next();
				
				PreparedStatement ps = con.prepareStatement(" update Employee set userName = ? where EmpId = "+id);
				ps.setString(1, usrnm);
				row = ps.executeUpdate();
				
			}else if(ans==6) {
				System.out.println("Enter salary");
				int sal = sc.nextInt();
				
				PreparedStatement ps = con.prepareStatement(" update Employee set EmpSalary = ? where EmpId = "+id);
				ps.setInt(1, sal);
				row = ps.executeUpdate();
				
			}else if(ans==7) {
				System.out.println("Enter no. of leaves");
				int lv = sc.nextInt();
				
				PreparedStatement ps = con.prepareStatement(" update Employee set LeavesAvl = ? where EmpId = "+id);
				ps.setInt(1, lv);
				row = ps.executeUpdate();
				
			}
			else {
				throw new EmpException("Invalid Input");
			}
			
			if(row > 0) {
				System.out.println("Entry Updated");
			}else {
				throw new EmpException("Update was not succesful");
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}



}
