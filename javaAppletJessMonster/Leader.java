package javaAppletJessMonster;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
public abstract class Leader{
	private JessMonster applet;
	private URL url;
	private Image player;
	public Image cardListBG;
	ArrayList<Monster> monsterList = new ArrayList<Monster>();
	ArrayList<LeaderCard> cardList = new ArrayList<LeaderCard>();
	private Monster activeMon;
	private LeaderCard activeCard;
	private Leader o;
	public boolean myTurn = false;
	public boolean tradeOK = false;
	public boolean cardOK = false;
	private Monster viewMon;
	public String playerNum;
	public Match match;
	
	public Leader(JessMonster applet){
		this.setApplet(applet);
		url = applet.url;
		player = applet.getImage(url,"Pictures/Ninja.png");
		cardListBG = applet.getImage(url,"Pictures/CardList.jpg");
		monsterList.add(ranChar(this));
		monsterList.add(ranMonster(this));
		monsterList.add(ranMonster(this));
		cardList.add(ranCard(this));
		cardList.add(ranCard(this));
		cardList.add(ranCard(this));
		cardList.add(ranCard(this));
		cardList.add(ranCard(this));
		activeCard = cardList.get(0);
		match = applet.match;
	}
	public void paint(Graphics g, JessMonster applet){
		g.drawImage(player, applet.getWidth() - 250, 0, applet);
		for (int i = 0; i < monsterList.size(); i++){
			if (monsterList.get(i) != null && viewMon == monsterList.get(i) ){
				monsterList.get(i).paint(g,applet.getWidth() - 400,100, applet);
			} else {
				monsterList.get(i).paint(g,applet.getWidth() - 150,125 * (i) + 225, applet);
			}
		}
		g.drawImage(cardListBG, 650, 0, applet);
		for (int i = 0; i < cardList.size(); i++){
			g.drawString(cardList.get(i).nameToString(),650 ,i * 20 + 10 );
			if (cardList.get(i) == activeCard){
				cardList.get(i).paint(g,650, 100, applet);
			}
		}
	}
	public Monster getActiveMon(){
		return this.activeMon;
	}
	public void setActiveMon(Monster newMon){
		activeMon = newMon; 
	}
	public Image getPlayer(){
		return player;
	}
	public URL getURL(){
		return url;
	}
	public Leader getO() {
		return o;
	}
	public void setO(Leader opponent) {
		this.o = opponent;
	}
	public void updateEOT(JessMonster applet){
		if (activeMon.type.equals("character")){
			Character mon = (Character) activeMon;
			int dieReward = (5 * mon.getKnowledge()) / 100 ;
			mon.setHP(mon.getHP() + dieReward * mon.HDice);
			mon.setEnergy(mon.getEnergy() + dieReward * mon.EnDice);
			mon.setSpirit(mon.getSpirit() + dieReward * mon.SDice);
			mon.setCombat(mon.getCombat() + dieReward * mon.CDice);
			mon.setKnowledge(mon.getKnowledge() + dieReward * mon.KDice);
			mon.setExperience(mon.getExperience() + dieReward * mon.ExDice);
			mon.getDiceList().clear();
			mon.HDice = 0;
			mon.EnDice = 0;
			mon.SDice = 0;
			mon.CDice = 0;
			mon.KDice = 0;
			mon.ExDice = 0;
			mon.RollNum = 0;
		}
		
	}
	public void updateBOT(JessMonster applet){
		getApplet().match.sleeper(1000);
		cardList.clear();
		cardList.add(ranCard(this));
		cardList.add(ranCard(this));
		cardList.add(ranCard(this));
		cardList.add(ranCard(this));
		cardList.add(ranCard(this));
		boolean hasMon = true;
		for (int i = 0; i < monsterList.size(); i++){
			if (monsterList.get(i) != null && monsterList.get(i).getHP() <= 0 ){
				monsterList.remove(i);
				if (monsterList.size() == 0){
					hasMon = false;
				} else {
					knockedOut();
				}
			} 
		}
		if (hasMon == false){
			applet.match.stopRunning();
		} else {
			activeMon.passive();
		}
	}
	public Monster getViewMon() {
		return viewMon;
	}
	public void setViewMon(Monster viewMon) {
		this.viewMon = viewMon;
	}
	public JessMonster getApplet() {
		return applet;
	}
	public void setApplet(JessMonster applet) {
		this.applet = applet;
	}
	abstract void knockedOut();
	abstract void update(JessMonster applet);
	abstract void takeTurn();
	abstract void paintEnd(Graphics g, JessMonster applet);
	public LeaderCard getActiveCard() {
		return activeCard;
	}
	public void setActiveCard(LeaderCard activeCard) {
		this.activeCard = activeCard;
	}
	public LeaderCard ranCard(Leader l){
    	LeaderCard card;
    	int rand = (int) (Math.random() * 5);
    	if (rand == 0){
    		card = new LCEnergyDrink(l);
    	} else if (rand == 1) {
    		card = new LCSteroids( l);
    	} else if (rand == 2) {
    		card = new LCBeer(l);
    	} else if (rand == 3) {
    		card = new LCProtein(l);
    	} else {
    		card = new LCHealthPack(l);
    	}
    	return card;
    }
    public Character ranChar(Leader l){
    	Character mon;
    	int rand = (int) (Math.random() * 3);
    	if (rand == 0) {
    		mon = new CSoldier(applet, l);
    	} else if (rand == 1) {
    		mon = new CRochelle(applet, l);
    	} else {
    		mon = new CAdipedys(applet, l);
    	} 
    	return mon;
    }
	 public Monster ranMonster(Leader l){
	    	Monster mon;
	    	int rand = (int) (Math.random() * 9);
	    	if (rand == 0) {
	    		mon = new JMTiger(applet, l);
	    	} else if (rand == 1) {
	    		mon = new JMAlligator(applet, l);
	    	} else if (rand == 2) {
	    		mon = new JMBear(applet, l);
	    	} else if (rand == 3) {
	    		mon = new JMSkeletalCow(applet, l);
	    	} else if (rand == 4) {
	    		mon = new JMRam(applet, l);
	    	} else if (rand == 5) {
	    		mon = new JMWolf(applet, l);
	    	} else if (rand == 6) {
	    		mon = new JMMountainLion(applet, l);
	    	} else if (rand == 7) {
	    		mon = new JMBoar(applet, l);
	    	} else {
	    		mon = new JMDragon(applet, l);
	    	} 
	    	return mon;
	    }
}