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

import javax.management.monitor.GaugeMonitor;

import entrance.TankClient;
import main.MapEditPanel;

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
	private boolean buildBooA=false;
	private boolean buildBooB=false;
	public MapEdit(MapEditPanel mep) {
		this.mep=mep;
	}
	public void moveAndBuild(KeyEvent e){
		GameMap gm=mep.getGameMap();
		int index=gm.getIndex();
		int mapOneIndex=gm.getMapOneIndex(yLoca/32, xLoca/32);
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				yLoca-=ySpeed;
				checkLocation();
				build(gm,index);
				break;
			case KeyEvent.VK_W:
				yLoca-=ySpeed;
				checkLocation();
				build(gm,index);
				break;
			case KeyEvent.VK_DOWN:
				yLoca+=ySpeed;
				checkLocation();
				build(gm,index);
				break;
			case KeyEvent.VK_S:
				yLoca+=ySpeed;
				checkLocation();
				build(gm,index);
				break;
			case KeyEvent.VK_LEFT:
				xLoca-=xSpeed;
				checkLocation();
				build(gm,index);
				break;
			case KeyEvent.VK_A:
				xLoca-=xSpeed;
				checkLocation();
				build(gm,index);
				break;
			case KeyEvent.VK_RIGHT:
				xLoca+=xSpeed;
				checkLocation();
				build(gm,index);
				break;
			case KeyEvent.VK_D:
				xLoca+=xSpeed;
				checkLocation();
				build(gm,index);
				break;
			case KeyEvent.VK_J:
				if (index==mapOneIndex) index++;
				if (index==14){
					index=0;
				}
				buildBooB=false;
				buildBooA=true;
				build(gm,index);
				//A键
				break;
			case KeyEvent.VK_K:
				
				if (index==mapOneIndex) index--;
				if (index==-1){
					index=13;
				}
				buildBooA=false;
				buildBooB=true;
				build(gm,index);
				//B键
				break;
			case KeyEvent.VK_Z:
				//中部左键
				break;
			case KeyEvent.VK_X:
				//中部右键
				break;
		}
		
	}
	public void stopBuild(KeyEvent e){
		if (e.getKeyCode()==KeyEvent.VK_J){
			buildBooA=false;
		}
		if (e.getKeyCode()==KeyEvent.VK_K){
			buildBooB=false;
		}
		
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
	public void build(GameMap gm,int index){
		if (buildBooA || buildBooB){
			gm.setIndex(index);
			gm.setMapOneTerrain(yLoca/32, xLoca/32, index);
		}
	}
	public void checkLocation(){
		xLoca=Math.max(0, xLoca);
		xLoca=Math.min(TankClient.GAME_WIDTH-xSpeed, xLoca);
		yLoca=Math.max(0, yLoca);
		yLoca=Math.min(TankClient.GAME_HEIGHT-ySpeed, yLoca);
	}
}
