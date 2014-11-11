package javaAppletJessMonster;

import java.awt.Graphics;

public abstract class LeaderCard {
	Leader player;
	public LeaderCard(Leader l){
		player = l;
	}
	abstract void activate();
	abstract boolean isMet();
	abstract void paint(Graphics g, int x, int y, JessMonster applet);
	abstract String nameToString();
}
