package com.sterling.api.servicespec;

import java.util.List;

import com.sterling.api.entities.Department;

public interface DepartmentService {
    public List<Department> getDepartments();
    public void addDeparment(Department d);
}
