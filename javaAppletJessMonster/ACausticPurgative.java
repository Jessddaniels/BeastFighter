package javaAppletJessMonster;
import java.awt.Graphics;

public class ACausticPurgative extends Attack {
	public ACausticPurgative(Monster mon){
		super(mon);
		setSDamage(10);
		setHDamage(10);
		setEnergyCost(15);
		setReqDice(new DieSet(0,0,0,2,0,1));
	}
	public void attack( Leader defender) {
		hAttack(defender);
		sAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Caustic Purgative for " + calcHDamage()+ " DMG");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Calumbra2Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Caustic Purgative" , x + 95 , y + 25);
		g.setFont(normalFont);
		g.drawString(getHDamage() + " DMG (" + calcHDamage() +")" , x + 110, y + 40);
		g.drawString(getSDamage() + "          DMG (" + calcSDamage() +")" , x + 95, y + 60);
		g.drawImage(applet.getImage(Images.Spirit), x + 115 ,y + 43, applet);
		//en cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy20), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Spirit20), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Spirit20), x ,y + 47, applet);
		g.drawImage(applet.getImage(Images.Experience20), x + 20,y + 27 , applet);
	}

}
