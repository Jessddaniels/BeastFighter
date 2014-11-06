package javaAppletJessMonster;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
public abstract class Leader{
	private JessMonster applet;
	private URL url;
	private Image player;
	ArrayList<Monster> monsterList = new ArrayList<Monster>();
	ArrayList<LeaderCard> cardList = new ArrayList<LeaderCard>();
	private Monster activeMon;
	private Leader o;
	public boolean myTurn = false;
	public boolean tradeOK = false;
	public boolean cardOK = false;
	private Monster viewMon;
	public String playerNum;
	
	public Leader(JessMonster applet){
		this.setApplet(applet);
		url = applet.url;
		player = applet.getImage(url,"Ninja.png");
		monsterList.add(applet.ranMonster(this));
		monsterList.add(applet.ranMonster(this));
		monsterList.add(applet.ranMonster(this));
		cardList.add(applet.ranCard(this));
		cardList.add(applet.ranCard(this));
		cardList.add(applet.ranCard(this));
	}
	public void paint(Graphics g, JessMonster applet){
		g.drawImage(player, applet.getWidth() - 266, 0, applet);
		for (int i = 0; i < monsterList.size(); i++){
			if (monsterList.get(i) != null && viewMon == monsterList.get(i) ){
				monsterList.get(i).paint(g,applet.getWidth() - 400,100, applet);
			} else {
				monsterList.get(i).paint(g,applet.getWidth() - 166,150 * (i + 1), applet);
			}
		}
		for (int i = 0; i < cardList.size(); i++){
			cardList.get(i).paint(g,632, i * 50, applet);
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
}