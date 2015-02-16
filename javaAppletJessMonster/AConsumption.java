package javaAppletJessMonster;
import java.awt.Graphics;

public class AConsumption extends Attack {
	public AConsumption  (Monster mon){
		super(mon);
		setHGain(25);
		setEnergyCost(15);
		setReqDice(new DieSet(2,0,0,1,0,0));
	}
	public void attack( Leader defender) {
		getHGain();
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Consumption");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Adipedys3Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Consumption  " , x + 105 , y + 22);
		g.setFont(normalFont);
		g.drawString("Heal " + getHGain() , x + 120, y + 40);
		//en cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Health), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Health), x ,y + 47, applet);
		g.drawImage(applet.getImage(Images.Spirit), x + 20 ,y + 27 , applet);
	}

}
