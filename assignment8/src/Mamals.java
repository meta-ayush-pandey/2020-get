

abstract public class Mamals extends Animal {
	int runningSpeed;
	
	public Mamals(int age,String name, String category, float weight,int speed,String sound) {
		super(age,name,category,weight,sound);
		runningSpeed = speed;
	}

	abstract public int topSpeed();
}
