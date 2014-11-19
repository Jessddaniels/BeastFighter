package javaAppletJessMonster;

import java.awt.Graphics;
import java.awt.Image;

public class CAdipedys extends Character {
	private Image pic;

	public CAdipedys(JessMonster applet, Leader l) {
		super(applet, l);
		pic = applet.getImage(super.getURL(),"Pictures/King.jpg");
		setHP(400);
		setEnergy(0);
		setSpirit(0);
		setCombat(100);
		setKnowledge(100);
		getAttackList().add(new AEat(this));
		getAttackList().add(new ABash(this));
		getAttackList().add(new AHeadSlap(this));
	}
	public void paint(Graphics g, int x, int y, JessMonster applet){
		super.paint(g, x, y, applet, pic);
	}
	public String nameToString() {
		if (getExperience() < 100){
			return "King Adipedys";
		} else if (getExperience() < 200){
			return "Adipedys the Hungry";
		} else if (getExperience() < 300){
			return "Adipedys the Glutton";
		} else if (getExperience() < 400){
			return "Demon Adipedys";
		} else {
			return "Lord of the Flies";
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