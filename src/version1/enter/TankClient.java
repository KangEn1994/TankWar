package version1.enter;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankClient extends Frame{
	private int clientSizeX=512,clientSizeY=498;
	//展示该Frame
	public void showFrame(){
		setBackground(new Color(127, 127, 127));
		setLocation(400, 100);
		setTitle("̹TankWar");
		setResizable(false);
		setVisible(true);
		setSize(clientSizeX,clientSizeY);
		setLayout(null);
		//设置关闭监听
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
		GamePanel gp=new GamePanel();
		gp.showPanel();
		gp.setIndex(GamePanel.INDEX_GAME_START);
		tc.add(gp);
	}
}
