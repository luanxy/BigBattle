package BattleGame;

public class FlyingMonkey extends Monkey{

	public FlyingMonkey(){
		setType(air);
		setTarget(air);
	}
	
	@Override
	public String getTroopName() {
		return "Flying Monkey";
		
	}
}
