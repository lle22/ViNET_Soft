package com.pn.service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.ehcache.annotations.Cacheable;
import com.pn.dao.user.EmployeeDao;
import com.pn.model.dmEmployee.Employee;

@Service("UserService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmployeeServiceImpl  implements EmployeeService{

	@Autowired
	EmployeeDao employeeDao;
	
	public Employee employeeLogin(Employee employee) {
		return employeeDao.loadById(employee.getId());
	}

	@Cacheable(cacheName="listEmployeeCache")
	public List<Employee> listEmployee() {
		return employeeDao.loadAll();
	}

	public Employee changePassword(Employee employee) {
		Employee emp = employeeDao.loadById(employee.getId());
		emp.setPassWord(employee.getPassWord());
		employeeDao.saveOrUpdate(emp);
		return emp;
	}

}
