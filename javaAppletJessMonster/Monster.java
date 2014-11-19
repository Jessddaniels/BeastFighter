package javaAppletJessMonster;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;

public abstract class Monster {
	private ArrayList<Attack> attackList = new ArrayList<Attack>();
	private URL url;
	public String type = "monster";
	private int hp;
	private int energy;
	private int combat;
	private int spirit;
	private int experience;
	private int knowledge;
	public Image runner;
	public Leader lead;
	public Image pic;
	public Image goldFrame;
	public Image silverFrame;
	public Image attackPage;
	public Image statPage;
	public JessMonster applet;
	public Match match;
	public Font normalFont;
	public Font nameFont = new Font("SansSerif", Font.BOLD, 20);
	public Font passiveFont = new Font("Serif", Font.BOLD, 15);
	public Monster(JessMonster applet, Leader p){
		lead = p;
		this.applet = applet;
		match = applet.match;
		url = applet.url;
		goldFrame = applet.getImage(getURL(),"Pictures/FrameActive.png");
		silverFrame = applet.getImage(getURL(),"Pictures/FrameInactive.png");
		attackPage = applet.getImage(getURL(),"Pictures/AttackPage.jpg");
		statPage = applet.getImage(getURL(),"Pictures/StatPage.jpg");
		runner = applet.getImage(getURL(),"Pictures/Runner.jpg");
		normalFont = applet.getFont();
	}
	abstract void paint(Graphics g, int x, int y, JessMonster applet);
	public void paint(Graphics g, int x, int y, JessMonster applet, Image pic){
		Leader p1 = applet.match.p1;
		Leader p2 = applet.match.p2;
		
		if (p1.getViewMon() == this || p2.getViewMon() == this){
			g.drawImage(attackPage, x, y, applet);
			g.setFont(nameFont);
			g.drawString("     " + nameToString(), x + 5, y + 25);
			g.setFont(normalFont);
			paintPassive(g, x + 35, y + 150, applet);
			paintA1(g, x + 5, y + 210, applet);
			paintA2(g, x + 5, y + 280, applet);
			paintA3(g, x + 5, y + 350, applet);
			g.drawString(""+getHP(), x + 205, y + 50  );
	    	g.drawString(""+getEnergy(), x + 205, y + 70);
	    	g.drawString(""+getCombat(), x + 205, y + 90);
	    	g.drawString(""+getSpirit(), x + 205, y + 110);
	    	g.drawString(""+getKnowledge(), x + 205, y + 130);
	    	g.drawString(""+getExperience(), x + 205, y + 150);
	    	g.drawImage(pic, x + 20, y + 35, applet);
	    	g.drawImage(applet.getImage(getURL(),"Pictures/Health.jpg"), x + 175, y + 35, applet);
	    	g.drawImage(applet.getImage(getURL(),"Pictures/Energy.jpg"), x + 175, y + 55, applet);
	    	g.drawImage(applet.getImage(getURL(),"Pictures/Combat.jpg"), x + 175, y + 75, applet);
	    	g.drawImage(applet.getImage(getURL(),"Pictures/Spirit.jpg"), x + 175, y + 95, applet);
	    	g.drawImage(applet.getImage(getURL(),"Pictures/Knowledge.jpg"), x + 175, y + 115, applet);
	    	g.drawImage(applet.getImage(getURL(),"Pictures/Experience.jpg"), x + 175, y + 135, applet);
	    	g.drawImage(applet.getImage(getURL(),"Pictures/Runner.jpg"), x + 210, y + 455, applet);
	    	g.drawImage(applet.getImage(getURL(),"Pictures/RestButton.jpg"), x + 20, y + 455, applet);
			if (p1.getActiveMon() == this || p2.getActiveMon() == this) {	
				g.drawImage(goldFrame, x+ 20, y+ 35, applet);
			} else {
				g.drawImage(silverFrame, x+ 20, y+ 35, applet);
			}
		} else {
			g.drawImage(pic, x, y, applet);
			if (p1.getActiveMon() == this || p2.getActiveMon() == this) {	
				g.drawImage(goldFrame, x, y, applet);
			} else {
				g.drawImage(silverFrame, x, y, applet);
			}
		}
	}
	abstract String nameToString();
	abstract void passive();
	abstract void paintPassive(Graphics g, int x, int y, JessMonster applet);
	void attack1(Leader attacker, Leader defender) {
		getAttackList().get(getAttackList().size() -1).attack(defender);
	}
	void attack2(Leader attacker, Leader defender) {
		getAttackList().get(getAttackList().size() -2).attack(defender);
	}
	void attack3(Leader attacker, Leader defender) {
		getAttackList().get(getAttackList().size() -3).attack(defender);
	}
	void paintA1(Graphics g, int x, int y, JessMonster applet) {
		getAttackList().get(getAttackList().size() -1).paint(g, x, y, applet);
	}
	void paintA2(Graphics g, int x, int y, JessMonster applet) {
		getAttackList().get(getAttackList().size() -2).paint(g, x, y, applet);
	}
	void paintA3(Graphics g, int x, int y, JessMonster applet) {
		getAttackList().get(getAttackList().size() -3).paint(g, x, y, applet);
	}
	boolean reqA1(Leader attacker, Leader defender) {
		return getAttackList().get(getAttackList().size() -1).isMet(defender);
	}
	boolean reqA2(Leader attacker, Leader defender) {
		return getAttackList().get(getAttackList().size() -2).isMet(defender);
	}
	boolean reqA3(Leader attacker, Leader defender) {
		return getAttackList().get(getAttackList().size() -3).isMet(defender);
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
	public int getCombat() {
		return combat;
	}
	public void setCombat(int combat) {
		this.combat = combat;
	}
	public int getSpirit() {
		return spirit;
	}
	public void setSpirit(int spirit) {
		this.spirit = spirit;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getKnowledge() {
		return knowledge;
	}
	public void setKnowledge(int knowledge) {
		this.knowledge = knowledge;
	}
	public void rest(){
		setEnergy(getEnergy() + 20);
		toTextBox(nameToString() + " Rested");
	}
	public void run(){
		setEnergy(getEnergy() - 20);
		lead.tradeOK = true;
		lead.myTurn = true;
		toTextBox(nameToString() + " Switched");
	}
	//sends a string to be printed in the text box
	public void toTextBox(String words){
		match.textbox.toTextBox(words, lead);
	}
}
