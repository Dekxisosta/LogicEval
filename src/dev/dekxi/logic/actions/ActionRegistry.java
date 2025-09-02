package dev.dekxi.logic.actions;

import dev.dekxi.logic.model.ActionMap;
import dev.dekxi.logic.model.Action;

import java.util.HashMap;
import java.util.Map;

/**
 * Registers all actions to an Action Map
 */
public class ActionRegistry{
	private ActionHandler handler = new ActionHandler();
    private ActionMap map;
    public ActionRegistry() {
        this.map = new ActionMap(new HashMap<>());
    }
	/*=================
	 * REGISTERING OF ACTIONS
	 * =============*/
	public void registerActions() {
		Action[] actions = {
				/*=================
				 * TRUTH VALUE SETTER AND DISPLAY REGISTERED ACTIONS
				 * =============*/
				handler.showTruthValues(),
				handler.setTruthValues(),
				
				/*=================
				 * UNARY OPERATOR REGISTERED ACTIONS
				 * =============*/
				handler.showNegationResult(),
				handler.showIdentityResult(),
				handler.showTautologyResult(),
				handler.showContradictionResult(),
				
				/*=================
				 * BINARY OPERATOR REGISTERED ACTIONS
				 * =============*/
				handler.showConjunctionResult(),
				handler.showDisjunctionResult(),
				
				/*=================
				 * IMPLICATION AND VARIANTS OPERATOR REGISTERED ACTIONS
				 * =============*/
				handler.showImplicationResult(),
				handler.showNonImplicationResult(),
				handler.showConverseImplicationResult(),
				handler.showConverseNonImplicationResult(),
				
				/*=================
				 * EQUIVALENCE AND EXCLUSIVE OPERATOR REGISTERED ACTIONS
				 * =============*/
				handler.showBiconditionalResult(),
				handler.showExclusiveOrResult(),
				
				/*=================
				 * NAND, NOR, AND XNOR OPERATOR REGISTERED ACTIONS
				 * =============*/
				handler.showNandResult(),
				handler.showNorResult(),
				handler.showXNorResult(),
				
				/*=================
				 * TRUTH TABLE TABULAR FORMAT REGISTERED ACTIONS
				 * =============*/
				handler.showUnaryTruthTable(),
				handler.showBinaryTruthTable(),
				handler.showImplicationTruthTable(),
				handler.showDerivedTruthTable()
		};
		
		//sets index for each action in actions
		for(int i=0; i<actions.length;i++)
			putAction(i+1,actions[i]);
		
		/*=================
		 * SYSTEM REGISTERED ACTION
		 * =============*/
		//0 is a special placeholder for program exist
		putAction(0, handler.promptProgramTermination());
	}
    public ActionMap getMap(){
        return map;
    }
	private void putAction(int num, Action action) {
		map.put(num, action);
	}
}