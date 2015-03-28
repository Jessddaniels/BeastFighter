package javaAppletJessMonster;
import java.awt.Graphics;

public class AWrath extends Attack {
	public AWrath(Monster mon){
		super(mon);
		setHDamage(15);
		setEnergyCost(30);
		setReqDice(new DieSet(0,0,0,2,2,0));
	}
	public void attack( Leader defender) {
		setHDamage(getHDamage() + mon.getDamage());
		hAttack(defender);
		setHDamage(15);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Wrath for " + calcHDamage()+ " DMG");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Debira3Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Wrath" , x + 125 , y + 20);
		g.setFont(normalFont);
		g.drawString(getHDamage() + " DMG (" + calcHDamage() +")" , x + 115, y + 35);
		g.drawString("2x Damage from" , x + 85, y + 55);
		g.drawImage(applet.getImage(Images.Damage), x + 180,y + 40 , applet);
		//en cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy20), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Combat20), x ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Combat20), x ,y + 45 , applet);
		g.drawImage(applet.getImage(Images.Damage20), x + 20,y + 25 , applet);
		g.drawImage(applet.getImage(Images.Damage20), x + 20 ,y + 45, applet);
		g.drawImage(applet.getImage(Images.Spirit20), x + 40,y + 25 , applet);
		g.drawImage(applet.getImage(Images.Spirit20), x + 40,y + 45 , applet);
	}

}
