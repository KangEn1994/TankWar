package version1.entity.square;

import version1.entity.Square;

public class Wood extends Square{
	public Wood(){
		setMaxSizeX(4);
		setMaxSizeY(4);
		setSquareMakeUp(new int[4][4]);
	}
	
}
