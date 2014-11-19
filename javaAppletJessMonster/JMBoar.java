package javaAppletJessMonster;

import java.awt.Graphics;
import java.awt.Image;

public class JMBoar extends Monster {
	private Image pic;

	public JMBoar(JessMonster applet, Leader l) {
		super(applet, l);
		pic = applet.getImage(super.getURL(),"Pictures/Boar.jpg");
		setHP(100);
		setEnergy(100);
		setSpirit(100);
		setCombat(100);
		getAttackList().add(new ANull(this));
		getAttackList().add(new ATackle(this));
		getAttackList().add(new AGore(this));
	}
	public void paint(Graphics g, int x, int y, JessMonster applet){
		super.paint(g, x, y, applet, pic);
	}
	String nameToString() {
		return "Boar";
	}
	void passive() {
		setHP(getHP() + 5);
		toTextBox("Health + 5");
	}
	void paintPassive(Graphics g, int x, int y, JessMonster applet) {
		g.setFont(passiveFont);
		g.drawString("Strong Appetite:" , x, y + 30);
		g.setFont(normalFont);
		g.drawString("              + 5" , x, y + 50);
		g.drawImage(applet.getImage(getURL(),"Pictures/Health.jpg"), x + 20,y + 35, applet);
	}
}