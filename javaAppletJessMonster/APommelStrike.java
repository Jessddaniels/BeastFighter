package javaAppletJessMonster;
import java.awt.Graphics;

public class APommelStrike extends Attack {
	public APommelStrike(Monster mon){
		super(mon);
		setExDamage(15);
		setEnergyCost(15);
		setReqDice(new DieSet(0,0,2,0,0,1));
	}
	public void attack( Leader defender) {
		exAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Pommel Strike");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Adipedys1Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Pommel Strike" , x + 105 , y + 25);
		g.setFont(normalFont);
		g.drawString(getExDamage() + "          DMG (" + calcExDamage() +")" , x + 90, y + 45);
		g.drawImage(applet.getImage(Images.Experience), x + 110 ,y + 30, applet);
		//en Cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Combat), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Combat), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Combat), x + 20 ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Experience), x + 20 ,y + 47 , applet);
	}

}
