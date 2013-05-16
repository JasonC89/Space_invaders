package howser.space_invaders;

import howser.space_invaders.gfx.Frame;
import howser.space_invaders.gfx.Sprite;
import howser.space_invaders.gfx.SpriteSheet;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 256;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 3;
	public static final String NAME = "Space invaders";
	private boolean running = false;

	private BufferedImage image;
	private int[] pixels;
	private Frame frame;
	private InputHandler input;

	// for testing
	private SpriteSheet test;
	private Random rand = new Random();
	private Sprite sprite;

	private int x, y;

	public Game() {

		frame = new Frame(WIDTH, HEIGHT);
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

		this.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		this.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		this.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

		JFrame jFrame = new JFrame();

		jFrame.setTitle(NAME);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jFrame.setLayout(new BorderLayout());

		jFrame.add(this, BorderLayout.CENTER);
		jFrame.pack();

		// jFrame.setIconImage(ICON_IMAGE_SOMETHING);
		jFrame.setLocationRelativeTo(null);
		jFrame.setResizable(false);
		jFrame.setVisible(true);
	}

	public void run() {
		init();

		int frames = 0;
		int ticks = 0;
		double targetTickTime = 1000000000 / 60;
		double lastUpdateTime = System.nanoTime();
		double lastFPSPrintTime = System.nanoTime();

		while (running) {
			double nowTime = System.nanoTime();
			boolean shouldRender = false;

			while (nowTime - lastUpdateTime >= targetTickTime) {
				ticks++;
				tick();
				lastUpdateTime = System.nanoTime();
				shouldRender = true;
			}

			if (shouldRender) {
				render();
				frames++;
			}

			if (nowTime - lastFPSPrintTime >= 1000000000) {
				System.out.println("Updates: " + ticks + ", Frames: " + frames);
				ticks = 0;
				frames = 0;
				lastFPSPrintTime = System.nanoTime();
			}
		}
	}

	public synchronized void start() {
		running = true;
		new Thread(this).start();
	}

	public synchronized void stop() {
		running = false;
	}

	public void init() {
		test = new SpriteSheet("/sprite_sheet.png");
		sprite = Sprite.getSpriteFromSheet(test, 0, 0, 16, 16);

		input = new InputHandler();
		input.addKeyListen(KeyEvent.VK_LEFT);
		input.addKeyListen(KeyEvent.VK_RIGHT);
		this.addKeyListener(input);
		x = WIDTH / 2;
		y = HEIGHT - 20;
	}

	public void tick() {
		if (input.isKeyPressed(KeyEvent.VK_LEFT)) {
			x--;
			System.out.println(x);
		}
		if (input.isKeyPressed(KeyEvent.VK_RIGHT)) {
			x++;
			System.out.println(x);
		}
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		// THIS IS JUST FOR TESTING
		int[] data = new int[WIDTH * HEIGHT];
		for (int i = 0; i < data.length; i++) {
			int b = rand.nextInt(100);
			if (b == 15) {
				data[i] = 0xffffffff;
			} else {
				data[i] = 0xff000000;
			}
		}

		frame.renderToFrame(data, 0, 0, WIDTH, HEIGHT);
		frame.renderToFrame(sprite.getPixels(), x, y, sprite.getWidth(),
				sprite.getHeight());
		frame.getPixels(pixels);

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();

		bs.show();
	}
}
