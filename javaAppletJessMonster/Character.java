package javaAppletJessMonster;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;


public abstract class Character extends Monster {
	public int HDice = 0;
	public int EnDice = 0;
	public int SDice = 0;
	public int CDice = 0;
	public int ExDice = 0;
	public int KDice = 0;
	public int RollNum = 0;
	private ArrayList<String> diceList = new ArrayList<String>();
	public Character(JessMonster applet, Leader p) {
		super(applet, p);
		type = "character";
	}
	public void roll(int dice){
		if (RollNum < 3){
			for (int i = 0; i < dice; i++){
				roll();
			}
			RollNum++;
		}
	}
	public void paint(Graphics g, int x, int y, JessMonster applet, Image pic){
		super.paint(g, x, y, applet, pic);
		g.drawImage(applet.getImage(getURL(),"Pictures/Die.jpg"), x + 120,y + 455, applet);
		for (int i = 0; i < getDiceList().size(); i++){
			if (getDiceList().get(i).equals("Health")){
				g.drawImage(applet.getImage(getURL(),"Pictures/Health.jpg"), x + 200,y + 200 + 40 * i, applet);
			} else if (getDiceList().get(i).equals("Energy")){
				g.drawImage(applet.getImage(getURL(),"Pictures/Energy.jpg"), x + 200,y + 200 + 40 * i, applet);
			} else if (getDiceList().get(i).equals("Spirit")){
				g.drawImage(applet.getImage(getURL(),"Pictures/Spirit.jpg"), x + 200,y + 200 + 40 * i, applet);
			} else if (getDiceList().get(i).equals("Combat")){
				g.drawImage(applet.getImage(getURL(),"Pictures/Combat.jpg"), x + 200,y + 200 + 40 * i, applet);
			} else if (getDiceList().get(i).equals("Experience")){
				g.drawImage(applet.getImage(getURL(),"Pictures/Experience.jpg"), x + 200,y + 200 + 40 * i, applet);
			} else if (getDiceList().get(i).equals("Knowledge")){
				g.drawImage(applet.getImage(getURL(),"Pictures/Knowledge.jpg"), x + 200,y + 200 + 40 * i, applet);
			} 
		}
	}
	public void removeDie(int position){
		String die = getDiceList().get(position);
		if (die.equals("Health")){
			HDice--;
		} else if (die.equals("Energy")){
			EnDice--;
		} else if (die.equals("Spirit")){
			SDice--;
		} else if (die.equals("Combat")){
			CDice--;
		} else if (die.equals("Knowledge")){
			KDice--;
		} else if (die.equals("Experience")){
			ExDice--;
		} 
		getDiceList().remove(position);
	}
	public void roll(){
		int rand = (int) (Math.random() * 5);
		if (rand == 0){
			HDice++;
			getDiceList().add("Health");
		} else if (rand == 1){
			EnDice++;
			getDiceList().add("Energy");
		}else if (rand == 2){
			SDice++;
			getDiceList().add("Spirit");
		}else if (rand == 3){
			CDice++;
			getDiceList().add("Combat");
		}else if (rand == 4){
			ExDice++;
			getDiceList().add("Experience");
		} else {
			KDice++;
			getDiceList().add("Knowledge");
		}
	}
	public ArrayList<String> getDiceList() {
		return diceList;
	}
	public void setDiceList(ArrayList<String> diceList) {
		this.diceList = diceList;
	}

}
