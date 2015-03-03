package javaAppletJessMonster;
import java.awt.Graphics;

public class ACallToNature extends Attack {
	public ACallToNature(Monster mon){
		super(mon);
		setSGain(25);
		setEnergyCost(20);
		setReqDice(new DieSet(0,0,0,4,0,0));
	}
	public void attack( Leader defender) {
		sGain();
		((Character) mon).RollNum = 3;
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Virgeo2Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Call To Nature" , x + 110 , y + 20);
		g.setFont(normalFont);
		g.drawString(getSGain() + "          Add (" + adj4Combat(getSGain()) +")" , x + 100, y + 45);
		g.drawImage(applet.getImage(Images.Spirit), x + 120 ,y + 30, applet);
		//en cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Spirit), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Spirit), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Spirit), x + 20 ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Spirit), x + 20 ,y + 47, applet);
	}

}
