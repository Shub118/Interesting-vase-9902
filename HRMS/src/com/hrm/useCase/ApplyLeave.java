package com.hrm.useCase;

import com.hrm.dao.LeaveDao;
import com.hrm.dao.LeaveDaoImpl;
import com.hrm.exceptions.EmpException;

public class ApplyLeave {
	
	public static void main(String[] args) {
		LeaveDao emdao = new LeaveDaoImpl();
		
		try {
			emdao.ApplyLeave();
		} catch (EmpException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}

}
