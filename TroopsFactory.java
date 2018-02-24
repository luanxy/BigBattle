package BattleGame;

public class TroopsFactory{

	public Troops createTroops(String name) {
		Troops troops = null; 
		switch (name) {
		case"Monkey":
			troops = new Monkey();
            break;
		case"FlyingMonkey":
			troops = new FlyingMonkey();
            break;
		case"Wizard":
			troops = new Wizard();
            break;
		case"Balloon":
			troops = new Balloon();
            break;
		default:
            break;
		}
		return troops;
		
	}
		 
}
	