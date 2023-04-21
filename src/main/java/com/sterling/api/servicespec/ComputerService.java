package com.sterling.api.servicespec;

import java.util.List;

import com.sterling.api.entities.Computer;
import com.sterling.api.utils.RecordNotFoundException;

public interface ComputerService {
public List<Computer> getComputers();
public Computer getComputer(int cno) throws RecordNotFoundException;
public Computer addComputer(Computer c);
public Computer updateComputer(Computer c,int cno) throws RecordNotFoundException;
public void deleteComputer(int cno) throws RecordNotFoundException;
}

