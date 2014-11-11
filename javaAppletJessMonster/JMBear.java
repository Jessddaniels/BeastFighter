package javaAppletJessMonster;

import java.awt.Graphics;
import java.awt.Image;

public class JMBear extends Monster {
	private Image pic;

	public JMBear(JessMonster applet, Leader l) {
		super(applet, l);
		pic = applet.getImage(super.getURL(),"Pictures/Bear.jpg");
		setHP(140);
		setEnergy(60);
		setPower(110);
		setSpirit(80);
		getAttackList().add(new AScratch(this));
		getAttackList().add(new ABodySlam(this));
		getAttackList().add(new AHybernate(this));
		getAttackList().add(new ARun(this));
	}
	String nameToString() {
		return "Bear";
	}
	void paint(Graphics g, int x, int y, JessMonster applet) {
		super.paint(g, x, y, applet, pic);
	}
	void passive() {
		setHP(getHP() + 5);
		applet.textbox.getArray().add(new TextUnit("HP + 5", lead));
	}
	void paintPassive(Graphics g, int x, int y, JessMonster applet) {
		g.setFont(passiveFont);
		g.drawString("Sleepful:" , x, y + 30);
		g.setFont(normalFont);
		g.drawString("              + 5" , x, y + 50);
		g.drawImage(applet.getImage(getURL(),"Pictures/Health.jpg"), x + 20,y + 35, applet);
	}
}
