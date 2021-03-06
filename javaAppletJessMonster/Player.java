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
	private Boolean mousePressed = false;
	public Player(JessMonster applet){
		super(applet);
		youWin = applet.getImage(Images.YouWin);
		youLose = applet.getImage(Images.YouLose);
		tradeOK = true;
		applet.addMouseListener(this);
		applet.addKeyListener(this);
	}
	public void update(JessMonster applet){
		//applet.addKeyListener(this);
		//applet.addMouseListener(this);
	}
	public void paint(Graphics g, JessMonster applet){
		//g.drawImage(getPlayer(), 150, 0, applet);
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
			if (arg0.getX() < 150 && cardOK && arg0.getY() < 225){//use cards
				if (arg0.getY() > 100){
					if (getActiveCard().isMet()){
						getActiveCard().activate();
						cardOK = false;
					}
				} else if (arg0.getY() > 80){//set view cards
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
				if (arg0.getY() > 475  && monsterList.size() > 2){
					setViewMon(monsterList.get(2));
					tradeOK = false;
				} else if (arg0.getY() > 350 && monsterList.size() > 1){
					setViewMon(monsterList.get(1));
					tradeOK = false;
				} else if (arg0.getY() > 225){
					setViewMon(monsterList.get(0));
					tradeOK = false;
				}
			} else if (arg0.getX() > 650) {//set opponent view monster
				if (arg0.getY() > 475 && getO().monsterList.size() > 2){
					getO().setViewMon(getO().monsterList.get(2));
					tradeOK = false;
				} else if (arg0.getY() > 350 && getO().monsterList.size() > 1){
					getO().setViewMon(getO().monsterList.get(1));
					tradeOK = false;
				} else if (arg0.getY() > 225){
					getO().setViewMon(getO().monsterList.get(0));
					tradeOK = false;
				}
				//monster attacks
			} else if (arg0.getX() < 395 && arg0.getX() > 155 && arg0.getY() < 520 && getViewMon() == getActiveMon()){
				if (arg0.getY() > 450){
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
				}//switch button
			} else if (arg0.getX() > 360 && arg0.getX() < 385 && !tradeOK && arg0.getY() > 550 && getViewMon() == getActiveMon()){
				Monster mon = getActiveMon();
				if (mon.getEnergy() >= 20) {
					mon.run();
				}//rest button
			} else if (arg0.getX() > 180 && arg0.getX() < 205 && arg0.getY() > 550 && getViewMon() == getActiveMon()){
				Monster mon = getActiveMon();
				mon.rest();
				myTurn = false;
				//roll button
			} else if (arg0.getX() > 250 && arg0.getX() < 305 && arg0.getY() > 550 && getViewMon() == getActiveMon() && getActiveMon().type.equals("character")){
				Character mon = (Character) getActiveMon();
				if (mousePressed == false) {
					mon.roll(6 - mon.getDiceList().size());
					mousePressed = true;
				}// remove dice for reroll 
			} else if (arg0.getX() > 155 && arg0.getX() < 335 && arg0.getY() > 520 && arg0.getY() < 550 && getViewMon() == getActiveMon() && getActiveMon().type.equals("character")){
				Character mon = (Character) getActiveMon();
				if (mon.RollNum < 3 && mousePressed == false){
					mousePressed = true;
					if (arg0.getX() > 305 && arg0.getX() < 335 && mon.getDiceList().size() > 5) {
						mon.removeDie(5);
					} else if (arg0.getX() > 275 && arg0.getX() < 305 && mon.getDiceList().size() > 4) {
						mon.removeDie(4);
					} else if (arg0.getX() > 245 && arg0.getX() < 275 && mon.getDiceList().size() > 3) {
						mon.removeDie(3);
					} else if (arg0.getX() > 215 && arg0.getX() < 245 && mon.getDiceList().size() > 2) {
						mon.removeDie(2);
					} else if (arg0.getX() > 185 && arg0.getX() < 215 && mon.getDiceList().size() > 1) {
						mon.removeDie(1);
					} else if (arg0.getX() > 155 && arg0.getX() < 185 && mon.getDiceList().size() > 0) {
						mon.removeDie(0);
					} else {
						mousePressed = false;
					}
				}
			} 
		} else if (arg0.getX() < 150 && tradeOK && getActiveMon() == null){//trading active monster
			if (arg0.getY() > 475 && monsterList.size() > 2){
				setActiveMon(monsterList.get(2));
				tradeOK = false;
			} else if (arg0.getY() > 350 && monsterList.size() > 1){
				setActiveMon(monsterList.get(1));
				tradeOK = false;
			} else if (arg0.getY() > 225){
				setActiveMon(monsterList.get(0));
				tradeOK = false;
			}
			setViewMon(getActiveMon());
		}
	}
	public void updateBOT(JessMonster applet){
		super.updateBOT(applet);
		if (monsterList.size() == 0){
			endStatus = false;
		}
	}
	public void mouseReleased(MouseEvent arg0) {
		mousePressed = false;
	}
	public void mouseDragged(MouseEvent arg0) {}
	public void mouseMoved(MouseEvent arg0) {}
}