package com.hrm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
