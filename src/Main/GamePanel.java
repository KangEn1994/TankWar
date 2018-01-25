package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import thread.PaintThread;
import entity.MapEdit;

public class GamePanel extends Panel{
	private MapEdit mapEdit=new MapEdit();
	public void showPanel(){
		setBackground(Color.BLACK);
		setBounds(32,67, 416, 416);
		setVisible(true);
		setLayout(null);
		addKeyListener(new KeyMonitor());
		PaintThread  pt=new PaintThread();
		pt.setGp(this);
		pt.start();
	}
	public void paint(Graphics g) {

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
			mapEdit.move(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
