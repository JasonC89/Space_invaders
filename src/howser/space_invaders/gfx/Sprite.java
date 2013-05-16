package howser.space_invaders.gfx;

public class Sprite {
	private int[] pixels;
	private int width;
	private int height;

	public boolean mirrorX;
	public boolean mirrorY;

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
				data[xa + ya * w] = sheet.pixels[(x + xa) + (y + ya)
						* sheet.width];
			}
		}
		return new Sprite(data, w, h);
	}

	public int[] getPixels() {
		if (!mirrorX && !mirrorY) {
			return pixels;
		}
		int[] returnData = new int[pixels.length];
		if (mirrorX) {
			int dataIndex = 0;
			for (int y = 0; y < height; y++) {
				for (int x = width - 1; x > -1; x--) {
					returnData[dataIndex] = pixels[x + y * width];
					dataIndex++;
				}
			}
		}
		if (mirrorY) {
			int[] dataToMirror = pixels.clone();
			if (mirrorX) {
				dataToMirror = returnData.clone();
			}
			int dataIndex = 0;
			for (int y = height - 1; y > -1; y--) {
				for (int x = 0; x < width; x++) {
					returnData[dataIndex] = dataToMirror[x + y * width];
					dataIndex++;
				}
			}
		}

		return returnData;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
