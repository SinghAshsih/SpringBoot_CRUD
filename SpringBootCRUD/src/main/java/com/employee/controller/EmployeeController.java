package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	// creating employee record
	@PostMapping("/create")
	public ResponseEntity<Employee> create(@RequestBody Employee employee) {
		employeeService.create(employee);
		return new ResponseEntity<>(employee, HttpStatus.CREATED);
	}

	// getting list of employee
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAll() {
		List<Employee> listOfEmployee = employeeService.getAllEmployee();
		return new ResponseEntity<>(listOfEmployee, HttpStatus.OK);
	}

	// getting employee by id
	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getById(@PathVariable Long id) {
		return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}

	// remove employee record

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeRecord(@PathVariable Long id) {
		employeeService.removeRecord(id);
		return new ResponseEntity<>("Record Deleted Successful", HttpStatus.OK);
	}

	// update employee
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee employee) {
		Employee existingEmployee = employeeService.getEmployeeById(id);
		existingEmployee.setName(employee.getName());
		existingEmployee.setEmailId(employee.getEmailId());
		existingEmployee.setSalary(employee.getSalary());
		existingEmployee.setAge(employee.getAge());
		existingEmployee.setEducation(employee.getEducation());

		employeeService.update(existingEmployee);
		return new ResponseEntity<>(existingEmployee, HttpStatus.OK);
	}

}
