package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/create")
	public ResponseEntity<Employee> create(@RequestBody Employee employee) {
		employeeService.create(employee);
		return new ResponseEntity<>(employee, HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAll() {
		List<Employee> listOfEmployee = employeeService.getAllEmployee();
		return new ResponseEntity<>(listOfEmployee, HttpStatus.OK);
	}

}
