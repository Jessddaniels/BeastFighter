package javaAppletJessMonster;

import java.awt.Graphics;
import java.awt.Image;

public class CCalumbra extends Character {
	private Image pic;

	public CCalumbra(JessMonster applet, Leader l) {
		super(applet, l);
		pic = applet.getImage(Images.Calumbra);
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
			return "Calumbra";
		} else if (getExperience() < 200){
			return "Columbra the Jealous";
		} else if (getExperience() < 300){
			return "Columbra the Mad";
		} else if (getExperience() < 400){
			return "Columbra the Murderer";
		} else {
			return "Demon Sight Columbra";
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