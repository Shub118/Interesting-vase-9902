package com.hrm.useCase;

import com.hrm.dao.DeptDaoImpl;
import com.hrm.exceptions.DeptException;

public class InsertDept {

	public static void main(String[] args) {
				
		DeptDaoImpl deptDao = new DeptDaoImpl();

		try {
			deptDao.insertDept();
		} catch (DeptException e) {
			e.getMessage();
		}

	}

}
