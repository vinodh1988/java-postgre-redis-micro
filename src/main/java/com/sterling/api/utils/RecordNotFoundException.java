package com.sterling.api.utils;

import com.sterling.api.entities.Computer;

public class RecordNotFoundException extends Exception{

/**
	 * 
	 */
	private static final long serialVersionUID = -5724496012890950245L;

@Override
public String getMessage() {
	// TODO Auto-generated method stub
	//return "There is a record with the same id";
	return "No records with that ID actually Exists";
}

}
