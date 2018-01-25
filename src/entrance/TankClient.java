package entrance;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Main.GamePanel;
import Main.MapEditPanel;
import Main.WelcomePanel;

public class TankClient extends Frame{
	//设置游戏主题部分的大小为416*416
	public static int GAME_WIDTH=416;
	public static int GAME_HEIGHT=416;
	//用于判定当前的GamePanel是哪一个
	private boolean mep=false,wp=true;
	//双缓冲用，防止闪屏(参考马士兵老师坦克大战系列视频)
	Image offScreenImage=null;
	//当前的GamePanel
	private GamePanel gp=new WelcomePanel();
	//private GamePanel gp=new MapEditPanel();
	//展示该Frame
	public void showFrame(){
		setBackground(new Color(127, 127, 127));
		setLocation(400, 100);
		setTitle("̹TankWar");
		setResizable(false);
		setVisible(true);
		setSize(512,498);
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
		//新建一个坦克大战客户端
		TankClient tc=new TankClient();
		//设置并展示该客户端
		tc.showFrame();
		//得到该客户端初始展示的GamePanel
		GamePanel gp=tc.gp;
		//设置该GamePanel
		gp.showPanel();
		//对GamePanel设置其父窗口TankClient
		gp.setTc(tc);
		//将GamePanel放入父窗口TankClient中
		tc.add(gp);
	}
	//更换其他的GamePanel
	public void replaceNewGamePanel(GamePanel gpNew){
		//移除原先的
		gp.getMyThread().setFlag(false);
		remove(gp);
		//获取最新的
		gp=gpNew;
		//设置最新的
		gp.showPanel();
		//将最新的添加进去
		add(gp);
		
	}
}
