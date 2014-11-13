package javaAppletJessMonster;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
public class Player extends Leader implements KeyListener, MouseMotionListener, MouseListener, MouseWheelListener{
	boolean endStatus = true;
	private Image youWin;
	private Image youLose;
	public Player(JessMonster applet){
		super(applet);
		youWin = applet.getImage(getURL(),"Pictures/YouWin.jpg");
		youLose = applet.getImage(getURL(),"Pictures/YouLose.jpg");
		tradeOK = true;
	}
	public void update(JessMonster applet){
		applet.addKeyListener(this);
		applet.addMouseListener(this);
	}
	public void paint(Graphics g, JessMonster applet){
		g.drawImage(getPlayer(), 150, 0, applet);
		for (int i = 0; i < monsterList.size(); i++){
			if (getViewMon() == monsterList.get(i) ){
				monsterList.get(i).paint(g,150,100, applet);
			} else {
				monsterList.get(i).paint(g,0,125 * (i) + 225, applet);
			}
		}
		g.drawImage(cardListBG, 0, 0, applet);
		for (int i = 0; i < cardList.size(); i++){
			g.drawString(cardList.get(i).nameToString(),0 ,i * 20 + 10 );
			if (cardList.get(i) == getActiveCard()){
				cardList.get(i).paint(g,0, 100, applet);
			}
		}
	}
	public void paintEnd(Graphics g, JessMonster applet){
		if (endStatus == true) {
			g.drawImage(youWin, 200, 0, applet);
		} else {
			g.drawImage(youLose, 200, 0,  applet);
		}
	}
	public Monster getActiveMon(){
		return super.getActiveMon();
	}
	public void setActiveMon(Monster newMon){
		super.setActiveMon(newMon);
	}
	public Monster getViewMon(){
		return super.getViewMon();
	}
	public void setViewMon(Monster newMon){
		super.setViewMon(newMon);
	}
	public void takeTurn() {
	}
	public void knockedOut() {
		tradeOK = true;
	}
	public LeaderCard getActiveCard(){
		return super.getActiveCard();
	}
	public void setActiveCard(LeaderCard card){
		super.setActiveCard(card);
	}
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_F:{
				break;
			}
			case KeyEvent.VK_S:{
				break;
			}
			case KeyEvent.VK_E:{
				break;
			}
			case KeyEvent.VK_D:{
				break;
			}
		}
	}
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_3:{
				setActiveMon(monsterList.get(2));
				break;
			}
			case KeyEvent.VK_2:{
				setActiveMon(monsterList.get(1));
				break;
			}
			case KeyEvent.VK_1:{
				setActiveMon(monsterList.get(0));
				break;
			}
			case KeyEvent.VK_D:{
				break;
			}
		}
	}
	public void keyTyped(KeyEvent arg0) {}
	public void mouseWheelMoved(MouseWheelEvent arg0) {}
	public void mouseClicked(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {
		if (myTurn == true){
			if (arg0.getX() < 150 && cardOK && arg0.getY() < 225){
				if (arg0.getY() > 100){
					if (getActiveCard().isMet()){
						getActiveCard().activate();
						cardOK = false;
					}
				} else if (arg0.getY() > 80){
					setActiveCard(cardList.get(4));
				} else if (arg0.getY() > 60){
					setActiveCard(cardList.get(3));
				} else if (arg0.getY() > 40){
					setActiveCard(cardList.get(2));
				} else if (arg0.getY() > 20){
					setActiveCard(cardList.get(1));
				} else if (arg0.getY() > 0){
					setActiveCard(cardList.get(0));
				}
			}
			if (arg0.getX() < 150 && tradeOK){//trading active monster
				if (arg0.getY() > 475){
					setActiveMon(monsterList.get(2));
					tradeOK = false;
				} else if (arg0.getY() > 350){
					setActiveMon(monsterList.get(1));
					tradeOK = false;
				} else if (arg0.getY() > 225){
					setActiveMon(monsterList.get(0));
					tradeOK = false;
				}
			} else if (arg0.getX() < 150 && !tradeOK) {//set own view monster
				if (arg0.getY() > 475){
					setViewMon(monsterList.get(2));
					tradeOK = false;
				} else if (arg0.getY() > 350){
					setViewMon(monsterList.get(1));
					tradeOK = false;
				} else if (arg0.getY() > 225){
					setViewMon(monsterList.get(0));
					tradeOK = false;
				}
			} else if (arg0.getX() > 650) {//set opponent view monster
				if (arg0.getY() > 475){
					getO().setViewMon(getO().monsterList.get(2));
					tradeOK = false;
				} else if (arg0.getY() > 350){
					getO().setViewMon(getO().monsterList.get(1));
					tradeOK = false;
				} else if (arg0.getY() > 225){
					getO().setViewMon(getO().monsterList.get(0));
					tradeOK = false;
				}
				//monster attacks
			} else if (arg0.getX() < 325 && arg0.getX() > 150 && !tradeOK && getViewMon() == getActiveMon()){
				if (arg0.getY() > 520){
					if(getActiveMon().reqA4(this,getO())) {
						myTurn = false;
						getActiveMon().attack4(this, getO());
					}
				} else if (arg0.getY() > 450){
					if(getActiveMon().reqA3(this,getO())) {
						getActiveMon().attack3(this, getO());
						myTurn = false;
					}
				} else if (arg0.getY() > 380){
					if(getActiveMon().reqA2(this,getO())) {
						getActiveMon().attack2(this, getO());
						myTurn = false;
					}
				} else if (arg0.getY() > 310){
					if(getActiveMon().reqA1(this,getO())) {
						getActiveMon().attack1(this, getO());
						myTurn = false;
					}
				}
			} else if (arg0.getX() > 360 && arg0.getX() < 385 && !tradeOK && getViewMon() == getActiveMon()){
				Monster mon = getActiveMon();
				if (arg0.getY() > 550 && mon.getEnergy() >= 20) {
					mon.setEnergy(mon.getEnergy() - 20);
					tradeOK = true;
					myTurn = true;
					mon.applet.textbox.getArray().add(new TextUnit(mon.nameToString() + " Switched", mon.lead));
				}
			}
		} else if (arg0.getX() < 150 && tradeOK && getActiveMon() == null){//trading active monster
			if (arg0.getY() > 475){
				setActiveMon(monsterList.get(2));
				tradeOK = false;
			} else if (arg0.getY() > 350){
				setActiveMon(monsterList.get(1));
				tradeOK = false;
			} else if (arg0.getY() > 225){
				setActiveMon(monsterList.get(0));
				tradeOK = false;
			}
			setViewMon(getActiveMon());
		}
	}
	public void updateEOT(JessMonster applet){
		super.updateEOT(applet);
		if (monsterList.size() == 0){
			endStatus = false;
		}
	}
	public void mouseReleased(MouseEvent arg0) {}
	public void mouseDragged(MouseEvent arg0) {}
	public void mouseMoved(MouseEvent arg0) {}
}