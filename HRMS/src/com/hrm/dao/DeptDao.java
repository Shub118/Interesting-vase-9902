package com.hrm.dao;

import com.hrm.exceptions.DeptException;

public interface DeptDao { 
	
	void insertDept() throws DeptException;
	
	void UpdateDept()  throws DeptException;
	
	void getAllDept() throws DeptException;
}
