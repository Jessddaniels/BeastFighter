package javaAppletJessMonster;

import java.awt.Image;
import java.net.URL;

public class Images {
	private URL url;
	public JessMonster applet;
	public static final String Energy = "Pictures/Energy.jpg";
	public static final String Health = "Pictures/Health.jpg";
	public Images(JessMonster applet){
		this.url = applet.url;
		this.applet = applet;
	}
	public Image getImage(String image){
		return applet.getImage(url,image);
	}
}
