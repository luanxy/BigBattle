package BattleGame;

public class Wizard extends Troops{
	
	public Wizard(){
		setHealth(60);
		setDamage(6);
		setType(ground);
		setTarget(all);
	}
	
	@Override
	public String getTroopName() {
		return "Wizard";
		
	}
	


}
