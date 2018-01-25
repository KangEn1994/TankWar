package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import entity.SelectTank;
import entity.Terrain;
import entrance.TankClient;
import thread.PaintThread;

public class WelcomePanel extends GamePanel{
	private SelectTank st=new SelectTank(this);
	

	@Override
	public void showPanel() {
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

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		String url="pic/"+Terrain.terrainMap.get("welcome");
		Image img=Toolkit.getDefaultToolkit().getImage(url); 
		g.drawImage(img, 0, 0,null);
		st.paint(g);
	}
	
	public class KeyMonitor implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			st.move(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
