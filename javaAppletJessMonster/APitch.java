package javaAppletJessMonster;
import java.awt.Graphics;

public class APitch extends Attack {
	public APitch(Monster mon){
		super(mon);
		setCDamage(20);
		setEnergyCost(10);
		setReqDice(new DieSet(0,0,0,1,0,1));
	}
	public void attack( Leader defender) {
		cAttack(defender);
		StFlammable flame = new StFlammable(defender.getActiveMon(), 15);
		defender.getActiveMon().getStatusList().add(flame);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Pitch");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Debira3Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Pitch" , x + 135 , y + 20);
		g.setFont(normalFont);
		g.drawString(getCDamage() + "         DMG (" + calcCDamage() +")" , x + 115, y +38);
		g.drawImage(applet.getImage(Images.Combat), x+ 130 ,y + 23, applet);
		g.drawString("Gives 15 Combustible." , x + 90, y + 55);
		//en cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Combat), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Experience), x ,y + 47 , applet);
	}

}
