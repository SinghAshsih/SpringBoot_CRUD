package com.employee.service;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeService {
	public String message(String message);

	public Employee create(Employee employee);

	public List<Employee> getAllEmployee();

	public Employee getEmployeeById(Long Id);

	public void removeRecord(Long id);

	public Employee update(Employee employee);


}
