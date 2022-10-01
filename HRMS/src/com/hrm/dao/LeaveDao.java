package com.hrm.dao;

import com.hrm.bean.Employee;
import com.hrm.exceptions.EmpException;

public interface LeaveDao {
	void ApplyLeave(Employee emp) throws EmpException;
	void LeaveApproval() throws EmpException;
}
