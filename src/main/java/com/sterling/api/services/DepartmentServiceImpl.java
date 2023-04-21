package com.sterling.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sterling.api.entities.Department;
import com.sterling.api.repositories.DeptRepository;
import com.sterling.api.servicespec.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
		private DeptRepository dept;
	@Override
	public List<Department> getDepartments() {
		// TODO Auto-generated method stub
		return dept.findAll();
	}
	@Override
	public void addDeparment(Department d) {
		// TODO Auto-generated method stub
		dept.save(d);
	}

}
