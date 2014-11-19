package javaAppletJessMonster;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class TextBox {
	private ArrayList<TextUnit> textbox = new ArrayList<TextUnit>();
	public Image pic;
	public TextBox(JessMonster applet){
		pic = applet.getImage(applet.url,"Pictures/TextBox.jpg");
	}
	public void paint(Graphics g, JessMonster applet){
		g.drawImage(pic, 250, 0, applet);
		for (int i = 0; i < textbox.size() && i < 9; i++){
			if (textbox.get(textbox.size() - i - 1).getPlayer().playerNum == "Player 1"){
				g.setColor(Color.BLUE);
			} else if (textbox.get(textbox.size() - i - 1).getPlayer().playerNum == "Player 2") {
				g.setColor(Color.RED.darker());
			}
			g.drawString(textbox.get(textbox.size() - i - 1).getWords() , 250, 95 - i * 10);
			g.setColor(Color.BLACK);
		}
	}
	public ArrayList<TextUnit> getArray(){
		return textbox;
	}
	//sends a string to be printed in the text box
	public void toTextBox(String words, Leader lead){
		getArray().add(new TextUnit(words, lead));
	}
}
