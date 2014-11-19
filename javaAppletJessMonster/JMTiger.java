package javaAppletJessMonster;

import java.awt.Graphics;
import java.awt.Image;

public class JMTiger extends Monster {
	private Image pic;

	public JMTiger(JessMonster applet, Leader l) {
		super(applet, l);
		pic = applet.getImage(super.getURL(),"Pictures/Tiger.jpg");
		setHP(80);
		setEnergy(120);
		setCombat(110);
		setSpirit(80);
		getAttackList().add(new AScratch(this));
		getAttackList().add(new ABite(this));
		getAttackList().add(new AAmbush(this));
	}
	public void paint(Graphics g, int x, int y, JessMonster applet){
		super.paint(g, x, y, applet, pic);
	}
	String nameToString() {
		return "Tiger";
	}
	void passive() {
		setEnergy(getEnergy() + 5);
		toTextBox("Energy + 5");
	}
	void paintPassive(Graphics g, int x, int y, JessMonster applet) {
		g.setFont(passiveFont);
		g.drawString("Energetic:" , x, y + 30);
		g.setFont(normalFont);
		g.drawString("              + 5" , x, y + 50);
		g.drawImage(applet.getImage(getURL(),"Pictures/Energy.jpg"), x + 20,y + 35, applet);
	}
}