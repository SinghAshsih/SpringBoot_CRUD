package com.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public String message(String message) {
		// TODO Auto-generated method stub
		message = "All good here. Go ahead ... !!";
		return message;
	}

	@Override
	public Employee create(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long Id) {
		// TODO Auto-generated method stub
		Optional<Employee> findById = employeeRepository.findById(Id);
		return findById.get();
	}

	@Override
	public void removeRecord(Long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee update(Employee employee) {
		// TODO Auto-generated method stub

		return employeeRepository.save(employee);
	}

}
