package javaAppletJessMonster;

import java.awt.Graphics;
import java.awt.Image;

public class CDebira extends Character {
	private Image pic;

	public CDebira(JessMonster applet, Leader l) {
		super(applet, l);
		pic = applet.getImage(Images.Debira);
		setHP(300);
		setMaxHealth(300);
		setEnergy(80);
		setSpirit(20);
		setCombat(0);
		getAttackList().add(new ACounterStance(this));
		getAttackList().add(new ARiposte(this));
		getAttackList().add(new AReflectionFade(this));
	}
	public void paint(Graphics g, int x, int y, JessMonster applet){
		super.paint(g, x, y, applet, pic);
	}
	public String nameToString() {
		if (getExperience() < 150){
			return "Debira the Rising";
		} else if (getExperience() < 300){
			return "Debira of Vengeance";
		} else {
			return "Debira of Wrath";
		}
	}
	void passive() {
		if (getAttackList().size() < 4 && getExperience() >= 50){
			getAttackList().add(new AVidensManus(this));
		} else if (getAttackList().size() < 5 && getExperience() >= 100){
			getAttackList().add(new ASparkingStrike(this));
		} else if (getAttackList().size() < 6 && getExperience() >= 150){
			getAttackList().add(new AAvengingBlast(this));
			toTextBox("Level 2");
		} else if (getAttackList().size() < 7 && getExperience() >= 200){
			getAttackList().add(new APitch(this));
		} else if (getAttackList().size() < 8 && getExperience() >= 250){
			getAttackList().add(new AVengeance(this));
		} else if (getAttackList().size() < 9 && getExperience() >= 300){
			getAttackList().add(new AWrath(this));
			toTextBox("Level 3");
		}
	}
	void paintPassive(Graphics g, int x, int y, JessMonster applet) {
		g.setFont(passiveFont);
		g.setFont(normalFont);
	}
}