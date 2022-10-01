package com.hrm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.hrm.bean.Employee;
import com.hrm.exceptions.EmpException;
import com.hrm.util.DBConnect;

public class LeaveDaoImpl implements LeaveDao {
	@Override
	public void ApplyLeave(Employee emp) throws EmpException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Leave Start date in YYYY-MM-DD format");
		String start = sc.next();
		
		System.out.println("Enter Leave End date in YYYY-MM-DD format");
		String End = sc.next();
		
		System.out.println("Enter Nature of Leave personal or Medical");
		String nature = sc.next();
		
		try(Connection con = DBConnect.start()){
			PreparedStatement ps = con.prepareStatement("insert into Leaves values(?,?,?,?,?)");
			
			ps.setInt(1,emp.getEmpId());
			ps.setString(2,start);
			ps.setString(3, End);
			ps.setString(4, nature);
			ps.setString(5, "Pending");
			
			int rows = ps.executeUpdate();
			
			if(rows>0) {
				System.out.println("Your Leave application is successfully submited");
			}else {
				throw new EmpException("Not inserted");
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}
	
	}

	
	
	@Override
	public void LeaveApproval() throws EmpException {
		Scanner sc = new Scanner(System.in);
		try(Connection con = DBConnect.start()){
			ResultSet rs = con.prepareStatement(" select e.EmpId, e.EmpDeptId, e.LeavesAvl, DATEDIFF(l.EndDt,l.StartDt ) days_Applied, nature from Employee e inner join Leaves l on e.EmpId = l.EmpId ").executeQuery();
			
			List<String[]> detailArr = new ArrayList<>();
			
			String[] detail = new String[5];
			
			while(rs.next()) {
				detail[0] = rs.getString("EmpId");
				detail[1] = rs.getString("EmpDeptId");
				detail[2] = rs.getString("LeavesAvl");
				detail[3] = rs.getString("days_Applied");
				detail[4] = rs.getString("nature");
				detailArr.add(detail);
			}
			
			System.out.println("Select one option \r\n "+"1. Review all applications \r\n"+"2.Review latest 5 Application \r\n"+"3.Review application based on Employee id");
			int option = sc.nextInt();
			
			if(option == 1) {
				for(String[] s: detailArr) {
					System.out.println("The employee id is " +s[0]);
					System.out.println("employee's Department Id is " +s[1]);
					System.out.println("employee's Available Leaves are " +s[2]);
					System.out.println("Employee need days of Leaves are " +s[3]);
					System.out.println("The nature of Leave is " +s[4]);
					System.out.println();
					System.out.println("Select options \r\n"+"1. Accept \r\n"+"2. Reject \r\n"+"3. Pending");
					int ans = Integer.parseInt(sc.next());
					 PreparedStatement ps1 = con.prepareStatement("update Leaves set status = ? where EmpId ="+Integer.parseInt(s[0]));
					int rows = 0;
					 if(ans == 1) {
						 ps1.setString(1, "Accepted");
						  rows = ps1.executeUpdate();
						
					}else if(ans == 2) {
						ps1.setString(1, "Rejected");
						 rows = ps1.executeUpdate();
						
					}
					 if(rows<1) {
							throw new EmpException("Something went wrong ");
						}
				}
			}
			
			else if(option == 2) {
				
				int i = 0;
				for(String[] s: detailArr) {
					
					if(i>=5) break;
					System.out.println("The employee id is " +s[0]);
					System.out.println("employee's Department Id is " +s[1]);
					System.out.println("employee's Available Leaves are " +s[2]);
					System.out.println("Employee need days of Leaves are " +s[3]);
					System.out.println("The nature of Leave is " +s[4]);
					System.out.println();
					System.out.println("Select options \r\n"+"1. Accept \r\n"+"2. Reject \r\n"+"any key for Pending");
					int ans = sc.nextInt();
					 PreparedStatement ps1 = con.prepareStatement("update Leaves set status = ? where EmpId ="+Integer.parseInt(s[0]));
					if(ans == 1) {
						 ps1.setString(1, "Accepted");
						 int rows = ps1.executeUpdate();
						 if(rows<1) {
							 throw new EmpException("Something went wrong ");
						 }
					}else if(ans == 2) {
						ps1.setString(1, "Rejected");
						int rows = ps1.executeUpdate();
						if(rows<1) {
							throw new EmpException("Something went wrong ");
						}
					}
					i++;
				}
			}
			
			else if(option == 3) {
				
				System.out.println("Enter employee Id");
				int sid = sc.nextInt();
				
				for(String[] s:detailArr) {
					if(Integer.parseInt(s[0]) == sid) {
						System.out.println("The employee id is " +s[0]);
						System.out.println("employee's Department Id is " +s[1]);
						System.out.println("employee's Available Leaves are " +s[2]);
						System.out.println("Employee need days of Leaves are " +s[3]);
						System.out.println("The nature of Leave is " +s[4]);
						System.out.println();
						System.out.println("Select options \r\n"+"1. Accept \r\n"+"2. Reject \r\n"+"any key for Pending");
						int ans = sc.nextInt();
						 PreparedStatement ps1 = con.prepareStatement("update Leaves set status = ? where EmpId ="+Integer.parseInt(s[0]));
						
						 if(ans == 1) {
							 ps1.setString(1, "Accepted");
							 int rows = ps1.executeUpdate();
							 if(rows<1) {
								 throw new EmpException("Something went wrong ");
							 }
						}else if(ans == 2) {
							ps1.setString(1, "Rejected");
							int rows = ps1.executeUpdate();
							if(rows<1) {
								throw new EmpException("Something went wrong ");
							}
						}
						
						break;
					}
				}
			}
			
			else {
				
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e){
			throw new EmpException("Something went wrong try again");
		}
		
	}
}
