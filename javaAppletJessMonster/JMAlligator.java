package javaAppletJessMonster;

import java.awt.Graphics;
import java.awt.Image;

public class JMAlligator extends Monster {
	private Image pic;
	
	public JMAlligator(JessMonster applet, Leader l) {
		super(applet, l);
		pic = applet.getImage(super.getURL(),"AlligatorResized.jpg");
		setHP(80);
		setEnergy(80);
		setPower(120);
		setSpirit(100);
		getAttackList().add(new ABite(this));
		getAttackList().add(new ADeathRoll(this));
		getAttackList().add(new ARest(this));
		getAttackList().add(new ARun(this));
	}
	String nameToString() {
		return "Alligator";
	}
	void paint(Graphics g, int x, int y, JessMonster applet) {
		super.paint(g, x, y, applet, pic);
	}
	void passive() {
		setSpirit(getHP() / 5 + getSpirit());
		applet.textbox.getArray().add(new TextUnit("Spirit +" + getHP() / 5, lead) );
	}
	void paintPassive(Graphics g, int x, int y, JessMonster applet) {
		g.setFont(nameFont);
		g.drawString("   " + nameToString() , x, y + 15);
		g.setFont(passiveFont);
		g.drawString("Sneaky Gator:" , x, y + 30);
		g.setFont(normalFont);
		g.drawString("     add 1/5        ("+ getHP() / 5+") to    " , x, y + 50);
		g.drawImage(applet.getImage(getURL(),"health.jpg"), x + 60,y + 35, applet);
		g.drawImage(applet.getImage(getURL(),"spirit.jpg"), x + 120,y + 35, applet);
	}
}
