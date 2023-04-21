package com.sterling.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Computer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2217397729834904585L;
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer sno;
	@Column
	private String brand;
	@Column
	private String cpu;
	@Column
	private Integer ram;
	@Column
	private String disk;
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public Integer getRam() {
		return ram;
	}
	public void setRam(Integer ram) {
		this.ram = ram;
	}
	public String getDisk() {
		return disk;
	}
	public void setDisk(String disk) {
		this.disk = disk;
	}

}
