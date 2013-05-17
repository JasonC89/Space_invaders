package howser.space_invaders.gfx;

public class Font {
	private SpriteSheet fontSheet;
	
	//Top row of the sheet is lowercase
	//middle row is UPPERCASE
	//bottom row is num3r1c + symb0l5
	
	private String chars = "abcdefghijklmnopqrstuvwxyz"
			+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789.,:'\"!?$%()-+/= ";
	
	private int width;
	private int height;
	private int tileWidth;
	private int tileHeight;

	public Font(String fontPath) {
		fontSheet = new SpriteSheet(fontPath);
		this.width = fontSheet.width;
		this.height = fontSheet.height;
		this.tileWidth = width/26;
		this.tileHeight = height/3;
	}
	
	public Sprite[] getStringSprites(String s){
		Sprite[] sprites = new Sprite[s.length()];
		for (int i = 0; i < s.length(); i++){
			int charIndex = chars.indexOf(s.charAt(i));
			
			sprites[i] = Sprite.getSpriteFromSheet(fontSheet, charIndex%26 * tileWidth, charIndex/26 * tileHeight, tileWidth, tileHeight);
		}
		return sprites;
	}
}
