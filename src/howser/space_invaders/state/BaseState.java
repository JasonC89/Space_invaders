package howser.space_invaders.state;

import howser.space_invaders.gfx.Frame;

public abstract class BaseState {
	
	protected StateManager stateManager;
	public String name;
	
	public BaseState(String name, StateManager stateManager){
		this.stateManager = stateManager;
		this.name = name;
	}
	
	public abstract void tick();
	public abstract void render(Frame frame);
	public abstract void onEnter(); //used for initializing the resources for this state
	public abstract void onExit(); //used for saving/removing/unloading resources
	public abstract void reset();
	
	public void changeState(String state){
		onExit();
	}
}