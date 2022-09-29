package com.hrm.useCase;

import com.hrm.dao.DeptDao;
import com.hrm.dao.DeptDaoImpl;
import com.hrm.exceptions.DeptException;

public class UpdateDept {

	public static void main(String[] args) {
		DeptDao dptdao = new DeptDaoImpl();
		
		try {
			dptdao.UpdateDept();
		} catch (DeptException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

	}

}
