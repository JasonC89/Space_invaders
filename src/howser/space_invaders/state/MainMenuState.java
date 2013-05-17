package howser.space_invaders.state;

import howser.space_invaders.InputHandler;
import howser.space_invaders.gfx.Font;
import howser.space_invaders.gfx.Frame;

public class MainMenuState extends BaseState {

	private Font menuFont;
	private int selectedItem;
	private final int ySpacing = 16;
	private InputHandler input;
	
	public MainMenuState(String name, StateManager stateManager, InputHandler input) {
		super(name, stateManager);
		this.input = input;
	}

	public void tick() {
		
	}

	public void render(Frame frame) {
		
	}

	public void onEnter() {
		selectedItem = 0;
	}

	public void onExit() {
		
	}

	public void reset() {
		
	}
}
