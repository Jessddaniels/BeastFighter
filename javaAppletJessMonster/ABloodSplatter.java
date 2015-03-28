package javaAppletJessMonster;
import java.awt.Graphics;

public class ABloodSplatter extends Attack {
	public ABloodSplatter(Monster mon){
		super(mon);
		setCDamage(10);
		setEnergyCost(20);
		setReqDice(new DieSet(0,0,0,0,1,1));
	}
	public void attack( Leader defender) {
		cAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Blood Splatter");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Calumbra1Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Blood Splatter" , x + 105 , y + 20);
		g.setFont(normalFont);
		g.drawString(getCDamage() + "          DMG (" + calcCDamage() +")" , x + 90, y + 45);
		g.drawImage(applet.getImage(Images.Combat), x + 110 ,y + 30, applet);
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy20), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Damage20), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Experience20), x ,y + 47 , applet);
	}

}
