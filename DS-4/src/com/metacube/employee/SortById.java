package com.metacube.employee;

import java.util.Comparator;

/**
 * This overwrites compare of sorting list by id
 * @author Ayush Pandey
 *
 */
public class SortById implements Comparator<EmployeeDetail> {

	public int compare(EmployeeDetail a, EmployeeDetail b){ 	            
		return a.getEmployeeId() - b.getEmployeeId(); 
	}
}
