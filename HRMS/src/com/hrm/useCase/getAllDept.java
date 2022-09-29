package com.hrm.useCase;

import com.hrm.dao.DeptDao;
import com.hrm.dao.DeptDaoImpl;
import com.hrm.exceptions.DeptException;

public class getAllDept {

	public static void main(String[] args) {
		DeptDao dptDao = new DeptDaoImpl();
		
		try {
			dptDao.getAllDept();
		} catch (DeptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
