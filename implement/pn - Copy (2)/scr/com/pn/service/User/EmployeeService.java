package com.pn.service.User;

import java.util.List;

import com.pn.model.dmEmployee.Employee;

public interface EmployeeService {

	public Employee employeeLogin(Employee employee);
	public List<Employee> listEmployee();
	public Employee changePassword(Employee employee);

}
