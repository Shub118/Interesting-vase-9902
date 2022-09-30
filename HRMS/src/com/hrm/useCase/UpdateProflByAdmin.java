package com.hrm.useCase;

import com.hrm.dao.EmpDaoImpl;
import com.hrm.exceptions.EmpException;

public class UpdateProflByAdmin {

	public static void main(String[] args) {
		try {
			new EmpDaoImpl().updateEmpByAdm();
		} catch (EmpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
