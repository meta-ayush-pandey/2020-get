package com.metacube.facade;

import java.sql.SQLException;
import java.util.Scanner;

import com.metacube.dao.ImportExportDetails;
import com.metacube.view.OptionChosen;

public class Functionality {

	public void showItems() {
		ImportExportDetails obj = new ImportExportDetails();
		OptionChosen oc = new OptionChosen();
		obj.showCart();
		System.out.println("\n");
		oc.chooseOption();
	}

	public void addItems() {
		ImportExportDetails obj = new ImportExportDetails();
		OptionChosen oc = new OptionChosen();
		System.out.println("Enter code of item you want to add");
		Scanner input = new Scanner(System.in);
		int code = input.nextInt();
		try {
			obj.addToCart(code);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n");
		oc.chooseOption();
	}

	public void deleteItems() {
		ImportExportDetails obj = new ImportExportDetails();
		OptionChosen oc = new OptionChosen();
		System.out.println("Enter code of item you want to delete");
		Scanner input = new Scanner(System.in);
		int code = input.nextInt();
		obj.deleteFromCart(code);
		showItems();
		System.out.println("\n");
		oc.chooseOption();
	}

	public void editQuantity() {
		ImportExportDetails obj = new ImportExportDetails();
		OptionChosen oc = new OptionChosen();
		System.out.println("Enter item code");
		Scanner input = new Scanner(System.in);
		int code = input.nextInt();
		System.out.println("Enter quantity");
		Scanner inputTwo = new Scanner(System.in);
		int quantity = inputTwo.nextInt();
		obj.editQuantity(code, quantity);
		if(quantity>0) {
			showItems();
			System.out.println("\n");
			oc.chooseOption();
		} else {
			System.out.println("quantity can't be zero or negative");
			editQuantity();
		}
	}

}
