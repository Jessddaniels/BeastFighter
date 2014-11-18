package javaAppletJessMonster;

import java.awt.Graphics;
import java.awt.Image;

public class CRochelle extends Character {
	private Image pic;

	public CRochelle(JessMonster applet, Leader l) {
		super(applet, l);
		pic = applet.getImage(super.getURL(),"Pictures/WomanWarrior.jpg");
		setHP(200);
		setEnergy(100);
		setSpirit(100);
		setCombat(100);
		setKnowledge(100);
		getAttackList().add(new ASwordStrike(this));
		getAttackList().add(new ACounterStance(this));
		getAttackList().add(new AReflectionFade(this));
	}
	public void paint(Graphics g, int x, int y, JessMonster applet){
		super.paint(g, x, y, applet, pic);
	}
	public String nameToString() {
		if (getExperience() < 100){
			return "Rochelle";
		} else if (getExperience() < 200){
			return "Rochelle the Rising";
		} else if (getExperience() < 300){
			return "Rochelle the Avenger";
		} else if (getExperience() < 400){
			return "Rochelle of Grief";
		} else {
			return "Rochelle of Vengeance";
		}
	}
	void passive() {
		if (getAttackList().size() < 4 && getExperience() >= 100){
			getAttackList().add(new ARiposte(this));
			applet.textbox.getArray().add(new TextUnit("Level 2", lead));
		} else if (getAttackList().size() < 5 && getExperience() >= 200){
			getAttackList().add(new AAvengingStrike(this));
			applet.textbox.getArray().add(new TextUnit("Level 3", lead));
		} else if (getAttackList().size() < 6 && getExperience() >= 300){
			getAttackList().add(new AGriefAndRage(this));
			applet.textbox.getArray().add(new TextUnit("Level 4", lead));
		} else if (getAttackList().size() < 7 && getExperience() >= 400){
			getAttackList().add(new AVengeance(this));
			applet.textbox.getArray().add(new TextUnit("Level 5", lead));
		}
	}
	void paintPassive(Graphics g, int x, int y, JessMonster applet) {
		g.setFont(passiveFont);
		//g.drawString("Energetic:" , x, y + 30);
		g.setFont(normalFont);
	}
}