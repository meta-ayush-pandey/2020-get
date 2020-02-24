package com.metacube.view;

import java.util.Scanner;

import com.metacube.controller.ControllerClass;
import com.metacube.dao.ImportExportDetails;

public class OptionChosen {

	ControllerClass con = null;
	public void chooseOption() {
		con = new ControllerClass();
		int choice;
		ImportExportDetails obj = new ImportExportDetails();
		obj.showInventory();
		try {
			Scanner input = new Scanner(System.in);
			System.out.println("1.Show Cart");
			System.out.println("2.Add Items");
			System.out.println("3.Delete Item");
			System.out.println("4.Edit Quantity");
			choice = input.nextInt();
			if(choice<=4) {
				con.controller(choice);
			} else {
				System.out.println("Please enter correct input");
				chooseOption();
			}
		} catch(Exception ex) {
			System.out.println("Please enter correct input");
			chooseOption();
		}
	}
}
