package version1.entity.square;

import java.awt.Image;
import java.awt.Toolkit;

import version1.entity.GameMap;
import version1.entity.PicManager;
import version1.entity.Square;

public class Home extends Square{
	public Home(){
		setMaxSizeX(1);
		setMaxSizeY(1);
		setSquareMakeUp(new int[1][1]);
		String url="pic/"+PicManager.terrainMap.get("home");
		Image img=Toolkit.getDefaultToolkit().getImage(url); 
		setImage(img);
		setxLoca(GameMap.maxSizeX/2);
		setyLoca(GameMap.maxSizeY-1);
	}
}
