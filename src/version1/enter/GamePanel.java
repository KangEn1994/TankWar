package version1.enter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.sun.org.apache.bcel.internal.generic.NEW;

import version1.entity.GameMap;
import version1.entity.MapEdit;
import version1.entity.PicManager;
import version1.entity.SelectTank;
import version1.thread.PaintThread;

public class GamePanel extends Panel{
	public final static int GAME_WIDTH=416;
	public final static int GAME_HEIGHT=416;
	
	public final static int INDEX_GAME_START=1;//开始游戏的界面
	public final static int INDEX_MAP_EDIT=2;//地图编辑界面
	public final static int INDEX_BEFORE_ROOM=3;//关卡播报页面
	public final static int INDEX_GAME_ROOM=4;//正式游戏页面
	public final static int INDEX_AFTER_ROOM=5;//游戏战况统计页面
	
	private int index;
	private Image offScreenImage=null;
	
	//INDEX_GAME_START用
	private int yIndex=416;
	private SelectTank st=new SelectTank(this);
	
	//INDEX_MAP_EDIT
	//需要一个编辑坦克，一个地图
	private GameMap gm=null;
	private MapEdit me=null;
	
	
	public GameMap getGameMap() {
		return gm;
	}
	public void setGameMap(GameMap gm) {
		this.gm = gm;
	}
	public Image getOffScreenImage() {
		return offScreenImage;
	}
	public void setOffScreenImage(Image offScreenImage) {
		this.offScreenImage = offScreenImage;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public void showPanel() {
		setBackground(Color.BLACK);
		setBounds(32,67, 416, 416);
		setVisible(true);
		setLayout(null);
		addKeyListener(new KeyMonitor());
		PaintThread  pt=new PaintThread();
		pt.setGp(this);
		pt.start();
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		switch(index){
			case GamePanel.INDEX_GAME_START:
				paintGameStart(g);
				break;
			case GamePanel.INDEX_MAP_EDIT:
				paintMapEdit(g);
				break;
			case GamePanel.INDEX_BEFORE_ROOM:
				paintBeforeGame(g);
				break;
			case GamePanel.INDEX_GAME_ROOM:
				paintGameRoom(g);
				break;
			case GamePanel.INDEX_AFTER_ROOM:
				paintAfterRoom(g);
				break;
		}
	}
	public void paintGameStart(Graphics g){
		String url="pic/"+PicManager.terrainMap.get("welcome");
		Image img=Toolkit.getDefaultToolkit().getImage(url); 
		g.drawImage(img, 0, yIndex,null);
		if (yIndex==0){
			st.paint(g);
		}else if (yIndex>0) {
			yIndex-=16;
		}else{
			yIndex=0;
		}
		
	}
	public void paintMapEdit(Graphics g){
		
		if (gm==null) {
			gm=new GameMap(g);
		}
		if (me==null){
			me=new MapEdit(gm);
		}
		gm.setGraphics(g);
		gm.paint();
		me.paint(g);
		
	}
	public void paintBeforeGame(Graphics g){
		
	}
	public void paintGameRoom(Graphics g){
		
	}
	public void paintAfterRoom(Graphics g){
		
	}
	public class KeyMonitor implements KeyListener{
		@Override
		public void keyTyped(KeyEvent e) {
		}
		@Override
		public void keyPressed(KeyEvent e) {
			if (index==GamePanel.INDEX_GAME_START && yIndex>0 && (e.getKeyCode()==KeyEvent.VK_J ||e.getKeyCode()==KeyEvent.VK_K)){
				yIndex=0;
			}else{
				switch (index){
					case GamePanel.INDEX_GAME_START:
						st.move(e);
						break;
					case GamePanel.INDEX_MAP_EDIT:
						if (e.getKeyCode()==KeyEvent.VK_Z){
							index=GamePanel.INDEX_GAME_START;
							yIndex=GamePanel.GAME_HEIGHT;
						}else{
							me.moveAndBuild(e);
						}
						break;
					case GamePanel.INDEX_BEFORE_ROOM:
						break;
					case GamePanel.INDEX_GAME_ROOM:
						break;
					case GamePanel.INDEX_AFTER_ROOM:
						break;
					
				}
				
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {
		}
	}
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		Image offScreenImage=getOffScreenImage();
		if (offScreenImage==null){
			offScreenImage=this.createImage(GAME_WIDTH,GAME_HEIGHT);
			setOffScreenImage(offScreenImage);
		}
		Graphics gOffScreen=offScreenImage.getGraphics();
		paint(gOffScreen);
		g.drawImage(offScreenImage,0,0, null);
	}
}
