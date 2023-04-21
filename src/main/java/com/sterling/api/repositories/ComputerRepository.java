package com.sterling.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sterling.api.entities.Computer;

public interface ComputerRepository extends JpaRepository<Computer, Long>{
public Computer findBySno(int Sno);
//public Computer findByBrand();
}
