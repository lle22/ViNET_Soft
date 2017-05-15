package com.pn.dao.user;

import org.springframework.stereotype.Repository;

import com.pn.dao.base.impl.GenericDAOImpl;
import com.pn.model.dmEmployee.Employee;

@Repository("EmployeeDao")
public class EmployeeDaoImpl extends GenericDAOImpl<Employee, String> implements EmployeeDao{


}