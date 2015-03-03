package javaAppletJessMonster;

import java.awt.Graphics;
import java.awt.Image;

public class CVirgeo extends Character {
	private Image pic;

	public CVirgeo(JessMonster applet, Leader l) {
		super(applet, l);
		pic = applet.getImage(Images.Virgeo);
		setHP(300);
		setMaxHealth(300);
		setEnergy(50);
		setSpirit(50);
		setCombat(0);
		getAttackList().add(new ABearHug(this));
		getAttackList().add(new AFellingChop(this));
		getAttackList().add(new ATimber(this));
	}
	public void paint(Graphics g, int x, int y, JessMonster applet){
		super.paint(g, x, y, applet, pic);
	}
	public String nameToString() {
		if (getExperience() < 150){
			return "Virgeo the Mountain Man";
		} else if (getExperience() < 300){
			return "Virgeo the Naturalist";
		} else {
			return "Virgeo the Greedy";
		}
	}
	void passive() {
		if (getAttackList().size() < 4 && getExperience() >= 50){
			getAttackList().add(new ABrambleSnare(this));
		} else if (getAttackList().size() < 5 && getExperience() >= 100){
			getAttackList().add(new AStampede(this));
		} else if (getAttackList().size() < 6 && getExperience() >= 150){
			getAttackList().add(new ACallToNature(this));
			toTextBox("Level 2");
		} else if (getAttackList().size() < 7 && getExperience() >= 200){
			getAttackList().add(new ABlightBolt(this));
		} else if (getAttackList().size() < 8 && getExperience() >= 250){
			getAttackList().add(new AToxicSpores(this));
		} else if (getAttackList().size() < 9 && getExperience() >= 300){
			getAttackList().add(new ALifeBloodBomb(this));
			toTextBox("Level 3");
		}
	}
	void paintPassive(Graphics g, int x, int y, JessMonster applet) {
		g.setFont(passiveFont);
		g.setFont(normalFont);
	}
}