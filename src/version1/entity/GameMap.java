package version1.entity;

import java.awt.Graphics;

import version1.entity.square.Home;

public class GameMap {
	private final static int maxSizeX=13;
	private final static int maxSizeY=13;
	
	
	private Graphics g;//绘制该地图用的画笔
	
	private Square[][] squareMap=new Square[maxSizeX][maxSizeY];
	
	public GameMap(Graphics g){
		this.g=g;
		squareMap[maxSizeX/2][maxSizeY-1]=new Home();
	}
	
	public void paint(){
		for (int i=0;i<maxSizeX;i++){
			for (int j=0;j<maxSizeY;j++){
				Square s=squareMap[i][j];
				g.drawImage(s.getImage(), s.getxLoca(), s.getyLoca(), null);
			}
		}
	}
}
