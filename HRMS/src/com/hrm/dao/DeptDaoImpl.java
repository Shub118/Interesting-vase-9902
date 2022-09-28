package com.hrm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.hrm.bean.Department;
import com.hrm.util.DBConnect;

public class DeptDaoImpl implements DeptDao{

	@Override
	public void insertDept(Department d) {
		try(Connection con = DBConnect.start()){
			
			PreparedStatement ps = con.prepareStatement("insert into Department values (?,?,?)");
			ps.setInt(1, d.getDeptId());
			ps.setString(2,d.getDeptName());
			ps.setString(3, d.getDeptLoc());
			
			int rows = ps.executeUpdate();
			if(rows>0) System.out.println("New Department Added");
			else System.out.println("Department not added");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
	
	
}
