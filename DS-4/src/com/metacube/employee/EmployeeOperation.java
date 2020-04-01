package com.metacube.employee;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This holds the functionalities for employee
 * @author Ayush Pandey
 *
 */
public class EmployeeOperation {
	private static ArrayList<EmployeeDetail> employeeList = new ArrayList<>();

	/**
	 * To add new employee in list
	 * @param id of employee
	 * @param EmployeeName
	 * @param address of employee
	 * @return string
	 */
	static String addEmployee(int id, String EmployeeName, String address) {
		for (int i=0; i<employeeList.size(); i++)
			if (employeeList.get(i).getEmployeeId() == id)
				return "Employee Exist";
		EmployeeDetail newEmployee = new EmployeeDetail(id, EmployeeName, address);
		employeeList.add(newEmployee);
		return "Added Successfully";
	}

	/**
	 * Display's the list of employees
	 */
	static void display() {			
		for (EmployeeDetail employee : employeeList)
			System.out.println("Id: " + employee.getEmployeeId() + ", Employee Name: "+employee.getName() + ", Address: "+ employee.getAddress());
	}

	/**
	 * To sort employee list on basis of Id
	 */
	static void sortEmployeeById() {
		Collections.sort(employeeList, new SortById());
	}

	/**
	 * To sort employee list on basis of name
	 */
	static void sortEmployeeByName() {
		Collections.sort(employeeList, new SortByName());
	}

	/**
	 * driver function for employee.
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println(addEmployee(2,"alpha","testing"));
		System.out.println(addEmployee(6,"beta","for the"));
		System.out.println(addEmployee(1,"gamma","virtual"));
		System.out.println(addEmployee(4,"delta","employees"));
		System.out.println(addEmployee(3,"theta","present"));
		System.out.println(addEmployee(3,"omega","in indian"));
		System.out.println(addEmployee(1,"neutron","education"));
		System.out.println(addEmployee(5,"proton","system"));
		System.out.println(addEmployee(7,"electron","boom kaboom!"));
		System.out.println("Employee List:");
		display();
		System.out.println("Sorted by Employee ID:");
		sortEmployeeById();
		display();
		System.out.println("Sorted by Employee Name:");
		sortEmployeeByName();
		display();
	}

}
