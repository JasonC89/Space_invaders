package howser.space_invaders.gfx;

public class Sprite {
	private int[] pixels;
	private int width;
	private int height;

	private boolean flipX;
	private boolean filpY;

		public Sprite(int[] pixelData, int width, int height) {
		this.pixels = pixelData;
		this.width = width;
		this.height = height;
	}

	public static Sprite getSpriteFromSheet(SpriteSheet sheet, int x, int y,
			int w, int h) {
		int[] data = new int[w * h];

		for (int ya = 0; ya < h; ya++) {
			for (int xa = 0; xa < w; xa++) {
				data[xa + ya * w] = sheet.pixels[(x+xa) + (y+ ya) * sheet.width];
			}
		}
		return new Sprite(data, w, h);
	}

	public int[] getPixels() {
		return pixels;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
