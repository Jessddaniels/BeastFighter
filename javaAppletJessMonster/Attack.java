package javaAppletJessMonster;

import java.awt.Font;
import java.awt.Graphics;

public abstract class Attack {
	public Monster mon;
	private int damage;
	private int enDamage;
	private int cDamage;
	private int sDamage;
	private int exDamage;
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
	public int getDamage() {
		return damage;
	}
	public int getEnDamage() {
		return enDamage;
	}
	public int getCDamage() {
		return cDamage;
	}
	public int getSDamage() {
		return sDamage;
	}
	public int getExDamage() {
		return exDamage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public void setEnDamage(int damage) {
		this.enDamage = damage;
	}
	public void setCDamage(int damage) {
		this.cDamage = damage;
	}
	public void setSDamage(int damage) {
		this.sDamage = damage;
	}
	public void setExDamage(int damage) {
		this.exDamage = damage;
	}
	public int applyDamage(){
		int attackDamage = calcDamage();
		mon.setDamage(0);
		return attackDamage;
	}
	public int calcDamage(){
		return (int) (mon.getDamage() + getDamage() * ( 1 + (mon.getCombat() / 500.0)));
	}
	public int calcEnDamage(){
		return (int) (getEnDamage() * ( 1 + (mon.getCombat() / 500.0)));
	}
	public int calcCDamage(){
		return (int) (getCDamage() * ( 1 + (mon.getCombat() / 500.0)));
	}
	public int calcSDamage(){
		return (int) (getSDamage() * ( 1 + (mon.getCombat() / 500.0)));
	}
	public int calcExDamage(){
		return (int) (getExDamage() * ( 1 + (mon.getCombat() / 500.0)));
	}
	
	//sends a string to be printed in the text box
	public void toTextBox(String words){
		mon.toTextBox(words);
	}
}
