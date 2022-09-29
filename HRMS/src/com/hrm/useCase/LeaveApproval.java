package com.hrm.useCase;

import com.hrm.dao.LeaveDao;
import com.hrm.dao.LeaveDaoImpl;
import com.hrm.exceptions.EmpException;

public class LeaveApproval {

	public static void main(String[] args) {
		LeaveDao Ld = new LeaveDaoImpl();
		
		try {
			Ld.LeaveApproval();
		} catch (EmpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
