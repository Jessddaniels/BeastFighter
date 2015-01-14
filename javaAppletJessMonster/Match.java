package javaAppletJessMonster;

import java.awt.Graphics;
import java.awt.Image;

public class Match {
	JessMonster applet;
	Leader p1;
	Leader p2;

	public int gamePhase = 0;
	boolean stopRunning = false;
	boolean running = true;
	private Image bg;
	public TextBox textbox;
	public Match(JessMonster applet){
		this.applet = applet;
		bg = applet.getImage(Images.BGGraveyard);
    	textbox = new TextBox(applet);
	}
	public void loop(){
		//initialize players. If done in constructor, Player constructs with null Match value
		int rand = (int) (Math.random() * 2);
    	if (rand == 0){
    		p2 = new Player(applet);
        	p1 = new Computer(applet, 1);
    	} else {
			p1 = new Player(applet);
			p2 = new Computer(applet, 1);
    	}
    	p1.setO(p2);
    	p1.playerNum = "Player 1";
    	p2.playerNum = "Player 2";
    	p2.setO(p1);
    	p1.myTurn = true;
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
	    		p1.update(applet);
	    		applet.repaint();
	    	} else if (p2.getActiveMon() == null) {
	    		if (gamePhase == 1){
					gamePhase++;
					textbox.getArray().add(new TextUnit("Player 2, Pick Your Fighter!", p2));
				}
	    		p2.knockedOut();
	    		p2.update(applet);
	    		applet.repaint();
	    	}
			applet.repaint();
			if (p1.getActiveMon() != null && p2.getActiveMon() != null ){
	    		if (p2.myTurn == true){
	    			p2.updateBOT(applet);
	    			p2.cardOK = true;
	    			while (p2.myTurn == true){
	    				p2.update(applet);
	    				applet.repaint();
	    				sleeper(20);
		    			p2.takeTurn();
		    			applet.repaint();
	    			}
	    			p2.updateEOT(applet);
	    			p1.myTurn = true;
	    		} else if (p1.myTurn == true){
	    			p1.updateBOT(applet);
	    			while (p1.myTurn == true){
	    				p1.update(applet);
	    				applet.repaint();
	    				sleeper(20);
	    				p1.takeTurn();
	    				applet.repaint();
	    			}
	    			p1.cardOK = true;
	    			p1.updateEOT(applet);
	    			p2.myTurn = true;
	    		}
			}
			sleeper(20);
		}
		applet.running = false;
	}
	public void paint(Graphics g){
    	g.drawImage(bg, 0, 0, applet);
    	textbox.paint(g, applet);
    	p1.paint(g, applet);
    	p2.paint(g, applet);
    	if (running == false){
    		p1.paintEnd(g, applet);
			p2.paintEnd(g, applet);
    	}
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
