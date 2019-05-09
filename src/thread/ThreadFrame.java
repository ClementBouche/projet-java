package thread;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;


public class ThreadFrame extends JFrame {

	private static final long serialVersionUID = -3213558431833952303L;

	private List<Color> colors;
	
	public ThreadFrame() {
		
		colors = new ArrayList<Color>();
		colors.add(Color.BLACK);
		colors.add(Color.BLUE);
		colors.add(Color.GREEN);
		colors.add(Color.RED);
		colors.add(Color.CYAN);
		colors.add(Color.DARK_GRAY);
		colors.add(Color.MAGENTA);
		
		setSize(new Dimension(500, 500));
		changeColor();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void changeColor() {
		int index = (int) Math.floor(Math.random() * colors.size());
		Color color = colors.get(index);
		System.out.println("new color " + color.toString());

		getContentPane().setBackground(color);
		repaint();
	}
	
	private static void withThread(ThreadFrame frame) {
		Thread thread = new Thread(new RunnableJob(frame));
		thread.start();
		int compteur = 0;
		while (compteur < 10) {
			if (thread != null && thread.isAlive()) {
				
			} else {
				compteur++;
				thread = new Thread(new RunnableJob(frame));
				thread.start();
			}
		}
	}
	
	private static void withoutThread(ThreadFrame frame) throws InterruptedException {
		int compteur = 0;
		while (compteur < 10) {
			frame.changeColor();
			TimeUnit.SECONDS.sleep(1);
			compteur++;
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadFrame frame = new ThreadFrame();

		System.out.println("with thread");
		withThread(frame);
		System.out.println("without thread");
		withoutThread(frame);
	}
	
}
