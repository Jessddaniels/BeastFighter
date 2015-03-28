package javaAppletJessMonster;
import java.awt.Graphics;

public class ABrambleSnare extends Attack {
	public ABrambleSnare(Monster mon){
		super(mon);
		setEnergyCost(15);
		setReqDice(new DieSet(0,0,0,2,0,2));
	}
	public void attack( Leader defender) {
		StEnsnared snare = new StEnsnared(defender.getActiveMon(), 5);
		defender.getActiveMon().getStatusList().add(snare);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Bramble Snare");
		
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
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy20), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Spirit20), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Spirit20), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Experience20), x +20 ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Experience20), x +20,y + 47 , applet);
	}

}
