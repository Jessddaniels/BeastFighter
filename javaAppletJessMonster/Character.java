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
	public int DDice = 0;
	public int RollNum = 0;
	public int diceValue = 0;
	
	private ArrayList<String> diceList = new ArrayList<String>();
	public Character(JessMonster applet, Leader p) {
		super(applet, p);
		type = "character";
		diceValue = 5;
	}
	public void roll(int dice){
		if (RollNum < 3 && 6 - HDice - EnDice - SDice - CDice - ExDice - DDice == dice && (RollNum == 0 || dice > 0)){
			for (int i = 0; i < dice; i++){
				roll();
			}
			RollNum++;
		} else if ( RollNum < 4){
			resolveDice();
			RollNum = 4;
		}
	}
	public void paint(Graphics g, int x, int y, JessMonster applet, Image pic){
		super.paint(g, x, y, applet, pic);
		g.drawImage(applet.getImage(getURL(),"Pictures/Die.jpg"), x + 120,y + 455, applet);
		for (int i = 0; i < getDiceList().size(); i++){
			if (getDiceList().get(i).equals("Health")){
				g.drawImage(applet.getImage(getURL(),"Pictures/Health.jpg"), x + 20 + i * 40,y + 430, applet);
			} else if (getDiceList().get(i).equals("Energy")){
				g.drawImage(applet.getImage(getURL(),"Pictures/Energy.jpg"), x+ 20+ i * 40,y + 430, applet);
			} else if (getDiceList().get(i).equals("Spirit")){
				g.drawImage(applet.getImage(getURL(),"Pictures/Spirit.jpg"), x + 20+ i * 40,y + 430, applet);
			} else if (getDiceList().get(i).equals("Combat")){
				g.drawImage(applet.getImage(getURL(),"Pictures/Combat.jpg"), x+ 20+ i * 40,y +430, applet);
			} else if (getDiceList().get(i).equals("Experience")){
				g.drawImage(applet.getImage(getURL(),"Pictures/Experience.jpg"), x + 20+ i * 40,y + 430, applet);
			} else if (getDiceList().get(i).equals("Damage")){
				g.drawImage(applet.getImage(getURL(),"Pictures/Damage.jpg"), x + 20+ i * 40,y + 430, applet);
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
		} else if (die.equals("Damage")){
			DDice--;
		} else if (die.equals("Experience")){
			ExDice--;
		} 
		getDiceList().remove(position);
	}
	public void roll(){
		int rand = (int) (Math.random() * 6);
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
			DDice++;
			getDiceList().add("Damage");
		}
	}
	public void resolveDice(){
		setHP(getHP() + diceValue * HDice);
		setEnergy(getEnergy() + diceValue * EnDice);
		setSpirit(getSpirit() + diceValue * SDice);
		setCombat(getCombat() + diceValue * CDice);
		setDamage(getDamage() + diceValue * DDice);
		setExperience(getExperience() + diceValue * ExDice);
	}
	public ArrayList<String> getDiceList() {
		return diceList;
	}
	public void setDiceList(ArrayList<String> diceList) {
		this.diceList = diceList;
	}
	public void run(){
		diceList.clear();
		setEnergy(getEnergy() - 20);
		lead.tradeOK = true;
		lead.myTurn = true;
		toTextBox(nameToString() + " Switched");
	}

}
