package javaAppletJessMonster;
import java.awt.Graphics;

public class ABrambleSnare extends Attack {
	public ABrambleSnare(Monster mon){
		super(mon);;
	}
	public void attack( Leader defender) {
		StEnsnared snare = new StEnsnared(defender.getActiveMon(), 5);
		defender.getActiveMon().getStatusList().add(snare);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Bramble Snare");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character") && ((Character) mon).ExDice >= 2){
			return true;
		} else if (mon.getEnergy() >= 15){
			mon.setEnergy(mon.getEnergy() - 15);
			return true;
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Virgeo2Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Bramble Snare" , x + 110 , y + 20);
		g.setFont(normalFont);
		g.drawString("Gives Ensnare:" , x + 112, y + 35);
		g.drawString("-5         , Saving Roll: 3" , x + 75, y + 50);
		g.drawImage(applet.getImage(Images.Combat), x + 90 ,y + 36, applet);
		g.drawImage(applet.getImage(Images.Combat), x + 200 ,y + 36, applet);
		//en cost
		g.drawString("15" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Spirit), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Spirit), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Experience), x +20 ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Experience), x +20,y + 47 , applet);
	}

}
