package com.hrm.bean;

public class Department {
	private int DeptId;
	private String DeptName;
	private String DeptLoc;
	
	public Department(int id,String name, String loc ){
		DeptId = id;
		DeptName = name;
		DeptLoc = loc;
	}
	
	public Department(){
		
	}
	
	public String getDeptLoc() {
		return DeptLoc;
	}
	public void setDeptLoc(String deptLoc) {
		DeptLoc = deptLoc;
	}
	public String getDeptName() {
		return DeptName;
	}
	public void setDeptName(String deptName) {
		DeptName = deptName;
	}
	public int getDeptId() {
		return DeptId;
	}
	public void setDeptId(int deptId) {
		DeptId = deptId;
	}
}
