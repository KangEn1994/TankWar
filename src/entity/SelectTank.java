package entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import entrance.TankClient;

public class SelectTank {
	private int selectShow=0;
	private int[] xLoca={100,100,100};
	private int[] yLoca={225,255,285};
	private int index=0;
	public void move(KeyEvent e){
		switch (e.getKeyCode()) {
			case KeyEvent.VK_X:
				index++;
				break;
		}
		if (index==3) index=0;
	}
	public void paint(Graphics g){
		String url="pic/"+Terrain.terrainMap.get("welcome");
		Image img=Toolkit.getDefaultToolkit().getImage(url); 
		g.drawImage(img, 0, 0,null);
		
		String url2="pic/"+Terrain.terrainMap.get("select1");
		Image img2=Toolkit.getDefaultToolkit().getImage(url2); 
		
		String url3="pic/"+Terrain.terrainMap.get("select2");
		Image img3=Toolkit.getDefaultToolkit().getImage(url3); 
		if (selectShow%2==0){
			g.drawImage(img2, xLoca[index], yLoca[index],null);
			selectShow++;
		}else{
			g.drawImage(img3, xLoca[index], yLoca[index],null);
			selectShow++;
		}
		if (selectShow==100) selectShow=0;
	}
}
