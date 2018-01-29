package version1.entity;

import java.awt.Image;

/*
 * @author uncleYiba
 * @describe 方块，每一个地图的格子
 * @date 2018/01/29
 */
public class Square {
	private int xLoca,yLoca;//坐标，统一采用右为x，下为y的坐标系
	private int maxSizeX,maxSizeY;//x,y轴方向最大分割尺寸
	private Image image;
	private int[][] squareMakeUp;
	
	public int[][] getSquareMakeUp() {
		return squareMakeUp;
	}
	public void setSquareMakeUp(int[][] squareMakeUp) {
		this.squareMakeUp = squareMakeUp;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public int getxLoca() {
		return xLoca;
	}
	public void setxLoca(int xLoca) {
		this.xLoca = xLoca;
	}
	public int getyLoca() {
		return yLoca;
	}
	public void setyLoca(int yLoca) {
		this.yLoca = yLoca;
	}
	public int getMaxSizeX() {
		return maxSizeX;
	}
	public void setMaxSizeX(int maxSizeX) {
		this.maxSizeX = maxSizeX;
	}
	public int getMaxSizeY() {
		return maxSizeY;
	}
	public void setMaxSizeY(int maxSizeY) {
		this.maxSizeY = maxSizeY;
	}
	public void paint(){
		
	}
	
}
