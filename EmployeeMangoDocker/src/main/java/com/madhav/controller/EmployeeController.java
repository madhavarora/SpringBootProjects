package com.madhav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.madhav.model.Employee;
import com.madhav.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@RequestMapping(method=RequestMethod.POST)
	public Employee create(@RequestBody Employee employee){
		
		//Employee tempEmployee   = new Employee("1", "123", "madhav", "madhav1");
		Employee result = employeeRepository.save(employee);
		return result;
		
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{employeeId}")
	public Employee get(@PathVariable String employeeId){
		Employee result   = employeeRepository.findById(employeeId).get();
		
		return result;
	}

	
	 @RequestMapping("/greeting")
	    public Employee greeting(String name) {
	        return new Employee("123", "1234", "madhavget", "madhavget2");
	    }
}
