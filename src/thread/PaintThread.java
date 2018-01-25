package thread;


import Main.GamePanel;

public class PaintThread extends Thread{
	private GamePanel gp;
	
	public GamePanel getGp() {
		return gp;
	}

	public void setGp(GamePanel gp) {
		this.gp = gp;
	}

	@Override
	public void run() {
		while(true){
			gp.repaint();
			try{
				Thread.sleep(200);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	

}
