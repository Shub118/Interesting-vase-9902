package com.hrm.bean;

public class Employee {
	 private int EmpId;   
	 private String EmpName;
	 private String EmpRole;    
	 private int EmpSalary;
	 private int EmpDeptId;
	 private String EmpPassword; 
	 private int LeavesAvl;
	 private String UserName;   
	  private boolean isAdmin;
	  
	  
	  
	public Employee(int empId, String empName, String empRole, int empSalary, int empDeptId, String empPassword,
			int leavesAvl, String userName, boolean isAdmin) {
		super();
		EmpId = empId;
		EmpName = empName;
		EmpRole = empRole;
		EmpSalary = empSalary;
		EmpDeptId = empDeptId;
		EmpPassword = empPassword;
		LeavesAvl = leavesAvl;
		UserName = userName;
		this.isAdmin = isAdmin;
	}
	
	public Employee() {
		
	}
	
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public String getEmpRole() {
		return EmpRole;
	}
	public void setEmpRole(String empRole) {
		EmpRole = empRole;
	}
	public int getEmpSalary() {
		return EmpSalary;
	}
	public void setEmpSalary(int empSalary) {
		EmpSalary = empSalary;
	}
	public int getEmpDeptId() {
		return EmpDeptId;
	}
	public void setEmpDeptId(int empDeptId) {
		EmpDeptId = empDeptId;
	}
	public String getEmpPassword() {
		return EmpPassword;
	}
	public void setEmpPassword(String empPassword) {
		EmpPassword = empPassword;
	}
	public int getLeavesAvl() {
		return LeavesAvl;
	}
	public void setLeavesAvl(int leavesAvl) {
		LeavesAvl = leavesAvl;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	  
	  
}
