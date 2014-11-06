package javaAppletJessMonster;

import java.awt.Graphics;
import java.awt.Image;

public class JMDragon extends Monster {
	private Image pic;

	public JMDragon(JessMonster applet, Leader l) {
		super(applet, l);
		pic = applet.getImage(super.getURL(),"DragonResized.jpg");
		setHP(80);
		setEnergy(80);
		setPower(120);
		setSpirit(100);
		getAttackList().add(new AScratch(this));
		getAttackList().add(new AFireball(this));
		getAttackList().add(new ARest(this));
		getAttackList().add(new ARun(this));
	}
	String nameToString() {
		return "Dragon";
	}
	void paint(Graphics g, int x, int y, JessMonster applet) {
		super.paint(g, x, y, applet, pic);
	}
	public void passive() {
		setSpirit(getSpirit() + 5);
		applet.textbox.getArray().add(new TextUnit("Spirit + 5", lead));
	}
	void paintPassive(Graphics g, int x, int y, JessMonster applet) {
		g.setFont(nameFont);
		g.drawString("   " + nameToString() , x, y + 15);
		g.setFont(passiveFont);
		g.drawString("Magic Power:" , x, y + 30);
		g.setFont(normalFont);
		g.drawString("              + 5" , x, y + 50);
		g.drawImage(applet.getImage(getURL(),"spirit.jpg"), x + 20,y + 35, applet);
	}
}
