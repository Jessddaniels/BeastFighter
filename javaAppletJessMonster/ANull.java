package javaAppletJessMonster;

import java.awt.Graphics;

public class ANull extends Attack {
	public ANull(Monster mon){
		super(mon);
		setHDamage(0);
	}
	public void attack( Leader defender) {
	}
	public boolean isMet(Leader defender) {
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
	}

}
