package BattleGame;

public class Monkey extends Troops{
	
	public Monkey(){
		setHealth(50);
		setDamage(6);
		setType(ground);
		setTarget(ground);
	}
	
	@Override
	public String getTroopName() {
		return "Monkey";
		
	}

	

}
