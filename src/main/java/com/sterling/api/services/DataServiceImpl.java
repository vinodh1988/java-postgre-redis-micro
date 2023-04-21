package com.sterling.api.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sterling.api.servicespec.DataService;
@Service
public class DataServiceImpl implements DataService {

	@Override
	public List<String> getNames() {
		// TODO Auto-generated method stub
		String[] names= {"Rosha","Harry","Naresh","Joseph","Ram","Christoper"};
		return Arrays.asList(names);
	}

}
