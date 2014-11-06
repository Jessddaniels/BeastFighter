package javaAppletJessMonster;

import java.awt.Graphics;
import java.awt.Image;

public class JMSkeletalCow extends Monster {
	private Image pic;
	public JMSkeletalCow(JessMonster applet, Leader l) {
		super(applet, l);
		pic = applet.getImage(super.getURL(),"SkeletalCowResized.jpg");
		setHP(80);
		setEnergy(140);
		setPower(90);
		setSpirit(100);
		getAttackList().add(new AHeadbutt(this));
		getAttackList().add(new ARestInPeace(this));
		getAttackList().add(new ASpiritSink(this));
		getAttackList().add(new ARun(this));
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
			applet.textbox.getArray().add(new TextUnit("Spirit Linked", lead));
		}
	}
	void paintPassive(Graphics g, int x, int y, JessMonster applet) {
		g.setFont(nameFont);
		g.drawString("     " + nameToString(), x, y + 15);
		g.setFont(passiveFont);
		g.drawString("Spirit Link:" , x, y + 30);
		g.setFont(normalFont);
		g.drawString("        < 80" , x + 80, y + 30);
		g.drawString("convert          to" , x, y + 50);
		g.drawImage(applet.getImage(getURL(),"health.jpg"), x + 80,y + 17, applet);
		g.drawImage(applet.getImage(getURL(),"health.jpg"), x + 85,y + 40, applet);
		g.drawImage(applet.getImage(getURL(),"spirit.jpg"), x + 45,y + 40, applet);
	}
}
