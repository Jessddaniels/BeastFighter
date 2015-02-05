package javaAppletJessMonster;

import java.awt.Font;
import java.awt.Graphics;

public abstract class Attack {
	public Monster mon;
	//die stat dmg
	private int hDamage;
	private int dDamage;
	private int enDamage;
	private int cDamage;
	private int sDamage;
	private int exDamage;
	//die max stat dmg
	private int maxHDamage;
	//die stat gains
	private int hGain;
	private int dGain;
	private int enGain;
	private int cGain;
	private int sGain;
	private int exGain;
	//fonts
	public Font normalFont;
	public Font nameFont = new Font("Serif", Font.BOLD, 16);
	public Font reqFont = new Font("Serif", Font.ITALIC, 12);
	public Font smallFont = new Font("SansSerif",Font.PLAIN, 10);
	
	public Attack(Monster mon){
		this.mon = mon;
		normalFont = mon.applet.getFont();
	}
	
	abstract void attack(Leader defender);
	abstract boolean isMet(Leader defender);
	abstract void paint(Graphics g, int x, int y, JessMonster applet);
	
	//adjusts values with the combat stat.
	public int adj4Combat(int stat){
		return (int) (stat * ( 1 + (mon.getCombat() / 500.0)));
	}
	//applies damage stat to hDamage for final attack. Consumes Damage dice. Used within hAttack()
	public int applyDamage(){
		int attackDamage = mon.getDamage();
		mon.setDamage(0);
		attackDamage += calcHDamage();
		return attackDamage;
	}
	
	//sends a string to be printed in the text box
	public void toTextBox(String words){
		mon.toTextBox(words);
	}
	
	//calculate combat adjusted attack values
	
	public int calcCDamage(){
		return adj4Combat(getCDamage());
	}
	public int calcDDamage(){
		return adj4Combat(getDDamage());
	}
	public int calcEnDamage(){
		return adj4Combat(getEnDamage());
	}
	public int calcExDamage(){
		return adj4Combat(getExDamage());
	}
	public int calcHDamage(){
		return adj4Combat(getHDamage());
	}
	public int calcSDamage(){
		return adj4Combat(getSDamage());
	}
	//calculate combat adjusted attack values for max attacks
	public int calcMaxHDamage(){
		return adj4Combat(getMaxHDamage());
	}
	//gaining stats
	public void cGain(){
		mon.setCombat(mon.getCombat() + getCGain());
	}
	public void dGain(){
		mon.setDamage(mon.getCombat() + getDGain());
	}
	public void enGain(){
		mon.setEnergy(mon.getEnergy() + getEnGain());
	}
	public void exGain(){
		mon.setExperience(mon.getExperience() + getExGain());
	}
	public void hGain(){
		mon.setHP(mon.getHP() + getHGain());
	}
	public void sGain(){
		mon.setSpirit(mon.getSpirit() + getSGain());
	}
	//damaging stats
	public void cAttack( Leader defender) {
		int currentC = defender.getActiveMon().getCombat();
		defender.getActiveMon().setCombat(currentC - calcCDamage());
	}
	public void dAttack( Leader defender) {
		int currentD = defender.getActiveMon().getDamage();
		defender.getActiveMon().setDamage(currentD - calcDDamage());
	}
	public void enAttack( Leader defender) {
		int currentEn = defender.getActiveMon().getEnergy();
		defender.getActiveMon().setEnergy(currentEn - calcEnDamage());
	}
	public void exAttack( Leader defender) {
		int currentEx = defender.getActiveMon().getExperience();
		defender.getActiveMon().setExperience(currentEx - calcExDamage());
	}
	public void hAttack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - applyDamage());
	}
	public void sAttack( Leader defender) {
		int currentS = defender.getActiveMon().getSpirit();
		defender.getActiveMon().setSpirit(currentS - calcSDamage());
	}
	//damaging max stats
	public void maxHAttack( Leader defender) {
		int currentmaxHP = defender.getActiveMon().getMaxHealth();
		defender.getActiveMon().setMaxHealth(currentmaxHP - calcMaxHDamage());
	}
	
	//GETTERS
	
	//return attack damage values
	public int getCDamage() {
		return cDamage;
	}
	public int getDDamage() {
		return dDamage;
	}
	public int getEnDamage() {
		return enDamage;
	}
	public int getExDamage() {
		return exDamage;
	}
	public int getHDamage() {
		return hDamage;
	}
	public int getSDamage() {
		return sDamage;
	}
	//return attaxk damage values for max attacks
	public int getMaxHDamage(){
		return maxHDamage;
	}
	//return attack gain values
	
	public int getCGain() {
		return cGain;
	}
	public int getDGain() {
		return dGain;
	}
	public int getEnGain() {
		return enGain;
	}
	public int getExGain() {
		return exGain;
	}
	public int getHGain() {
		return hGain;
	}
	public int getSGain() {
		return sGain;
	}
	
	//SETTERS
	
	//set attack damage stats
	public void setCDamage(int damage) {
		this.cDamage = damage;
	}
	public void setDDamage(int damage){
		this.dDamage = damage;
	}
	public void setEnDamage(int damage) {
		this.enDamage = damage;
	}
	public void setExDamage(int damage) {
		this.exDamage = damage;
	}
	public void setHDamage(int damage) {
		this.hDamage = damage;
	}
	public void setSDamage(int damage) {
		this.sDamage = damage;
	}
	//set attack damage stats for max values
	public void setMaxHDamage(int damage){
		this.maxHDamage = damage;
	}
	//set attack gain stats
	public void setCGain(int cGain) {
		this.cGain = cGain;
	}
	public void setDGain(int dGain) {
		this.dGain = dGain;
	}
	public void setHGain(int hGain) {
		this.hGain = hGain;
	}
	public void setEnGain(int enGain) {
		this.enGain = enGain;
	}
	public void setExGain(int exGain) {
		this.exGain = exGain;
	}
	public void setSGain(int sGain) {
		this.sGain = sGain;
	}
}
