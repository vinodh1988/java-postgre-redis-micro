package com.sterling.api.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sterling.api.entities.Department;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
public interface DepartmentApiSpecification {
@ApiOperation(httpMethod = "GET",response = List.class, value = "Returns Depts list")
   public ResponseEntity<List<Department>> getDepartments();

@ApiOperation(httpMethod = "POST",response = Department.class, value = "Adds Depts list")
   public ResponseEntity<Department> addDepartment(Department department);
}
