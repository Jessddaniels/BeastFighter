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
	public URL url;
	public Images images;
	Image dbImage; //db for double buffered
	Graphics dbg;
	public Match match;
    public void init(){
    	setSize(800,600);
    	url = this.getDocumentBase();
    	images = new Images(this);
    	match = new Match(this);
    }
    public void start(){
    	if(thread.getState() == Thread.State.NEW){
    		thread.start();
    	}
    }
    public void destroy(){
    	running = false;
    }
    public void stop(){
    	running = false;
    }
    public void run(){
    	match.loop();
    }
    public void update(Graphics g){ //to handle flickering
    	dbImage = createImage(getWidth(),getHeight());
    	dbg = dbImage.getGraphics();
    	match.paint(dbg);
    	g.drawImage(dbImage, 0, 0, this);
    }
    public Image getImage(String image){
		return images.getImage(image);
	}
}