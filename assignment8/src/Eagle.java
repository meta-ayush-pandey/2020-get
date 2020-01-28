

public class Eagle extends Birds {
	public Eagle(int age,String name, String category, float weight, boolean canFly,String sound){
		super(age, name, category, weight, canFly,sound);
	}
	
	public String getSound(){
		return super.soundOfAnimal;
	}
	
	public boolean canFly(){
		return super.fly;
	}
}
