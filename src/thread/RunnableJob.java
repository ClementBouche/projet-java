package thread;

import java.util.concurrent.TimeUnit;

public class RunnableJob implements Runnable {
	
	private ThreadFrame frame;
	
	public RunnableJob(ThreadFrame threadFrame) {
		this.frame = threadFrame;
	}
	
	@Override
	public void run() {
		frame.changeColor();
		frame.repaint();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
