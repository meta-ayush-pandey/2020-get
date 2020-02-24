package com.metacube.controller;

import com.metacube.facade.Functionality;

public class ControllerClass {

	
	public void controller(int option) {
		Functionality f = new Functionality();
		if(option == 1) {
			f.showItems();
		}
		if(option == 2) {
			f.addItems();
		}
		if(option == 3) {
			f.deleteItems();
		}
		if(option == 4) {
			f.editQuantity();
		}
	}
}
