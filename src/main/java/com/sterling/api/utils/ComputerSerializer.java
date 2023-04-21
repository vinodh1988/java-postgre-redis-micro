package com.sterling.api.utils;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sterling.api.entities.Computer;

public class ComputerSerializer implements Serializer<Computer> {

	@Override
	public byte[] serialize(String topic, Computer data) {
		// TODO Auto-generated method stub
		ObjectMapper obj=new ObjectMapper();
		try {
			byte[] barray=obj.writeValueAsString(data).getBytes();
			return barray;
		}
		catch(Exception e) {
			return new byte[0];
		}
		
	}

}
