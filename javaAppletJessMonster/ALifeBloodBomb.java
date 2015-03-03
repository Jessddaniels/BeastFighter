package javaAppletJessMonster;
import java.awt.Graphics;

public class ALifeBloodBomb extends Attack {
	public ALifeBloodBomb(Monster mon){
		super(mon);
		setHDamage(50);
		setEnergyCost(25);
		setReqDice(new DieSet(0,0,2,3,0,0));
	}
	public void attack( Leader defender) {
		hAttack(defender);
		for (int i = 0; i < mon.lead.monsterList.size(); i++ ){
			mon.lead.monsterList.get(i).setHP(mon.lead.monsterList.get(i).getHP() - 10);
		}
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Life Blood Bomb for " + calcHDamage()+ " DMG");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Virgeo3Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Life Blood Bomb" , x + 100 , y + 25);
		g.setFont(normalFont);
		g.drawString(getHDamage() + " DMG (" + calcHDamage() +")" , x + 110, y + 40);
		g.drawString("10 DMG to allies (" + adj4Combat(10) +")" , x + 90, y + 55);
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
