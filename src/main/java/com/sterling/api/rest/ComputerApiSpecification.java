package com.sterling.api.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.sterling.api.entities.Computer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
public interface ComputerApiSpecification {
	@ApiOperation(value="reads all computer details",response=List.class,httpMethod="GET")
	public List<Computer> getComputers();
	@ApiOperation(value="Add a new computer",response=Computer.class,httpMethod="POST")
	public ResponseEntity<Computer> addComputer(@RequestBody Computer c) ;
	@ApiOperation(value="Update a new computer ",response=String.class,httpMethod="PUT")
	public ResponseEntity<String> updateComputer(@RequestBody Computer c,@PathVariable Integer cno);
	@ApiOperation(value="reads computer details by ID",response=Computer.class,httpMethod="GET")
	public ResponseEntity<Computer> getComputer(@PathVariable Integer cno);
	@ApiOperation(value="delete a new computer",response=String.class,httpMethod="DELETE")
	public ResponseEntity<String> deleteComputer(@PathVariable Integer cno);
}
