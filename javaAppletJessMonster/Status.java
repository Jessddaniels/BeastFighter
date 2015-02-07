package javaAppletJessMonster;

import java.awt.Graphics;

public abstract class Status {
	private String type;
	private int value;
	private Monster mon;
	public Status(Monster mon, String type, int value){
		this.setMon(mon);
		this.setType(type);
		this.setValue(value);
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Monster getMon() {
		return mon;
	}
	public void setMon(Monster mon) {
		this.mon = mon;
	}
	abstract void passive();
	abstract void trigger();
	abstract void paint(Graphics g, int x, int y, int index, JessMonster applet);
}
