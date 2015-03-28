package javaAppletJessMonster;
import java.awt.Graphics;

public class ADryHanging extends Attack {
	public ADryHanging(Monster mon){
		super(mon);
		setDGain(30);
		setEnergyCost(20);
		setReqDice(new DieSet(2,0,0,0,0,2));
	}
	public void attack( Leader defender) {
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Dry Hanging" );
		toTextBox(" and gained " + (30 + 30 * mon.getCombat() / 500) + " attack" );
		dGain();
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Calumbra3Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Dry Hanging" , x + 105 , y + 20);
		g.setFont(normalFont);
		g.drawString("Gain "+getDGain()+"          (" + (30 + 30 * mon.getCombat() / 500) +")" , x + 110, y + 40);
		g.drawImage(applet.getImage(Images.Damage), x + 155 ,y + 25, applet);
		//en cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy20), x + 40 ,y + 3, applet);
		// die cost
		g.drawImage(applet.getImage(Images.Health20), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Health20), x ,y + 47, applet);
		g.drawImage(applet.getImage(Images.Experience20), x + 20,y + 27 , applet);
		g.drawImage(applet.getImage(Images.Experience20), x +20 ,y + 47 , applet);
	}

}
