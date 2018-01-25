package entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import Main.MapEditPanel;
import entrance.TankClient;

/*
 * @author uncleYiba
 * @describe 地图编辑
 * @date 2018/01/25
 */
public class MapEdit {
	private int xLoca=0,yLoca=0;
	private int xSpeed=32,ySpeed=32;
	private int show=0;
	private MapEditPanel mep;
	
	
	public MapEdit(MapEditPanel mep) {
		this.mep=mep;
	}
	public void move(KeyEvent e){
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				yLoca-=ySpeed;
				break;
			case KeyEvent.VK_W:
				yLoca-=ySpeed;
				break;
			case KeyEvent.VK_DOWN:
				yLoca+=ySpeed;
				break;
			case KeyEvent.VK_S:
				yLoca+=ySpeed;
				break;
			case KeyEvent.VK_LEFT:
				xLoca-=xSpeed;
				break;
			case KeyEvent.VK_A:
				xLoca-=xSpeed;
				break;
			case KeyEvent.VK_RIGHT:
				xLoca+=xSpeed;
				break;
			case KeyEvent.VK_D:
				xLoca+=xSpeed;
				break;
		}
		xLoca=Math.max(0, xLoca);
		xLoca=Math.min(TankClient.GAME_WIDTH-xSpeed, xLoca);
		yLoca=Math.max(0, yLoca);
		yLoca=Math.min(TankClient.GAME_HEIGHT-ySpeed, yLoca);
	}
	public void paint(Graphics g){
		String url="";
		if (show%10>1){
			url="pic/"+Terrain.terrainMap.get("mapEdit");
			show++;
		}else{
			url="pic/"+Terrain.terrainMap.get("homeAround");
			show++;
		}
		if (show==100) show=0;
		
		Image img=Toolkit.getDefaultToolkit().getImage(url); 
		g.drawImage(img, xLoca, yLoca,null);
	}
}
