package BattleGame;

public abstract class Troops { 
	protected int ground = 0;
	protected int air = 1;
	protected int all = 2;
	
	protected int damage;
	protected int health;
	protected int type;
	protected int target;
	protected int totalDamage = 0;
	
	protected abstract String getTroopName();  
	
	protected int getDamage(){
		return damage;
	}; 
	
	protected int getHealth(){
		return health;
	}; 
	
	protected int getType(){
		return type;
	}; 
	
	protected int getTarget(){
		return target;
	};
	
	protected int getTotalDamage(){
		return totalDamage;
	}; 
	
	protected void setHealth(int h){
		health  = h;
	};
	
	protected void setDamage(int d){
		damage = d;
	};
	
	protected void setType(int ty){
		type = ty;
	};
	
	protected void setTarget(int ta){
		target = ta;
	};
	
	protected void getAttack(int dm){
		health-=dm;
	};
	
	protected void setTotalDamage(int td){
		totalDamage+=td;
	}; 
	
	protected boolean ifTarget(Troops t){
		if(target == all)
			return true;
		
		else if(target == t.type)
			return true;
		
		else 
			return false;
	}
}


