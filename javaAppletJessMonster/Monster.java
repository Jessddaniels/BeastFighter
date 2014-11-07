package javaAppletJessMonster;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;

public abstract class Monster {
	private ArrayList<Attack> attackList = new ArrayList<Attack>();
	private URL url;
	private int hp;
	private int energy;
	private int power;
	private int spirit;
	public Leader lead;
	public Image pic;
	public Image goldFrame;
	public Image silverFrame;
	public Image attackPage;
	public Image statPage;
	public JessMonster applet;
	public Font normalFont;
	public Font nameFont = new Font("SansSerif", Font.BOLD, 20);
	public Font passiveFont = new Font("Serif", Font.BOLD, 15);
	public Monster(JessMonster applet, Leader p){
		this.lead = p;
		this.applet = applet;
		url = applet.url;
		goldFrame = applet.getImage(getURL(),"PictureFrameGold150Height.png");
		silverFrame = applet.getImage(getURL(),"PictureFrameSilver150Height.png");
		attackPage = applet.getImage(getURL(),"AttackPage.jpg");
		statPage = applet.getImage(getURL(),"StatPage.jpg");
		normalFont = applet.getFont();
	}
	abstract void paint(Graphics g, int x, int y, JessMonster applet);
	public void paint(Graphics g, int x, int y, JessMonster applet, Image pic){
		g.drawImage(pic, x, y, applet);
		if (applet.p1.getViewMon() == this || applet.p2.getViewMon() == this){
			g.drawImage(attackPage, x, y + 150, applet);
			paintPassive(g, x + 35, y + 150, applet);
			paintA1(g, x + 35, y + 220, applet);
			paintA2(g, x + 35, y + 290, applet);
			paintA3(g, x + 35, y + 360, applet);
			paintA4(g, x + 35, y + 430, applet);
			g.drawImage(statPage, x + 150, y, applet);
			g.drawString(""+getHP(), x + 205, y + 20  );
	    	g.drawString(""+getEnergy(), x + 205, y + 60);
	    	g.drawString(""+getPower(), x + 205, y + 100);
	    	g.drawString(""+getSpirit(), x + 205, y + 140);
			
		}
		if (applet.p1.getActiveMon() == this || applet.p2.getActiveMon() == this) {	
			g.drawImage(goldFrame, x, y, applet);
		} else {
			g.drawImage(silverFrame, x, y, applet);
		}
		
	}
	abstract String nameToString();
	abstract void passive();
	abstract void paintPassive(Graphics g, int x, int y, JessMonster applet);
	void attack1(Leader attacker, Leader defender) {
		getAttackList().get(0).attack(defender);
	}
	void attack2(Leader attacker, Leader defender) {
		getAttackList().get(1).attack(defender);
	}
	void attack3(Leader attacker, Leader defender) {
		getAttackList().get(2).attack(defender);
	}
	void attack4(Leader attacker, Leader defender) {
		getAttackList().get(3).attack(defender);
	}
	void paintA1(Graphics g, int x, int y, JessMonster applet) {
		getAttackList().get(0).paint(g, x, y, applet);
	}
	void paintA2(Graphics g, int x, int y, JessMonster applet) {
		getAttackList().get(1).paint(g, x, y, applet);
	}
	void paintA3(Graphics g, int x, int y, JessMonster applet) {
		getAttackList().get(2).paint(g, x, y, applet);
	}
	void paintA4(Graphics g, int x, int y, JessMonster applet) {
		getAttackList().get(3).paint(g, x, y, applet);
	}
	boolean reqA1(Leader attacker, Leader defender) {
		return getAttackList().get(0).isMet(defender);
	}
	boolean reqA2(Leader attacker, Leader defender) {
		return getAttackList().get(1).isMet(defender);
	}
	boolean reqA3(Leader attacker, Leader defender) {
		return getAttackList().get(2).isMet(defender);
	}
	boolean reqA4(Leader attacker, Leader defender) {
		return getAttackList().get(3).isMet(defender);
	}
	public URL getURL(){
		return url;
	}
	public int getHP(){
		return hp;	
	}
	public void setHP(int hp){
		this.hp = hp;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public ArrayList<Attack> getAttackList() {
		return attackList;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getSpirit() {
		return spirit;
	}
	public void setSpirit(int spirit) {
		this.spirit = spirit;
	}
}
