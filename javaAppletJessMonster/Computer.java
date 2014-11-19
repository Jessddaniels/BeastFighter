package javaAppletJessMonster;

import java.awt.Graphics;

public class Computer extends Leader {
	int level;
	public Computer(JessMonster applet, int level) {
		super(applet);
		this.level = level;
	}
	public Monster getActiveMon(){
		return super.getActiveMon();
	}
	public void setActiveMon(Monster newMon){
		super.setActiveMon(newMon);
	}
	public void takeTurn(){
		getApplet().match.sleeper(1000);//use cards
		int i = 0;
		while (cardOK && i < 3){
			if (cardList.get(i).isMet()){
				cardList.get(i).activate();
				cardOK = false;
			}
			i++;
		}
		getApplet().match.sleeper(1000);
		if (level == 0){
			if (getActiveMon().type.equals("character")){
				((Character) getActiveMon()).roll(6);
			}
			if(getActiveMon().reqA1(this,getO())) {
				getActiveMon().attack1(this, getO());
				myTurn = false;
			} else if(getActiveMon().reqA2(this,getO())) {
				getActiveMon().attack2(this, getO());
				myTurn = false;
			} else if(getActiveMon().reqA3(this,getO())) {
				getActiveMon().attack3(this, getO());
				myTurn = false;
			} else {
				getActiveMon().rest();
				myTurn = false;
			}
		} else if (level == 1){
			boolean done = false;
			while (!done){
				int rand = (int) (Math.random() * 5);
				done = true;
				if (getActiveMon().type.equals("character")){
					((Character) getActiveMon()).roll(6);
				}
				if (tradeOK && monsterList.size() > 1){
					done = false;
					int randy = (int) (Math.random() * monsterList.size());
					while (monsterList.get(randy) == getActiveMon()) {
						randy = (int) (Math.random() * monsterList.size());
					}
					setActiveMon(monsterList.get(randy));
					setViewMon(monsterList.get(randy));
					tradeOK = false;
					
				} else if(rand == 0 && getActiveMon().reqA1(this,getO())) {
					getActiveMon().attack1(this, getO());
					myTurn = false;
				} else if(rand == 1 && getActiveMon().reqA2(this,getO())) {
					getActiveMon().attack2(this, getO());
					myTurn = false;
				} else if(rand == 2 && getActiveMon().reqA3(this,getO())) {
					getActiveMon().attack3(this, getO());
					myTurn = false;
				} else if (rand == 3){
					getActiveMon().rest();
					myTurn = false;
				} else if (rand == 4 && getActiveMon().getEnergy() >= 20 && monsterList.size() > 1){
					getActiveMon().run();
					done = false;
				} else {
					done = false;
				}
			}
		}
	}
	void update(JessMonster applet) {
	}
	public void paintEnd(Graphics g, JessMonster applet){
	}
	public void knockedOut() {
		for (int j = 0; j < monsterList.size(); j++){
			if (monsterList.get(j) != null) {
				setActiveMon(monsterList.get(j));
				setViewMon(monsterList.get(j));
			} else {
				j++;
			}
		}
	}
}
