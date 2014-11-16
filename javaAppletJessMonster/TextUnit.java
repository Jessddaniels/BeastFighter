package javaAppletJessMonster;


public class TextUnit {
	private String words;
	private Leader player;
	public TextUnit(String words, Leader player){
		this.setWords(words);
		this.setPlayer(player);
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	public Leader getPlayer() {
		return player;
	}
	public void setPlayer(Leader player) {
		this.player = player;
	}
}
