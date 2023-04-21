package com.sterling.api.rest;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
public interface RestApiSpecification {
@ApiOperation(value="return a greet",response=String.class,httpMethod="GET")
public String hello();
@ApiOperation(value="return a list of Strings",response=List.class,httpMethod="GET")
public List<String> names();
}
