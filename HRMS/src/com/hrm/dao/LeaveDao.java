package com.hrm.dao;

import com.hrm.exceptions.EmpException;

public interface LeaveDao {
	void ApplyLeave() throws EmpException;
	void LeaveApproval() throws EmpException;
}
