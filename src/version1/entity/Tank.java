package version1.entity;

import version1.thread.MoveThread;

public class Tank {
	private boolean moveBoo;
	private MoveThread moveThread;
	
	public MoveThread getMoveThread() {
		return moveThread;
	}

	public void setMoveThread(MoveThread moveThread) {
		this.moveThread = moveThread;
	}

	public boolean getMoveBoo() {
		return moveBoo;
	}

	public void setMoveBoo(boolean moveBoo) {
		this.moveBoo = moveBoo;
	}
	
	
}
