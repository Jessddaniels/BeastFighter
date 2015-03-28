package javaAppletJessMonster;
import java.awt.Graphics;

public class ADemonicPull extends Attack {
	public ADemonicPull(Monster mon){
		super(mon);
		setHDamage(20);
		setHGain(20);
		setEnergyCost(999999);
		setReqDice(new DieSet(0,1,0,1,0,0));
	}
	public void attack( Leader defender) {
		hAttack(defender);
		hGain();
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Demonic Pull for " + calcHDamage()+ " DMG");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Calumbra3Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Demonic Pull" , x + 105 , y + 20);
		g.setFont(normalFont);
		g.drawString(getHGain() +"          ADD", x + 105, y + 45);
		g.drawImage(applet.getImage(Images.Energy), x + 125 ,y + 35, applet);
		//en cost
		g.drawString("Null" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy20), x + 40 ,y + 3, applet);
		// die cost
		g.drawImage(applet.getImage(Images.Energy20), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Spirit20), x ,y + 47, applet);
	}

}
