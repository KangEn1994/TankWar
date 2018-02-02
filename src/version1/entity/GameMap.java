package version1.entity;

import java.awt.Graphics;

import version1.entity.square.Home;

public class GameMap {
	public final static int maxSizeX=13;
	public final static int maxSizeY=13;
	
	
	private Graphics g;//绘制该地图用的画笔
	
	public Graphics getGraphics() {
		return g;
	}

	public void setGraphics(Graphics g) {
		this.g = g;
	}

	private Square[][] squareMap=new Square[maxSizeX][maxSizeY];
	
	public GameMap(Graphics g){
		this.g=g;
		squareMap[maxSizeX/2][maxSizeY-1]=new Home();
	}
	
	public void paint(){
		for (int i=0;i<maxSizeX;i++){
			for (int j=0;j<maxSizeY;j++){
				Square s=squareMap[i][j];
				if (s!=null){
					g.drawImage(s.getImage(), s.getxLoca()*32, s.getyLoca()*32, null);
				}
				
			}
		}
	}
}
