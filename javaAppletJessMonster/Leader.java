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
	
	public Leader(JessMonster applet){
		this.setApplet(applet);
		url = applet.url;
		player = applet.getImage(url,"Pictures/Ninja.png");
		cardListBG = applet.getImage(url,"Pictures/CardList.jpg");
		monsterList.add(applet.ranMonster(this));
		monsterList.add(applet.ranMonster(this));
		monsterList.add(applet.ranMonster(this));
		cardList.add(applet.ranCard(this));
		cardList.add(applet.ranCard(this));
		cardList.add(applet.ranCard(this));
		cardList.add(applet.ranCard(this));
		cardList.add(applet.ranCard(this));
		activeCard = cardList.get(0);
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
		getApplet().sleeper(1000);
		cardList.clear();
		cardList.add(applet.ranCard(this));
		cardList.add(applet.ranCard(this));
		cardList.add(applet.ranCard(this));
		cardList.add(applet.ranCard(this));
		cardList.add(applet.ranCard(this));
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
			applet.stopRunning();
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
}