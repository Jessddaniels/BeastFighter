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
	//sends a string to be printed in the text box
		public void toTextBox(String words){
			player.getActiveMon().toTextBox(words);
		}
}
