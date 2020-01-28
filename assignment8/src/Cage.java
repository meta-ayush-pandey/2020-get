

import java.util.HashMap;

public class Cage {
	final String animalBreed;
	final int cageId;
	static int counter =0;
	HashMap<String,Animal> listOfAnimal = new HashMap<>();
	final int capacityOfCage;
	
	public Cage(String typeOfAnimal, int capacity){
		animalBreed = typeOfAnimal;
		capacityOfCage = capacity;
		cageId = counter++;
	}
}
