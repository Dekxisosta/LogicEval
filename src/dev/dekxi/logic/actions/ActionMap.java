package dev.dekxi.logic.app.src.dev.dekxi.logic.actions;

import java.util.HashMap;
import java.util.Map;

import dev.dekxi.logic.model.Action;

public class ActionMap {
	static ActionMap INSTANCE = new ActionMap();
	private Map<Integer, Action> actionMap = new HashMap<>();
	
	private ActionMap() {}
	public static ActionMap getInstance() {return INSTANCE;}
	
	public void put(int num, Action action) {actionMap.put(num, action);}
	public Action get(int num) {return actionMap.get(num);}
	
	public String[] getActionNames() {
		int size = actionMap.size();
		String[] names = new String[size];
		
		for(int i=0; i<size;i++)
			names[i] = get(i).getName();
		
		return names;
	}
	public void perform(int choice) {get(choice).run();}
}