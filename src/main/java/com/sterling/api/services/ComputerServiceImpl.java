package com.sterling.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sterling.api.entities.Computer;
import com.sterling.api.repositories.ComputerRepository;
import com.sterling.api.servicespec.ComputerService;
import com.sterling.api.utils.RecordNotFoundException;

@Service
public class ComputerServiceImpl implements ComputerService {// ,InitializingBean
	@Autowired
	ComputerRepository repo;
//	ComputerService repo;

	@Override
	public List<Computer> getComputers() {
		// TODO Auto-generated method stub
		// return null;
		// return ((ComputerService) repo).getComputers();
		return repo.findAll();
	}
	/*
	 * @Override public void afterPropertiesSet() throws Exception { // TODO
	 * Auto-generated method stub System.out.println(
	 * "------------------------------------------------------------------");
	 * System.out.println(repo.getClass()+" is the class"); }
	 */

	@Override
	@CachePut(value="computers", key="#result.sno")
	public Computer addComputer(Computer c) {
		// TODO Auto-generated method stub
		Computer computer = repo.save(c);
		return computer;
	}

	@Override
	@CachePut(value="computers", key="#sno")
	public Computer updateComputer(Computer c, int sno) throws RecordNotFoundException {
		Computer computer = repo.findBySno(sno);
		if (computer == null)
			throw new RecordNotFoundException();
		else {
			c.setSno(sno);
			c.setBrand(c.getBrand() == null ? computer.getBrand() : c.getBrand());
			c.setCpu(c.getCpu() == null ? computer.getCpu() : c.getCpu());
			c.setRam(c.getRam() == null ? computer.getRam() : c.getRam());
			c.setDisk(c.getDisk() == null ? computer.getDisk() : c.getDisk());
			return repo.save(c);
		}
	}

	@Override
	@Cacheable(value="computers",key="#sno")
	public Computer getComputer(int sno) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		Computer computer = repo.findBySno(sno);
		if (computer == null)
			throw new RecordNotFoundException();
		else
			return computer;
	}

	@Override
	@CacheEvict(value="computers", key="#cno")
	public void deleteComputer(int cno) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		Computer computer = repo.findBySno(cno);
		if (computer == null)
			throw new RecordNotFoundException();
		else
			repo.delete(computer);
	}
}
