package BattleGame;

public class Balloon extends Troops{
	
	public Balloon(){
		setHealth(55);
		setDamage(8);
		setType(air);
		setTarget(ground);
	}
	
	public String getTroopName() {
		return "Balloon";
		
	}



}
