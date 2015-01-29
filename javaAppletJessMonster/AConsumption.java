package javaAppletJessMonster;
import java.awt.Graphics;

public class AConsumption extends Attack {
	public AConsumption  (Monster mon){
		super(mon);
		setHGain(25);
	}
	public void attack( Leader defender) {
		getHGain();
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Consumption");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).HDice >= 2 && ((Character) mon).SDice >= 1 ){
				return true;
			} else if (mon.getEnergy() >= 15){
				mon.setEnergy(mon.getEnergy() - 15);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Adipedys3Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Consumption  " , x + 105 , y + 22);
		g.setFont(normalFont);
		g.drawString("Heal 25" , x + 120, y + 40);
		//en cost
		g.drawString("15" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Health), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Health), x ,y + 47, applet);
		g.drawImage(applet.getImage(Images.Spirit), x + 20 ,y + 27 , applet);
	}

}
