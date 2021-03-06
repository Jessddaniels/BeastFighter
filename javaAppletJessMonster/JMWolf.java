package javaAppletJessMonster;

import java.awt.Graphics;
import java.awt.Image;

public class JMWolf extends Monster {
	private Image pic;

	public JMWolf(JessMonster applet, Leader l) {
		super(applet, l);
		pic = applet.getImage(super.getURL(),"Pictures/Wolf.jpg");
		setHP(100);
		setEnergy(100);
		setSpirit(100);
		setCombat(100);
		getAttackList().add(new ABite(this));
		getAttackList().add(new ATakeDown(this));
		getAttackList().add(new APackInstincts(this));
	}
	public void paint(Graphics g, int x, int y, JessMonster applet){
		super.paint(g, x, y, applet, pic);
	}
	String nameToString() {
		return "Wolf";
	}
	void passive() {
		setSpirit(getSpirit() + 5);
		toTextBox("Spirit + 5");
	}
	void paintPassive(Graphics g, int x, int y, JessMonster applet) {
		g.setFont(passiveFont);
		g.drawString("The Hunt:" , x, y + 30);
		g.setFont(normalFont);
		g.drawString("              + 5" , x, y + 50);
		g.drawImage(applet.getImage(getURL(),"Pictures/Spirit.jpg"), x + 20,y + 35, applet);
	}
}