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
			int x = 0;
			int y = 0;
			
			if (charIndex >= 26*2 ){
				y = 2;
				charIndex -= 26*2;
			} else if (charIndex >= 26){
				y = 1;
				charIndex -= 26;
			}
			x= charIndex;
			
			sprites[i] = Sprite.getSpriteFromSheet(fontSheet, x * tileWidth, y * tileHeight, tileWidth, tileHeight);
		}
		return sprites;
	}
}
