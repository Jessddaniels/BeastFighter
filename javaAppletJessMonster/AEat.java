package javaAppletJessMonster;
import java.awt.Graphics;

public class AEat extends Attack {
	public AEat(Monster mon){
		super(mon);
		setHGain(15);
		setEnergyCost(10);
		setReqDice(new DieSet(2,0,0,0,0,0));
	}
	public void attack( Leader defender) {
		hGain();
		((Character) mon).RollNum = 2;
		toTextBox(mon.nameToString() + " used Eat");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Adipedys2Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Eat" , x + 125 , y + 20);
		g.setFont(normalFont);
		g.drawString(getHGain() + "          ADD ", x + 110, y + 40);
		g.drawImage(applet.getImage(Images.Health), x + 125 ,y + 25, applet);
		//en cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Health), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Health), x ,y + 47 , applet);
	}

}
