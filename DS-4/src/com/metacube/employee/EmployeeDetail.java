package com.metacube.employee;

/**
 * This class holds the structure of employee
 * @author Ayush Pandey
 *
 */
public class EmployeeDetail {
	private int employeeId;
	private String name;
	private String address;

	/**
	 * To initialize the object
	 * @param employeeId of employee
	 * @param name of employee
	 * @param address of employee
	 */
	public EmployeeDetail(int employeeId, String name, String address) {
		this.employeeId = employeeId;
		this.name = name;
		this.address = address;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
