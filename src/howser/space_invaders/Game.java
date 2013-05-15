package howser.space_invaders;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 256;
	public static final int HEIGHT = WIDTH / 12*9;
	public static final int SCALE = 3;
	public static final String NAME = "Space invaders";
	private boolean running = false;
	
	public Game(){
		this.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));	
		this.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		this.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		JFrame frame = new JFrame();
		
		frame.setTitle(NAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(new BorderLayout());
		
		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public void run() {
		while (running){
			System.out.println("Running");
		}
	}
	
	public synchronized void start(){
		running = true;
		new Thread(this).start();
	}
	
	public synchronized void stop(){
		running = false;
	}
	
	public void init(){
		
	}
	
	public void tick(){
		
	}
	
	public void render(){
		
	}
}
