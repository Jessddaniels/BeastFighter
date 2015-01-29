package javaAppletJessMonster;
import java.awt.Graphics;

public class AMiracleTonic extends Attack {
	public AMiracleTonic(Monster mon){
		super(mon);
	}
	public void attack( Leader defender) {
		toTextBox(mon.nameToString() + " used Miracle Tonic" );
		int rand = (int) (Math.random() * 6);
		if (rand == 0){
			toTextBox(" and gained " + (25 + 25 * mon.getCombat() / 500) + " health" );
			setHGain(25);
			hGain();
		} else if (rand ==1){
			toTextBox(" and gained " + (25 + 25 * mon.getCombat() / 500) + " energy" );
			setEnGain(25);
			enGain();
		} else if (rand ==2){
			toTextBox(" and gained " + (25 + 25 * mon.getCombat() / 500) + " combat" );
			setCGain(25);
			cGain();
		} else if (rand ==3){
			toTextBox(" and gained " + (25 + 25 * mon.getCombat() / 500) + " spirit" );
			setSGain(25);
			sGain();
		} else if (rand ==4){
			toTextBox(" and gained " + (25 + 25 * mon.getCombat() / 500) + " attack" );
			setDGain(25);
			dGain();
		} else {
			toTextBox(" and gained " + (25 + 25 * mon.getCombat() / 500) + " experience" );
			setExGain(25);
			exGain();
		}
		((Character) mon).RollNum = 3;
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).ExDice >= 2 && ((Character) mon).HDice >= 2 ){
				return true;
			} else if (mon.getEnergy() >= 20){
				mon.setEnergy(mon.getEnergy() - 20);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Calumbra1Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Miracle Tonic" , x + 105 , y + 25);
		g.setFont(normalFont);
		g.drawString("ADD "+ (25 + 25 * mon.getCombat() / 500)+" to random die stat", x + 80, y + 45);
		//en cost
		g.drawString("20" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Health), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Health), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Experience), x + 20 ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Experience), x + 20 ,y + 47 , applet);
	}

}
