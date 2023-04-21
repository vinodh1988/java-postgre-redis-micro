package com.sterling.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sterling.api.entities.Department;
import com.sterling.api.entities.Employee;
import com.sterling.api.servicespec.DepartmentService;

@RestController
@RequestMapping("/api")
public class DepartmentAPI implements DepartmentApiSpecification {

	@Autowired
	private DepartmentService dservice;
	@Override
	@RequestMapping("/departments")
	public ResponseEntity<List<Department>> getDepartments() {
		// TODO Auto-generated method stub
		return new ResponseEntity<List<Department>>(dservice.getDepartments(),HttpStatus.OK);
	}
	@Override
	@PostMapping("/departments")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
		// TODO Auto-generated method stub
		try {
			for(Employee e:department.getEmployees()) {
				e.setDept(department);
			}
			dservice.addDeparment(department);
			return new ResponseEntity<Department>(department,HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Department>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}

}
