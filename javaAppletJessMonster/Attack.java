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
	
	public int getHDamage() {
		return hDamage;
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
	public void setHDamage(int damage) {
		this.hDamage = damage;
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
		int attackDamage = calcDDamage();
		mon.setDamage(0);
		return attackDamage;
	}
	public int calcHDamage(){
		return adj4Combat(getHDamage());
	}
	public int calcEnDamage(){
		return adj4Combat(getEnDamage());
	}
	public int calcCDamage(){
		return adj4Combat(getCDamage());
	}
	public int calcDDamage(){
		return adj4Combat(getDDamage());
	}
	public int calcSDamage(){
		return adj4Combat(getSDamage());
	}
	public int calcExDamage(){
		return adj4Combat(getExDamage());
	}
	
	//sends a string to be printed in the text box
	public int adj4Combat(int stat){
		return (int) (stat * ( 1 + (mon.getCombat() / 500.0)));
	}
	public void toTextBox(String words){
		mon.toTextBox(words);
	}
	public int getDDamage() {
		return dDamage;
	}
	public void setDDamage(int dDamage) {
		this.dDamage = dDamage;
	}
	public int getHGain() {
		return hGain;
	}
	public void setHGain(int hGain) {
		this.hGain = hGain;
	}
	public int getDGain() {
		return dGain;
	}
	public void setDGain(int dGain) {
		this.dGain = dGain;
	}
	public int getCGain() {
		return cGain;
	}
	public void setCGain(int cGain) {
		this.cGain = cGain;
	}
	public int getSGain() {
		return sGain;
	}
	public void setSGain(int sGain) {
		this.sGain = sGain;
	}
	public int getEnGain() {
		return enGain;
	}
	public void setEnGain(int enGain) {
		this.enGain = enGain;
	}
	public int getExGain() {
		return exGain;
	}
	public void setExGain(int exGain) {
		this.exGain = exGain;
	}
}
