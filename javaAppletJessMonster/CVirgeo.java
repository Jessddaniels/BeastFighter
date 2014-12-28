package javaAppletJessMonster;

import java.awt.Graphics;
import java.awt.Image;

public class CVirgeo extends Character {
	private Image pic;

	public CVirgeo(JessMonster applet, Leader l) {
		super(applet, l);
		pic = applet.getImage(Images.Virgeo);
		setHP(200);
		setEnergy(100);
		setSpirit(100);
		setCombat(100);
		setDamage(100);
		getAttackList().add(new ASwordStrike(this));
		getAttackList().add(new ACounterStance(this));
		getAttackList().add(new AReflectionFade(this));
	}
	public void paint(Graphics g, int x, int y, JessMonster applet){
		super.paint(g, x, y, applet, pic);
	}
	public String nameToString() {
		if (getExperience() < 100){
			return "Virgeo";
		} else if (getExperience() < 200){
			return "Virgeo the Mountain";
		} else if (getExperience() < 300){
			return "Virgeo the Island";
		} else if (getExperience() < 400){
			return "Virgeo the Natural";
		} else {
			return "Virgeo the Greedy";
		}
	}
	void passive() {
		if (getAttackList().size() < 4 && getExperience() >= 100){
			getAttackList().add(new ARiposte(this));
			toTextBox("Level 2");
		} else if (getAttackList().size() < 5 && getExperience() >= 200){
			getAttackList().add(new AAvengingStrike(this));
			toTextBox("Level 3");
		} else if (getAttackList().size() < 6 && getExperience() >= 300){
			getAttackList().add(new AGriefAndRage(this));
			toTextBox("Level 4");
		} else if (getAttackList().size() < 7 && getExperience() >= 400){
			getAttackList().add(new AVengeance(this));
			toTextBox("Level 5");
		}
	}
	void paintPassive(Graphics g, int x, int y, JessMonster applet) {
		g.setFont(passiveFont);
		g.setFont(normalFont);
	}
}