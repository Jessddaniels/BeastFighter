package javaAppletJessMonster;

import java.awt.Image;
import java.net.URL;

public class Images {
	private URL url;
	public JessMonster applet;
	//characters
	public static final String Calumbra = "Pictures/Calumbra.jpg";
	public static final String Virgeo = "Pictures/Virgeo.jpg";
	public static final String Debira = "Pictures/WomanWarrior.jpg";
	public static final String Adipedys = "Pictures/King.jpg";
	//stats
	public static final String Combat = "Pictures/Combat.jpg";
	public static final String Energy = "Pictures/Energy.jpg";
	public static final String Experience = "Pictures/Experience.jpg";
	public static final String Health = "Pictures/Health.jpg";
	public static final String Damage = "Pictures/Damage.jpg";
	public static final String Spirit = "Pictures/Spirit.jpg";
	//attacks
	public static final String Adipedys1Attack = "Pictures/Adipedys1Attack.jpg";
	public static final String Adipedys2Attack = "Pictures/Adipedys2Attack.jpg";
	public static final String Adipedys3Attack = "Pictures/Adipedys3Attack.jpg";
	public static final String Bash = "Pictures/Bash.jpg";
	public static final String Bite = "Pictures/Bite.jpg";
	public static final String BodySlam = "Pictures/BodySlam.jpg";
	public static final String Blood = "Pictures/Blood.jpg";
	public static final String Calumbra1Attack = "Pictures/Calumbra1Attack.jpg";
	public static final String Calumbra2Attack = "Pictures/Calumbra2Attack.jpg";
	public static final String Calumbra3Attack = "Pictures/Calumbra3Attack.jpg";
	public static final String DeathRoll = "Pictures/DeathRoll.jpg";
	public static final String Debira1Attack = "Pictures/Debira1Attack.jpg";
	public static final String Debira2Attack = "Pictures/Debira2Attack.jpg";
	public static final String Debira3Attack = "Pictures/Debira3Attack.jpg";
	public static final String FireBall = "Pictures/FireBall.jpg";
	public static final String Gore = "Pictures/Gore.jpg";
	public static final String Headbutt = "Pictures/Headbutt.jpg";
	public static final String HeadSlap = "Pictures/HeadSlap.jpg";
	public static final String Hybernate = "Pictures/Hybernate.jpg";
	public static final String PackInstincts = "Pictures/PackInstincts.jpg";
	public static final String RestButton = "Pictures/RestButton.jpg";
	public static final String Runner = "Pictures/Runner.jpg";
	public static final String SpiritSink = "Pictures/SpiritSink.jpg";
	public static final String SwordStrike = "Pictures/SwordStrike.jpg";
	public static final String Rest = "Pictures/Rest.jpg";
	public static final String TakeDown = "Pictures/TakeDown.jpg";
	public static final String Virgeo1Attack = "Pictures/Virgeo1Attack.jpg";
	public static final String Virgeo2Attack = "Pictures/Virgeo2Attack.jpg";
	public static final String Virgeo3Attack = "Pictures/Virgeo3Attack.jpg";
	//misc
	public static final String TextBox = "Pictures/TextBox.jpg";
	public static final String YouWin = "Pictures/YouWin.jpg";
	public static final String YouLose = "Pictures/YouLose.jpg";
	public static final String Player = "Pictures/Ninja.png";
	public static final String CardListBG = "Pictures/CardList.jpg";
	public static final String BGGraveyard = "Pictures/bgGraveyard.jpg";
	
	public Images(JessMonster applet){
		this.url = applet.url;
		this.applet = applet;
	}
	public Image getImage(String image){
		return applet.getImage(url,image);
	}
}
