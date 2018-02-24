package BattleGame;

import java.util.LinkedList;
import java.util.ListIterator;

public class Game {
	
	private static int arm_number = 20;
	
	public static boolean game_over = false;
	public static boolean troop1_alive = true;
	public static boolean troop2_alive = true;
	
	public static int round_number = 0;
	
	public static void battle(LinkedList<Troops> t1, LinkedList<Troops> t2){

		ListIterator<Troops> listiterator1=t1.listIterator();
		ListIterator<Troops> listiterator2=t2.listIterator();
		
		while(!game_over){
			round_number++;
			System.out.print("Round "+round_number+": ");
			
			if(!listiterator1.hasNext())
				listiterator1 = t1.listIterator();
			
			if(!listiterator2.hasNext())
				listiterator2 = t2.listIterator();
			
			attack(listiterator1.next(),listiterator2.next());
			
			if(troop1_alive == false){
				listiterator1.remove();
				troop1_alive = true;
			}
			
			if(troop2_alive == false){
				listiterator2.remove();
				troop2_alive = true;
			}
			
			gameOver(t1,t2);
		}
		System.out.println("GAME OVER");
		
		
	}
	
	public static void attack(Troops t1, Troops t2){
		System.out.println("Player 1 " + t1.getTroopName() + " (health=" + t1.getHealth() + 
				", totalDamage=" + t1.getTotalDamage() + ") vs. Player 2 " + t2.getTroopName()
				+ " (health=" + t2.getHealth() + ", totalDamage=" + t2.getTotalDamage() + ")");
		int attackDamage;
		
		if(t1.ifTarget(t2))
			attackDamage = t1.getDamage();
		else 
			attackDamage = t1.getDamage() - t1.getDamage()/2;
		
		if(t2.getHealth()> attackDamage){
			t2.getAttack(attackDamage);
			t1.setTotalDamage(attackDamage);
		}
		else{
			t2.getAttack(t2.getHealth());
			t1.setTotalDamage(t2.getHealth());
			System.out.println("Player 2 " + t2.getTroopName() + " was killed");
			troop2_alive = false;
		}
		
		if(t2.ifTarget(t1))
			attackDamage = t2.getDamage();
		else 
			attackDamage = t2.getDamage() - t2.getDamage()/2;
		
		if(t1.getHealth()> attackDamage){
			t1.getAttack(attackDamage);
			t2.setTotalDamage(attackDamage);
		}
		else{
			t1.getAttack(t1.getHealth());
			t2.setTotalDamage(t1.getHealth());
			System.out.println("Player 1 " + t1.getTroopName() + " was killed");
			troop1_alive = false;
		}
			
			
	}
	
	public static void gameOver(LinkedList<Troops> t1, LinkedList<Troops> t2){
		if(t1.size()==0 || t2.size() == 0)
			game_over = true;
	}
	
	public static void setArm(TroopsFactory tf,LinkedList<Troops> a1, LinkedList<Troops> a2){
		for(int i = 0; i < arm_number/4; i++){
			a1.add(tf.createTroops("Monkey"));
			a1.add(tf.createTroops("FlyingMonkey"));
			a1.add(tf.createTroops("Wizard"));
			a1.add(tf.createTroops("Balloon"));

			a2.add(tf.createTroops("FlyingMonkey"));
			a2.add(tf.createTroops("Wizard"));
			a2.add(tf.createTroops("Balloon"));
			a2.add(tf.createTroops("Monkey"));
		}
	}
	
	public static void showArmList(LinkedList<Troops> t){
		int i = 0;
		for (Troops troo:t) {
			i++;
			System.out.println(i+ ". " + troo.getTroopName());
		}
	}
	
	public static int judgeWinner(LinkedList<Troops> t1, LinkedList<Troops> t2){
		if(t1.isEmpty())
			return 2;
		else
			return 1;
	}
	
	public static void showRemainingList(LinkedList<Troops> t){
		int i = 0;
		for (Troops troo:t) {
			i++;
			System.out.println(i+ ". " + troo.getTroopName() +", health=" + troo.getHealth() + 
					", totalDamage=" + troo.getTotalDamage());
		}
	}
	
	public static void showMostOutstandingTroop(LinkedList<Troops> t){
		int longestIndex = 0;
		int longest = 0;
		ListIterator<Troops> listiterator=t.listIterator();
		
		while(listiterator.hasNext()){
			int damage = listiterator.next().getTotalDamage();
			int count = 0;

			while (damage!=0){
		    
		        // This operation reduces length
		        // of every sequence of 1s by one.
				damage = (damage & (damage << 1));
		 
		        count++;
		    }
			
			if(count > longest){
				longest = count;
				longestIndex = listiterator.nextIndex();
			}
				
			
		}
		
		listiterator = t.listIterator();
		
		int i = 1;
		
		while(i<longestIndex){
			listiterator.next();
			i++;
		}
		Troops troo= listiterator.next();

		
		System.out.println(troo.getTroopName() +", health=" + troo.getHealth() + 
				", totalDamage=" + troo.getTotalDamage());
		
		
	}
	
	public static void main(String args[]){
		TroopsFactory factroy = new TroopsFactory();
		LinkedList<Troops> arm1 = new LinkedList<>();  
		LinkedList<Troops> arm2 = new LinkedList<>();  
		setArm(factroy, arm1, arm2);
		
		System.out.println("Army 1 - Initial Troops:");
		showArmList(arm1);
		System.out.println("");
		System.out.println("Army 2 - Initial Troops:");
		showArmList(arm2);
		System.out.println("");
		
		System.out.println("BATTLE");
		battle(arm1,arm2);
		System.out.println("");
		
		System.out.println("WINNER");
		int win = judgeWinner(arm1, arm2);
		System.out.println("Army " + win +" is the winner. Remaining troops:");
		
		LinkedList<Troops> winArm;
		
		if(win == 1)
			winArm = arm1;
			
		else
			winArm = arm2;
		
		showRemainingList(winArm);
		System.out.println("");
		
		System.out.println("The most Outstanding Troop is:");
		showMostOutstandingTroop(winArm);
		
	}

}
