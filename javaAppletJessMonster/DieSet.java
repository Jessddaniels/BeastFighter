package javaAppletJessMonster;

public class DieSet {
	private int healthDice;
	private int energyDice;
	private int combatDice;
	private int spiritDice;
	private int damageDice;
	private int experienceDice;
	public DieSet(int h, int en, int c, int s, int d, int ex){
		setHealthDice(h);
		setEnergyDice(en);
		setCombatDice(c);
		setSpiritDice(s);
		setDamageDice(d);
		setExperienceDice(ex);
	}
	public DieSet(){
		
	}
	public void clearDice(){
		healthDice = 0;
		energyDice = 0;
		combatDice = 0;
		spiritDice = 0;
		damageDice = 0;
		experienceDice = 0;
	}
	public boolean reqMet(DieSet dice){
		if (healthDice > dice.getHealthDice()){
			return false;
		}
		if (energyDice > dice.getEnergyDice()){
			return false;
		}
		if (combatDice > dice.getCombatDice()){
			return false;
		}
		if (spiritDice > dice.getSpiritDice()){
			return false;
		}
		if (damageDice > dice.getDamageDice()){
			return false;
		}
		if (experienceDice > dice.getExperienceDice()){
			return false;
		}
		return true;
	}
	public int totalDice(){
		return healthDice + energyDice + combatDice + spiritDice + damageDice + experienceDice;
	}
	public int getSpiritDice() {
		return spiritDice;
	}
	public void setSpiritDice(int spiritDice) {
		this.spiritDice = spiritDice;
	}
	public int getHealthDice() {
		return healthDice;
	}
	public void setHealthDice(int healthDice) {
		this.healthDice = healthDice;
	}
	public int getEnergyDice() {
		return energyDice;
	}
	public void setEnergyDice(int energyDice) {
		this.energyDice = energyDice;
	}
	public int getCombatDice() {
		return combatDice;
	}
	public void setCombatDice(int combatDice) {
		this.combatDice = combatDice;
	}
	public int getDamageDice() {
		return damageDice;
	}
	public void setDamageDice(int damageDice) {
		this.damageDice = damageDice;
	}
	public int getExperienceDice() {
		return experienceDice;
	}
	public void setExperienceDice(int experienceDice) {
		this.experienceDice = experienceDice;
	}
}
