package javaAppletJessMonster;

import java.awt.Graphics;
import java.awt.Image;

public class CSoldier extends Character {
	private Image pic;

	public CSoldier(JessMonster applet, Leader l) {
		super(applet, l);
		pic = applet.getImage(super.getURL(),"Pictures/Soldier.jpg");
		setHP(100);
		setEnergy(100);
		setSpirit(100);
		setCombat(100);
		setKnowledge(80);
		getAttackList().add(new ANull(this));
		getAttackList().add(new ANull(this));
		getAttackList().add(new ASwordStrike(this));
	}
	public void paint(Graphics g, int x, int y, JessMonster applet){
		super.paint(g, x, y, applet, pic);
	}
	String nameToString() {
		return "Soldier";
	}
	void passive() {
		if (getAttackList().size() < 4 && getExperience() >= 100){
			getAttackList().add(new ABash(this));
			toTextBox("Level 2");
		}
	}
	void paintPassive(Graphics g, int x, int y, JessMonster applet) {
		g.setFont(passiveFont);
		g.setFont(normalFont);
	}
}