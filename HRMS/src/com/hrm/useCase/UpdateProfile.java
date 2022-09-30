package com.hrm.useCase;

import com.hrm.dao.EmpDaoImpl;
import com.hrm.exceptions.EmpException;

public class UpdateProfile {
	public static void main(String[] arg) {
		 try {
			new EmpDaoImpl().updateEmp();
		} catch (EmpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

}
