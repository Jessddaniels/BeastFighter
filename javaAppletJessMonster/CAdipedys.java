package javaAppletJessMonster;

import java.awt.Graphics;
import java.awt.Image;

public class CAdipedys extends Character {
	private Image pic;

	public CAdipedys(JessMonster applet, Leader l) {
		super(applet, l);
		pic = applet.getImage(Images.Adipedys);
		setHP(800);
		setEnergy(0);
		setSpirit(0);
		setCombat(200);
		getAttackList().add(new APommelStrike(this));
		getAttackList().add(new AQuickThrust(this));
		getAttackList().add(new AStunningThrow(this));
	}
	public void paint(Graphics g, int x, int y, JessMonster applet){
		super.paint(g, x, y, applet, pic);
	}
	public String nameToString() {
		if (getExperience() < 100){
			return "King Adipedys";
		} else if (getExperience() < 300){
			return "Adipedys the Glutton";
		} else {
			return "Adipedys of the Flies";
		}
	}
	void passive() {
		if (getAttackList().size() < 4 && getExperience() >= 100){
			getAttackList().add(new AEat(this));
		} else if (getAttackList().size() < 5 && getExperience() >= 200){
			getAttackList().add(new AHeadSlap(this));
		} else if (getAttackList().size() < 6 && getExperience() >= 300){
			getAttackList().add(new AMomentum(this));
			toTextBox("Level 2");
		} else if (getAttackList().size() < 7 && getExperience() >= 400){
			getAttackList().add(new AConsumption(this));
		} else if (getAttackList().size() < 8 && getExperience() >= 400){
			getAttackList().add(new ABile(this));
		} else if (getAttackList().size() < 9 && getExperience() >= 400){
			getAttackList().add(new AVileGenesis(this));
			toTextBox("Level 3");
		}
	}
	void paintPassive(Graphics g, int x, int y, JessMonster applet) {
		g.setFont(passiveFont);
		g.setFont(normalFont);
	}
}