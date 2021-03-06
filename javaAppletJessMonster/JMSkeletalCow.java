package javaAppletJessMonster;

import java.awt.Graphics;
import java.awt.Image;

public class JMSkeletalCow extends Monster {
	private Image pic;
	public JMSkeletalCow(JessMonster applet, Leader l) {
		super(applet, l);
		pic = applet.getImage(super.getURL(),"Pictures/SkeletalCow.jpg");
		setHP(80);
		setEnergy(140);
		setCombat(90);
		setSpirit(100);
		getAttackList().add(new AHeadbutt(this));
		getAttackList().add(new ARestInPeace(this));
		getAttackList().add(new ASpiritSink(this));
	}
	String nameToString() {
		return "Skeletal Cow";
	}
	void paint(Graphics g, int x, int y, JessMonster applet) {
		super.paint(g, x, y, applet, pic);
	}
	void passive() {
		if (getHP() < 80){
			if (getSpirit() > 80 - getHP()){
				setSpirit(getSpirit() - 80 + getHP());
				setHP(80);
			} else {
				setHP(getHP() + getSpirit());
				setSpirit(0);
			}
			toTextBox("Spirit Linked");
		}
	}
	void paintPassive(Graphics g, int x, int y, JessMonster applet) {
		g.setFont(passiveFont);
		g.drawString("Spirit Link:" , x, y + 30);
		g.setFont(normalFont);
		g.drawString("        < 80" , x + 80, y + 30);
		g.drawString("convert          to" , x, y + 50);
		g.drawImage(applet.getImage(getURL(),"Pictures/Health.jpg"), x + 80,y + 17, applet);
		g.drawImage(applet.getImage(getURL(),"Pictures/Health.jpg"), x + 85,y + 40, applet);
		g.drawImage(applet.getImage(getURL(),"Pictures/Spirit.jpg"), x + 45,y + 40, applet);
	}
}
