

public class Tiger extends Mamals {
	
	public Tiger(int age,String name, String category, float weight, int speed,String sound){
		super(age, name, category, weight,speed,sound);
	}

	public String getSound(){
		return super.soundOfAnimal;
	}
	
	public int topSpeed(){
		return super.runningSpeed;
	}
}
