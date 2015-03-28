package javaAppletJessMonster;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;

public abstract class Monster {
	private ArrayList<Attack> attackList = new ArrayList<Attack>();
	private ArrayList<Status> statusList = new ArrayList<Status>();
	private URL url;
	public String type = "monster";
	private int hp;
	private int maxHealth;
	private int energy;
	private int combat;
	private int spirit;
	private int experience;
	private int damage;
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
	public Font nameFont = new Font("SansSerif", Font.BOLD, 18);
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
		normalFont = applet.getFont();
	}
	abstract void paint(Graphics g, int x, int y, JessMonster applet);
	public void paint(Graphics g, int x, int y, JessMonster applet, Image pic){
		Leader p1 = applet.match.p1;
		Leader p2 = applet.match.p2;
		
		if (p1.getViewMon() == this || p2.getViewMon() == this){
			g.drawImage(attackPage, x, y, applet);
			g.setFont(nameFont);
			g.drawString("     " + nameToString(), x - 10, y + 25);
			g.setFont(normalFont);
			paintPassive(g, x + 35, y + 150, applet);
			paintA1(g, x + 5, y + 210, applet);
			paintA2(g, x + 5, y + 280, applet);
			paintA3(g, x + 5, y + 350, applet);
			g.drawString(""+getHP() + "/" + getMaxHealth(), x + 195, y + 50  );
	    	g.drawString(""+getEnergy(), x + 195, y + 70);
	    	g.drawString(""+getCombat(), x + 195, y + 90);
	    	g.drawString(""+getSpirit(), x + 195, y + 110);
	    	g.drawString(""+getDamage(), x + 195, y + 130);
	    	g.drawString(""+getExperience(), x + 195, y + 150);
	    	g.drawImage(pic, x + 20, y + 35, applet);
	    	g.drawImage(applet.getImage(Images.Health20), x + 175, y + 35, applet);
	    	g.drawImage(applet.getImage(Images.Energy20), x + 175, y + 55, applet);
	    	g.drawImage(applet.getImage(Images.Combat20), x + 175, y + 75, applet);
	    	g.drawImage(applet.getImage(Images.Spirit20), x + 175, y + 95, applet);
	    	g.drawImage(applet.getImage(Images.Damage20), x + 175, y + 115, applet);
	    	g.drawImage(applet.getImage(Images.Experience20), x + 175, y + 135, applet);
	    	g.drawImage(applet.getImage(Images.Runner), x + 210, y + 455, applet);
	    	g.drawImage(applet.getImage(Images.RestButton), x + 20, y + 455, applet);
	    	for (int i = 0; i < statusList.size(); i++){
	    		statusList.get(i).paint(g,x,y, i, applet);
	    	}
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
	public ArrayList<Status> getStatusList() {
		return statusList;
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
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
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
	public int getMaxHealth() {
		return maxHealth;
	}
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
}
