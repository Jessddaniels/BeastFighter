package javaAppletJessMonster;

import java.awt.Font;
import java.awt.Graphics;

public abstract class Attack {
	public Monster mon;
	private int damage;
	private int kDamage;
	public Font normalFont;
	public Font nameFont = new Font("Serif", Font.BOLD, 16);
	public Font reqFont = new Font("Serif", Font.ITALIC, 12);
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
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int calcDamage(){
		return (int) (getDamage() * ( mon.getCombat() / 100.0));
	}
	public int calcKDamage(){
		return (int) (getKDamage() * ( mon.getKnowledge() / 100.0));
	}
	public int getKDamage() {
		return kDamage;
	}
	public void setKDamage(int kDamage) {
		this.kDamage = kDamage;
	}
	//sends a string to be printed in the text box
	public void toTextBox(String words){
		mon.toTextBox(words);
	}
}
