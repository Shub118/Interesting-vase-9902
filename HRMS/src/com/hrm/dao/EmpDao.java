package com.hrm.dao;

import com.hrm.bean.Employee;
import com.hrm.exceptions.EmpException;

public interface Emp {
	void registerEmp(Employee e) throws EmpException ;
}
