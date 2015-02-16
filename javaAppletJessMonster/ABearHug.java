package javaAppletJessMonster;
import java.awt.Graphics;

public class ABearHug extends Attack {
	public ABearHug(Monster mon){
		super(mon);
		setEnDamage(20);
		setEnergyCost(20);
		setReqDice(new DieSet(2,2,0,0,0,0));
	}
	public void attack( Leader defender) {
		enAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Bear Hug");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Virgeo1Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Bear Hug" , x + 115 , y + 20);
		g.setFont(normalFont);
		g.drawString(getEnDamage() + "          DMG (" + calcEnDamage() +")" , x + 95, y + 45);
		g.drawImage(applet.getImage(Images.Energy), x + 115 ,y + 30, applet);
		//en cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Health), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Health), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Energy), x + 20 ,y + 27 , applet);
		g.drawImage(applet.getImage(Images.Energy), x + 20 ,y + 47, applet);
	}

}
