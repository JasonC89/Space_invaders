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

	public void render(int[] data, int xa, int ya, int w, int h,
			boolean mirrorX, boolean mirrorY) {

		int dataIndex = 0;
		if (mirrorX && mirrorY) {
			dataIndex = data.length - 1;
		} else if (mirrorX) {
			dataIndex = w - 1;
		} else if (mirrorY) {
			dataIndex = w * h - w;
		}

		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				if (data[dataIndex] != 0xffff00ff) {
					if (0 > xa + x || xa + x > width || 0 > ya + y
							|| ya + y > height) {
						if (mirrorX) {
							dataIndex--;
						} else {
							dataIndex++;
						}
						continue;
					}
					pixels[(xa + x) + (ya + y) * width] = data[dataIndex];
				}
				if (mirrorX) {
					dataIndex--;
				} else {
					dataIndex++;
				}
			}
			if (mirrorY){
				dataIndex = (h - y)*w;
			}
		}
	}

	public void render(int[] data, int xa, int ya, int w, int h) {
		render(data, xa, ya, w, h, false, false);
	}
}
