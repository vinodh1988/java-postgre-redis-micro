package com.sterling.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sterling.api.entities.Computer;

import com.sterling.api.servicespec.ComputerService;
import com.sterling.api.utils.RecordNotFoundException;

@RestController
@RequestMapping("/api")
public class ComputerAPI implements ComputerApiSpecification{
	@Autowired
	private ComputerService computer;
	


	@RequestMapping("/computers")

	public List<Computer> getComputers() {
		// return Computer.findAll();
		return computer.getComputers();
	}
	

	@PostMapping("/computers")
	public ResponseEntity<Computer> addComputer(@RequestBody Computer c) {
		try {
			computer.addComputer(c);
			return new ResponseEntity<Computer>(c, HttpStatus.OK);

		}

		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Computer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value="/computers/{cno}",method= {RequestMethod.PUT,RequestMethod.PATCH})
	public ResponseEntity<String> updateComputer(@RequestBody Computer c,@PathVariable Integer cno){
		try {
			computer.updateComputer(c,cno);
			return new ResponseEntity<String>("suceefully updated",HttpStatus.OK);
			
		}
		catch(RecordNotFoundException e) {
			return new ResponseEntity<String>("Record not found",HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			return new  ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping("/computers/{cno}")
	public ResponseEntity<Computer> getComputer(@PathVariable Integer cno){
		try {
			Computer c=computer.getComputer(cno);
		
			return new ResponseEntity<Computer>(c,HttpStatus.OK);
			
		}
		catch(RecordNotFoundException e) {
			return new ResponseEntity<Computer>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new  ResponseEntity<Computer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/computers/{cno}")
	public ResponseEntity<String> deleteComputer(@PathVariable Integer cno){
		try {
			computer.deleteComputer(cno);
			return new ResponseEntity<String>("Successfully deleted",HttpStatus.OK);
			
		}
		catch(RecordNotFoundException e) {
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			return new  ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
