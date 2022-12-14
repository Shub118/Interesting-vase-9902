package com.hrm.dao;

import com.hrm.bean.Employee;
import com.hrm.exceptions.EmpException;

public interface EmpDao {
	void registerEmp(Employee e) throws EmpException ;
	
	void Transfer(int empId, int Dept) throws EmpException;
	
	void updateEmp(Employee emp) throws EmpException;
	
	void updateEmpByAdm() throws EmpException;

	void viewProfl(Employee emp) ;
}
