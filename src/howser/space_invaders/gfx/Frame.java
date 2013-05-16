package howser.space_invaders.gfx;

public class Frame {

	public int[] pixels;
	private int width;
	private int height;
	public final int TRANSPARENT_COLOUR = 0xffff00ff;

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
				if (data[dataIndex] != TRANSPARENT_COLOUR) {
					if (0 >= xa + x || xa + x >= width || 0 >= ya + y
							|| ya + y >= height) {
						dataIndex++;
						continue;
					}
					pixels[(xa + x) + (ya + y) * width] = data[dataIndex];
				}
				dataIndex++;
			}
		}
	}
	
	public void renderString(String string, Font font, int x, int y){
		Sprite[] sprites = font.getStringSprites(string);
		
		for (int i = 0; i < sprites.length; i++){
			renderToFrame(sprites[i].getPixels(), x + i * sprites[i].getWidth(), y,sprites[i].getWidth(), sprites[i].getHeight());
		}
	}
}
