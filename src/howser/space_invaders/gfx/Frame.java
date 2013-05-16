package howser.space_invaders.gfx;

public class Frame {

	public int[] pixels;
	private int width;
	private int height;

	public Frame(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	public void getPixels(int[] pixelArray) {
		for (int i = 0; i < pixelArray.length; i++) {
			pixelArray[i] = pixels[i];
		}
	}

	public void renderToFrame(int[] data, int xa, int ya, int w, int h) {
		int dataIndex = 0;
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				if (data[dataIndex] != 0xffff00ff) {
					if (0 > xa + x || xa + x > width || 0 > ya + y
							|| ya + y > height) {
						dataIndex++;
						continue;
					}
					pixels[(xa + x) + (ya + y) * width] = data[dataIndex];
				}
				dataIndex++;
			}
		}
	}
}
