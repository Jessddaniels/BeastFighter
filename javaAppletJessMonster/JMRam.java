package javaAppletJessMonster;

import java.awt.Graphics;
import java.awt.Image;

public class JMRam extends Monster {
	private Image pic;

	public JMRam(JessMonster applet, Leader l) {
		super(applet, l);
		pic = applet.getImage(super.getURL(),"Pictures/Ram.jpg");
		setHP(100);
		setEnergy(100);
		setSpirit(100);
		setCombat(100);
		getAttackList().add(new ANull(this));
		getAttackList().add(new ATackle(this));
		getAttackList().add(new AHeadbutt(this));
	}
	public void paint(Graphics g, int x, int y, JessMonster applet){
		super.paint(g, x, y, applet, pic);
	}
	String nameToString() {
		return "Ram";
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