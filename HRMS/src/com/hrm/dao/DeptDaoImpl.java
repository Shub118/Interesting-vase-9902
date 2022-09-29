package com.hrm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.hrm.bean.Department;
import com.hrm.exceptions.DeptException;
import com.hrm.util.DBConnect;

public class DeptDaoImpl implements DeptDao{

	@Override
	public void insertDept()  throws DeptException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Department Id");
		int id = sc.nextInt();
		
		System.out.println("Please Enter Department Name");
		String name = sc.next();
		
		System.out.println("Please Enter Department Location");
		String loc = sc.next();
		
		Department d = new Department(id,name,loc);
		
		try(Connection con = DBConnect.start()){
			
			PreparedStatement ps = con.prepareStatement("insert into Department values (?,?,?)");
			ps.setInt(1, d.getDeptId());
			ps.setString(2,d.getDeptName());
			ps.setString(3, d.getDeptLoc());
			
			int rows = ps.executeUpdate();
			if(rows>0) System.out.println("New Department Added");
			else {
				throw new DeptException("Insertion was unsuccesful");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

//	////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void UpdateDept()  throws DeptException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Department id");
		int id = sc.nextInt();
		
		try(Connection con = DBConnect.start()){	
				
			System.out.println("What do you want to upadate please enter number\r\n"+" 1. Department number \r\n"+" 2.Department name \r\n"+" 3. Department Location");
			int query = sc.nextInt();
			
			int rows = 0;
			
			if(query == 1) {
				System.out.println("Enter new Department number");
				PreparedStatement ps = con.prepareStatement("update Department set DeptId = "+sc.nextInt()+" where DeptId = "+id);
				rows = ps.executeUpdate();
			}else if(query == 2) {
				System.out.println("Enter new Department name");
				PreparedStatement ps = con.prepareStatement("update Department set DeptName = '"+sc.next()+"' where DeptId = "+id);
				rows = ps.executeUpdate();
			}else if(query == 3) {
				System.out.println("Enter new Department Location");
				PreparedStatement ps = con.prepareStatement("update Department set Location = '"+sc.next()+"' where DeptId = "+id);
				rows = ps.executeUpdate();
			}else {
				throw new DeptException("wrong option ");
			}
			
			if(rows>0) System.out.println("Department Updated");
			else { 
				throw new DeptException("Update failed"); 
			}
			
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}	
		
		
	}
	
	
///////////////////////////////////////////////////////////////////////////
	
	@Override
	public void getAllDept() throws DeptException {
		try(Connection con = DBConnect.start()){
			ResultSet rs = con.prepareStatement("select * from Department").executeQuery();
			if(rs.isBeforeFirst()) throw new DeptException("No Department in Database");
			while(rs.next()) {
				System.out.println("| Department Id is "+rs.getInt("DeptId"));
				System.out.println("| Department Name is "+rs.getString("DeptName"));
				System.out.println("| Department Location is "+rs.getString("Location"));
				System.out.println("===============================================");
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
	}
	
	
}
