package com.sterling.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sterling.api.entities.Department;

public interface DeptRepository extends  JpaRepository<Department, Long> {

}
