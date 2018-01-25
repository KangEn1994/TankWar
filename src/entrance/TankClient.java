package entrance;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Main.GamePanel;
import Main.WelcomePanel;

public class TankClient extends Frame{
	public static int GAME_WIDTH=416;
	public static int GAME_HEIGHT=416;
	private boolean mep=false,wp=false;
	Image offScreenImage=null;
	public void showFrame(){
		setBackground(new Color(127, 127, 127));
		setLocation(400, 100);
		setTitle("̹TankWar");
		setResizable(false);
		setVisible(true);
		setSize(512,498);
		setLayout(null);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		TankClient tc=new TankClient();
		tc.showFrame();
		GamePanel gp=new WelcomePanel();
		gp.showPanel();
		tc.add(gp);
		
	}
}
