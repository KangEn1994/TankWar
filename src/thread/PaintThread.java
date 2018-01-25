package thread;


import Main.GamePanel;

public class PaintThread extends Thread{
	private GamePanel gp;
	private boolean flag=true;
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public GamePanel getGp() {
		return gp;
	}

	public void setGp(GamePanel gp) {
		this.gp = gp;
	}

	@Override
	public void run() {
		while(flag){
			gp.repaint();
			try{
				Thread.sleep(200);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	

}
