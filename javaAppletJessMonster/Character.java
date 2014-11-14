package javaAppletJessMonster;

public abstract class Character extends Monster {
	public int HDice = 0;
	public int EnDice = 0;
	public int SDice = 0;
	public int CDice = 0;
	public int IDice = 0;
	public int KDice = 0;
	public Character(JessMonster applet, Leader p) {
		super(applet, p);
	}
	public void roll(int dice){
		for (int i = 0; i < dice; i++){
			roll();
		}
	}
	public void roll(){
		int rand = (int) (Math.random() * 5);
		if (rand == 0){
			HDice++;
		} else if (rand == 1){
			EnDice++;
		}else if (rand == 2){
			SDice++;
		}else if (rand == 3){
			CDice++;
		}else if (rand == 4){
			IDice++;
		} else {
			KDice++;
		}
	}

}
