package javaAppletJessMonster;

import java.awt.Graphics;
import java.awt.Image;

public class JMMountainLion extends Monster {
	private Image pic;

	public JMMountainLion(JessMonster applet, Leader l) {
		super(applet, l);
		pic = applet.getImage(super.getURL(),"Pictures/MountainLion.jpg");
		setHP(100);
		setEnergy(100);
		setSpirit(100);
		setCombat(100);
		getAttackList().add(new AScratch(this));
		getAttackList().add(new AAmbush(this));
		getAttackList().add(new ARest(this));
		getAttackList().add(new ARun(this));
	}
	public void paint(Graphics g, int x, int y, JessMonster applet){
		super.paint(g, x, y, applet, pic);
	}
	String nameToString() {
		return "Mountain Lion";
	}
	void passive() {
		setCombat(getCombat() + 5);
		applet.textbox.getArray().add(new TextUnit("Combat + 5", lead));
	}
	void paintPassive(Graphics g, int x, int y, JessMonster applet) {
		g.setFont(passiveFont);
		g.drawString("Ferocity:" , x, y + 30);
		g.setFont(normalFont);
		g.drawString("              + 5" , x, y + 50);
		g.drawImage(applet.getImage(getURL(),"Pictures/Combat.jpg"), x + 20,y + 35, applet);
	}
}