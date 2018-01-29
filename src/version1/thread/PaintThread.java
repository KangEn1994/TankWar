package version1.thread;


import java.awt.Panel;



public class PaintThread extends Thread{
	private Panel gp;
	private boolean flag=true;
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Panel getGp() {
		return gp;
	}

	public void setGp(Panel gp) {
		this.gp = gp;
	}

	@Override
	public void run() {
		while(flag){
			gp.repaint();
			try{
				Thread.sleep(300);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	

}
