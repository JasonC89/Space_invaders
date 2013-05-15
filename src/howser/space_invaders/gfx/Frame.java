package howser.space_invaders.gfx;

import java.util.Arrays;

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
		for (int y = ya; y < h + ya; y++) {
			for (int x = xa; x < w + xa; x++) {
				if (data[dataIndex] != 0x00000000) {
					pixels[x + y * width] = data[dataIndex];
				}
				dataIndex++;
			}
		}
	}
}
