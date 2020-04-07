package com.employee;

/**
 * Driver class for employee list
 * @author Ayush
 *
 */
public class EmployeeOperation {

	public static void main(String[] args){
		EmployeeList.addEmployee("test", 20000, 22);
		EmployeeList.addEmployee("chal", 23000, 25);
		EmployeeList.addEmployee("raha", 98000, 25);
		EmployeeList.addEmployee("hai", 120000, 21);
		EmployeeList.addEmployee("unique", 19000, 27);
		EmployeeList.addEmployee("name", 10000, 29);
		EmployeeList.addEmployee("chal", 23000, 20);
		EmployeeList.addEmployee("hota hai", 25000, 26);
		EmployeeList.displayList();
		System.out.println("----------------");
		EmployeeList.sortList();
		EmployeeList.displayList();
	}
}
