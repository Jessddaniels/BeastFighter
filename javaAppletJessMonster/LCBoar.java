package javaAppletJessMonster;

import java.awt.Graphics;

public class LCBoar extends LeaderCard {
	public LCBoar(Leader l){
		super(l);
	}
	void activate() {
		Monster chara = player.getActiveMon();
		chara.setSpirit(chara.getSpirit() - 40);
		Monster mon = new JMBoar(player.getApplet(), player);
	    player.monsterList.add(mon);
		toTextBox("Gained support of Boar");
	}
	boolean isMet() {
		if (player.getActiveMon().getSpirit() >= 40){
			if (player.monsterList.size() < 3){
				return true;
			}
		}
		return false;
	}
	void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(player.getURL(),"Pictures/HealthPack.jpg"), x,y, applet);
		g.drawString(nameToString() , x, y + 15);
		g.drawString(" Boar     -40" , x, y + 25);
		g.drawImage(applet.getImage(Images.Spirit), x + 30,y + 30, applet);
	}
	String nameToString() {
		return "Boar";
	}
}