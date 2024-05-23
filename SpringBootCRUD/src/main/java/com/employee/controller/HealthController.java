package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/check")
public class HealthController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/message")
	public ResponseEntity<?> message(String message) {
		return ResponseEntity.ok(employeeService.message(message));
		 
	}
}
