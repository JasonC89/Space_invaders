package howser.space_invaders.state;

import howser.space_invaders.gfx.Frame;

import java.util.ArrayList;

public class StateManager {
	
	private int currentState;
	private ArrayList<BaseState> states;
	public StateManager(){
		states = new ArrayList<BaseState>();
		currentState = 0;
	}
	
	public void addState(BaseState state){
		states.add(state);
	}
	
	public void changeState(String state){
		for (int i = 0; i < states.size(); i++){
			if (states.get(i).name == state){
				currentState = i;
				states.get(i).onEnter();
				return;
			}
		}
	}
	
	public void tick(){
		states.get(currentState).tick();
	}
	
	public void render(Frame frame){
		states.get(currentState).render(frame);
	}
	
	public void clearStates(){
		states.clear();
	}
	
	public void resetState(String state){
		for (int i = 0; i< states.size(); i++){
			if (states.get(i).name == state){
				states.get(i).reset();
			}
		}
	}
}
