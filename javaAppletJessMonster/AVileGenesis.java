package javaAppletJessMonster;
import java.awt.Graphics;

public class AVileGenesis extends Attack {
	public AVileGenesis(Monster mon){
		super(mon);
		setEnergyCost(25);
		setReqDice(new DieSet(0,0,0,4,0,0));
	}
	public void attack( Leader defender) {
		toTextBox(mon.nameToString() + " used Vile Genesis" );
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
			toTextBox("Gained support of Boar");
			Monster monster = new JMBoar(mon.lead.getApplet(), mon.lead);
		    mon.lead.monsterList.add(monster);
		}
		((Character) mon).RollNum = 3;
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Adipedys3Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Vile Genesis" , x + 110 , y + 20);
		g.setFont(normalFont);
		g.drawString("Random effect" , x + 110, y + 35);
		//en Cost
		g.drawString(getEnergyCost()  + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//dice
		g.drawImage(applet.getImage(Images.Spirit), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Spirit), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Spirit), x + 20 ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Spirit), x + 20 ,y + 47, applet);
	}

}
