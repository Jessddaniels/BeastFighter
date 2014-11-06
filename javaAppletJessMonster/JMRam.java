package javaAppletJessMonster;

import java.awt.Graphics;
import java.awt.Image;

public class JMRam extends Monster {
	private Image pic;

	public JMRam(JessMonster applet, Leader l) {
		super(applet, l);
		pic = applet.getImage(super.getURL(),"Ram.jpg");
		setHP(100);
		setEnergy(100);
		setSpirit(100);
		setPower(100);
		getAttackList().add(new ATackle(this));
		getAttackList().add(new AHeadbutt(this));
		getAttackList().add(new ARest(this));
		getAttackList().add(new ARun(this));
	}
	public void paint(Graphics g, int x, int y, JessMonster applet){
		super.paint(g, x, y, applet, pic);
	}
	String nameToString() {
		return "Ram";
	}
	void passive() {
		setEnergy(getEnergy() + 5);
		applet.textbox.getArray().add(new TextUnit("Energy + 5", lead));
	}
	void paintPassive(Graphics g, int x, int y, JessMonster applet) {
		g.setFont(nameFont);
		g.drawString("     " + nameToString(), x, y + 15);
		g.setFont(passiveFont);
		g.drawString("Energetic:" , x, y + 30);
		g.setFont(normalFont);
		g.drawString("              + 5" , x, y + 50);
		g.drawImage(applet.getImage(getURL(),"energy.jpg"), x + 20,y + 35, applet);
	}
}