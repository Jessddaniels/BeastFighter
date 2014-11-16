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
		getAttackList().add(new ASwordStrike(this));
		getAttackList().add(new AHeadbutt(this));
		getAttackList().add(new ARest(this));
	}
	public void paint(Graphics g, int x, int y, JessMonster applet){
		super.paint(g, x, y, applet, pic);
	}
	String nameToString() {
		return "Soldier";
	}
	void passive() {
		setEnergy(getEnergy() + 5);
		applet.textbox.getArray().add(new TextUnit("Energy + 5", lead));
	}
	void paintPassive(Graphics g, int x, int y, JessMonster applet) {
		g.setFont(passiveFont);
		g.drawString("Energetic:" , x, y + 30);
		g.setFont(normalFont);
		g.drawString("              + 5" , x, y + 50);
		g.drawImage(applet.getImage(getURL(),"Pictures/Energy.jpg"), x + 20,y + 35, applet);
		g.drawImage(applet.getImage(getURL(),"Pictures/Energy.jpg"), x + 20,y + 35, applet);
		g.drawImage(applet.getImage(getURL(),"Pictures/Energy.jpg"), x + 20,y + 35, applet);
	}
}