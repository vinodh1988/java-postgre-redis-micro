package com.sterling.api.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Department {
@Id
   private Integer dno;
@Column   
   private String name;
@OneToMany(mappedBy = "dept", cascade = CascadeType.ALL)
Set<Employee> employees;
public Integer getDno() {
	return dno;
}
public void setDno(Integer dno) {
	this.dno = dno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Set<Employee> getEmployees() {
	return employees;
}
public void setEmployees(Set<Employee> employees) {
	this.employees = employees;
}


   
   
}
