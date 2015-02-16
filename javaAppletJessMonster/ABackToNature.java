package javaAppletJessMonster;
import java.awt.Graphics;

public class ABackToNature extends Attack {
	public ABackToNature(Monster mon){
		super(mon);
		setCDamage(10);
		setSGain(10);
		setEnergyCost(15);
		setReqDice(new DieSet(0,0,0,3,0,0));
	}
	public void attack( Leader defender) {
		cAttack(defender);
		getSGain();
		((Character) mon).RollNum = 3;
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Virgeo2Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Back To Nature" , x + 110 , y + 20);
		g.setFont(normalFont);
		g.drawString(getSGain() + "          Add (" + adj4Combat(getSGain()) +")" , x + 90, y + 35);
		g.drawImage(applet.getImage(Images.Spirit), x + 110 ,y + 20, applet);
		g.drawString(getCDamage() + "         DMG (" + calcCDamage() +")" , x + 90, y + 55);
		g.drawImage(applet.getImage(Images.Combat), x + 110 ,y + 40, applet);
		//en cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Spirit), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Spirit), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Spirit), x + 20 ,y + 27, applet);
	}

}
