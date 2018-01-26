package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import entity.GameMap;
import entity.MapEdit;
import entity.Terrain;
import entrance.TankClient;
import thread.PaintThread;

public class MapEditPanel extends GamePanel{
	private MapEdit mapEdit=new MapEdit(this);
	private GameMap gameMap=new GameMap();
	
	
	
	public GameMap getGameMap() {
		return gameMap;
	}
	public void setGameMap(GameMap gameMap) {
		this.gameMap = gameMap;
	}
	@Override
	public void showPanel(){
		setBackground(Color.BLACK);
		setBounds(32,67, 416, 416);
		setVisible(true);
		setLayout(null);
		addKeyListener(new KeyMonitor());
		PaintThread  pt=new PaintThread();
		pt.setGp(this);
		pt.start();
		setMyThread(pt);
	}
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		Image offScreenImage=getOffScreenImage();
		if (offScreenImage==null){
			offScreenImage=this.createImage(TankClient.GAME_WIDTH,TankClient.GAME_HEIGHT);
			setOffScreenImage(offScreenImage);
		}
		Graphics gOffScreen=offScreenImage.getGraphics();
		paint(gOffScreen);
		g.drawImage(offScreenImage,0,0, null);
	}
	public void paint(Graphics g) {
		for (int i=0;i<26;i++){
			for (int j=0;j<26;j++){
				String url="pic/"+Terrain.terrainMap.get(Terrain.terrainMap2.get(gameMap.getMapTypeTwo()[i][j]));
				Image img=Toolkit.getDefaultToolkit().getImage(url); 
				g.drawImage(img, j*16, i*16,null);
			}
		}
		mapEdit.paint(g);
	}
	
	public class KeyMonitor implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			mapEdit.moveAndBuild(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			mapEdit.stopBuild(e);
		}
		
	}
}
