package version1.thread;

import version1.entity.Tank;

public class MoveThread extends Thread{
	private boolean flag;
	
	private Tank tank;
	
	public Tank getTank() {
		return tank;
	}

	public void setTank(Tank tank) {
		this.tank = tank;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public MoveThread(Tank tank) {
		this.tank=tank;
		flag=true;
	}
	@Override
	public void run() {
		while (flag){
			letMove(tank);
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public void letMove(Tank tank){
		tank.setMoveBoo(true);
		System.out.println("行动");
	}
}
