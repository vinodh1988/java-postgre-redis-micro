package com.sterling.api.rest;

import java.time.LocalDateTime;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sterling.api.servicespec.DataService;

@RestController
@RequestMapping("/api")
public class RestAPI implements RestApiSpecification {
	@Autowired
	DataService service;

@RequestMapping("/names")
public List<String> names(){
	return service.getNames();
}

@Override
public String hello() {
	// TODO Auto-generated method stub
	return null;
}

}
