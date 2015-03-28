package javaAppletJessMonster;
import java.awt.Graphics;

public class AInfectingCuts extends Attack {
	public AInfectingCuts(Monster mon){
		super(mon);
		setEnDamage(15);
		setEnergyCost(15);
		setReqDice(new DieSet(0,0,2,1,0,0));
	}
	public void attack( Leader defender) {
		enAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Infecting Cuts" );
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Calumbra1Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Infecting Cuts" , x + 105 , y + 20);
		g.setFont(normalFont);
		g.drawString(getEnDamage() + "          DMG (" + calcEnDamage() +")" , x + 90, y + 45);
		g.drawImage(applet.getImage(Images.Energy), x + 110 ,y + 30, applet);
		//en cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy20), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Health20), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Combat20), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Combat20), x + 20 ,y + 27, applet);
	}

}
