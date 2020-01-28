

abstract public class Reptiles extends Animal {
	
	String swim;
	
	public Reptiles(int age,String name, String category, float weight, String canSwim,String sound) {
		super(age,name,category,weight,sound);
		swim = canSwim;
	}

	abstract public String swimSpeed();

}
