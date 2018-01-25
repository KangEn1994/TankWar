package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import thread.PaintThread;
import entity.MapEdit;
import entrance.TankClient;

public class GamePanel extends Panel{
	
	private TankClient tc;
	private Image offScreenImage=null;
	private PaintThread myThread;
	
	public PaintThread getMyThread() {
		return myThread;
	}

	public void setMyThread(PaintThread myThread) {
		this.myThread = myThread;
	}
	public Image getOffScreenImage() {
		return offScreenImage;
	}
	public void setOffScreenImage(Image offScreenImage) {
		this.offScreenImage = offScreenImage;
	}
	public TankClient getTc() {
		return tc;
	}
	public void setTc(TankClient tc) {
		this.tc = tc;
	}
	public void showPanel(){

	}
	
}
