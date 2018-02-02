package version1.entity;

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

import version1.thread.MoveThread;




/*
 * @author uncleYiba
 * @describe 地图编辑
 * @date 2018/02/02
 */
public class MapEdit extends Tank{
	private int xLoca=0,yLoca=0;
	private int xSpeed=32,ySpeed=32;
	private int show=0;
	
	private GameMap gm;
	
	private int index=0;
	private boolean buildBooA=false;
	private boolean buildBooB=false;
	
	public MapEdit(GameMap gm) {
		this.gm=gm;
		MoveThread mt=new MoveThread(this);
		setMoveThread(mt);
		mt.setFlag(true);
		mt.start();
	}
	public void moveAndBuild(KeyEvent e){
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				if (getMoveBoo()){
					yLoca-=ySpeed;
					checkLocation();
				}
				//build(gm,index);
				break;
			case KeyEvent.VK_W:
				if (getMoveBoo()){
					yLoca-=ySpeed;
					checkLocation();
				}
				//build(gm,index);
				break;
			case KeyEvent.VK_DOWN:
				if (getMoveBoo()){
					yLoca+=ySpeed;
					checkLocation();
				}
				//build(gm,index);
				break;
			case KeyEvent.VK_S:
				if (getMoveBoo()){
					yLoca+=ySpeed;
					checkLocation();
				}
				//build(gm,index);
				break;
			case KeyEvent.VK_LEFT:
				if (getMoveBoo()){
					xLoca-=xSpeed;
					checkLocation();
				}
				//build(gm,index);
				break;
			case KeyEvent.VK_A:
				if (getMoveBoo()){
					xLoca-=xSpeed;
					checkLocation();
				}
				//build(gm,index);
				break;
			case KeyEvent.VK_RIGHT:
				if (getMoveBoo()){
					xLoca+=xSpeed;
					checkLocation();
				}
				//build(gm,index);
				break;
			case KeyEvent.VK_D:
				if (getMoveBoo()){
					xLoca+=xSpeed;
					checkLocation();
				}
				//build(gm,index);
				break;
			case KeyEvent.VK_J:
				//if (index==mapOneIndex) index++;
				//if (index==14){
				//	index=0;
				//}
				buildBooB=false;
				buildBooA=true;
				//build(gm,index);
				//A键
				break;
			case KeyEvent.VK_K:
				
				//if (index==mapOneIndex) index--;
				//if (index==-1){
				//	index=13;
				//}
				buildBooA=false;
				buildBooB=true;
				//build(gm,index);
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
			url="pic/"+PicManager.terrainMap.get("mapEdit");
			show++;
		}else{
			url="pic/"+PicManager.terrainMap.get("homeAround");
			show++;
		}
		if (show==100) show=0;
		
		Image img=Toolkit.getDefaultToolkit().getImage(url); 
		g.drawImage(img, xLoca, yLoca,null);
	}
	public void build(GameMap gm,int index){
		if (buildBooA || buildBooB){
			//gm.setIndex(index);
			//gm.setMapOneTerrain(yLoca/32, xLoca/32, index);
		}
	}
	public void checkLocation(){
		xLoca=Math.max(0, xLoca);
		xLoca=Math.min(GameMap.maxSizeX*32-xSpeed, xLoca);
		yLoca=Math.max(0, yLoca);
		yLoca=Math.min(GameMap.maxSizeY*32-ySpeed, yLoca);
		setMoveBoo(false);
	}
}
