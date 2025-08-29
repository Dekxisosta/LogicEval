# LogicCalc

A console-based logic calculator

## Description
This is a console-based boolean logic evaluator with files separated according
to their responsibilities. You can add other console-based actions by adding an Action object in
[ActionHandler.java](https://github.com/Dekxisosta/LogicEval/blob/main/src/dev/dekxi/logic/actions/ActionHandler.java) and putting it in 
the actionMap via [ActionRegistry.java](https://github.com/Dekxisosta/LogicEval/blob/main/src/dev/dekxi/logic/actions/ActionRegistry.java)

### ActionHandler Sample Code
```java
/**
*Handles returning of code functionality for program use
*@return new Action(String s, Runnable r)
*/
public class ActionHandler {
    void yourFunction() {
        return new Action("ActionName",
            ()-> {
                //your function's code
            }
        );
    }
}
```
### ActionRegistry Sample Code
```java
/**
 * Registers available actions by retrieving them from the ActionHandler
 * and putting them into ActionMap. 
 * 
 * This ensures all actions are initialized and ready 
 * for use in the console application
*/
import dev.dekxi.logic.actions.ActionHandler;
public class ActionRegistry {
    public void registerActions() {
        //stores registed actions in an Action array for later indexing
        Action[] = {
            //other actions
            handler.yourFunction()
        }

        //sets index for each action in actions
		for(int i=0; i<actions.length;i++)
			putAction(i+1,actions[i]);

		//0 is a special placeholder for program termination
		putAction(0, handler.promptProgramTermination());
    }
}
```

You can add or change code blocks in [ConsoleUI.java](https://github.com/Dekxisosta/LogicEval/blob/main/src/dev/dekxi/logic/ui/ConsoleUI.java) to 
manipulate the formatting of console print-outs

## Disclaimer
LogicCalc is a practice project developed to experiment with software design principles.  
While functional, the codebase may not reflect best practices for a production-ready tool.

