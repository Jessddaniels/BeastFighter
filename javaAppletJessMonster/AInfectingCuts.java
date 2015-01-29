package javaAppletJessMonster;
import java.awt.Graphics;

public class AInfectingCuts extends Attack {
	public AInfectingCuts(Monster mon){
		super(mon);
		setEnDamage(15);
	}
	public void attack( Leader defender) {
		enAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Infecting Cuts" );
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).CDice >= 2 && ((Character) mon).SDice >= 1 ){
				return true;
			} else if (mon.getEnergy() >= 15){
				mon.setEnergy(mon.getEnergy() - 15);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Calumbra1Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Infecting Cuts" , x + 105 , y + 20);
		g.setFont(normalFont);
		g.drawString("15          DMG (" + calcEnDamage() +")" , x + 90, y + 45);
		g.drawImage(applet.getImage(Images.Energy), x + 110 ,y + 30, applet);
		//en cost
		g.drawString("15" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Health), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Combat), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Combat), x + 20 ,y + 27, applet);
	}

}
