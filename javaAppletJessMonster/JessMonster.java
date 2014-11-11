package javaAppletJessMonster;

import java.applet.*;
import java.awt.*;
import java.net.URL;

public class JessMonster extends Applet implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Thread thread = new Thread(this);
	boolean running = true;
	boolean stopRunning = false;
	public URL url;
	private Image bg;
	public int gamePhase = 0;
	Leader p1;
	Leader p2;
	Image dbImage; //db for double buffered
	Graphics dbg;
	BattleText textbox;
    public void init(){
    	setSize(800,600);
    	url = this.getDocumentBase();
    	bg = this.getImage(url,"Pictures/bgGraveyard.jpg");
    	
    	textbox = new BattleText(this);
    	int rand = (int) (Math.random() * 2);
    	if (rand == 0){
    		p2 = new Player(this);
        	p1 = new Computer(this, 1);
    	} else {
			p1 = new Player(this);
			p2 = new Computer(this, 1);
    	}
    	p1.setO(p2);
    	p1.playerNum = "Player 1";
    	p2.playerNum = "Player 2";
    	p2.setO(p1);
    	p1.myTurn = true;
    }
    public void start(){
    	thread.start();
    }
    public void destroy(){
    	running = false;
    }
    public void stop(){
    	running = false;
    }
    public void run(){
    	while (running){
    		if (stopRunning == true){
    			running = false;
    		}
    		if (p1.getActiveMon() == null) {
    			if (gamePhase == 0){
    				gamePhase++;
    				textbox.getArray().add(new TextUnit("Player 1, Pick Your Fighter!", p1));
    			}
        		p1.knockedOut();
        		p1.update(this);
        		repaint();
        	} else if (p2.getActiveMon() == null) {
        		if (gamePhase == 1){
    				gamePhase++;
    				textbox.getArray().add(new TextUnit("Player 2, Pick Your Fighter!", p2));
    			}
        		p2.knockedOut();
        		p2.update(this);
        		repaint();
        	}
    		repaint();
    		if (p1.getActiveMon() != null && p2.getActiveMon() != null ){
	    		if (p2.myTurn == true){
	    			p2.updateEOT(this);
	    			p2.cardOK = true;
	    			while (p2.myTurn == true){
	    				p2.update(this);
	    				repaint();
	    				sleeper(20);
		    			p2.takeTurn();
		    			repaint();
	    			}
	    			p1.myTurn = true;
	    		} else if (p1.myTurn == true){
	    			p1.updateEOT(this);
	    			while (p1.myTurn == true){
	    				p1.update(this);
	    				repaint();
	    				sleeper(20);
	    				p1.takeTurn();
	    				repaint();
	    			}
	    			p1.cardOK = true;
	    			p2.myTurn = true;
	    		}
    		}
			sleeper(20);
    	}
    }
    public void update(Graphics g){ //to handle flickering
    	dbImage = createImage(getWidth(),getHeight());
    	dbg = dbImage.getGraphics();
    	paint(dbg);
    	g.drawImage(dbImage, 0, 0, this);
    }
    public void paint(Graphics g){
    	g.drawImage(bg, 0, 0, this);
    	textbox.paint(g, this);
    	p1.paint(g, this);
    	p2.paint(g, this);
    	if (running == false){
    		p1.paintEnd(g, this);
			p2.paintEnd(g, this);
    	}
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
    public Monster ranMonster(Leader l){
    	Monster mon;
    	int rand = (int) (Math.random() * 9);
    	if (rand == 0) {
    		mon = new JMTiger(this, l);
    	} else if (rand == 1) {
    		mon = new JMAlligator(this, l);
    	} else if (rand == 2) {
    		mon = new JMBear(this, l);
    	} else if (rand == 3) {
    		mon = new JMSkeletalCow(this, l);
    	} else if (rand == 4) {
    		mon = new JMRam(this, l);
    	} else if (rand == 5) {
    		mon = new JMWolf(this, l);
    	} else if (rand == 6) {
    		mon = new JMMountainLion(this, l);
    	} else if (rand == 7) {
    		mon = new JMBoar(this, l);
    	} else {
    		mon = new JMDragon(this, l);
    	} 
    	return mon;
    }
    public void stopRunning(){
    	stopRunning = true;
    }
    public void sleeper(int num){
    	try {
			Thread.sleep(num);
		} catch(InterruptedException e) {
			System.out.print("ERROR HAS OCCURED");
		}
    }
}