package com.employee;

/**
 * This class holds the functionalities of linked list
 * @author Ayush
 *
 */
public class EmployeeList {

	private static Employee header;

	/**
	 * To add new Employee in list
	 * @param data of Employee
	 * @return true if successful
	 */
	static boolean addEmployee(String name, long data, int age){
		Employee newEmployee = new Employee(name, data, age);

		if(header == null){
			header = newEmployee;
		}
		else{
			Employee temp = header;
			while(temp.getNext() != null){
				temp = temp.getNext();
			}
			temp.setNext(newEmployee);
		}
		return true;
	}
	
	/**
	 * To display the linked list
	 * @return true if list present
	 */
	static boolean displayList() {
		if(header == null){
			return false;
		}
		Employee temp = header;
		while(temp != null){
			System.out.println("Name: "+ temp.getName() + " Salary: "+ temp.getSalary() + " Age: " + temp.getAge() +" -> ");
			temp = temp.getNext();
		}
		return true;
	}
	
	/**
	 * To sort employee in descending order of there salary
	 */
	static void sortList(){
		QuickSort.sort(header, getLastElement());
	}
	
	/**
	 * To get the last node in list
	 * @return last node
	 */
	private static Employee getLastElement(){
		Employee temp = header;
		while(temp.getNext()!=null){
			temp = temp.getNext();
		}
		return temp;
	}
}

