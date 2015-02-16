package javaAppletJessMonster;
import java.awt.Graphics;

public class ARiposte extends Attack {
	public ARiposte(Monster mon){
		super(mon);
		setEnergyCost(15);
		setReqDice(new DieSet(0,0,2,0,1,0));
	}
	public void attack( Leader defender) {
		setHDamage(defender.getActiveMon().getDamage());
		defender.getActiveMon().setDamage(0);
		hAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Riposte for " + calcHDamage()+ " DMG");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Debira1Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Riposte" , x + 120 , y + 20);
		g.setFont(smallFont);
		g.drawString("Opponent's Damage Stat DMG." , x + 80, y + 35);
		g.drawString("Set Opponent's Damage Stat" , x + 75, y + 45);
		g.drawString("to 0." , x + 130, y + 55);
		g.setFont(normalFont);
		//en cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Combat), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Combat), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Damage), x + 20 ,y + 27, applet);
	}

}
