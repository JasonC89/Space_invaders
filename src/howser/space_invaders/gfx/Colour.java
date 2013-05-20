package howser.space_invaders.gfx;

public class Colour {
	
	public static int getColour(int r, int g, int b){
		return (r << 16) + (g << 8) +(b);
	}
	
	public static final int GREEN = getColour(0,255,0);
	public static final int BLUE = getColour(0,0,255);
	public static final int RED = getColour(255,0,0);
	public static final int WHITE = getColour(255,255,255);
	public static final int BLACK = getColour(0,0,0);
	public static final int PURPLE = getColour(255,0,255);
	public static final int YELLOW = getColour(0,255,255);
}
