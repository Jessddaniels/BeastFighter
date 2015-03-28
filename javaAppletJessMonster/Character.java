package javaAppletJessMonster;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;


public abstract class Character extends Monster {
	public DieSet dieSet = new DieSet(0,0,0,0,0,0);
	public int RollNum = 0;
	public int diceValue = 0;
	
	private ArrayList<String> diceList = new ArrayList<String>();
	public Character(JessMonster applet, Leader p) {
		super(applet, p);
		type = "character";
		diceValue = 5;
	}
	public void roll(int dice){
		if (RollNum < 3 && 6 - dieSet.totalDice() == dice && (RollNum == 0 || dice > 0)){
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
				g.drawImage(applet.getImage(Images.Health30), x +5+ i * 30,y + 420, applet);
			} else if (getDiceList().get(i).equals("Energy")){
				g.drawImage(applet.getImage(Images.Energy30), x+5+ i * 30,y + 420, applet);
			} else if (getDiceList().get(i).equals("Spirit")){
				g.drawImage(applet.getImage(Images.Spirit30), x+5+ i * 30,y + 420, applet);
			} else if (getDiceList().get(i).equals("Combat")){
				g.drawImage(applet.getImage(Images.Combat30), x+5+ i * 30,y +420, applet);
			} else if (getDiceList().get(i).equals("Experience")){
				g.drawImage(applet.getImage(Images.Experience30), x+5+ i * 30,y + 420, applet);
			} else if (getDiceList().get(i).equals("Damage")){
				g.drawImage(applet.getImage(Images.Damage30), x+5+ i * 30,y + 420, applet);
			} 
		}
	}
	public void removeDie(int position){
		String die = getDiceList().get(position);
		if (die.equals("Health")){
			dieSet.setHealthDice(dieSet.getHealthDice() - 1);
		} else if (die.equals("Energy")){
			dieSet.setEnergyDice(dieSet.getEnergyDice() - 1);
		} else if (die.equals("Spirit")){
			dieSet.setSpiritDice(dieSet.getSpiritDice() - 1);
		} else if (die.equals("Combat")){
			dieSet.setCombatDice(dieSet.getCombatDice() - 1);
		} else if (die.equals("Damage")){
			dieSet.setDamageDice(dieSet.getDamageDice() - 1);
		} else if (die.equals("Experience")){
			dieSet.setExperienceDice(dieSet.getExperienceDice() - 1);
		} 
		getDiceList().remove(position);
	}
	public void roll(){
		int rand = (int) (Math.random() * 6);
		if (rand == 0){
			dieSet.setHealthDice(dieSet.getHealthDice() + 1);
			getDiceList().add("Health");
		} else if (rand == 1){
			dieSet.setEnergyDice(dieSet.getEnergyDice()+ 1);
			getDiceList().add("Energy");
		}else if (rand == 2){
			dieSet.setSpiritDice(dieSet.getSpiritDice() + 1);
			getDiceList().add("Spirit");
		}else if (rand == 3){
			dieSet.setCombatDice(dieSet.getCombatDice() + 1);
			getDiceList().add("Combat");
		}else if (rand == 4){
			dieSet.setExperienceDice(dieSet.getExperienceDice() + 1);
			getDiceList().add("Experience");
		} else {
			dieSet.setDamageDice(dieSet.getDamageDice() + 1);
			getDiceList().add("Damage");
		}
	}
	public void resolveDice(){
		setHP(getHP() + diceValue * dieSet.getHealthDice());
		setEnergy(getEnergy() + diceValue * dieSet.getEnergyDice());
		setSpirit(getSpirit() + diceValue * dieSet.getSpiritDice());
		setCombat(getCombat() + diceValue * dieSet.getCombatDice());
		setDamage(getDamage() + diceValue * dieSet.getDamageDice());
		setExperience(getExperience() + diceValue * dieSet.getExperienceDice());
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
