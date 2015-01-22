package javaAppletJessMonster;

import java.awt.Graphics;
import java.awt.Image;

public class CCalumbra extends Character {
	private Image pic;

	public CCalumbra(JessMonster applet, Leader l) {
		super(applet, l);
		pic = applet.getImage(Images.Calumbra);
		setHP(300);
		setEnergy(0);
		setSpirit(100);
		setCombat(0);
		getAttackList().add(new AMiracleTonic(this));
		getAttackList().add(new AInfectingCuts(this));
		getAttackList().add(new ABloodSplatter(this));
	}
	public void paint(Graphics g, int x, int y, JessMonster applet){
		super.paint(g, x, y, applet, pic);
	}
	public String nameToString() {
		if (getExperience() < 150){
			return "Calumbra the Jealous";
		} else if (getExperience() < 300){
			return "Demon Sight Calumbra";
		} else {
			return "Demonic Calumbra";
		}
	}
	void passive() {
		if (getAttackList().size() < 4 && getExperience() >= 50){
			getAttackList().add(new ACausticPurgative(this));
		} else if (getAttackList().size() < 5 && getExperience() >= 100){
			getAttackList().add(new AButcherHook(this));
		} else if (getAttackList().size() < 6 && getExperience() >= 150){
			getAttackList().add(new AFuguToxin(this));
			toTextBox("Level 2");
		} else if (getAttackList().size() < 7 && getExperience() >= 200){
			getAttackList().add(new ALeechTrap(this));
		} else if (getAttackList().size() < 8 && getExperience() >= 250){
			getAttackList().add(new ADryHanging(this));
		} else if (getAttackList().size() < 9 && getExperience() >= 300){
			getAttackList().add(new ADemonicPull(this));
			toTextBox("Level 3");
		}
	}
	void paintPassive(Graphics g, int x, int y, JessMonster applet) {
		g.setFont(passiveFont);
		g.setFont(normalFont);
	}
}