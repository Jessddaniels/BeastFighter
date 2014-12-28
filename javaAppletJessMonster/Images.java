package javaAppletJessMonster;

import java.awt.Image;
import java.net.URL;

public class Images {
	private URL url;
	public JessMonster applet;
	//characters
	public static final String Calumbra = "Pictures/Calumbra.jpg";
	public static final String Virgeo = "Pictures/Virgeo.jpg";
	public static final String Rochelle = "Pictures/WomanWarrior.jpg";
	public static final String Adipedys = "Pictures/King.jpg";
	//stats
	public static final String Combat = "Pictures/Combat.jpg";
	public static final String Energy = "Pictures/Energy.jpg";
	public static final String Experience = "Pictures/Experience.jpg";
	public static final String Health = "Pictures/Health.jpg";
	public static final String Damage = "Pictures/Damage.jpg";
	public static final String Spirit = "Pictures/Spirit.jpg";
	//attacks
	public static final String Bash = "Pictures/Bash.jpg";
	public static final String Bite = "Pictures/Bite.jpg";
	public static final String BodySlam = "Pictures/BodySlam.jpg";
	public static final String Blood = "Pictures/Blood.jpg";
	public static final String DeathRoll = "Pictures/DeathRoll.jpg";
	public static final String FireBall = "Pictures/FireBall.jpg";
	public static final String Gore = "Pictures/Gore.jpg";
	public static final String Headbutt = "Pictures/Headbutt.jpg";
	public static final String HeadSlap = "Pictures/HeadSlap.jpg";
	public static final String Hybernate = "Pictures/Hybernate.jpg";
	public static final String PackInstincts = "Pictures/PackInstincts.jpg";
	public static final String SpiritSink = "Pictures/SpiritSink.jpg";
	public static final String SwordStrike = "Pictures/SwordStrike.jpg";
	public static final String Rest = "Pictures/Rest.jpg";
	public static final String TakeDown = "Pictures/TakeDown.jpg";
	//misc
	public static final String TextBox = "Pictures/TextBox.jpg";
	public static final String YouWin = "Pictures/YouWin.jpg";
	public static final String YouLose = "Pictures/YouLose.jpg";
	public Images(JessMonster applet){
		this.url = applet.url;
		this.applet = applet;
	}
	public Image getImage(String image){
		return applet.getImage(url,image);
	}
}
