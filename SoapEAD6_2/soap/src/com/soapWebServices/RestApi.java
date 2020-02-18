package com.soapWebServices;

public class RestApi {
	public double area(double sideA, double sideB, double sideC) {
		try {
			if((sideA > 0) && (sideB > 0) && (sideC > 0) && ((sideA + sideB > sideC) && (sideA + sideC > sideB) && (sideB + sideC > sideA))) {
				double s = (sideA + sideB + sideC)/2;
				double areaTriangle = Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
				return areaTriangle;
			} else {
				System.out.println("Invalid Input");
				return -1;
			}
		} catch(NumberFormatException ex) {
			System.out.println("Number Format Exception");
			return 0;
		}
	}
}
