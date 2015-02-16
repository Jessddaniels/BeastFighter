package javaAppletJessMonster;
import java.awt.Graphics;

public class ASparkingStrike extends Attack {
	public ASparkingStrike(Monster mon){
		super(mon);
		setHDamage(15);
		setEnergyCost(15);
		setReqDice(new DieSet(0,0,3,0,0,0));
	}
	public void attack( Leader defender) {
		hAttack(defender);
		for (int i = defender.getActiveMon().getStatusList().size() - 1; i >= 0; i--){
			if (defender.getActiveMon().getStatusList().get(i).getType().equals("StFlammable")){
				defender.getActiveMon().getStatusList().get(i).trigger();
				defender.getActiveMon().getStatusList().remove(i);
			}
		}
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Sparking Strike for " + calcHDamage()+ " DMG");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Debira2Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Sparking Strike" , x + 105 , y + 25);
		g.setFont(normalFont);
		g.drawString(getHDamage() + " DMG (" + calcHDamage() +")" , x + 115, y + 40);
		g.drawString("Ignites Combustibles." , x + 90, y + 55);
		//en cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Combat), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Combat), x  ,y + 47, applet);
		g.drawImage(applet.getImage(Images.Combat), x + 20,y + 27 , applet);
	}

}
