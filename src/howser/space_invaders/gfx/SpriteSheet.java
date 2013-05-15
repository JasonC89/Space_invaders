package howser.space_invaders.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	 
	public int[] pixels;
	public int width;
	public int height;
	
	public SpriteSheet(String imagePath){
		BufferedImage image = null;
		try {
			image = ImageIO.read(SpriteSheet.class.getResource(imagePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.width = image.getWidth();
		this.height = image.getHeight();
		
		pixels = image.getRGB(0, 0, width, height, null, 0, width);
		System.out.println(pixels[0]);
		for (int i = 0; i < pixels.length; i++){
			//if (pixels[i] == 0xffff00ff);
		}
	}
}
