

public class AnimalTypeFactory {
	
	public static Animal addAnimal(String type,int age,String name, String category, float weight, int speed,String sound){

		Animal animal = null;
		if("tiger".equals(type))
			animal = new Tiger(age, name, category, weight, speed, sound);	

		return animal;
	}

	public static Animal addAnimal(String type,int age,String name, String category, float weight, String swim,String sound){

		Animal animal = null;
		if("crocodile".equalsIgnoreCase(type))
			animal = new Crocodiale(age, name, category, weight, swim, sound);

		return animal;
	}

	public static Animal addAnimal(String type,int age,String name, String category, float weight, boolean canFly,String sound){

		Animal animal = null;
		if("eagle".equalsIgnoreCase(type))
			animal = new Eagle(age, name, category, weight, canFly, sound);

		return animal;
	}
}
